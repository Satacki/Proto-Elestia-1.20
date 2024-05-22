package net.lykos.protoelestia.item.custom;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class CorruptedWardenHeart extends Item {
    public CorruptedWardenHeart(Settings settings) {
        super(settings);
    }
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {
        playerEntity.playSound(SoundEvents.ENTITY_WARDEN_HEARTBEAT, 3.0F, 1.0F);
        return TypedActionResult.fail(playerEntity.getStackInHand(hand));
    }


    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if(Screen.hasShiftDown()) {
            tooltip.add(Text.translatable("item.protoelestia.warden_heart_corrupted.tooltip.shiftkey"));
        } else {
            tooltip.add(Text.translatable("item.protoelestia.warden_heart_corrupted.tooltip"));
        }
    }

}

