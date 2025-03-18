package net.lykos.protogmt.command;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.lykos.protogmt.items.PactOfEternalNightItem;
import net.lykos.protogmt.util.UUIDConfig;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.network.chat.Component;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.lykos.protogmt.registry.ModItems;

import java.util.UUID;

public class PactCommands {
    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        // Command to bestow the Pact Item (restricted to allowed UUIDs)
        dispatcher.register(Commands.literal("bestow_nyx_pact")
                .requires(source -> {
                    try {
                        ServerPlayer player = source.getPlayerOrException();
                        UUID playerUUID = player.getUUID();
                        boolean isAllowed = UUIDConfig.isAllowedUUID(playerUUID);
                        System.out.println("[DEBUG] Player " + player.getName().getString() + " (" + playerUUID + ") attempting to use bestow_nyx_pact. Allowed: " + isAllowed);
                        return isAllowed; // Only allowed players can use it
                    } catch (CommandSyntaxException e) {
                        System.out.println("[DEBUG] Failed to get player from source in bestow_nyx_pact.");
                        return false;
                    }
                })
                .then(Commands.argument("target", EntityArgument.player())
                        .executes(context -> {
                            ServerPlayer target = EntityArgument.getPlayer(context, "target");
                            ItemStack pactItem = new ItemStack(ModItems.PACT_OF_NYX);
                            boolean added = target.addItem(pactItem);
                            System.out.println("[DEBUG] Attempting to give " + target.getName().getString() + " the Pact of Nyx. Success: " + added);
                            if (added) {
                                context.getSource().sendSuccess(() -> Component.literal("\uD83C\uDF19 The Pact has been granted to " + target.getName().getString()), true);
                                target.displayClientMessage(Component.literal("\uD83C\uDF0C A dark presence bestows you a contract..."), true);
                            } else {
                                context.getSource().sendFailure(Component.literal("\u26A0 Inventory full! Could not grant the Pact."));
                            }
                            return Command.SINGLE_SUCCESS;
                        })
                )
        );

        // Command to break the pact early
        dispatcher.register(Commands.literal("whisper_to_the_sun")
                .executes(context -> {
                    try {
                        MinecraftServer server = context.getSource().getServer();
                        if (PactOfEternalNightItem.isEternalNightActive()) {
                            System.out.println("[DEBUG] Trying to cancel eternal night...");
                            PactOfEternalNightItem.cancelEternalNight(server);
                            context.getSource().sendSuccess(() -> Component.literal("☀ You have severed the contract... The Sun slowly awakens..."), true);
                            System.out.println("[DEBUG] ✅ Eternal night successfully canceled!");
                        } else {
                            context.getSource().sendFailure(Component.literal("\uD83C\uDF19 The Sun does not hear your plea..."));
                            System.out.println("[DEBUG] ❌ No active pact to cancel.");
                        }
                        return Command.SINGLE_SUCCESS;
                    } catch (Exception e) {
                        e.printStackTrace(); // Print error to logs
                        context.getSource().sendFailure(Component.literal("❌ An error occurred while breaking the Pact."));
                        return 0;
                    }
                })
        );
    }
}
