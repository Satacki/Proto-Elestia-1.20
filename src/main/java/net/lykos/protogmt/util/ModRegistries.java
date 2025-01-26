package net.lykos.protogmt.util;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.lykos.protogmt.registry.ModItems;

public class ModRegistries {
    public static void init() {
        registerFuels();
    }

    private static void registerFuels() {
        FuelRegistry registry = FuelRegistry.INSTANCE;

        registry.add(ModItems.ETHER, 10000);
    }

}
