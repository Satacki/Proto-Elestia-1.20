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
                return true; // Allow non-players to die normally
            }

            ItemStack chestplate = player.getItemBySlot(EquipmentSlot.CHEST);
            if (chestplate.getItem() instanceof IdofrontArmorItem armorItem) {
                if (armorItem.activateCartridge(player)) {
                    // Force inventory sync before death
                    player.inventoryMenu.broadcastChanges();
                    return false; // Prevent death
                }
            }
            return true; // Allow normal death
        });
    }
}
