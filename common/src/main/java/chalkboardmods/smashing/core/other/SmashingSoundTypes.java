package chalkboardmods.smashing.core.other;

import chalkboardmods.smashing.core.registry.SmashingSounds;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.SoundType;

import java.util.function.Supplier;

public class SmashingSoundTypes {
    public static final Supplier<SoundType> POT = () -> new SoundType(1.0F, 1.0F, SmashingSounds.POT_SMASH.get(), SoundEvents.STONE_STEP, SoundEvents.STONE_PLACE, SoundEvents.STONE_HIT, SoundEvents.STONE_FALL);
}
