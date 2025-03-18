package net.lykos.protogmt.events;

import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import net.minecraft.server.level.ServerPlayer;

public class RespawnHandler {
    public static void register() {
        ServerPlayerEvents.AFTER_RESPAWN.register((oldPlayer, newPlayer, alive) -> {
            System.out.println("[DEBUG] Player " + newPlayer.getName().getString() + " has respawned.");

            // ✅ **Ensure inventory sync after respawn**
            newPlayer.inventoryMenu.broadcastChanges();

            // ✅ **Prevent stuck death loops by forcing movement**
            newPlayer.teleportTo(newPlayer.getX(), newPlayer.getY() + 1, newPlayer.getZ());
        });
    }
}
