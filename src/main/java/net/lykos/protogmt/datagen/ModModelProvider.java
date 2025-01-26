package net.lykos.protogmt.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.lykos.protogmt.registry.ModBlocks;
import net.lykos.protogmt.registry.ModItems;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.ItemModelGenerators;
import net.minecraft.data.models.model.ModelTemplates;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators gen) {
        BlockModelGenerators.BlockFamilyProvider mithrilTexturePool = gen.family(ModBlocks.MITHRIL_PURE_BLOCK);
        BlockModelGenerators.BlockFamilyProvider impure_mithrilTexturePool = gen.family(ModBlocks.MITHRIL_IMPURE_BLOCK);

        gen.createTrivialCube(ModBlocks.MITHRIL_ORE);
        gen.createTrivialCube(ModBlocks.MITHRIL_DEEP_SLATE);
        gen.createTrivialCube(ModBlocks.DEEPSLATE_ETHER_ORE);
        gen.createTrivialCube(ModBlocks.ETHER_ORE);

        mithrilTexturePool.stairs(ModBlocks.MITHRIL_PURE_STAIRS);
        mithrilTexturePool.slab(ModBlocks.MITHRIL_PURE_SLAB);
        mithrilTexturePool.button(ModBlocks.MITHRIL_PURE_BUTTON);
        mithrilTexturePool.pressurePlate(ModBlocks.MITHRIL_PURE_PRESSURE_PLATE);
        mithrilTexturePool.wall(ModBlocks.MITHRIL_PURE_WALL);

        impure_mithrilTexturePool.stairs(ModBlocks.MITHRIL_IMPURE_STAIRS);
        impure_mithrilTexturePool.slab(ModBlocks.MITHRIL_IMPURE_SLAB);
        impure_mithrilTexturePool.wall(ModBlocks.MITHRIL_IMPURE_WALL);
    }

    @Override
    public void generateItemModels(ItemModelGenerators gen) {
        gen.generateFlatItem(ModItems.MITHRIL_RAW, ModelTemplates.FLAT_ITEM);
        gen.generateFlatItem(ModItems.ETHER_SCANNER, ModelTemplates.FLAT_ITEM);
        gen.generateFlatItem(ModItems.MITHRIL_INGOT, ModelTemplates.FLAT_ITEM);
        gen.generateFlatItem(ModItems.ETHER, ModelTemplates.FLAT_ITEM);
        gen.generateFlatItem(ModItems.CORRUPTED_WARDEN_HEART, ModelTemplates.FLAT_ITEM);
        gen.generateFlatItem(ModItems.PURIFIED_WARDEN_HEART, ModelTemplates.FLAT_ITEM);
        gen.generateFlatItem(ModItems.HOLY_CHEESE, ModelTemplates.FLAT_ITEM);
        gen.generateFlatItem(ModItems.VEX_CORE, ModelTemplates.FLAT_ITEM);
        gen.generateFlatItem(ModItems.ALLEY_CORE, ModelTemplates.FLAT_ITEM);
        gen.generateFlatItem(ModItems.VEX_SOUL, ModelTemplates.FLAT_ITEM);
        gen.generateFlatItem(ModItems.ALLEY_SOUL, ModelTemplates.FLAT_ITEM);
        gen.generateFlatItem(ModItems.ETHER_TRIM_UPGRADE, ModelTemplates.FLAT_ITEM);
        gen.generateFlatItem(ModItems.MITHRIL_TOOL_UPGRADE, ModelTemplates.FLAT_ITEM);
        gen.generateFlatItem(ModItems.THE_KEY, ModelTemplates.FLAT_HANDHELD_ROD_ITEM);
        gen.generateFlatItem(ModItems.CHESIUM_AXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        gen.generateFlatItem(ModItems.CHESIUM_PICKAXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        gen.generateFlatItem(ModItems.CHESIUM_SHOVEL, ModelTemplates.FLAT_HANDHELD_ITEM);
        gen.generateFlatItem(ModItems.CHESIUM_SWORD, ModelTemplates.FLAT_HANDHELD_ITEM);
        gen.generateFlatItem(ModItems.CHESIUM_HOE, ModelTemplates.FLAT_HANDHELD_ITEM);
        gen.generateFlatItem(ModItems.ETHER_AXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        gen.generateFlatItem(ModItems.ETHER_PICKAXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        gen.generateFlatItem(ModItems.ETHER_HOE, ModelTemplates.FLAT_HANDHELD_ITEM);
        gen.generateFlatItem(ModItems.ETHER_SHOVEL, ModelTemplates.FLAT_HANDHELD_ITEM);
        gen.generateFlatItem(ModItems.ETHER_SWORD, ModelTemplates.FLAT_HANDHELD_ITEM);
        gen.generateFlatItem(ModItems.NETHERITE_ETHER_UPGRADED_HELMET, ModelTemplates.FLAT_ITEM);
        gen.generateFlatItem(ModItems.NETHERITE_ETHER_UPGRADED_CHESTPLATE, ModelTemplates.FLAT_ITEM);
        gen.generateFlatItem(ModItems.NETHERITE_ETHER_UPGRADED_LEGGINGS, ModelTemplates.FLAT_ITEM);
        gen.generateFlatItem(ModItems.NETHERITE_ETHER_UPGRADED_BOOTS, ModelTemplates.FLAT_ITEM);
        gen.generateFlatItem(ModItems.MITHRIL_AXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        gen.generateFlatItem(ModItems.MITHRIL_PICKAXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        gen.generateFlatItem(ModItems.MITHRIL_SHOVEL, ModelTemplates.FLAT_HANDHELD_ITEM);
        gen.generateFlatItem(ModItems.MITHRIL_SWORD, ModelTemplates.FLAT_HANDHELD_ITEM);
        gen.generateFlatItem(ModItems.MITHRIL_HOE, ModelTemplates.FLAT_HANDHELD_ITEM);
    }
}
