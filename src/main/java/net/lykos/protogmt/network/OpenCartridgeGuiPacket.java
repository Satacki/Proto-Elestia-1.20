package net.lykos.protogmt.network;

import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.lykos.protogmt.items.IdofrontArmorItem;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleMenuProvider;
import net.lykos.protogmt.gui.BondrewdArmorScreenHandler;
import net.lykos.protogmt.registry.ModScreenHandlers;

public class OpenCartridgeGuiPacket {
    public static final ResourceLocation ID = new ResourceLocation("protogmt", "open_cartridge_gui");

    public static void register() {
        ServerPlayNetworking.registerGlobalReceiver(ID, (server, player, handler, buf, responseSender) -> {
            server.execute(() -> handle(player, buf, responseSender));
        });
    }

    public static void handle(ServerPlayer player, FriendlyByteBuf buf, PacketSender responseSender) {
        if (player.getInventory().getArmor(2).getItem() instanceof IdofrontArmorItem) {
            // Open the GUI from the server
            player.openMenu(new SimpleMenuProvider(
                    (syncId, inventory, p) -> new BondrewdArmorScreenHandler(syncId, inventory, player.getItemBySlot(EquipmentSlot.CHEST)),
                    player.getDisplayName()
            ));
        } else {
            player.sendSystemMessage(Component.literal("You must be wearing the Idofront Chestplate!"));
        }
    }
}
