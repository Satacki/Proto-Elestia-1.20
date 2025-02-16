package net.lykos.protogmt.items;

import net.lykos.protogmt.util.ModTags;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class EtherScannerItem extends Item {
    public EtherScannerItem(Item.Properties settings) {
        super(settings);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        if (!context.getLevel().isClientSide() && context.getPlayer() != null) {
            BlockPos positionClicked = context.getClickedPos();
            Player player = context.getPlayer();
            boolean foundBlock = false;

            outerloop:
            for (int x = positionClicked.getX() - 8; x < positionClicked.getX() + 8; x++) {
                for (int y = positionClicked.getY(); y > -64; y--) {
                    for (int z = positionClicked.getZ() - 8; z <
                                                             positionClicked.getZ() +
                                                             8; z++) { // Fixed variable from x to z
                        BlockPos posToCheck = new BlockPos(x, y, z);
                        BlockState blockState = context.getLevel().getBlockState(posToCheck);
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
                player.sendSystemMessage(Component.literal("No Ether Found in the 16x16 Area")); // No bitches ?
            }
        }

        context.getItemInHand().hurtAndBreak(1, context.getPlayer(),
                                             playerEntity -> playerEntity.broadcastBreakEvent(context.getHand())
        );

        return super.useOn(context);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> tooltip, TooltipFlag context) {
        if (Screen.hasShiftDown()) {
            tooltip.add(Component.translatable("item.protogmt.ether_scanner.tooltip.shiftkey"));
        } else {
            tooltip.add(Component.translatable("item.protogmt.ether_scanner.tooltip"));
        }
    }

    private void outputEtherCoordinates(BlockPos position, Player player, Block block) {
        player.sendSystemMessage(Component.literal(String.format(
                "Ether Found! Transmitting Coordinates: %s at X: %s Y: %s Z: %s",
                block.getName().getString(),
                position.getX(),
                position.getY(),
                position.getZ()
        ))); // Changed Text.literal to Text.of
    }

    private boolean isEther(BlockState blockState) {
        return blockState.is(ModTags.Blocks.ETHER_DETECTOR_ETHER_BLOCKS);
    }
}