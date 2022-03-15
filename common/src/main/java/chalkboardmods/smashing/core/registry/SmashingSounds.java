package chalkboardmods.smashing.core.registry;

import chalkboardmods.smashing.core.Smashing;
import gg.moonflower.pollen.api.registry.PollinatedRegistry;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.SoundType;

import java.util.function.Supplier;

public class SmashingSounds {
    public static final PollinatedRegistry<SoundEvent> SOUNDS = PollinatedRegistry.create(Registry.SOUND_EVENT, Smashing.MOD_ID);

    public static final Supplier<SoundEvent> POT_SMASH = registerSound("block.ceramics.shatter");

    public static final SoundType POT = new SoundType(1.0F, 1.0F, POT_SMASH.get(), SoundEvents.STONE_STEP, SoundEvents.STONE_PLACE, SoundEvents.STONE_HIT, SoundEvents.STONE_FALL);

    private static Supplier<SoundEvent> registerSound(String id) {
        return SOUNDS.register(id, () -> new SoundEvent(new ResourceLocation(Smashing.MOD_ID, id)));
    }
}
