package net.lykos.protogmt.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.lykos.protogmt.registry.ModBlocks;
import net.lykos.protogmt.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider arg) {
        getOrCreateTagBuilder(ModTags.Blocks.ETHER_DETECTOR_ETHER_BLOCKS)
                .add(ModBlocks.ETHER_ORE)
                .add(ModBlocks.DEEPSLATE_ETHER_ORE);

        getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.ETHER_ORE)
                .add(ModBlocks.DEEPSLATE_ETHER_ORE)
                .add(ModBlocks.MITHRIL_IMPURE_BLOCK)
                .add(ModBlocks.MITHRIL_PURE_BLOCK)
                .add(ModBlocks.MITHRIL_ORE)
                .add(ModBlocks.MITHRIL_DEEP_SLATE)
                .add(ModBlocks.MITHRIL_PURE_BUTTON)
                .add(ModBlocks.MITHRIL_PURE_PRESSURE_PLATE)
                .add(ModBlocks.MITHRIL_IMPURE_SLAB)
                .add(ModBlocks.MITHRIL_PURE_SLAB)
                .add(ModBlocks.MITHRIL_IMPURE_STAIRS)
                .add(ModBlocks.MITHRIL_PURE_WALL)
                .add(ModBlocks.MITHRIL_IMPURE_WALL)
                .add(ModBlocks.MITHRIL_PURE_STAIRS);

        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.ETHER_ORE)
                .add(ModBlocks.DEEPSLATE_ETHER_ORE);


        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.MITHRIL_IMPURE_BLOCK)
                .add(ModBlocks.MITHRIL_PURE_BLOCK)
                .add(ModBlocks.MITHRIL_ORE)
                .add(ModBlocks.MITHRIL_DEEP_SLATE)
                .add(ModBlocks.MITHRIL_PURE_BUTTON)
                .add(ModBlocks.MITHRIL_PURE_PRESSURE_PLATE)
                .add(ModBlocks.MITHRIL_IMPURE_SLAB)
                .add(ModBlocks.MITHRIL_PURE_SLAB)
                .add(ModBlocks.MITHRIL_PURE_WALL)
                .add(ModBlocks.MITHRIL_IMPURE_WALL)
                .add(ModBlocks.MITHRIL_IMPURE_STAIRS)
                .add(ModBlocks.MITHRIL_PURE_STAIRS);

        getOrCreateTagBuilder(BlockTags.WALLS)
                .add(ModBlocks.MITHRIL_PURE_WALL)
                .add(ModBlocks.MITHRIL_IMPURE_WALL);


        //Mithril If i'm correct.
        getOrCreateTagBuilder(TagKey.create(Registries.BLOCK, new ResourceLocation("fabric", "need_tool_level_5")));

        //Ether.
        getOrCreateTagBuilder(TagKey.create(Registries.BLOCK, new ResourceLocation("fabric", "need_tool_level_6")));

        //Chesium but it's a Troll Material so don't expect something here soon.
        getOrCreateTagBuilder(TagKey.create(Registries.BLOCK, new ResourceLocation("fabric", "need_tool_level_7")));

    }
}
