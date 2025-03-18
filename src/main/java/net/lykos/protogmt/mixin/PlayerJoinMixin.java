package net.lykos.protogmt.mixin;

import net.lykos.protogmt.items.RuneBreakerItem;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.UUID;

import static net.lykos.protogmt.items.RuneBreakerItem.restoreEnchantments;
import static net.lykos.protogmt.items.RuneBreakerItem.shouldRestoreEnchantments;

@Mixin(ServerPlayer.class)
public class PlayerJoinMixin {

    @Inject(method = "restoreFrom", at = @At("HEAD"))
    private void onPlayerJoin(ServerPlayer oldPlayer, boolean alive, CallbackInfo ci) {
        ServerPlayer player = (ServerPlayer) (Object) this; // Get the player instance
        UUID playerId = player.getUUID();
        ServerLevel level = player.serverLevel(); // Get the ServerLevel

        if (shouldRestoreEnchantments(player.getUUID(), level)) {
            restoreEnchantments(level);
        }

    }
}
