package net.lykos.protogmt.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.lykos.protogmt.block.ModBlocks;
import assets.protogmt.models.block.item.ModItems;

public class ModBlockLootTableGenerator extends FabricBlockLootTableProvider {
    public ModBlockLootTableGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.MITHRIL_PURE_BLOCK);
        addDrop(ModBlocks.MITHRIL_IMPURE_BLOCK);

        addDrop(ModBlocks.MITHRIL_ORE, oreDrops(ModBlocks.MITHRIL_ORE, ModItems.MITHRIL_RAW));
        addDrop(ModBlocks.MITHRIL_DEEP_SLATE, oreDrops(ModBlocks.MITHRIL_DEEP_SLATE, ModItems.MITHRIL_RAW));

        addDrop(ModBlocks.MITHRIL_IMPURE_STAIRS);
        addDrop(ModBlocks.MITHRIL_IMPURE_WALL);
        addDrop(ModBlocks.MITHRIL_PURE_WALL);
        addDrop(ModBlocks.MITHRIL_PURE_STAIRS);
        addDrop(ModBlocks.MITHRIL_PURE_BUTTON);
        addDrop(ModBlocks.MITHRIL_PURE_PRESSURE_PLATE);
        addDrop(ModBlocks.MITHRIL_PURE_SLAB, slabDrops(ModBlocks.MITHRIL_PURE_SLAB));
        addDrop(ModBlocks.MITHRIL_IMPURE_SLAB, slabDrops(ModBlocks.MITHRIL_IMPURE_SLAB));
    }
}
