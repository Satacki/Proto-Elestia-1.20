package net.lykos.protoelestia.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.lykos.protoelestia.block.ModBlocks;
import net.lykos.protoelestia.util.ModTags;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ModTags.Blocks.ETHER_DETECTOR_ETHER_BLOCKS)
                .add(ModBlocks.ETHER_ORE)
                .add(ModBlocks.DEEPSLATE_ETHER_ORE);

        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.ETHER_ORE)
                .add(ModBlocks.DEEPSLATE_ETHER_ORE)
                .add(ModBlocks.MITHRIL_IMPURE_BLOCK)
                .add(ModBlocks.MITHRIL_PURE_BLOCK)
                .add(ModBlocks.MITHRIL_ORE)
                .add(ModBlocks.MITHRIL_DEEP_SLATE);

        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.ETHER_ORE)
                .add(ModBlocks.DEEPSLATE_ETHER_ORE);

        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.MITHRIL_IMPURE_BLOCK)
                .add(ModBlocks.MITHRIL_PURE_BLOCK)
                .add(ModBlocks.MITHRIL_ORE)
                .add(ModBlocks.MITHRIL_DEEP_SLATE);

    }
}
