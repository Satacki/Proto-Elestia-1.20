package net.lykos.protogmt.items;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

import java.util.*;

public class RuneBreakerItem extends Item {
    private static final int RADIUS = 16;
    private static final int COOLDOWN_TICKS = 6000; // 5 minutes (in ticks)
    private static final int DISABLE_DURATION_TICKS = 3600; // 3 minutes (in ticks)

    private static final Map<UUID, Map<EquipmentSlot, StoredEnchantment>> storedEnchantments = new HashMap<>();
    private static final Set<BlockPos> activeZones = new HashSet<>();
    private static final Set<UUID> affectedEntities = new HashSet<>();
    public static final Map<UUID, Long> cooldowns = new HashMap<>();
    private static final Set<UUID> affectedPlayers = new HashSet<>();

    public RuneBreakerItem(Properties properties) {
        super(properties);
    }

    // **Right-click activation on a block**
    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        if (!(level instanceof ServerLevel serverLevel)) return InteractionResult.SUCCESS;

        Player player = context.getPlayer();
        if (player == null) return InteractionResult.FAIL;

        if (isOnCooldown(player)) {
            player.sendSystemMessage(Component.literal("§cThe Rune Breaker is still on cooldown!"));
            return InteractionResult.FAIL;
        }

        BlockPos pos = context.getClickedPos();
        if (activeZones.contains(pos)) {
            player.sendSystemMessage(Component.literal("§cThe Rune Breaker is already active here!"));
            return InteractionResult.FAIL;
        }

