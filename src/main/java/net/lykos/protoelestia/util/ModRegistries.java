package net.lykos.protoelestia.util;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.lykos.protoelestia.item.ModItems;

public class ModRegistries {
    public static void  registerModStuffs() {
        registerFuels();
    }

    private static void registerFuels() {
        FuelRegistry registry = FuelRegistry.INSTANCE;

        registry.add(ModItems.ETHER, 10000 );
    }

}
