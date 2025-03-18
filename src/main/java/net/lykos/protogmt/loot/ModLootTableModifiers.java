package net.lykos.protogmt.loot;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.lykos.protogmt.registry.ModItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

public class ModLootTableModifiers {

    public static void register() {
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (id.equals(new ResourceLocation("minecraft", "chests/ancient_city"))) {
                LootItem.Builder<?> customItem = LootItem.lootTableItem(ModItems.IDOFRONT_TEMPLATE) // Replace with your custom item
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0, 1)))
                        .setWeight(1);

                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .add(customItem)
                        .setRolls(UniformGenerator.between(1, 2));

                tableBuilder.pool(poolBuilder.build());
            }
        });
    }
}