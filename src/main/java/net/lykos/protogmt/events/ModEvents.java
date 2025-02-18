package net.lykos.protogmt.events;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.lykos.protogmt.items.IdofrontArmorItem;

public class ModEvents {
    public static void register() {
        ServerTickEvents.END_SERVER_TICK.register(server -> {
            for (ServerPlayer player : server.getPlayerList().getPlayers()) {
                if (player.getHealth() <= 0.5F) {
                    ItemStack chestplate = player.getItemBySlot(EquipmentSlot.CHEST);
                    if (chestplate.getItem() instanceof IdofrontArmorItem) {
                        if (((IdofrontArmorItem) chestplate.getItem()).activateCartridge(player)) {
                            return;
                        }
                    }
                }
            }
        });
    }
}
