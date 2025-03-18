package net.lykos.protogmt.handlers;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.lykos.protogmt.items.RuneBreakerItem;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;

import java.util.UUID;

public class RuneBreakerTickHandler {
    public static void registerTickHandler() {
        ServerTickEvents.END_SERVER_TICK.register(server -> checkRestoreEnchantments(server));
    }

    private static void checkRestoreEnchantments(MinecraftServer server) {
        long currentTick = server.getTickCount(); // Get current server tick count

        for (ServerLevel level : server.getAllLevels()) {
            RuneBreakerItem.cooldowns.entrySet().removeIf(entry -> {
                UUID playerId = entry.getKey();
                long restoreTick = entry.getValue();

                if (currentTick >= restoreTick) {
                    RuneBreakerItem.restoreEnchantments(level);
                    return true; // Remove from cooldown list after restoration
                }
                return false;
            });
        }
    }
}
