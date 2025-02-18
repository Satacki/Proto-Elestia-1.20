package net.lykos.protogmt.mixin;

import net.lykos.protogmt.util.IPlayerCartridgeData;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(Player.class)
public abstract class PlayerMixin implements IPlayerCartridgeData {

    @Unique
    private long cartridgeImmunityEnd = 0;

    @Inject(method = "addAdditionalSaveData", at = @At("HEAD"))
    private void saveCartridgeImmunity(CompoundTag tag, CallbackInfo ci) {
        tag.putLong("CartridgeImmunityEnd", cartridgeImmunityEnd);
    }

    @Inject(method = "readAdditionalSaveData", at = @At("HEAD"))
    private void loadCartridgeImmunity(CompoundTag tag, CallbackInfo ci) {
        if (tag.contains("CartridgeImmunityEnd")) {
            cartridgeImmunityEnd = tag.getLong("CartridgeImmunityEnd");
        }
    }

    @Unique
    public void setCartridgeImmunity(long time) {
        this.cartridgeImmunityEnd = time;
    }

    @Unique
    public long getCartridgeImmunity() {
        return this.cartridgeImmunityEnd;
    }
}
