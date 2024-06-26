package net.lykos.protoelestia.item.custom;

import net.lykos.protoelestia.block.ModBlocks;
import net.lykos.protoelestia.util.ModTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class EtherScannerItem extends Item {
    public EtherScannerItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        if (!context.getWorld().isClient() && context.getPlayer() != null) {
            BlockPos positionClicked = context.getBlockPos();
            PlayerEntity player = context.getPlayer();
            boolean foundBlock = false;

            outerloop:
            for (int x = positionClicked.getX() - 8; x < positionClicked.getX() + 8; x++) {
                for (int y = positionClicked.getY(); y > -64; y--) {
                    for (int z = positionClicked.getZ() - 8; z < positionClicked.getZ() + 8; z++) { // Fixed variable from x to z
                        BlockPos posToCheck = new BlockPos(x, y, z);
                        BlockState blockState = context.getWorld().getBlockState(posToCheck);
                        Block block = blockState.getBlock();

                        if (isEther(blockState)) {
                            outputEtherCoordinates(posToCheck, player, block);

                            foundBlock = true;
                            break outerloop;
                        }
                    }
                }
            }

            if (!foundBlock) {
                player.sendMessage(Text.of("No Ether Found in the 16x16 Area")); // No bitches ?
            }
        }

        context.getStack().damage(1, context.getPlayer(),
                playerEntity -> playerEntity.sendToolBreakStatus(context.getHand()));

        return super.useOnBlock(context);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
       if(Screen.hasShiftDown()) {
           tooltip.add(Text.translatable("item.protoelestia.ether_scanner.tooltip.shiftkey"));
       } else {
           tooltip.add(Text.translatable("item.protoelestia.ether_scanner.tooltip"));
       }
    }

    private void outputEtherCoordinates(BlockPos position, PlayerEntity player, Block block) {
        player.sendMessage(Text.of(String.format("Ether Found! Transmitting Coordinates: %s at X: %s Y: %s Z: %s", block.getName().getString(), position.getX(), position.getY(), position.getZ()))); // Changed Text.literal to Text.of
    }

    private boolean isEther(BlockState blockState) {
        return blockState.isIn(ModTags.Blocks.ETHER_DETECTOR_ETHER_BLOCKS);
    }
}