package assets.protogmt.models.block.item.custom;

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

public class TheKey extends Item {
    public TheKey(Settings settings) {
        super(settings);
    }
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {
        playerEntity.playSound(SoundEvents.BLOCK_END_PORTAL_FRAME_FILL, 3.0F, 1.0F);
        return TypedActionResult.fail(playerEntity.getStackInHand(hand));
    }
    @Override
    public boolean hasGlint(ItemStack stack) {
        return true;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if(Screen.hasShiftDown()) {
            tooltip.add(Text.translatable("item.protogmt.the_key.tooltip.shiftkey"));
            tooltip.add(Text.translatable("item.protogmt.the_key.tooltip.shiftkey2"));
        } else {
            tooltip.add(Text.translatable("item.protogmt.the_key.tooltip"));
            tooltip.add(Text.translatable("item.protogmt.the_key.tooltip2"));
        }
    }

}

