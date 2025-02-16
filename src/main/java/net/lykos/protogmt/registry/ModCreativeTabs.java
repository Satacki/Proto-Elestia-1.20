package net.lykos.protogmt.registry;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.lykos.protogmt.ProtoGMT;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeTabs {
    public static final CreativeModeTab MOD_TAB = Registry.register(
            BuiltInRegistries.CREATIVE_MODE_TAB,
            ProtoGMT.id("test_group"),
            FabricItemGroup.builder()
                    .title(Component.translatable("itemgroup.elestia_ore"))
                    .icon(() -> new ItemStack(ModItems.MITHRIL_RAW))
                    .displayItems((displayContext, entries) -> {
                        entries.accept(ModItems.MITHRIL_RAW);
                        entries.accept(ModItems.MITHRIL_INGOT);
                        entries.accept(ModItems.ETHER_SCANNER);
                        entries.accept(ModItems.CORRUPTED_WARDEN_HEART);
                        entries.accept(ModItems.PURIFIED_WARDEN_HEART);
                        entries.accept(ModItems.ETHER);
                        entries.accept(ModItems.VEX_CORE);
                        entries.accept(ModItems.ALLEY_CORE);
                        entries.accept(ModItems.HOLY_CHEESE);
                        entries.accept(ModItems.THE_KEY);
                        entries.accept(ModItems.ALLEY_SOUL);
                        entries.accept(ModItems.VEX_SOUL);
                        entries.accept(ModItems.ETHER_TRIM_UPGRADE);
                        entries.accept(ModItems.MITHRIL_TOOL_UPGRADE);
                        entries.accept(ModItems.CHESIUM_AXE);
                        entries.accept(ModItems.CHESIUM_HOE);
                        entries.accept(ModItems.CHESIUM_SHOVEL);
                        entries.accept(ModItems.CHESIUM_PICKAXE);
                        entries.accept(ModItems.CHESIUM_SWORD);
                        entries.accept(ModItems.ETHER_AXE);
                        entries.accept(ModItems.ETHER_HOE);
                        entries.accept(ModItems.ETHER_PICKAXE);
                        entries.accept(ModItems.ETHER_SHOVEL);
                        entries.accept(ModItems.ETHER_SWORD);
                        entries.accept(ModItems.NETHERITE_ETHER_UPGRADED_HELMET);
                        entries.accept(ModItems.NETHERITE_ETHER_UPGRADED_CHESTPLATE);
                        entries.accept(ModItems.NETHERITE_ETHER_UPGRADED_LEGGINGS);
                        entries.accept(ModItems.NETHERITE_ETHER_UPGRADED_BOOTS);
                        entries.accept(ModItems.MITHRIL_AXE);
                        entries.accept(ModItems.MITHRIL_HOE);
                        entries.accept(ModItems.MITHRIL_SHOVEL);
                        entries.accept(ModItems.MITHRIL_PICKAXE);
                        entries.accept(ModItems.MITHRIL_SWORD);
                        entries.accept(ModBlocks.MITHRIL_IMPURE_BLOCK);
                        entries.accept(ModBlocks.MITHRIL_PURE_BLOCK);
                        entries.accept(ModBlocks.MITHRIL_DEEP_SLATE);
                        entries.accept(ModBlocks.MITHRIL_ORE);
                        entries.accept(ModBlocks.ETHER_ORE);
                        entries.accept(ModBlocks.DEEPSLATE_ETHER_ORE);
                        entries.accept(ModBlocks.MITHRIL_IMPURE_STAIRS);
                        entries.accept(ModBlocks.MITHRIL_PURE_STAIRS);
                        entries.accept(ModBlocks.MITHRIL_PURE_SLAB);
                        entries.accept(ModBlocks.MITHRIL_IMPURE_SLAB);
                        entries.accept(ModBlocks.MITHRIL_PURE_BUTTON);
                        entries.accept(ModBlocks.MITHRIL_PURE_PRESSURE_PLATE);
                        entries.accept(ModBlocks.MITHRIL_IMPURE_WALL);
                        entries.accept(ModBlocks.MITHRIL_PURE_WALL);
                    })
                    .build()
    );

    public static void init() {

    }
}
