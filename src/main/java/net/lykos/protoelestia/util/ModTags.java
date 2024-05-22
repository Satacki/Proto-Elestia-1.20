package net.lykos.protoelestia.util;

import net.lykos.protoelestia.ProtoElestia;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {


    public static class Blocks {

        public static final TagKey<Block> ETHER_DETECTOR_ETHER_BLOCKS =
                createBlockTag("ether_detector_ether_blocks");

        private static TagKey<Block> createBlockTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, new Identifier(ProtoElestia.MOD_ID, name));
        }

        private static TagKey<Block> createCommonBlockTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, new Identifier("c", name));
        }

    }

    public static class Items{
        public static class Blocks {

            private static TagKey<Item> createItemTag(String name) {
                return TagKey.of(RegistryKeys.ITEM, new Identifier(ProtoElestia.MOD_ID, name));
            }

            private static TagKey<Item> createCommonItemTag(String name) {
                return TagKey.of(RegistryKeys.ITEM, new Identifier("c", name));
            }

        }

    }
}