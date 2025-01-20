package net.lykos.protogmt.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.lykos.protogmt.ProtoGMT;
import net.lykos.protogmt.block.ModBlocks;
import assets.protogmt.models.block.item.ModItems;
import net.minecraft.data.server.recipe.CookingRecipeJsonBuilder;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.SmithingTransformRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

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
                .input('S', ModBlocks.MITHRIL_PURE_BLOCK)
                .input('P', Items.MILK_BUCKET)
                .criterion(hasItem(Items.MILK_BUCKET), conditionsFromItem(Items.MILK_BUCKET))
                .criterion(hasItem(ModBlocks.MITHRIL_PURE_BLOCK), conditionsFromItem(ModBlocks.MITHRIL_IMPURE_BLOCK))
                .offerTo(exporter, convertBetween(ModItems.HOLY_CHEESE, ModBlocks.MITHRIL_PURE_BLOCK));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ETHER_TRIM_UPGRADE)
                .pattern("QNQ")
                .pattern("QPQ")
                .pattern("QQQ")
                .input('Q', Items.QUARTZ)
                .input('N', ModItems.MITHRIL_TOOL_UPGRADE)
                .input('P', ModItems.ETHER)
                .criterion(hasItem(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE), conditionsFromItem(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE))
                .criterion(hasItem(ModBlocks.MITHRIL_PURE_BLOCK), conditionsFromItem(ModBlocks.MITHRIL_PURE_BLOCK))
                .criterion(hasItem(ModItems.ETHER), conditionsFromItem(ModItems.ETHER))
                .offerTo(exporter, convertBetween(ModItems.ETHER, ModItems.ETHER_TRIM_UPGRADE));

                ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.MITHRIL_TOOL_UPGRADE)
                .pattern("SUS")
                .pattern("SPS")
                .pattern("PPP")
                .input('S', ModBlocks.MITHRIL_IMPURE_BLOCK)
                .input('U', Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE)
                .input('P', ModBlocks.MITHRIL_PURE_BLOCK)
                .criterion(hasItem(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE), conditionsFromItem(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE))
                .criterion(hasItem(ModBlocks.MITHRIL_IMPURE_BLOCK), conditionsFromItem(ModBlocks.MITHRIL_IMPURE_BLOCK))
                .criterion(hasItem(ModBlocks.MITHRIL_PURE_BLOCK), conditionsFromItem(ModBlocks.MITHRIL_PURE_BLOCK))
                .offerTo(exporter, convertBetween(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE, ModItems.MITHRIL_TOOL_UPGRADE));




        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.PURIFIED_WARDEN_HEART)
                .pattern("CEC")
                .pattern("VHA")
                .pattern("MMM")
                .input('C', ModItems.HOLY_CHEESE)
                .input('E', ModItems.ETHER)
                .input('V', ModItems.VEX_CORE)
                .input('H', ModItems.CORRUPTED_WARDEN_HEART)
                .input('A', ModItems.ALLEY_CORE)
                .input('M', ModBlocks.MITHRIL_PURE_BLOCK)
                .criterion(hasItem(ModItems.HOLY_CHEESE), conditionsFromItem(ModItems.HOLY_CHEESE))
                .criterion(hasItem(ModItems.ETHER), conditionsFromItem(ModItems.ETHER))
                .criterion(hasItem(ModItems.CORRUPTED_WARDEN_HEART), conditionsFromItem(ModItems.CORRUPTED_WARDEN_HEART))
                .criterion(hasItem(ModItems.VEX_CORE), conditionsFromItem(ModItems.VEX_CORE))
                .criterion(hasItem(ModItems.ALLEY_CORE), conditionsFromItem(ModItems.ALLEY_CORE))
                .criterion(hasItem(ModBlocks.MITHRIL_PURE_BLOCK), conditionsFromItem(ModBlocks.MITHRIL_PURE_BLOCK))
                .offerTo(exporter, convertBetween(ModItems.PURIFIED_WARDEN_HEART, ModItems.ETHER));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.THE_KEY)
                .pattern("VEA")
                .pattern("HDN")
                .pattern("SYR")
                .input('E', ModItems.ETHER)
                .input('V', ModItems.VEX_SOUL)
                .input('H', ModItems.PURIFIED_WARDEN_HEART)
                .input('A', ModItems.ALLEY_SOUL)
                .input('D', Items.DRAGON_EGG)
                .input('S', Items.ECHO_SHARD)
                .input('N', Items.NETHER_STAR)
                .input('Y', Items.ENDER_EYE)
                .input('R', Items.WITHER_ROSE)
                .criterion(hasItem(Items.DRAGON_EGG), conditionsFromItem(Items.DRAGON_EGG))
                .criterion(hasItem(ModItems.ETHER), conditionsFromItem(ModItems.ETHER))
                .criterion(hasItem(ModItems.PURIFIED_WARDEN_HEART), conditionsFromItem(ModItems.PURIFIED_WARDEN_HEART))
                .criterion(hasItem(ModItems.VEX_SOUL), conditionsFromItem(ModItems.VEX_SOUL))
                .criterion(hasItem(ModItems.ALLEY_SOUL), conditionsFromItem(ModItems.ALLEY_SOUL))
                .criterion(hasItem(Items.ECHO_SHARD), conditionsFromItem(Items.ECHO_SHARD))
                .criterion(hasItem(Items.NETHER_STAR), conditionsFromItem(Items.NETHER_STAR))
                .criterion(hasItem(Items.ENDER_EYE), conditionsFromItem(Items.ENDER_EYE))
                .criterion(hasItem(Items.WITHER_ROSE), conditionsFromItem(Items.WITHER_ROSE))
                .offerTo(exporter, convertBetween(ModItems.THE_KEY, ModItems.ETHER));

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
        offerWallRecipe(exporter,RecipeCategory.BUILDING_BLOCKS, ModBlocks.MITHRIL_PURE_WALL, ModBlocks.MITHRIL_PURE_BLOCK);


        //A changer
        SmithingTransformRecipeJsonBuilder.create(
                Ingredient.ofItems(ModItems.HOLY_CHEESE),
                Ingredient.ofItems(Items.NETHERITE_INGOT),
                Ingredient.ofItems(ModItems.MITHRIL_INGOT),
                RecipeCategory.MISC, ModItems.ETHER)
                .criterion(hasItem(ModItems.HOLY_CHEESE), conditionsFromItem(ModItems.HOLY_CHEESE))
                .criterion(hasItem(Items.NETHERITE_INGOT), conditionsFromItem(Items.NETHERITE_INGOT))
                .criterion(hasItem(ModItems.MITHRIL_INGOT), conditionsFromItem(ModItems.MITHRIL_INGOT))
                .offerTo(exporter, new Identifier(ProtoGMT.MOD_ID, "ether_lost_craft"));



        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(ModItems.ETHER_TRIM_UPGRADE),
                        Ingredient.ofItems(Items.NETHERITE_HELMET),
                        Ingredient.ofItems(ModItems.ETHER),
                        RecipeCategory.MISC, ModItems.NETHERITE_ETHER_UPGRADED_HELMET)
                .criterion(hasItem(ModItems.ETHER_TRIM_UPGRADE), conditionsFromItem(ModItems.ETHER_TRIM_UPGRADE))
                .criterion(hasItem(Items.NETHERITE_HELMET), conditionsFromItem(Items.NETHERITE_HELMET))
                .criterion(hasItem(ModItems.ETHER), conditionsFromItem(ModItems.ETHER))
                .offerTo(exporter, new Identifier(ProtoGMT.MOD_ID, "ether_helmet"));

                SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(ModItems.ETHER_TRIM_UPGRADE),
                        Ingredient.ofItems(Items.NETHERITE_CHESTPLATE),
                        Ingredient.ofItems(ModItems.ETHER),
                        RecipeCategory.MISC, ModItems.NETHERITE_ETHER_UPGRADED_CHESTPLATE)
                .criterion(hasItem(ModItems.ETHER_TRIM_UPGRADE), conditionsFromItem(ModItems.ETHER_TRIM_UPGRADE))
                .criterion(hasItem(Items.NETHERITE_CHESTPLATE), conditionsFromItem(Items.NETHERITE_CHESTPLATE))
                .criterion(hasItem(ModItems.ETHER), conditionsFromItem(ModItems.ETHER))
                .offerTo(exporter, new Identifier(ProtoGMT.MOD_ID, "ether_chestplate"));

                SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(ModItems.ETHER_TRIM_UPGRADE),
                        Ingredient.ofItems(Items.NETHERITE_LEGGINGS),
                        Ingredient.ofItems(ModItems.ETHER),
                        RecipeCategory.MISC, ModItems.NETHERITE_ETHER_UPGRADED_LEGGINGS)
                .criterion(hasItem(ModItems.ETHER_TRIM_UPGRADE), conditionsFromItem(ModItems.ETHER_TRIM_UPGRADE))
                .criterion(hasItem(Items.NETHERITE_LEGGINGS), conditionsFromItem(Items.NETHERITE_LEGGINGS))
                .criterion(hasItem(ModItems.ETHER), conditionsFromItem(ModItems.ETHER))
                .offerTo(exporter, new Identifier(ProtoGMT.MOD_ID, "ether_leggings"));

                SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(ModItems.ETHER_TRIM_UPGRADE),
                        Ingredient.ofItems(Items.NETHERITE_BOOTS),
                        Ingredient.ofItems(ModItems.ETHER),
                        RecipeCategory.MISC, ModItems.NETHERITE_ETHER_UPGRADED_BOOTS)
                .criterion(hasItem(ModItems.ETHER_TRIM_UPGRADE), conditionsFromItem(ModItems.ETHER_TRIM_UPGRADE))
                .criterion(hasItem(Items.NETHERITE_BOOTS), conditionsFromItem(Items.NETHERITE_BOOTS))
                .criterion(hasItem(ModItems.ETHER), conditionsFromItem(ModItems.ETHER))
                .offerTo(exporter, new Identifier(ProtoGMT.MOD_ID, "ether_boots"));

                SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(ModItems.ETHER_TRIM_UPGRADE),
                        Ingredient.ofItems(ModItems.MITHRIL_PICKAXE),
                        Ingredient.ofItems(ModItems.ETHER),
                        RecipeCategory.MISC, ModItems.ETHER_PICKAXE)
                .criterion(hasItem(ModItems.ETHER_TRIM_UPGRADE), conditionsFromItem(ModItems.ETHER_TRIM_UPGRADE))
                .criterion(hasItem(ModItems.MITHRIL_PICKAXE), conditionsFromItem(ModItems.MITHRIL_PICKAXE))
                .criterion(hasItem(ModItems.ETHER), conditionsFromItem(ModItems.ETHER))
                .offerTo(exporter, new Identifier(ProtoGMT.MOD_ID, "ether_pickaxe"));

                SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(ModItems.ETHER_TRIM_UPGRADE),
                        Ingredient.ofItems(ModItems.MITHRIL_AXE),
                        Ingredient.ofItems(ModItems.ETHER),
                        RecipeCategory.MISC, ModItems.ETHER_AXE)
                .criterion(hasItem(ModItems.ETHER_TRIM_UPGRADE), conditionsFromItem(ModItems.ETHER_TRIM_UPGRADE))
                .criterion(hasItem(ModItems.MITHRIL_AXE), conditionsFromItem(ModItems.MITHRIL_AXE))
                .criterion(hasItem(ModItems.ETHER), conditionsFromItem(ModItems.ETHER))
                .offerTo(exporter, new Identifier(ProtoGMT.MOD_ID, "ether_axe"));

                SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(ModItems.ETHER_TRIM_UPGRADE),
                        Ingredient.ofItems(ModItems.MITHRIL_HOE),
                        Ingredient.ofItems(ModItems.ETHER),
                        RecipeCategory.MISC, ModItems.ETHER_HOE)
                .criterion(hasItem(ModItems.ETHER_TRIM_UPGRADE), conditionsFromItem(ModItems.ETHER_TRIM_UPGRADE))
                .criterion(hasItem(ModItems.MITHRIL_HOE), conditionsFromItem(ModItems.MITHRIL_HOE))
                .criterion(hasItem(ModItems.ETHER), conditionsFromItem(ModItems.ETHER))
                .offerTo(exporter, new Identifier(ProtoGMT.MOD_ID, "ether_hoe"));

                SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(ModItems.ETHER_TRIM_UPGRADE),
                        Ingredient.ofItems(ModItems.MITHRIL_SHOVEL),
                        Ingredient.ofItems(ModItems.ETHER),
                        RecipeCategory.MISC, ModItems.ETHER_SHOVEL)
                .criterion(hasItem(ModItems.ETHER_TRIM_UPGRADE), conditionsFromItem(ModItems.ETHER_TRIM_UPGRADE))
                .criterion(hasItem(ModItems.MITHRIL_SHOVEL), conditionsFromItem(ModItems.MITHRIL_SHOVEL))
                .criterion(hasItem(ModItems.ETHER), conditionsFromItem(ModItems.ETHER))
                .offerTo(exporter, new Identifier(ProtoGMT.MOD_ID, "ether_shovel"));

                SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(ModItems.ETHER_TRIM_UPGRADE),
                        Ingredient.ofItems(ModItems.MITHRIL_SWORD),
                        Ingredient.ofItems(ModItems.ETHER),
                        RecipeCategory.MISC, ModItems.ETHER_SWORD)
                .criterion(hasItem(ModItems.ETHER_TRIM_UPGRADE), conditionsFromItem(ModItems.ETHER_TRIM_UPGRADE))
                .criterion(hasItem(ModItems.MITHRIL_SWORD), conditionsFromItem(ModItems.MITHRIL_SWORD))
                .criterion(hasItem(ModItems.ETHER), conditionsFromItem(ModItems.ETHER))
                .offerTo(exporter, new Identifier(ProtoGMT.MOD_ID, "ether_sword"));

                SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(ModItems.MITHRIL_TOOL_UPGRADE),
                        Ingredient.ofItems(Items.NETHERITE_PICKAXE),
                        Ingredient.ofItems(ModItems.MITHRIL_INGOT),
                        RecipeCategory.MISC, ModItems.MITHRIL_PICKAXE)
                .criterion(hasItem(ModItems.MITHRIL_TOOL_UPGRADE), conditionsFromItem(ModItems.MITHRIL_TOOL_UPGRADE))
                .criterion(hasItem(Items.NETHERITE_PICKAXE), conditionsFromItem(Items.NETHERITE_PICKAXE))
                .criterion(hasItem(ModItems.MITHRIL_INGOT), conditionsFromItem(ModItems.MITHRIL_INGOT))
                .offerTo(exporter, new Identifier(ProtoGMT.MOD_ID, "mithril_pickaxe"));

                SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(ModItems.MITHRIL_TOOL_UPGRADE),
                        Ingredient.ofItems(Items.NETHERITE_AXE),
                        Ingredient.ofItems(ModItems.MITHRIL_INGOT),
                        RecipeCategory.MISC, ModItems.MITHRIL_AXE)
                .criterion(hasItem(ModItems.MITHRIL_TOOL_UPGRADE), conditionsFromItem(ModItems.MITHRIL_TOOL_UPGRADE))
                .criterion(hasItem(Items.NETHERITE_AXE), conditionsFromItem(Items.NETHERITE_AXE))
                .criterion(hasItem(ModItems.MITHRIL_INGOT), conditionsFromItem(ModItems.MITHRIL_INGOT))
                .offerTo(exporter, new Identifier(ProtoGMT.MOD_ID, "mithril_axe"));

                SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(ModItems.MITHRIL_TOOL_UPGRADE),
                        Ingredient.ofItems(Items.NETHERITE_HOE),
                        Ingredient.ofItems(ModItems.MITHRIL_INGOT),
                        RecipeCategory.MISC, ModItems.MITHRIL_HOE)
                .criterion(hasItem(ModItems.MITHRIL_TOOL_UPGRADE), conditionsFromItem(ModItems.MITHRIL_TOOL_UPGRADE))
                .criterion(hasItem(Items.NETHERITE_HOE), conditionsFromItem(Items.NETHERITE_HOE))
                .criterion(hasItem(ModItems.MITHRIL_INGOT), conditionsFromItem(ModItems.MITHRIL_INGOT))
                .offerTo(exporter, new Identifier(ProtoGMT.MOD_ID, "mithril_hoe"));

                SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(ModItems.MITHRIL_TOOL_UPGRADE),
                        Ingredient.ofItems(Items.NETHERITE_SHOVEL),
                        Ingredient.ofItems(ModItems.MITHRIL_INGOT),
                        RecipeCategory.MISC, ModItems.MITHRIL_SHOVEL)
                .criterion(hasItem(ModItems.MITHRIL_TOOL_UPGRADE), conditionsFromItem(ModItems.MITHRIL_TOOL_UPGRADE))
                .criterion(hasItem(Items.NETHERITE_SHOVEL), conditionsFromItem(Items.NETHERITE_SHOVEL))
                .criterion(hasItem(ModItems.MITHRIL_INGOT), conditionsFromItem(ModItems.MITHRIL_INGOT))
                .offerTo(exporter, new Identifier(ProtoGMT.MOD_ID, "mithril_shovel"));

                SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(ModItems.MITHRIL_TOOL_UPGRADE),
                        Ingredient.ofItems(Items.NETHERITE_SWORD),
                        Ingredient.ofItems(ModItems.MITHRIL_INGOT),
                        RecipeCategory.MISC, ModItems.MITHRIL_SWORD)
                .criterion(hasItem(ModItems.MITHRIL_TOOL_UPGRADE), conditionsFromItem(ModItems.MITHRIL_TOOL_UPGRADE))
                .criterion(hasItem(Items.NETHERITE_SWORD), conditionsFromItem(Items.NETHERITE_SWORD))
                .criterion(hasItem(ModItems.MITHRIL_INGOT), conditionsFromItem(ModItems.MITHRIL_INGOT))
                .offerTo(exporter, new Identifier(ProtoGMT.MOD_ID, "mithril_sword"));


    }
}
