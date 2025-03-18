package net.lykos.protogmt.crafting;

import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Manages hidden recipes in the mod.
 */
public class HiddenRecipeRegistry {
    private static final Map<ResourceLocation, HiddenRecipe> HIDDEN_RECIPES = new HashMap<>();

    /**
     * Adds a hidden recipe.
     *
     * @param id          The recipe ID.
     * @param ingredients The ingredients used in the recipe.
     * @param output      The output item.
     */
    public static void addRecipe(ResourceLocation id, ItemStack[][] ingredients, ItemStack output) {
        NonNullList<Ingredient> ingredientList = NonNullList.create();
        for (ItemStack[] stacks : ingredients) {
            ingredientList.add(Ingredient.of(stacks)); // Convert ItemStack to Ingredient
        }

        HiddenRecipe recipe = new HiddenRecipe(id, ingredientList, output);
        HIDDEN_RECIPES.put(id, recipe);
    }

    /**
     * Retrieves all hidden recipes.
     *
     * @return A list of all hidden recipes.
     */
    public static List<HiddenRecipe> getAllHiddenRecipes() {
        return new ArrayList<>(HIDDEN_RECIPES.values());
    }

    /**
     * Retrieves the RecipeManager from the server.
     *
     * @param server The Minecraft server instance.
     * @return The RecipeManager instance.
     */
    public static RecipeManager getRecipeManager(MinecraftServer server) {
        return server.getRecipeManager();
    }
}
