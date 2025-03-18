package net.lykos.protogmt.util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.server.MinecraftServer;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class UUIDConfig {
    private static File CONFIG_FILE;
    private static final Gson GSON = new Gson();
    private static Set<UUID> allowedUUIDs = new HashSet<>();

    public static void initialize(MinecraftServer server) {
        CONFIG_FILE = new File(server.getServerDirectory(), "config/uuid_lock.json");
        loadConfig();
    }

    public static void loadConfig() {
        if (CONFIG_FILE == null) {
            System.err.println("[ERROR] Config file is not initialized. Call UUIDConfig.initialize(server) first.");
            return;
        }

        if (!CONFIG_FILE.exists()) {
            System.out.println("[DEBUG] No UUID config file found on server. Creating a new one with an empty list.");
            saveConfig();
            return;
        }

        try (FileReader reader = new FileReader(CONFIG_FILE)) {
            Type setType = new TypeToken<Set<UUID>>() {}.getType();
            allowedUUIDs = GSON.fromJson(reader, setType);
            System.out.println("[DEBUG] Loaded UUIDs from server config: " + allowedUUIDs);
        } catch (IOException e) {
            System.err.println("[ERROR] Failed to load UUID config: " + e.getMessage());
        }
    }

    public static void saveConfig() {
        if (CONFIG_FILE == null) {
            System.err.println("[ERROR] Config file is not initialized. Call UUIDConfig.initialize(server) first.");
            return;
        }

        try (FileWriter writer = new FileWriter(CONFIG_FILE)) {
            GSON.toJson(allowedUUIDs, writer);
            System.out.println("[DEBUG] Saved UUID config to server: " + allowedUUIDs);
        } catch (IOException e) {
            System.err.println("[ERROR] Failed to save UUID config: " + e.getMessage());
        }
    }

    public static boolean isAllowedUUID(UUID uuid) {
        boolean isAllowed = allowedUUIDs.contains(uuid);
        System.out.println("[DEBUG] Checking UUID on server: " + uuid + " | Allowed: " + isAllowed);
        return isAllowed;
    }

    public static void addUUID(UUID uuid) {
        allowedUUIDs.add(uuid);
        saveConfig();
    }

    public static void removeUUID(UUID uuid) {
        allowedUUIDs.remove(uuid);
        saveConfig();
    }
}
