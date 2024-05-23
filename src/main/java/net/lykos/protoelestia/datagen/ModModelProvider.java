package net.lykos.protoelestia.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.lykos.protoelestia.block.ModBlocks;
import net.lykos.protoelestia.item.ModItems;
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
        impure_mithrilTexturePool.stairs(ModBlocks.MITHRIL_IMPURE_STAIRS);
        impure_mithrilTexturePool.slab(ModBlocks.MITHRIL_IMPURE_SLAB);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.MITHRIL_RAW, Models.GENERATED);
        itemModelGenerator.register(ModItems.ETHER_SCANNER, Models.GENERATED);
        itemModelGenerator.register(ModItems.MITHRIL_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.ETHER, Models.GENERATED);
        itemModelGenerator.register(ModItems.CORRUPTED_WARDEN_HEART, Models.GENERATED);
        itemModelGenerator.register(ModItems.HOLY_CHEESE, Models.GENERATED);

    }
}
