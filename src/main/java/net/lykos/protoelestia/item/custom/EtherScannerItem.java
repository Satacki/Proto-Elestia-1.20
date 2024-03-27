package net.lykos.protoelestia.item.custom;

import net.lykos.protoelestia.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;

public class EtherScannerItem extends Item{
    public EtherScannerItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        if (!context.getWorld().isClient() && context.getPlayer() != null) {
            BlockPos positionClicked = context.getBlockPos();
            PlayerEntity player = context.getPlayer();
            boolean foundBlock = false;

            outerloop: for (int x = positionClicked.getX() - 8; x < positionClicked.getX() + 8; x++) {
                for (int y = positionClicked.getY(); y > -64; y--) {
                    for (int z = positionClicked.getZ() - 8; x < positionClicked.getZ() + 8; x++) {
                        // use x, y, z here for the exact positions from the origin of the world
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


            if (!foundBlock){
                player.sendMessage(Text.literal("No Ether Found in the 16x16 Area")); // No Bitches ?
            }


        }

        context.getStack().damage(1, context.getPlayer(),
                playerEntity -> playerEntity.sendToolBreakStatus(context.getHand()));

        return super.useOnBlock(context);
    }

    private void outputEtherCoordinates(BlockPos position, PlayerEntity player, Block block) {
        player.sendMessage(Text.literal(String.format("Ether Found! Transmitting Coordinates: %s at X: %s Y: %s Z: %s", block.getName().getString(), position.getX(), position.getY(), position.getZ())));
    }

    private boolean isEther(BlockState blockState) {
        return blockState.isOf(ModBlocks.ETHER_ORE) || blockState.isOf(ModBlocks.DEEPSLATE_ETHER_ORE);
    }
}