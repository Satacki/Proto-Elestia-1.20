package net.lykos.protoelestia.item.custom;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class EtherTrimUpgrade extends Item {
    public EtherTrimUpgrade(Settings settings) {
        super(settings);
    }
        @Override
        public boolean hasGlint(ItemStack stack) {
            return true;
        }


    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if(Screen.hasShiftDown()) {
            tooltip.add(Text.translatable("item.protoelestia.ether_trim.tooltip.shiftkey"));
            tooltip.add(Text.translatable("item.protoelestia.ether_trim.tooltip.shiftkey2"));
        } else {
            tooltip.add(Text.translatable("item.protoelestia.ether_trim.tooltip"));
        }
    }
    }