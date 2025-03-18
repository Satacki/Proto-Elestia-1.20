package net.lykos.protogmt.items;

import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import net.lykos.protogmt.client.IdofrontArmorRenderer;
import net.lykos.protogmt.sound.ModSounds;
import net.lykos.protogmt.util.IPlayerCartridgeData;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.nbt.ListTag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.network.chat.Component;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.SimpleMenuProvider;
import net.lykos.protogmt.gui.BondrewdArmorScreenHandler;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.client.RenderProvider;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;

import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class IdofrontArmorItem extends ArmorItem implements GeoItem {
    private final AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);
    private final Supplier<Object> renderProvider = GeoItem.makeRenderer(this);

    public IdofrontArmorItem(ArmorMaterial material, Type type, Properties settings) {
        super(material, type, settings);
    }


    public void setCartridge(ItemStack chestplate, int slot, ItemStack cartridge) {
        CompoundTag tag = chestplate.getOrCreateTag();
        ListTag cartridges = tag.getList("Cartridges", 10);

        if (!cartridge.isEmpty()) {
            CompoundTag cartridgeTag = new CompoundTag();
            cartridge.save(cartridgeTag);
            if (cartridges.size() <= slot) {
                cartridges.add(cartridgeTag);
            } else {
                cartridges.set(slot, cartridgeTag);
            }
        } else {
            if (cartridges.size() > slot) {
                cartridges.remove(slot);
            }
        }

        tag.put("Cartridges", cartridges);
        chestplate.setTag(tag); // ✅ Force update

        updateCartridgeState(chestplate); // ✅ Ensure the "HasCartridge" NBT updates correctly
    }




    public ItemStack getCartridge(ItemStack chestplate, int slot) {
        CompoundTag tag = chestplate.getTag();
        if (tag != null && tag.contains("Cartridges")) {
            ListTag cartridges = tag.getList("Cartridges", 10);
            if (slot < cartridges.size()) {
                return ItemStack.of(cartridges.getCompound(slot));
            }
        }
        return ItemStack.EMPTY;
    }



    public boolean hasCartridge(ItemStack chestplate) {
        for (int i = 0; i < 3; i++) {
            if (!getCartridge(chestplate, i).isEmpty()) {
                return true;
            }
        }
        return false;
    }


    public boolean activateCartridge(Player player) {
        ItemStack chestplate = player.getItemBySlot(EquipmentSlot.CHEST);
        if (!(chestplate.getItem() instanceof IdofrontArmorItem)) return false;

        if (!hasCartridge(chestplate)) {
            System.out.println("[DEBUG] No cartridges left. Cannot activate.");
            return false; // 🚨 Prevent activation when no cartridges exist!
        }

        // Close GUI BEFORE consuming cartridge
        if (player instanceof ServerPlayer serverPlayer) {
            serverPlayer.closeContainer();
        }

        for (int i = 0; i < 3; i++) {
            ItemStack cartridge = getCartridge(chestplate, i);
            if (!cartridge.isEmpty()) {
                System.out.println("[DEBUG] Using Cartridge in Slot: " + i);

                setCartridge(chestplate, i, ItemStack.EMPTY);
                chestplate.setTag(chestplate.getOrCreateTag()); // Force inventory sync
                player.getInventory().setChanged(); // Ensure inventory updates

                if (player instanceof ServerPlayer serverPlayer) {
                    serverPlayer.inventoryMenu.broadcastChanges();
                }

                // Fix sound playing for all players
                player.level().playSound(player, player.getX(), player.getY(), player.getZ(),
                        ModSounds.CARTRIDGE_ACTIVATE, SoundSource.PLAYERS, 1.0f, 1.0f);

                // Apply Effects
                player.setHealth(2.0F);
                player.removeAllEffects();
                player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 900, 1));
                player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 900, 1));
                player.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 100, 1));
                player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 800, 0));

                if (player instanceof IPlayerCartridgeData playerData) {
                    playerData.setCartridgeImmunity(player.level().getGameTime() + (30 * 20));
                }

                updateCartridgeState(chestplate); // ✅ Update NBT to reflect cartridge usage

                return true; // Stop here, we used a cartridge
            }
        }

        return false; // No cartridges found!
    }


    public void updateCartridgeState(ItemStack chestplate) {
        CompoundTag tag = chestplate.getOrCreateTag();
        boolean hasCartridges = hasCartridge(chestplate); // Check if at least 1 cartridge exists
        tag.putBoolean("HasCartridge", hasCartridges); // ✅ Store in NBT
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot slot) {
        Multimap<Attribute, AttributeModifier> modifiers = LinkedHashMultimap.create(super.getDefaultAttributeModifiers(slot)); // ✅ Create a mutable copy

        if (slot == EquipmentSlot.CHEST) { // ✅ Apply only to the chestplate
            modifiers.put(Attributes.MOVEMENT_SPEED,
                    new AttributeModifier(UUID.fromString("123e4567-e89b-12d3-a456-426614174000"),
                            "Armor Speed Reduction", -0.0, AttributeModifier.Operation.MULTIPLY_TOTAL)); // ✅ Reduce speed by 10%
        }

        return modifiers;
    }




    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        ItemStack heldItem = player.getItemInHand(hand);

        if (!world.isClientSide && heldItem.getItem() == this) {
            // ✅ Prevent GUI from opening if the armor is being equipped
            if (player.getItemBySlot(EquipmentSlot.CHEST).isEmpty()) {
                player.openMenu(new SimpleMenuProvider(
                        (syncId, inv, p) -> new BondrewdArmorScreenHandler(syncId, inv, heldItem),
                        Component.literal("Cartridge Slots")
                ));
                return InteractionResultHolder.success(heldItem);
            }
        }
        return super.use(world, player, hand);
    }

    @Override
    public void createRenderer(Consumer<Object> consumer) {
        consumer.accept(new RenderProvider() {
            private IdofrontArmorRenderer renderer;

            @Override
            public HumanoidModel<LivingEntity> getHumanoidArmorModel(
                    LivingEntity livingEntity,
                    ItemStack itemStack,
                    EquipmentSlot equipmentSlot,
                    HumanoidModel<LivingEntity> original
            ) {
                if (this.renderer == null) this.renderer = new IdofrontArmorRenderer();

                this.renderer.prepForRender(livingEntity, itemStack, equipmentSlot, original);

                return this.renderer;
            }
        });
    }

    @Override
    public Supplier<Object> getRenderProvider() {
        return this.renderProvider;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController(this, "controller", 0, this::predicate));
    }

    private PlayState predicate(AnimationState animationState) {
        animationState.getController().setAnimation(RawAnimation.begin().then("idle", Animation.LoopType.LOOP));
        return PlayState.CONTINUE;
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }
}
