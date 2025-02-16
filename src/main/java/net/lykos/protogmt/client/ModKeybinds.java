package net.lykos.protogmt.client;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import org.lwjgl.glfw.GLFW;
import net.lykos.protogmt.gui.BondrewdArmorScreen;
import net.lykos.protogmt.gui.BondrewdArmorScreenHandler;
import net.lykos.protogmt.items.IdofrontArmorItem;

//I'm starting to lose my mind

public class ModKeybinds {
    public static final String KEY_CATEGORY_PROTOMOD = "key.categories.protogmt";
    public static final String KEY_CARTRIDGE_GUI = "key.protogmt.open_cartridge_gui";

    public static KeyMapping openCartridgeGuiKey;

    public static void register() {
        // Register the keybind (Default: G Key)
        openCartridgeGuiKey = KeyBindingHelper.registerKeyBinding(new KeyMapping(
                KEY_CARTRIDGE_GUI,
                GLFW.GLFW_KEY_G, // Default Key: "G"
                KEY_CATEGORY_PROTOMOD
        ));

        // Detect when the key is pressed
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (openCartridgeGuiKey.consumeClick()) {
                if (client.player != null) {
                    openCartridgeGui(client.player);
                }
            }
        });
    }

    private static void openCartridgeGui(Player player) {
        if (player.getInventory().getArmor(2).getItem() instanceof IdofrontArmorItem) {
            // Open the GUI on the client
            Minecraft.getInstance().setScreen(
                    new BondrewdArmorScreen(
                            new BondrewdArmorScreenHandler(0, player.getInventory()), // ScreenHandler
                            player.getInventory(), // Player Inventory
                            Component.literal("Cartridge Slots") // Title
                    )
            );
        } else {
            player.sendSystemMessage(Component.literal("You must be wearing the Idofront Chestplate!"));
        }
    }
}
