package net.lykos.protogmt.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.lykos.protogmt.registry.ModBlocks;
import net.lykos.protogmt.registry.ModItems;

public class ModBlockLootTableGenerator extends FabricBlockLootTableProvider {
    public ModBlockLootTableGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        dropSelf(ModBlocks.MITHRIL_PURE_BLOCK);
        dropSelf(ModBlocks.MITHRIL_IMPURE_BLOCK);

        add(ModBlocks.MITHRIL_ORE, createOreDrop(ModBlocks.MITHRIL_ORE, ModItems.MITHRIL_RAW));
        add(ModBlocks.MITHRIL_DEEP_SLATE, createOreDrop(ModBlocks.MITHRIL_DEEP_SLATE, ModItems.MITHRIL_RAW));

        dropSelf(ModBlocks.MITHRIL_IMPURE_STAIRS);
        dropSelf(ModBlocks.MITHRIL_IMPURE_WALL);
        dropSelf(ModBlocks.MITHRIL_PURE_WALL);
        dropSelf(ModBlocks.MITHRIL_PURE_STAIRS);
        dropSelf(ModBlocks.MITHRIL_PURE_BUTTON);
        dropSelf(ModBlocks.MITHRIL_PURE_PRESSURE_PLATE);

        add(ModBlocks.MITHRIL_PURE_SLAB, createSlabItemTable(ModBlocks.MITHRIL_PURE_SLAB));
        add(ModBlocks.MITHRIL_IMPURE_SLAB, createSlabItemTable(ModBlocks.MITHRIL_IMPURE_SLAB));
    }
}
