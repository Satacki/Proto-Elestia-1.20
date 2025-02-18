package net.lykos.protogmt.sound;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;

public class ModSounds {
    public static final ResourceLocation CARTRIDGE_ACTIVATE_ID = new ResourceLocation("protogmt", "cartridge_activate");
    public static final SoundEvent CARTRIDGE_ACTIVATE = SoundEvent.createVariableRangeEvent(CARTRIDGE_ACTIVATE_ID);

    public static void register() {
        Registry.register(BuiltInRegistries.SOUND_EVENT, CARTRIDGE_ACTIVATE_ID, CARTRIDGE_ACTIVATE);
        System.out.println("[DEBUG] Registered sound: " + CARTRIDGE_ACTIVATE_ID);
    }
}
