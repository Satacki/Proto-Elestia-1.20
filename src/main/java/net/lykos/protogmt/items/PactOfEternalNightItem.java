package net.lykos.protogmt.items;

import com.mojang.brigadier.CommandDispatcher;
import net.lykos.protogmt.sound.ModSounds;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class PactOfEternalNightItem extends Item {
    public static boolean isNightActive = false;
    private static final long NIGHT_DURATION_TICKS = TimeUnit.MINUTES.toSeconds(30) * 20; // 30 minutes
    private static final Map<ServerLevel, Long> nightEndTimes = new HashMap<>();

    public PactOfEternalNightItem(Properties properties) {
        super(properties);
    }
    public static boolean isEternalNightActive() {
        return isNightActive;
    }

    public static void cancelEternalNight(MinecraftServer server) {
        if (!isNightActive) return; // ✅ Prevents unnecessary execution

        isNightActive = false; // ✅ Reset the flag
        for (ServerLevel world : server.getAllLevels()) {
            world.getGameRules().getRule(GameRules.RULE_DAYLIGHT).set(true, server);
        }
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if (!(level instanceof ServerLevel serverLevel)) {
            return InteractionResultHolder.pass(player.getItemInHand(hand));
        }

        MinecraftServer server = serverLevel.getServer();

        if (isNightActive) {
            player.displayClientMessage(Component.literal("§cThe contract is already sealed..."), true);
            return InteractionResultHolder.fail(player.getItemInHand(hand));
        }

        activateEternalNight(server);
        player.displayClientMessage(Component.literal("§3The Pact has been forged... The night shall reign."), true);
        level.playSound(null, player.getOnPos(), ModSounds.PACT_ACTIVATE, SoundSource.PLAYERS, 1.0F, 1.0F);

        return InteractionResultHolder.success(player.getItemInHand(hand));
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return isEternalNightActive(); // Makes the item glow when active
    }

    public static void activateEternalNight(MinecraftServer server) {
        isNightActive = true; // ✅ Set the global flag
        for (ServerLevel world : server.getAllLevels()) {
            world.setDayTime(18000);
            world.getGameRules().getRule(GameRules.RULE_DAYLIGHT).set(false, server);
        }
    }


    public static void deactivateEternalNight(MinecraftServer server) {
        if (!isNightActive) return;

        isNightActive = false;

        for (ServerLevel world : server.getAllLevels()) {
            world.getGameRules().getRule(GameRules.RULE_DAYLIGHT).set(true, server);
            world.setDayTime(0); // Reset to morning
        }
    }

    public static void checkNightTime(ServerLevel world) {
        if (isNightActive && world.getGameTime() >= nightEndTimes.getOrDefault(world, Long.MAX_VALUE)) {
            deactivateEternalNight(world.getServer());
        }
    }

    public static void registerCommand(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("invoke_nyx_ascendance")
                .requires(source -> source.hasPermission(2))
                .executes(context -> {
                    MinecraftServer server = context.getSource().getServer();
                    if (isNightActive) {
                        deactivateEternalNight(server);
                        context.getSource().sendSuccess(() -> Component.literal("§eThe grip of darkness weakens..."), true);
                    } else {
                        context.getSource().sendFailure(Component.literal("§cThe night holds no contract..."));
                    }
                    return 1;
                }));
    }
}
