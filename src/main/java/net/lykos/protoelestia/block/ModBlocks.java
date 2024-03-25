package net.lykos.protoelestia.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.lykos.protoelestia.ProtoElestia;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
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


    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(ProtoElestia.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(ProtoElestia.MOD_ID, name),
             new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        ProtoElestia.LOGGER.info("Enregistre les block modder pour" + ProtoElestia.MOD_ID);
    }
}
