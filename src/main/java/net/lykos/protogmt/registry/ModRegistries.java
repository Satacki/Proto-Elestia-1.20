package net.lykos.protogmt.registry;

import net.lykos.protogmt.crafting.HiddenRecipe;
import net.lykos.protogmt.crafting.HiddenRecipeSerializer;
import net.lykos.protogmt.crafting.HiddenRecipeType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.core.Registry;

public class ModRegistries {
    public static final RecipeType<HiddenRecipe> HIDDEN_RECIPE_TYPE = HiddenRecipeType.INSTANCE;
    public static final RecipeSerializer<HiddenRecipe> HIDDEN_RECIPE_SERIALIZER = HiddenRecipeSerializer.INSTANCE;

    public static void register() {
        Registry.register(BuiltInRegistries.RECIPE_TYPE, new ResourceLocation("protogmt", "hidden_recipe"), HIDDEN_RECIPE_TYPE);
        Registry.register(BuiltInRegistries.RECIPE_SERIALIZER, new ResourceLocation("protogmt", "hidden_recipe"), HIDDEN_RECIPE_SERIALIZER);
    }
}
