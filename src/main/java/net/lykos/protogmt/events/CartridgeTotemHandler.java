package net.lykos.protogmt.events;

import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.lykos.protogmt.items.IdofrontArmorItem;

public class CartridgeTotemHandler {
    public static void register() {
        ServerLivingEntityEvents.ALLOW_DEATH.register((LivingEntity entity, DamageSource source, float amount) -> {
            if (!(entity instanceof ServerPlayer player)) {
                return true; // Allow normal death for non-players
            }

            ItemStack chestplate = player.getItemBySlot(EquipmentSlot.CHEST);
            if (chestplate.getItem() instanceof IdofrontArmorItem armorItem) {

                // ✅ Check if the armor has any cartridges left
                if (!armorItem.hasCartridge(chestplate)) {
                    System.out.println("[DEBUG] No cartridges left. Allowing death.");
                    return true; // Allow normal death
                }

                // ✅ Cartridge is available, activate it
                if (armorItem.activateCartridge(player)) {
                    System.out.println("[DEBUG] Cartridge used, preventing death.");
                    player.setHealth(2.0F); // Prevent limbo state
                    player.clearFire();
                    player.setRemainingFireTicks(0);
                    player.getCombatTracker().recheckStatus();
                    player.inventoryMenu.broadcastChanges();
                    return false; // Prevent death
                }
            }

            return true; // Default: allow normal death
        });
    }
}
