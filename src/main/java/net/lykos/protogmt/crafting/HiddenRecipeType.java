package net.lykos.protogmt.crafting;

import net.minecraft.world.item.crafting.RecipeType;

/**
 * Custom recipe type for hidden recipes.
 */
public class HiddenRecipeType implements RecipeType<HiddenRecipe> {
    public static final HiddenRecipeType INSTANCE = new HiddenRecipeType();

    private HiddenRecipeType() {
    }
}
