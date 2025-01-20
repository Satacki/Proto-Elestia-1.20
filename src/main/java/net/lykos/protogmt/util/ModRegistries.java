package net.lykos.protogmt.util;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import assets.protogmt.models.block.item.ModItems;

public class ModRegistries {
    public static void  registerModStuffs() {
        registerFuels();
    }

    private static void registerFuels() {
        FuelRegistry registry = FuelRegistry.INSTANCE;

        registry.add(ModItems.ETHER, 10000 );
    }

}