        activateRuneBreaker(serverLevel, pos, player);
        setCooldown(player);
        return InteractionResult.SUCCESS;
    }

    // **Crouch activation**
    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if (!(level instanceof ServerLevel serverLevel)) return InteractionResultHolder.pass(player.getItemInHand(hand));

        if (player.isCrouching()) {
            if (isOnCooldown(player)) {
                player.sendSystemMessage(Component.literal("§cThe Rune Breaker is still on cooldown!"));
                return InteractionResultHolder.fail(player.getItemInHand(hand));
            }

            BlockPos pos = player.blockPosition();
            if (activeZones.contains(pos)) {
                player.sendSystemMessage(Component.literal("§cThe Rune Breaker is already active here!"));
                return InteractionResultHolder.fail(player.getItemInHand(hand));
            }

            activateRuneBreaker(serverLevel, pos, player);
            setCooldown(player);
            return InteractionResultHolder.success(player.getItemInHand(hand));
        }
        return InteractionResultHolder.pass(player.getItemInHand(hand));
    }

    private void activateRuneBreaker(ServerLevel level, BlockPos center, Player user) {
        activeZones.add(center);
        level.playSound(null, center, SoundEvents.ANVIL_BREAK, SoundSource.PLAYERS, 1.0F, 1.0F);

        level.getServer().getPlayerList().getPlayers().forEach(player ->
                player.sendSystemMessage(Component.literal("§6The Rune Breaker has been activated!")));

        long activationTime = level.getGameTime();
        cooldowns.put(user.getUUID(), activationTime);

        removeEnchantments(user);
        affectedPlayers.add(user.getUUID());

        for (Player player : level.players()) {
            if (!player.getUUID().equals(user.getUUID()) && player.distanceToSqr(center.getX(), center.getY(), center.getZ()) <= RADIUS * RADIUS) {
                removeEnchantments(player);
                affectedPlayers.add(player.getUUID());
                cooldowns.put(player.getUUID(), activationTime);
            }
        }
    }


    private boolean isOnCooldown(Player player) {
        UUID playerId = player.getUUID();
        if (!cooldowns.containsKey(playerId)) return false;

        if (!(player.level() instanceof ServerLevel serverLevel)) return false;
        long currentTicks = serverLevel.getGameTime(); // ✅ Get current game ticks

        return (currentTicks - cooldowns.get(playerId)) < COOLDOWN_TICKS; // ✅ Compare with game ticks
    }


    private void setCooldown(Player player) {
        if (player.level() instanceof ServerLevel serverLevel) {
            cooldowns.put(player.getUUID(), serverLevel.getGameTime());
        }
    }

    public static boolean shouldRestoreEnchantments(UUID playerId, ServerLevel level) {
        if (!cooldowns.containsKey(playerId)) return false;

        long elapsedTicks = level.getGameTime() - cooldowns.get(playerId);
        return elapsedTicks >= DISABLE_DURATION_TICKS;
    }




    public static boolean isWithinActiveZone(BlockPos pos) {
        return activeZones.stream().anyMatch(activePos -> activePos.distSqr(pos) <= RADIUS * RADIUS);
    }

    public static void restoreEnchantments(ServerLevel level) {
        long currentTime = level.getGameTime();
        Set<UUID> toRestore = new HashSet<>(affectedEntities);
        toRestore.addAll(affectedPlayers);

        for (UUID uuid : toRestore) {
            if (!storedEnchantments.containsKey(uuid)) continue;

            Map<EquipmentSlot, StoredEnchantment> stored = storedEnchantments.get(uuid);
            if (stored == null || stored.isEmpty()) continue;

            ServerPlayer player = level.getServer().getPlayerList().getPlayer(uuid);
            if (player != null) { // ✅ Ensure the player is online
                for (Map.Entry<EquipmentSlot, StoredEnchantment> entry : stored.entrySet()) {
                    EquipmentSlot slot = entry.getKey();
                    StoredEnchantment storedEnchantment = entry.getValue();
                    boolean restored = false;

                    // ✅ Search inventory first
                    for (ItemStack inventoryItem : player.getInventory().items) {
                        CompoundTag itemTag = inventoryItem.getTag();
                        if (itemTag != null && itemTag.getBoolean("RuneBreaker_Unenchanted")) {
                            UUID storedUUID = itemTag.getUUID("RuneBreaker_UUID");

                            // ✅ Only restore enchantments to the correct item
                            if (storedUUID.equals(storedEnchantment.getUUID())) {
                                storedEnchantment.restore(inventoryItem);
                                itemTag.remove("RuneBreaker_Unenchanted"); // ✅ Remove marker
                                itemTag.remove("RuneBreaker_Enchantments"); // ✅ Cleanup
                                itemTag.remove("RuneBreaker_UUID"); // ✅ Cleanup

                                restored = true;
                                break;
                            }
                        }
                    }

                    // ✅ If not found in inventory, check armor slots
                    if (!restored) {
                        ItemStack equippedItem = player.getItemBySlot(slot);
                        CompoundTag equippedTag = equippedItem.getTag();

                        if (equippedTag != null && equippedTag.getBoolean("RuneBreaker_Unenchanted")) {
                            UUID storedUUID = equippedTag.getUUID("RuneBreaker_UUID");

                            if (storedUUID.equals(storedEnchantment.getUUID())) {
                                storedEnchantment.restore(equippedItem);
                                equippedTag.remove("RuneBreaker_Unenchanted");
                                equippedTag.remove("RuneBreaker_Enchantments");
                                equippedTag.remove("RuneBreaker_UUID");
                            }
                        }
                    }
                }
                player.sendSystemMessage(Component.literal("§aYour enchantments have been restored!"));
            }

            storedEnchantments.remove(uuid); // ✅ Cleanup after restoring
        }

        affectedEntities.clear();
        affectedPlayers.clear();
    }



    public static void removeEnchantments(LivingEntity entity) {
        UUID entityId = entity.getUUID();
        if (entity instanceof Player) {
            affectedPlayers.add(entityId);
        } else {
            affectedEntities.add(entityId);
        }

        for (EquipmentSlot slot : EquipmentSlot.values()) {
            ItemStack itemStack = entity.getItemBySlot(slot);
            if (!itemStack.isEmpty() && itemStack.isEnchanted()) {
                storeEnchantments(entityId, slot, itemStack);

                // ✅ Mark the item so we know which one to restore
                CompoundTag tag = itemStack.getOrCreateTag();
                tag.putBoolean("RuneBreaker_Unenchanted", true);

                itemStack.removeTagKey("Enchantments"); // Remove enchantments
            }
        }
    }

    public static void storeEnchantments(UUID uuid, EquipmentSlot slot, ItemStack itemStack) {
        CompoundTag tag = itemStack.getOrCreateTag();

        if (tag.contains("Enchantments", 9)) {
            ListTag enchantments = tag.getList("Enchantments", 10);

            // ✅ Store enchantments inside the item itself
            tag.put("RuneBreaker_Enchantments", enchantments.copy());
            tag.putBoolean("RuneBreaker_Unenchanted", true); // ✅ Marks the item for restoration

            // ✅ Assign a unique ID to this item to track it (prevents duplicate items from conflicting)
            tag.putUUID("RuneBreaker_UUID", UUID.randomUUID());

            storedEnchantments.computeIfAbsent(uuid, k -> new HashMap<>())
                    .put(slot, new StoredEnchantment(slot, itemStack.copy(), enchantments));
        }
    }


    private static class StoredEnchantment {
        private final EquipmentSlot slot;
        private final UUID itemUUID;
        private final ListTag enchantmentData;

        public StoredEnchantment(EquipmentSlot slot, ItemStack itemStack, ListTag enchantmentData) {
            this.slot = slot;
            this.itemUUID = itemStack.getTag().getUUID("RuneBreaker_UUID"); // ✅ Store the item's unique ID
            this.enchantmentData = enchantmentData.copy();
        }

        public EquipmentSlot getSlot() {
            return slot;
        }

        public UUID getUUID() {
            return itemUUID;
        }

        public void restore(ItemStack targetItem) {
            targetItem.getOrCreateTag().put("Enchantments", enchantmentData);
        }
    }



    public static boolean isPlayerAffected(UUID playerId) {
        return affectedPlayers.contains(playerId);
    }
}
