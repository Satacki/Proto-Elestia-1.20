package net.lykos.protogmt.crafting;

import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;

public interface IHiddenRecipe {
    ItemStack assemble(Container inv);

}
