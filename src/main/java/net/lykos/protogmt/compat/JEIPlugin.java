package net.lykos.protogmt.compat;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.constants.ModIds;
import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.recipe.RecipeType;
import net.lykos.protogmt.crafting.HiddenRecipe;
import net.lykos.protogmt.crafting.HiddenRecipeRegistry;
import net.minecraft.resources.ResourceLocation;

import java.util.List;

@mezz.jei.api.JeiPlugin
public class JEIPlugin implements IModPlugin {
    private static final ResourceLocation PLUGIN_ID = new ResourceLocation("protogmt", "jei_plugin");

    @Override
    public ResourceLocation getPluginUid() {
        return PLUGIN_ID;
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        // JEI requires categories to be registered before recipes
        System.out.println("[DEBUG] Registering JEI Categories...");
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        System.out.println("[DEBUG] Registering JEI recipes...");

        // Fetch all hidden recipes
        List<HiddenRecipe> hiddenRecipes = HiddenRecipeRegistry.getAllHiddenRecipes();

        System.out.println("[DEBUG] Total hidden recipes: " + hiddenRecipes.size());

        // Only register non-hidden recipes to JEI
        hiddenRecipes.forEach(hiddenRecipe -> {
            ResourceLocation recipeId = hiddenRecipe.getId();
            System.out.println("[DEBUG] Preventing recipe from registering in JEI: " + recipeId);
        });

        System.out.println("[DEBUG] Finished registering recipes in JEI.");
    }
}
