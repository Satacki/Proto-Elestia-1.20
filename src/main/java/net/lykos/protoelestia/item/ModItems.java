package net.lykos.protoelestia.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.lykos.protoelestia.ProtoElestia;
import net.lykos.protoelestia.block.ModBlocks;
import net.lykos.protoelestia.item.custom.*;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class ModItems {
    public static final Item MITHRIL_INGOT = registerItem("mithril_ingot",
            new Item(new FabricItemSettings()));
    public static final Item MITHRIL_RAW = registerItem("raw_mithril",
            new Item(new FabricItemSettings()));
    public static final Item ETHER = registerItem("ether",
            new Item(new FabricItemSettings()));
    public static final Item VEX_SOUL = registerItem("vex_soul",
            new Item(new FabricItemSettings().rarity(Rarity.RARE)));
    public static final Item VEX_CORE = registerItem("vex_core",
            new Item(new FabricItemSettings().rarity(Rarity.RARE).recipeRemainder(VEX_SOUL).maxCount(1)));
    public static final Item ALLEY_SOUL = registerItem("alley_soul",
            new Item(new FabricItemSettings().rarity(Rarity.RARE)));
    public static final Item ALLEY_CORE = registerItem("alley_core",
            new Item(new FabricItemSettings().rarity(Rarity.RARE).recipeRemainder(ALLEY_SOUL).maxCount(1)));
    public static final Item ETHER_SCANNER = registerItem("ether_scanner",
            new EtherScannerItem(new FabricItemSettings().maxDamage(512)));
    public static final Item CORRUPTED_WARDEN_HEART = registerItem("corrupted_warden_heart",
            new CorruptedWardenHeart(new FabricItemSettings().rarity(Rarity.UNCOMMON)));
    public static final Item PURIFIED_WARDEN_HEART = registerItem("purified_warden_heart",
            new PurifiedWardenHeart(new FabricItemSettings().rarity(Rarity.UNCOMMON)));
    public static final Item HOLY_CHEESE = registerItem("holy_cheese",
            new HolyCheese(new FabricItemSettings().food(ModFoodComponent.HOLY_CHEESE).rarity(Rarity.EPIC)));
    public static final Item THE_KEY = registerItem("the_key",
            new TheKey(new FabricItemSettings().rarity(Rarity.EPIC)));


        private static Item registerItem(String name, Item item) {
            return Registry.register(Registries.ITEM, new Identifier(ProtoElestia.MOD_ID, name), item);
        }

        private static void itemGroupOre(FabricItemGroupEntries entries) {
            entries.add(MITHRIL_INGOT);
            entries.add(MITHRIL_RAW);
            entries.add(ETHER);

            entries.add(ModBlocks.MITHRIL_PURE_BLOCK);
            entries.add(ModBlocks.MITHRIL_IMPURE_BLOCK);
            entries.add(ModBlocks.MITHRIL_DEEP_SLATE);
            entries.add(ModBlocks.MITHRIL_ORE);
            entries.add(ModBlocks.ETHER_ORE);
            entries.add(ModBlocks.DEEPSLATE_ETHER_ORE);
        }
        public static void registerModItems() {
            ProtoElestia.LOGGER.info("Enregistre les items du mod" + ProtoElestia.MOD_ID);

            ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::itemGroupOre);
        }
}
