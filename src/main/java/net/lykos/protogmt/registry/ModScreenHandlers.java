package net.lykos.protogmt.registry;

import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.Registry;
import net.lykos.protogmt.gui.BondrewdArmorScreenHandler;

public class ModScreenHandlers {
    public static final MenuType<BondrewdArmorScreenHandler> BONDED_ARMOR_SCREEN_HANDLER =
            ScreenHandlerRegistry.registerSimple(
                    new ResourceLocation("protogmt", "bondrewd_armor"), // Replace "protogmt" with your mod ID
                    BondrewdArmorScreenHandler::new
            );

    public static void register() {
        // Call this in ModInitializer to register the screen handler
    }
}
