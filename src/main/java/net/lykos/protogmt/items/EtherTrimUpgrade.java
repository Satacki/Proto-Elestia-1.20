package net.lykos.protogmt.items;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class EtherTrimUpgrade extends Item {
    public EtherTrimUpgrade(Item.Properties settings) {
        super(settings);
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return true;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> tooltip, TooltipFlag context) {
        if (Screen.hasShiftDown()) {
            tooltip.add(Component.translatable("item.protogmt.ether_trim.tooltip.shiftkey"));
            tooltip.add(Component.translatable("item.protogmt.ether_trim.tooltip.shiftkey2"));
        } else {
            tooltip.add(Component.translatable("item.protogmt.ether_trim.tooltip"));
        }
    }
}