package chalkboardmods.smashing.core.forge.other;

import chalkboardmods.smashing.core.Smashing;
import chalkboardmods.smashing.core.registry.SmashingFeatures;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Smashing.MOD_ID)
public class ForgeGeneration {
    @SubscribeEvent
    public static void onBiomeLoad(BiomeLoadingEvent event) {
        ResourceLocation biome = event.getName();
        BiomeGenerationSettingsBuilder generation = event.getGeneration();

        generation.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, SmashingFeatures.Placed.COMMON);
    }
}
