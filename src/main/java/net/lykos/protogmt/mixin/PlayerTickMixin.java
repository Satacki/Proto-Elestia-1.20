package net.lykos.protogmt.mixin;

import net.lykos.protogmt.items.RuneBreakerItem;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.core.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.UUID;

@Mixin(ServerPlayer.class)
public class PlayerTickMixin {
    @Inject(method = "tick", at = @At("HEAD"))
    private void onPlayerTick(CallbackInfo ci) {
        ServerPlayer player = (ServerPlayer) (Object) this;
        ServerLevel level = player.serverLevel();

        if (RuneBreakerItem.shouldRestoreEnchantments(player.getUUID(), level)) {
            RuneBreakerItem.restoreEnchantments(level);
        }
    }
}
