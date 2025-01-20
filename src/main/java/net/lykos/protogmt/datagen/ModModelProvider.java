package net.lykos.protogmt.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.lykos.protogmt.block.ModBlocks;
import assets.protogmt.models.block.item.ModItems;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        BlockStateModelGenerator.BlockTexturePool mithrilTexturePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.MITHRIL_PURE_BLOCK);
        BlockStateModelGenerator.BlockTexturePool impure_mithrilTexturePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.MITHRIL_IMPURE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MITHRIL_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MITHRIL_DEEP_SLATE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_ETHER_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ETHER_ORE);

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
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.MITHRIL_RAW, Models.GENERATED);
        itemModelGenerator.register(ModItems.ETHER_SCANNER, Models.GENERATED);
        itemModelGenerator.register(ModItems.MITHRIL_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.ETHER, Models.GENERATED);
        itemModelGenerator.register(ModItems.CORRUPTED_WARDEN_HEART, Models.GENERATED);
        itemModelGenerator.register(ModItems.PURIFIED_WARDEN_HEART, Models.GENERATED);
        itemModelGenerator.register(ModItems.HOLY_CHEESE, Models.GENERATED);
        itemModelGenerator.register(ModItems.VEX_CORE, Models.GENERATED);
        itemModelGenerator.register(ModItems.ALLEY_CORE, Models.GENERATED);
        itemModelGenerator.register(ModItems.VEX_SOUL, Models.GENERATED);
        itemModelGenerator.register(ModItems.ALLEY_SOUL, Models.GENERATED);
        itemModelGenerator.register(ModItems.ETHER_TRIM_UPGRADE, Models.GENERATED);
        itemModelGenerator.register(ModItems.MITHRIL_TOOL_UPGRADE, Models.GENERATED);

        itemModelGenerator.register(ModItems.THE_KEY, Models.HANDHELD_ROD);

        itemModelGenerator.register(ModItems.CHESIUM_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.CHESIUM_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.CHESIUM_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.CHESIUM_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.CHESIUM_HOE, Models.HANDHELD);



        itemModelGenerator.register(ModItems.ETHER_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ETHER_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ETHER_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ETHER_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ETHER_SWORD, Models.HANDHELD);


        itemModelGenerator.register(ModItems.NETHERITE_ETHER_UPGRADED_HELMET, Models.GENERATED);
        itemModelGenerator.register(ModItems.NETHERITE_ETHER_UPGRADED_CHESTPLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.NETHERITE_ETHER_UPGRADED_LEGGINGS, Models.GENERATED);
        itemModelGenerator.register(ModItems.NETHERITE_ETHER_UPGRADED_BOOTS, Models.GENERATED);







        itemModelGenerator.register(ModItems.MITHRIL_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.MITHRIL_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.MITHRIL_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.MITHRIL_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.MITHRIL_HOE, Models.HANDHELD);


    }
}
