package net.lykos.protogmt.items;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class CorruptedWardenHeart extends Item {
    public CorruptedWardenHeart(Item.Properties settings) {
        super(settings);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player playerEntity, InteractionHand hand) {
        playerEntity.playSound(SoundEvents.WARDEN_HEARTBEAT, 3.0F, 1.0F);

        return InteractionResultHolder.fail(playerEntity.getItemInHand(hand));
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return true;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> tooltip, TooltipFlag flags) {
        if (Screen.hasShiftDown()) {
            tooltip.add(Component.translatable("item.protogmt.warden_heart_corrupted.tooltip.shiftkey"));
        } else {
            tooltip.add(Component.translatable("item.protogmt.warden_heart_corrupted.tooltip"));
        }
    }

}

