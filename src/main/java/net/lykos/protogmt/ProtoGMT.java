package net.lykos.protogmt;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.fabricmc.api.ModInitializer;
import com.google.gson.JsonElement;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.loader.api.FabricLoader;
import net.lykos.protogmt.client.ModKeybinds;
import net.lykos.protogmt.command.PactCommands;
import net.lykos.protogmt.events.*;
import net.lykos.protogmt.network.OpenCartridgeGuiPacket;
import net.lykos.protogmt.registry.*;
import net.lykos.protogmt.loot.ModLootTableModifiers;
import net.lykos.protogmt.sound.ModSounds;
import net.lykos.protogmt.handlers.RuneBreakerTickHandler;
import net.lykos.protogmt.util.ModRegistries;
import net.lykos.protogmt.util.UUIDConfig;
import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.UUID;

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
        ModScreenHandlers.register();
        ModEvents.register();
        ModSounds.register();
        CartridgeTotemHandler.register();
        ModLootTableModifiers.register();
        RespawnHandler.register();
        ModRecipes.register();
        RuneBreakerTickHandler.registerTickHandler();

        OpenCartridgeGuiPacket.register();
        NegativeEffectBlocker.register();
        PvpEventHandler.register();


        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
            PactCommands.register(dispatcher);
        });

        System.out.println("[ProtoGMT] ✅ Commands Registered!");

        // Properly initialize UUIDConfig when the server starts
        ServerLifecycleEvents.SERVER_STARTING.register(server -> {
            UUIDConfig.initialize(server);
        });
    }


    public static class ConfigManager {
        private static final Path CONFIG_PATH = FabricLoader.getInstance().getConfigDir().resolve("protogmt/uuid_locked.json");
        private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
        private static List<UUID> allowedPlayers;

        public static void loadConfig() {
            try {
                if (!Files.exists(CONFIG_PATH)) {
                    createDefaultConfig();
                }
                String json = Files.readString(CONFIG_PATH);
                JsonObject config = GSON.fromJson(json, JsonObject.class);
                allowedPlayers = config.getAsJsonArray("allowed_players")
                        .asList()
                        .stream()
                        .map(JsonElement::getAsString)
                        .map(UUID::fromString)
                        .toList();
            } catch (Exception e) {
                System.err.println("[ProtoGMT] ⚠ Error loading config: " + e.getMessage());
                e.printStackTrace();
            }
        }

        private static void createDefaultConfig() {
            try {
                Files.createDirectories(CONFIG_PATH.getParent());
                JsonObject defaultConfig = new JsonObject();
                JsonArray defaultUUIDs = new JsonArray();
                defaultUUIDs.add("3f7bc1c7-deef-491c-8b87-8f9d6fc173fb"); // Replace with real UUIDs
                defaultConfig.add("allowed_players", defaultUUIDs);
                Files.writeString(CONFIG_PATH, GSON.toJson(defaultConfig));
                System.out.println("[ProtoGMT] ✅ Default config generated.");
            } catch (IOException e) {
                System.err.println("[ProtoGMT] ⚠ Error creating config: " + e.getMessage());
            }
        }
    }
}
