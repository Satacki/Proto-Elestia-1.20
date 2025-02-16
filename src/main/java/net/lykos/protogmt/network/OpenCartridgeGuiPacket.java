package net.lykos.protogmt.network;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.lykos.protogmt.registry.ModScreenHandlers;
import net.minecraft.world.MenuProvider;

public class OpenCartridgeGuiPacket {
    public static final ResourceLocation ID = new ResourceLocation("protogmt", "open_cartridge_gui");

    /**
     * ✅ Handles the packet when received on the server
     */
    public static void handle(ServerPlayer player, FriendlyByteBuf buf) {
        if (player != null) {
            player.openMenu((MenuProvider) ModScreenHandlers.BONDED_ARMOR_SCREEN_HANDLER); // ✅ Open the GUI
        }
    }

    /**
     * ✅ Registers the packet so the server can listen for it
     */
    public static void register() {
        ServerPlayNetworking.registerGlobalReceiver(ID, (server, player, handler, buf, responseSender) -> {
            server.execute(() -> handle(player, buf));
        });
    }
}
