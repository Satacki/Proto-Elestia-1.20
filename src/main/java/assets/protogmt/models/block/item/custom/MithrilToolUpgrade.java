package assets.protogmt.models.block.item.custom;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class MithrilToolUpgrade extends Item {
    public MithrilToolUpgrade(Settings settings) {
        super(settings);
    }


    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if(Screen.hasShiftDown()) {
            tooltip.add(Text.translatable("item.protogmt.mithril_tool.tooltip.shiftkey"));
            tooltip.add(Text.translatable("item.protogmt.mithril_tool.tooltip.shiftkey2"));
        } else {
            tooltip.add(Text.translatable("item.protogmt.mithril_tool.tooltip"));
        }
    }
    }