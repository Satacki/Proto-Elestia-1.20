package net.lykos.protogmt.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.lykos.protogmt.ProtoGMT;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block MITHRIL_PURE_BLOCK = registerBlock("mithril_pure_block",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));
    public static final Block MITHRIL_IMPURE_BLOCK = registerBlock("mithril_impure_block",
            new Block(FabricBlockSettings.copyOf(Blocks.RAW_IRON_BLOCK)));
    public static final Block MITHRIL_DEEP_SLATE = registerBlock("mithril_deepslate_ore",
            new Block(FabricBlockSettings.copyOf(Blocks.DEEPSLATE_GOLD_ORE)));
    public static final Block MITHRIL_ORE = registerBlock("mithril_ore",
            new Block(FabricBlockSettings.copyOf(Blocks.GOLD_ORE)));
    public static final Block ETHER_ORE = registerBlock("ether_ore",
            new Block(FabricBlockSettings.copyOf(Blocks.OBSIDIAN)));
    public static final Block DEEPSLATE_ETHER_ORE = registerBlock("deepslate_ether_ore",
            new Block(FabricBlockSettings.copyOf(Blocks.OBSIDIAN)));



    public static final Block MITHRIL_PURE_STAIRS = registerBlock("mithril_pure_stairs",
            new StairsBlock(ModBlocks.MITHRIL_PURE_BLOCK.getDefaultState(), FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));
    public static final Block MITHRIL_IMPURE_STAIRS = registerBlock("mithril_impure_stairs",
            new StairsBlock(ModBlocks.MITHRIL_IMPURE_BLOCK.getDefaultState(), FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));

    public static final Block MITHRIL_PURE_PRESSURE_PLATE = registerBlock("mithril_pure_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.copyOf(Blocks.STONE_PRESSURE_PLATE), BlockSetType.IRON));
    public static final Block MITHRIL_PURE_BUTTON = registerBlock("mithril_pure_button",
            new ButtonBlock(FabricBlockSettings.copyOf(Blocks.STONE_BUTTON), BlockSetType.IRON,40,true));

    public static final Block MITHRIL_IMPURE_SLAB = registerBlock("mithril_impure_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));
    public static final Block MITHRIL_PURE_SLAB = registerBlock("mithril_pure_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));
    public static final Block MITHRIL_PURE_WALL = registerBlock("mithril_pure_wall",
            new WallBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));
    public static final Block MITHRIL_IMPURE_WALL = registerBlock("mithril_impure_wall",
            new WallBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));


    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(ProtoGMT.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(ProtoGMT.MOD_ID, name),
             new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        ProtoGMT.LOGGER.info("Enregistre les block modder pour" + ProtoGMT.MOD_ID);
    }
}
