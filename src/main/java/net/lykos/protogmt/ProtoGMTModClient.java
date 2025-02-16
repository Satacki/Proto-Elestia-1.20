package net.lykos.protogmt;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.lykos.protogmt.client.ModKeybinds;
import net.lykos.protogmt.registry.ModScreenHandlers;
import net.lykos.protogmt.gui.BondrewdArmorScreen;


public class ProtoGMTModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ModKeybinds.register();
        ScreenRegistry.register(ModScreenHandlers.BONDED_ARMOR_SCREEN_HANDLER, BondrewdArmorScreen::new);
    }
}
