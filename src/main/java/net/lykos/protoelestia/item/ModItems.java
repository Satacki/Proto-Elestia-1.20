package net.lykos.protoelestia.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.lykos.protoelestia.ProtoElestia;
import net.lykos.protoelestia.block.ModBlocks;
import net.lykos.protoelestia.item.custom.*;
import net.minecraft.item.*;
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
    public static final Item ETHER_TRIM_UPGRADE = registerItem("ether_upgrade_trim",
            new EtherTrimUpgrade(new FabricItemSettings().rarity(Rarity.EPIC)));




    ///Tools ans stuff part


//Chesium
    public static final Item CHESIUM_PICKAXE = registerItem("chesium_pickaxe",
            new PickaxeItem(ModToolMaterials.CHESIUM, 0, -2f, new FabricItemSettings().rarity(Rarity.EPIC)));
    public static final Item CHESIUM_HOE = registerItem("chesium_hoe",
            new HoeItem(ModToolMaterials.CHESIUM, 0, -2f, new FabricItemSettings().rarity(Rarity.EPIC)));
    public static final Item CHESIUM_AXE = registerItem("chesium_axe",
            new AxeItem(ModToolMaterials.CHESIUM, 3, -3.1f, new FabricItemSettings().rarity(Rarity.EPIC)));
    public static final Item CHESIUM_SHOVEL = registerItem("chesium_shovel",
            new ShovelItem(ModToolMaterials.CHESIUM, 0, -2f, new FabricItemSettings().rarity(Rarity.EPIC)));
    public static final Item CHESIUM_SWORD = registerItem("chesium_sword",
            new SwordItem(ModToolMaterials.CHESIUM, 1, 0f, new FabricItemSettings().rarity(Rarity.EPIC)));





    //Ether Armor and Tools
    public static final Item ETHER_PICKAXE = registerItem("ether_pickaxe",
            new PickaxeItem(ModToolMaterials.ETHER, 4, -2f, new FabricItemSettings().rarity(Rarity.UNCOMMON)));
    public static final Item ETHER_HOE = registerItem("ether_hoe",
            new HoeItem(ModToolMaterials.ETHER, 3, -2f, new FabricItemSettings().rarity(Rarity.UNCOMMON)));
    public static final Item ETHER_AXE = registerItem("ether_axe",
            new AxeItem(ModToolMaterials.ETHER, 9, -3.1f, new FabricItemSettings().rarity(Rarity.UNCOMMON)));
    public static final Item ETHER_SHOVEL = registerItem("ether_shovel",
            new ShovelItem(ModToolMaterials.ETHER, 3, -2f, new FabricItemSettings().rarity(Rarity.UNCOMMON)));
    public static final Item ETHER_SWORD = registerItem("ether_sword",
            new SwordItem(ModToolMaterials.ETHER, 6, 0f, new FabricItemSettings().rarity(Rarity.UNCOMMON)));

    public static final Item NETHERITE_ETHER_UPGRADED_HELMET = registerItem("netherite_ether_upgraded_helmet",
            new EtherArmorItem(ModArmorMaterials.ETHER, ArmorItem.Type.HELMET, new FabricItemSettings().rarity(Rarity.UNCOMMON)));
    public static final Item NETHERITE_ETHER_UPGRADED_CHESTPLATE = registerItem("netherite_ether_upgraded_chestplate",
            new EtherArmorItem(ModArmorMaterials.ETHER, ArmorItem.Type.CHESTPLATE, new FabricItemSettings().rarity(Rarity.UNCOMMON)));
    public static final Item NETHERITE_ETHER_UPGRADED_LEGGINGS = registerItem("netherite_ether_upgraded_leggings",
            new EtherArmorItem(ModArmorMaterials.ETHER, ArmorItem.Type.LEGGINGS, new FabricItemSettings().rarity(Rarity.UNCOMMON)));
    public static final Item NETHERITE_ETHER_UPGRADED_BOOTS = registerItem("netherite_ether_upgraded_boots",
            new EtherArmorItem(ModArmorMaterials.ETHER, ArmorItem.Type.BOOTS, new FabricItemSettings().rarity(Rarity.UNCOMMON)));









    public static final Item MITHRIL_PICKAXE = registerItem("mithril_pickaxe",
            new PickaxeItem(ModToolMaterials.MITHRIL, 1, -2f, new FabricItemSettings().rarity(Rarity.COMMON)));
    public static final Item MITHRIL_HOE = registerItem("mithril_hoe",
            new HoeItem(ModToolMaterials.MITHRIL, 1, -2f, new FabricItemSettings().rarity(Rarity.COMMON)));
    public static final Item MITHRIL_AXE = registerItem("mithril_axe",
            new AxeItem(ModToolMaterials.MITHRIL, 5, -3.1f, new FabricItemSettings().rarity(Rarity.COMMON)));
    public static final Item MITHRIL_SHOVEL = registerItem("mithril_shovel",
            new ShovelItem(ModToolMaterials.MITHRIL, 1, -2f, new FabricItemSettings().rarity(Rarity.COMMON)));
    public static final Item MITHRIL_SWORD = registerItem("mithril_sword",
            new SwordItem(ModToolMaterials.MITHRIL, 3, 0f, new FabricItemSettings().rarity(Rarity.COMMON)));

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
