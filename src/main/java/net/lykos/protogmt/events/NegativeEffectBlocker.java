package net.lykos.protogmt.events;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.lykos.protogmt.mixin.PlayerMixin;
import net.lykos.protogmt.util.IPlayerCartridgeData;
import net.lykos.protogmt.util.ModEntityData;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

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


// ✅ If immunity is active, remove negative effects
        if (player.level().getGameTime() < immunityEndTime) {
            for (MobEffect effect : player.getActiveEffects().stream().map(e -> e.getEffect()).toList()) {
                if (isNegativeEffect(effect)) {
                    player.removeEffect(effect);
                }
            }
        }

    }

    private static boolean isNegativeEffect(MobEffect effect) {
        return effect == MobEffects.POISON || effect == MobEffects.WITHER || effect == MobEffects.BLINDNESS
                || effect == MobEffects.MOVEMENT_SLOWDOWN || effect == MobEffects.WEAKNESS || effect == MobEffects.UNLUCK
                || effect == MobEffects.LEVITATION || effect == MobEffects.BAD_OMEN;
    }
}
