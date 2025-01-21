package net.lykos.protogmt;

import net.fabricmc.api.ModInitializer;
import net.lykos.protogmt.registry.ModBlocks;
import net.lykos.protogmt.registry.ModCreativeTabs;
import net.lykos.protogmt.registry.ModItems;
import net.lykos.protogmt.util.ModRegistries;
import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProtoGMT implements ModInitializer {
    public static final String MOD_ID = "protogmt";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static ResourceLocation id(String location) {
        return new ResourceLocation(MOD_ID, location);
    }

    @Override
    public void onInitialize() {
        ModCreativeTabs.init();
        ModItems.init();
        ModBlocks.init();
        ModRegistries.init();
    }
}