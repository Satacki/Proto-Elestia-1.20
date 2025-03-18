package net.lykos.protogmt.sound;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;

public class ModSounds {
    public static final ResourceLocation CARTRIDGE_ACTIVATE_ID = new ResourceLocation("protogmt", "cartridge_activate");
    public static final ResourceLocation PACT_ACTIVATE_ID = new ResourceLocation("protogmt", "pact_activate");
    public static final ResourceLocation PACT_FAILURE_ID = new ResourceLocation("protogmt", "pact_failure");
    public static final ResourceLocation PACT_COMMAND_ID = new ResourceLocation("protogmt", "pact_command");

    public static final SoundEvent CARTRIDGE_ACTIVATE = SoundEvent.createVariableRangeEvent(CARTRIDGE_ACTIVATE_ID);
    public static final SoundEvent PACT_ACTIVATE = SoundEvent.createVariableRangeEvent(PACT_ACTIVATE_ID);
    public static final SoundEvent PACT_FAILURE = SoundEvent.createVariableRangeEvent(PACT_FAILURE_ID);
    public static final SoundEvent PACT_COMMAND = SoundEvent.createVariableRangeEvent(PACT_COMMAND_ID);

    public static void register() {
        Registry.register(BuiltInRegistries.SOUND_EVENT, CARTRIDGE_ACTIVATE_ID, CARTRIDGE_ACTIVATE);
        Registry.register(BuiltInRegistries.SOUND_EVENT, PACT_ACTIVATE_ID, PACT_ACTIVATE);
        Registry.register(BuiltInRegistries.SOUND_EVENT, PACT_FAILURE_ID, PACT_FAILURE);
        Registry.register(BuiltInRegistries.SOUND_EVENT, PACT_COMMAND_ID, PACT_COMMAND);
    }
}
