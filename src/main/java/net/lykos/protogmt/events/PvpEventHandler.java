package net.lykos.protogmt.events;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.lykos.protogmt.items.StoneOfNeutralityItem;
import net.minecraft.server.level.ServerPlayer;
import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;

public class PvpEventHandler {
    public static void register() {
        // Prevent dealing PVP damage
        ServerLivingEntityEvents.ALLOW_DAMAGE.register((entity, source, amount) -> {
            if (entity instanceof ServerPlayer player) {
                if (source.getEntity() instanceof ServerPlayer attacker) {
                    // If the attacker OR the victim has the Stone of Neutrality, prevent damage
                    if (StoneOfNeutralityItem.isPvpDisabled(player) || StoneOfNeutralityItem.isPvpDisabled(attacker)) {
                        return false; // Prevent PVP damage
                    }
                }
            }
            return true; // Allow all other damage
        });

        // Prevent receiving PVP damage (Extra Check)
        ServerTickEvents.END_WORLD_TICK.register(world -> {
            for (ServerPlayer player : world.players()) {
                if (StoneOfNeutralityItem.isPvpDisabled(player)) {
                    player.invulnerableTime = 10; // Slight PVP invulnerability boost
                }
            }
        });
    }
}
