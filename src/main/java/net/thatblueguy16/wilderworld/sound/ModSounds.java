package net.thatblueguy16.wilderworld.sound;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.thatblueguy16.wilderworld.WilderWorld;

public class ModSounds {
    public static final SoundEvent BOG_MAW_IDLE = registerSoundEvent("bog_maw_idle");
    public static final SoundEvent BOG_MAW_HURT = registerSoundEvent("bog_maw_hurt");
    public static final SoundEvent BOG_MAW_DEATH = registerSoundEvent("bog_maw_death");

    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = Identifier.of(WilderWorld.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerSounds() {
        WilderWorld.LOGGER.info("Registering Mod Sounds for " + WilderWorld.MOD_ID);
    }

}
