package chalkboardmods.smashing.core.registry;

import chalkboardmods.smashing.core.Smashing;
import gg.moonflower.pollen.api.registry.PollinatedRegistry;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;

import java.util.function.Supplier;

public class SmashingSounds {
    public static final PollinatedRegistry<SoundEvent> SOUNDS = PollinatedRegistry.create(Registry.SOUND_EVENT, Smashing.MOD_ID);

    public static final Supplier<SoundEvent> POT_SMASH = registerSound("block.ceramics.shatter");

    private static Supplier<SoundEvent> registerSound(String id) {
        return SOUNDS.register(id, () -> new SoundEvent(new ResourceLocation(Smashing.MOD_ID, id)));
    }
}
