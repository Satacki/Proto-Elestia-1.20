package net.lykos.protogmt.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.lykos.protogmt.ProtoGMT;
import net.lykos.protogmt.registry.ModBlocks;
import net.lykos.protogmt.registry.ModItems;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Consumer;

public class ModRecipeGenerator extends FabricRecipeProvider {
    public ModRecipeGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void buildRecipes(Consumer<FinishedRecipe> exporter) {
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItems.HOLY_CHEESE)
                .pattern("SSS")
                .pattern("SPS")
                .pattern("SSS")
                .define('S', ModBlocks.MITHRIL_PURE_BLOCK)
                .define('P', Items.MILK_BUCKET)
                .unlockedBy(getHasName(Items.MILK_BUCKET), has(Items.MILK_BUCKET))
                .unlockedBy(getHasName(ModBlocks.MITHRIL_PURE_BLOCK), has(ModBlocks.MITHRIL_IMPURE_BLOCK))
                .save(exporter, getConversionRecipeName(ModItems.HOLY_CHEESE, ModBlocks.MITHRIL_PURE_BLOCK));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ETHER_TRIM_UPGRADE)
                .pattern("QNQ")
                .pattern("QPQ")
                .pattern("QQQ")
                .define('Q', Items.QUARTZ)
                .define('N', ModItems.MITHRIL_TOOL_UPGRADE)
                .define('P', ModItems.ETHER)
                .unlockedBy(
                        getHasName(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
                        has(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE)
                )
                .unlockedBy(getHasName(ModBlocks.MITHRIL_PURE_BLOCK), has(ModBlocks.MITHRIL_PURE_BLOCK))
                .unlockedBy(getHasName(ModItems.ETHER), has(ModItems.ETHER))
                .save(exporter, getConversionRecipeName(ModItems.ETHER, ModItems.ETHER_TRIM_UPGRADE));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.MITHRIL_TOOL_UPGRADE)
                .pattern("SUS")
                .pattern("SPS")
                .pattern("PPP")
                .define('S', ModBlocks.MITHRIL_IMPURE_BLOCK)
                .define('U', Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE)
                .define('P', ModBlocks.MITHRIL_PURE_BLOCK)
                .unlockedBy(
                        getHasName(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
                        has(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE)
                )
                .unlockedBy(getHasName(ModBlocks.MITHRIL_IMPURE_BLOCK), has(ModBlocks.MITHRIL_IMPURE_BLOCK))
                .unlockedBy(getHasName(ModBlocks.MITHRIL_PURE_BLOCK), has(ModBlocks.MITHRIL_PURE_BLOCK))
                .save(
                        exporter,
                        getConversionRecipeName(
                                Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE,
                                ModItems.MITHRIL_TOOL_UPGRADE
                        )
                );


        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PURIFIED_WARDEN_HEART)
                .pattern("CEC")
                .pattern("VHA")
                .pattern("MMM")
                .define('C', ModItems.HOLY_CHEESE)
                .define('E', ModItems.ETHER)
                .define('V', ModItems.VEX_CORE)
                .define('H', ModItems.CORRUPTED_WARDEN_HEART)
                .define('A', ModItems.ALLEY_CORE)
                .define('M', ModBlocks.MITHRIL_PURE_BLOCK)
                .unlockedBy(getHasName(ModItems.HOLY_CHEESE), has(ModItems.HOLY_CHEESE))
                .unlockedBy(getHasName(ModItems.ETHER), has(ModItems.ETHER))
                .unlockedBy(getHasName(ModItems.CORRUPTED_WARDEN_HEART), has(ModItems.CORRUPTED_WARDEN_HEART))
                .unlockedBy(getHasName(ModItems.VEX_CORE), has(ModItems.VEX_CORE))
                .unlockedBy(getHasName(ModItems.ALLEY_CORE), has(ModItems.ALLEY_CORE))
                .unlockedBy(getHasName(ModBlocks.MITHRIL_PURE_BLOCK), has(ModBlocks.MITHRIL_PURE_BLOCK))
                .save(exporter, getConversionRecipeName(ModItems.PURIFIED_WARDEN_HEART, ModItems.ETHER));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.THE_KEY)
                .pattern("VEA")
                .pattern("HDN")
                .pattern("SYR")
                .define('E', ModItems.ETHER)
                .define('V', ModItems.VEX_SOUL)
                .define('H', ModItems.PURIFIED_WARDEN_HEART)
                .define('A', ModItems.ALLEY_SOUL)
                .define('D', Items.DRAGON_EGG)
                .define('S', Items.ECHO_SHARD)
                .define('N', Items.NETHER_STAR)
                .define('Y', Items.ENDER_EYE)
                .define('R', Items.WITHER_ROSE)
                .unlockedBy(getHasName(Items.DRAGON_EGG), has(Items.DRAGON_EGG))
                .unlockedBy(getHasName(ModItems.ETHER), has(ModItems.ETHER))
                .unlockedBy(getHasName(ModItems.PURIFIED_WARDEN_HEART), has(ModItems.PURIFIED_WARDEN_HEART))
                .unlockedBy(getHasName(ModItems.VEX_SOUL), has(ModItems.VEX_SOUL))
                .unlockedBy(getHasName(ModItems.ALLEY_SOUL), has(ModItems.ALLEY_SOUL))
                .unlockedBy(getHasName(Items.ECHO_SHARD), has(Items.ECHO_SHARD))
                .unlockedBy(getHasName(Items.NETHER_STAR), has(Items.NETHER_STAR))
                .unlockedBy(getHasName(Items.ENDER_EYE), has(Items.ENDER_EYE))
                .unlockedBy(getHasName(Items.WITHER_ROSE), has(Items.WITHER_ROSE))
                .save(exporter, getConversionRecipeName(ModItems.THE_KEY, ModItems.ETHER));

        nineBlockStorageRecipes(
                exporter,
                RecipeCategory.MISC,
                ModItems.MITHRIL_INGOT,
                RecipeCategory.MISC,
                ModBlocks.MITHRIL_PURE_BLOCK
        );
        nineBlockStorageRecipes(
                exporter,
                RecipeCategory.MISC,
                ModItems.MITHRIL_RAW,
                RecipeCategory.MISC,
                ModBlocks.MITHRIL_IMPURE_BLOCK
        );

        SimpleCookingRecipeBuilder.smoking(
                        Ingredient.of(ModItems.MITHRIL_RAW),
                        RecipeCategory.MISC,
                        ModItems.MITHRIL_INGOT,
                        100,
                        2000
                )
                .unlockedBy(getHasName(ModItems.MITHRIL_RAW), has(ModItems.MITHRIL_RAW))
                .save(exporter, getSimpleRecipeName(ModItems.MITHRIL_INGOT) + "_from_smoking");

        SimpleCookingRecipeBuilder.campfireCooking(
                        Ingredient.of(ModItems.MITHRIL_RAW),
                        RecipeCategory.MISC,
                        ModItems.MITHRIL_INGOT,
                        200,
                        4000
                )
                .unlockedBy(getHasName(ModItems.MITHRIL_RAW), has(ModItems.MITHRIL_RAW))
                .save(exporter, getSimpleRecipeName(ModItems.MITHRIL_INGOT) + "_from_campfire");

        SimpleCookingRecipeBuilder.campfireCooking(
                        Ingredient.of(ModBlocks.MITHRIL_IMPURE_BLOCK),
                        RecipeCategory.MISC,
                        ModBlocks.MITHRIL_PURE_BLOCK,
                        1800,
                        36000
                )
                .unlockedBy(getHasName(ModBlocks.MITHRIL_IMPURE_BLOCK), has(ModBlocks.MITHRIL_IMPURE_BLOCK))
                .save(exporter, getSimpleRecipeName(ModBlocks.MITHRIL_PURE_BLOCK) + "_from_campfire");

        SimpleCookingRecipeBuilder.smoking(
                        Ingredient.of(ModBlocks.MITHRIL_IMPURE_BLOCK),
                        RecipeCategory.MISC,
                        ModBlocks.MITHRIL_PURE_BLOCK,
                        900,
                        18000
                )
                .unlockedBy(getHasName(ModBlocks.MITHRIL_IMPURE_BLOCK), has(ModBlocks.MITHRIL_IMPURE_BLOCK))
                .save(exporter, getSimpleRecipeName(ModBlocks.MITHRIL_PURE_BLOCK) + "_from_smoking");

        pressurePlate(exporter, ModBlocks.MITHRIL_PURE_PRESSURE_PLATE, ModItems.MITHRIL_INGOT);

        oneToOneConversionRecipe(exporter, ModBlocks.MITHRIL_PURE_BUTTON, ModItems.MITHRIL_INGOT, "mithril_button");

        wall(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.MITHRIL_PURE_WALL, ModBlocks.MITHRIL_PURE_BLOCK);


        //A changer
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ModItems.HOLY_CHEESE),
                        Ingredient.of(Items.NETHERITE_INGOT),
                        Ingredient.of(ModItems.MITHRIL_INGOT),
                        RecipeCategory.MISC,
                        ModItems.ETHER
                )
                .unlocks(getHasName(ModItems.HOLY_CHEESE), has(ModItems.HOLY_CHEESE))
                .unlocks(getHasName(Items.NETHERITE_INGOT), has(Items.NETHERITE_INGOT))
                .unlocks(getHasName(ModItems.MITHRIL_INGOT), has(ModItems.MITHRIL_INGOT))
                .save(exporter, ProtoGMT.id("ether_lost_craft"));


        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ModItems.ETHER_TRIM_UPGRADE),
                        Ingredient.of(Items.NETHERITE_HELMET),
                        Ingredient.of(ModItems.ETHER),
                        RecipeCategory.MISC,
                        ModItems.NETHERITE_ETHER_UPGRADED_HELMET
                )
                .unlocks(getHasName(ModItems.ETHER_TRIM_UPGRADE), has(ModItems.ETHER_TRIM_UPGRADE))
                .unlocks(getHasName(Items.NETHERITE_HELMET), has(Items.NETHERITE_HELMET))
                .unlocks(getHasName(ModItems.ETHER), has(ModItems.ETHER))
                .save(exporter, ProtoGMT.id("ether_helmet"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ModItems.ETHER_TRIM_UPGRADE),
                        Ingredient.of(Items.NETHERITE_CHESTPLATE),
                        Ingredient.of(ModItems.ETHER),
                        RecipeCategory.MISC,
                        ModItems.NETHERITE_ETHER_UPGRADED_CHESTPLATE
                )
                .unlocks(getHasName(ModItems.ETHER_TRIM_UPGRADE), has(ModItems.ETHER_TRIM_UPGRADE))
                .unlocks(getHasName(Items.NETHERITE_CHESTPLATE), has(Items.NETHERITE_CHESTPLATE))
                .unlocks(getHasName(ModItems.ETHER), has(ModItems.ETHER))
                .save(exporter, ProtoGMT.id("ether_chestplate"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ModItems.ETHER_TRIM_UPGRADE),
                        Ingredient.of(Items.NETHERITE_LEGGINGS),
                        Ingredient.of(ModItems.ETHER),
                        RecipeCategory.MISC,
                        ModItems.NETHERITE_ETHER_UPGRADED_LEGGINGS
                )
                .unlocks(getHasName(ModItems.ETHER_TRIM_UPGRADE), has(ModItems.ETHER_TRIM_UPGRADE))
                .unlocks(getHasName(Items.NETHERITE_LEGGINGS), has(Items.NETHERITE_LEGGINGS))
                .unlocks(getHasName(ModItems.ETHER), has(ModItems.ETHER))
                .save(exporter, ProtoGMT.id("ether_leggings"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ModItems.ETHER_TRIM_UPGRADE),
                        Ingredient.of(Items.NETHERITE_BOOTS),
                        Ingredient.of(ModItems.ETHER),
                        RecipeCategory.MISC,
                        ModItems.NETHERITE_ETHER_UPGRADED_BOOTS
                )
                .unlocks(getHasName(ModItems.ETHER_TRIM_UPGRADE), has(ModItems.ETHER_TRIM_UPGRADE))
                .unlocks(getHasName(Items.NETHERITE_BOOTS), has(Items.NETHERITE_BOOTS))
                .unlocks(getHasName(ModItems.ETHER), has(ModItems.ETHER))
                .save(exporter, ProtoGMT.id("ether_boots"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ModItems.ETHER_TRIM_UPGRADE),
                        Ingredient.of(ModItems.MITHRIL_PICKAXE),
                        Ingredient.of(ModItems.ETHER),
                        RecipeCategory.MISC,
                        ModItems.ETHER_PICKAXE
                )
                .unlocks(getHasName(ModItems.ETHER_TRIM_UPGRADE), has(ModItems.ETHER_TRIM_UPGRADE))
                .unlocks(getHasName(ModItems.MITHRIL_PICKAXE), has(ModItems.MITHRIL_PICKAXE))
                .unlocks(getHasName(ModItems.ETHER), has(ModItems.ETHER))
                .save(exporter, ProtoGMT.id("ether_pickaxe"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ModItems.ETHER_TRIM_UPGRADE),
                        Ingredient.of(ModItems.MITHRIL_AXE),
                        Ingredient.of(ModItems.ETHER),
                        RecipeCategory.MISC,
                        ModItems.ETHER_AXE
                )
                .unlocks(getHasName(ModItems.ETHER_TRIM_UPGRADE), has(ModItems.ETHER_TRIM_UPGRADE))
                .unlocks(getHasName(ModItems.MITHRIL_AXE), has(ModItems.MITHRIL_AXE))
                .unlocks(getHasName(ModItems.ETHER), has(ModItems.ETHER))
                .save(exporter, ProtoGMT.id("ether_axe"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ModItems.ETHER_TRIM_UPGRADE),
                        Ingredient.of(ModItems.MITHRIL_HOE),
                        Ingredient.of(ModItems.ETHER),
                        RecipeCategory.MISC,
                        ModItems.ETHER_HOE
                )
                .unlocks(getHasName(ModItems.ETHER_TRIM_UPGRADE), has(ModItems.ETHER_TRIM_UPGRADE))
                .unlocks(getHasName(ModItems.MITHRIL_HOE), has(ModItems.MITHRIL_HOE))
                .unlocks(getHasName(ModItems.ETHER), has(ModItems.ETHER))
                .save(exporter, ProtoGMT.id("ether_hoe"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ModItems.ETHER_TRIM_UPGRADE),
                        Ingredient.of(ModItems.MITHRIL_SHOVEL),
                        Ingredient.of(ModItems.ETHER),
                        RecipeCategory.MISC,
                        ModItems.ETHER_SHOVEL
                )
                .unlocks(getHasName(ModItems.ETHER_TRIM_UPGRADE), has(ModItems.ETHER_TRIM_UPGRADE))
                .unlocks(getHasName(ModItems.MITHRIL_SHOVEL), has(ModItems.MITHRIL_SHOVEL))
                .unlocks(getHasName(ModItems.ETHER), has(ModItems.ETHER))
                .save(exporter, ProtoGMT.id("ether_shovel"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ModItems.ETHER_TRIM_UPGRADE),
                        Ingredient.of(ModItems.MITHRIL_SWORD),
                        Ingredient.of(ModItems.ETHER),
                        RecipeCategory.MISC,
                        ModItems.ETHER_SWORD
                )
                .unlocks(getHasName(ModItems.ETHER_TRIM_UPGRADE), has(ModItems.ETHER_TRIM_UPGRADE))
                .unlocks(getHasName(ModItems.MITHRIL_SWORD), has(ModItems.MITHRIL_SWORD))
                .unlocks(getHasName(ModItems.ETHER), has(ModItems.ETHER))
                .save(exporter, ProtoGMT.id("ether_sword"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ModItems.MITHRIL_TOOL_UPGRADE),
                        Ingredient.of(Items.NETHERITE_PICKAXE),
                        Ingredient.of(ModItems.MITHRIL_INGOT),
                        RecipeCategory.MISC,
                        ModItems.MITHRIL_PICKAXE
                )
                .unlocks(getHasName(ModItems.MITHRIL_TOOL_UPGRADE), has(ModItems.MITHRIL_TOOL_UPGRADE))
                .unlocks(getHasName(Items.NETHERITE_PICKAXE), has(Items.NETHERITE_PICKAXE))
                .unlocks(getHasName(ModItems.MITHRIL_INGOT), has(ModItems.MITHRIL_INGOT))
                .save(exporter, ProtoGMT.id("mithril_pickaxe"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ModItems.MITHRIL_TOOL_UPGRADE),
                        Ingredient.of(Items.NETHERITE_AXE),
                        Ingredient.of(ModItems.MITHRIL_INGOT),
                        RecipeCategory.MISC,
                        ModItems.MITHRIL_AXE
                )
                .unlocks(getHasName(ModItems.MITHRIL_TOOL_UPGRADE), has(ModItems.MITHRIL_TOOL_UPGRADE))
                .unlocks(getHasName(Items.NETHERITE_AXE), has(Items.NETHERITE_AXE))
                .unlocks(getHasName(ModItems.MITHRIL_INGOT), has(ModItems.MITHRIL_INGOT))
                .save(exporter, ProtoGMT.id("mithril_axe"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ModItems.MITHRIL_TOOL_UPGRADE),
                        Ingredient.of(Items.NETHERITE_HOE),
                        Ingredient.of(ModItems.MITHRIL_INGOT),
                        RecipeCategory.MISC,
                        ModItems.MITHRIL_HOE
                )
                .unlocks(getHasName(ModItems.MITHRIL_TOOL_UPGRADE), has(ModItems.MITHRIL_TOOL_UPGRADE))
                .unlocks(getHasName(Items.NETHERITE_HOE), has(Items.NETHERITE_HOE))
                .unlocks(getHasName(ModItems.MITHRIL_INGOT), has(ModItems.MITHRIL_INGOT))
                .save(exporter, ProtoGMT.id("mithril_hoe"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ModItems.MITHRIL_TOOL_UPGRADE),
                        Ingredient.of(Items.NETHERITE_SHOVEL),
                        Ingredient.of(ModItems.MITHRIL_INGOT),
                        RecipeCategory.MISC,
                        ModItems.MITHRIL_SHOVEL
                )
                .unlocks(getHasName(ModItems.MITHRIL_TOOL_UPGRADE), has(ModItems.MITHRIL_TOOL_UPGRADE))
                .unlocks(getHasName(Items.NETHERITE_SHOVEL), has(Items.NETHERITE_SHOVEL))
                .unlocks(getHasName(ModItems.MITHRIL_INGOT), has(ModItems.MITHRIL_INGOT))
                .save(exporter, ProtoGMT.id("mithril_shovel"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ModItems.MITHRIL_TOOL_UPGRADE),
                        Ingredient.of(Items.NETHERITE_SWORD),
                        Ingredient.of(ModItems.MITHRIL_INGOT),
                        RecipeCategory.MISC,
                        ModItems.MITHRIL_SWORD
                )
                .unlocks(getHasName(ModItems.MITHRIL_TOOL_UPGRADE), has(ModItems.MITHRIL_TOOL_UPGRADE))
                .unlocks(getHasName(Items.NETHERITE_SWORD), has(Items.NETHERITE_SWORD))
                .unlocks(getHasName(ModItems.MITHRIL_INGOT), has(ModItems.MITHRIL_INGOT))
                .save(exporter, ProtoGMT.id("mithril_sword"));
    }
}
