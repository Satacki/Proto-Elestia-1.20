package net.lykos.protoelestia.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.lykos.protoelestia.ProtoElestia;
import net.lykos.protoelestia.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final ItemGroup TEST_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(ProtoElestia.MOD_ID,"test_group"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.elestia_ore"))
                    .icon(() -> new ItemStack(ModItems.MITHRIL_RAW)).entries((displayContext, entries) -> {
                        entries.add(ModItems.MITHRIL_RAW);
                        entries.add(ModItems.MITHRIL_INGOT);
                        entries.add(ModItems.ETHER_SCANNER);
                        entries.add(ModItems.CORRUPTED_WARDEN_HEART);
                        entries.add(ModItems.ETHER);


                        entries.add(ModBlocks.MITHRIL_IMPURE_BLOCK);
                        entries.add(ModBlocks.MITHRIL_PURE_BLOCK);
                        entries.add(ModBlocks.MITHRIL_DEEP_SLATE);
                        entries.add(ModBlocks.MITHRIL_ORE);
                        entries.add(ModBlocks.ETHER_ORE);
                        entries.add(ModBlocks.DEEPSLATE_ETHER_ORE);

                        entries.add(ModBlocks.MITHRIL_IMPURE_STAIRS);
                        entries.add(ModBlocks.MITHRIL_PURE_STAIRS);
                        entries.add(ModBlocks.MITHRIL_PURE_SLAB);
                        entries.add(ModBlocks.MITHRIL_IMPURE_SLAB);


                    }).build());
    public static void registerItemGroup() {

    }
}
