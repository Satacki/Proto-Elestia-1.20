package net.lykos.protoelestia.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.lykos.protoelestia.ProtoElestia;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item MITHRIL_INGOT = registerItem("mithril_ingot",
            new Item(new FabricItemSettings()));
    public static final Item MITHRIL_RAW = registerItem("raw_mithril",
            new Item(new FabricItemSettings()));


        private static Item registerItem(String name, Item item) {
            return Registry.register(Registries.ITEM, new Identifier(ProtoElestia.MOD_ID, name), item);
        }

        private static void itemGroupOre(FabricItemGroupEntries entries) {
            entries.add(MITHRIL_INGOT);
            entries.add(MITHRIL_RAW);
        }
        public static void registerModItems() {
            ProtoElestia.LOGGER.info("Enregistre les items du mod" + ProtoElestia.MOD_ID);

            ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::itemGroupOre);
        }
}
