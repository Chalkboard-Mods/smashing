package chalkboardmods.smashing.core.forge.other;

import chalkboardmods.smashing.core.Smashing;
import chalkboardmods.smashing.core.forge.registry.ForgeFeatures;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Smashing.MOD_ID)
public class ForgeGeneration {
    @SubscribeEvent
    public static void onBiomeLoad(BiomeLoadingEvent event) {
        BiomeGenerationSettingsBuilder generation = event.getGeneration();

        if (event.getCategory() != Biome.BiomeCategory.NETHER && event.getCategory() != Biome.BiomeCategory.THEEND && event.getCategory() != Biome.BiomeCategory.NONE) {
            generation.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, ForgeFeatures.Placed.COMMON);
        }
    }
}
