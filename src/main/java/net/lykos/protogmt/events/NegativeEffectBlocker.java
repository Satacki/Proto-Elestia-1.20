package net.lykos.protogmt.events;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.lykos.protogmt.util.IPlayerCartridgeData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;

import java.util.Set;

public class NegativeEffectBlocker {
    public static void register() {
        ServerTickEvents.END_SERVER_TICK.register(server -> {
            for (ServerPlayer player : server.getPlayerList().getPlayers()) {
                checkAndRemoveNegativeEffects(player);
            }
        });
    }

    private static void checkAndRemoveNegativeEffects(Player player) {
        long immunityEndTime = 0;
        if (player instanceof IPlayerCartridgeData playerData) {
            immunityEndTime = playerData.getCartridgeImmunity();
        }

        if (player.level().getGameTime() < immunityEndTime) {
            for (MobEffect effect : player.getActiveEffects().stream().map(e -> e.getEffect()).toList()) {
                if (isNegativeEffect(effect)) {
                    player.removeEffect(effect);
                }
            }
        }
    }

    private static boolean isNegativeEffect(MobEffect effect) {

        Set<MobEffect> blockedVanillaEffects = Set.of(
                MobEffects.POISON, MobEffects.WITHER, MobEffects.BLINDNESS,
                MobEffects.MOVEMENT_SLOWDOWN, MobEffects.WEAKNESS,
                MobEffects.LEVITATION, MobEffects.DARKNESS
        );

        if (blockedVanillaEffects.contains(effect)) {
            return true;
        }

        ResourceLocation effectID = BuiltInRegistries.MOB_EFFECT.getKey(effect);
        if (effectID == null) return false;

        Set<String> blockedModdedEffects = Set.of(
                "pickyourpoison:comatose",
                "pickyourpoison:batrachotoxin",
                "the_bumblezone:paralyzed"
        );

        return blockedModdedEffects.contains(effectID.toString());
    }
}
