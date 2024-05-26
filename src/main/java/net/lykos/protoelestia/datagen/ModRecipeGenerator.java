package net.lykos.protoelestia.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.lykos.protoelestia.block.ModBlocks;
import net.lykos.protoelestia.item.ModItems;
import net.minecraft.data.server.recipe.CookingRecipeJsonBuilder;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.RecipeProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeGenerator extends FabricRecipeProvider {
    public ModRecipeGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.HOLY_CHEESE)
                .pattern("SSS")
                .pattern("SPS")
                .pattern("SSS")
                .input('S', Items.MILK_BUCKET)
                .input('P', ModItems.ETHER)
                .criterion(hasItem(Items.MILK_BUCKET), conditionsFromItem(Items.MILK_BUCKET))
                .criterion(hasItem(ModItems.ETHER), conditionsFromItem(ModItems.ETHER))
                .offerTo(exporter, convertBetween(ModItems.HOLY_CHEESE, ModItems.ETHER));

        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.MITHRIL_INGOT, RecipeCategory.MISC, ModBlocks.MITHRIL_PURE_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.MITHRIL_RAW, RecipeCategory.MISC, ModBlocks.MITHRIL_IMPURE_BLOCK);

        CookingRecipeJsonBuilder.createSmoking(Ingredient.ofItems(ModItems.MITHRIL_RAW), RecipeCategory.MISC, ModItems.MITHRIL_INGOT, 100, 2000)
                .criterion(hasItem(ModItems.MITHRIL_RAW), conditionsFromItem(ModItems.MITHRIL_RAW))
                .offerTo(exporter, getRecipeName(ModItems.MITHRIL_INGOT) + "_from_smoking");

        CookingRecipeJsonBuilder.createCampfireCooking(Ingredient.ofItems(ModItems.MITHRIL_RAW), RecipeCategory.MISC, ModItems.MITHRIL_INGOT, 200, 4000)
                .criterion(hasItem(ModItems.MITHRIL_RAW), conditionsFromItem(ModItems.MITHRIL_RAW))
                .offerTo(exporter, getRecipeName(ModItems.MITHRIL_INGOT) + "_from_campfire");

        CookingRecipeJsonBuilder.createCampfireCooking(Ingredient.ofItems(ModBlocks.MITHRIL_IMPURE_BLOCK), RecipeCategory.MISC, ModBlocks.MITHRIL_PURE_BLOCK, 1800, 36000)
                .criterion(hasItem(ModBlocks.MITHRIL_IMPURE_BLOCK), conditionsFromItem(ModBlocks.MITHRIL_IMPURE_BLOCK))
                .offerTo(exporter, getRecipeName(ModBlocks.MITHRIL_PURE_BLOCK) + "_from_campfire");

        CookingRecipeJsonBuilder.createSmoking(Ingredient.ofItems(ModBlocks.MITHRIL_IMPURE_BLOCK), RecipeCategory.MISC, ModBlocks.MITHRIL_PURE_BLOCK, 900, 18000)
                .criterion(hasItem(ModBlocks.MITHRIL_IMPURE_BLOCK), conditionsFromItem(ModBlocks.MITHRIL_IMPURE_BLOCK))
                .offerTo(exporter, getRecipeName(ModBlocks.MITHRIL_PURE_BLOCK) + "_from_smoking");

        offerPressurePlateRecipe(exporter, ModBlocks.MITHRIL_PURE_PRESSURE_PLATE, ModItems.MITHRIL_INGOT);
        offerSingleOutputShapelessRecipe(exporter, ModBlocks.MITHRIL_PURE_BUTTON, ModItems.MITHRIL_INGOT, "mithril_button");
        
    }
}
