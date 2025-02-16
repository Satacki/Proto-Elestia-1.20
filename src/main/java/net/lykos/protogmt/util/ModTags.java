package net.lykos.protogmt.util;

import net.lykos.protogmt.ProtoGMT;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> ETHER_DETECTOR_ETHER_BLOCKS =
                createBlockTag("ether_detector_ether_blocks");

        private static TagKey<Block> createBlockTag(String name) {
            return TagKey.create(Registries.BLOCK, new ResourceLocation(ProtoGMT.MOD_ID, name));
        }

        private static TagKey<Block> createCommonBlockTag(String name) {
            return TagKey.create(Registries.BLOCK, new ResourceLocation("c", name));
        }
    }

    public static class Items {
        public static class Blocks {
            private static TagKey<Item> createItemTag(String name) {
                return TagKey.create(Registries.ITEM, new ResourceLocation(ProtoGMT.MOD_ID, name));
            }

            private static TagKey<Item> createCommonItemTag(String name) {
                return TagKey.create(Registries.ITEM, new ResourceLocation("c", name));
            }
        }
    }
}