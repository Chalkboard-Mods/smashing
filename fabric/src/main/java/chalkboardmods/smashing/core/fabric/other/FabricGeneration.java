package chalkboardmods.smashing.core.fabric.other;

import chalkboardmods.smashing.core.Smashing;
import chalkboardmods.smashing.core.registry.SmashingBlocks;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.ModificationPhase;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class FabricGeneration {
    public static ConfiguredFeature<?,?> COMMON_CF;
    public static PlacedFeature COMMON_PF;

    private static final BlockPredicate POT_PREDICATE = BlockPredicate.allOf(
            BlockPredicate.ONLY_IN_AIR_PREDICATE,
            BlockPredicate.solid(BlockPos.ZERO.below()),
            BlockPredicate.not(BlockPredicate.matchesBlocks(List.of(Blocks.POINTED_DRIPSTONE), BlockPos.ZERO.below()))
    );

    public static final WeightedStateProvider COMMON = new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(SmashingBlocks.COMMON_POT.get().defaultBlockState(), 3).add(SmashingBlocks.LARGE_COMMON_POT.get().defaultBlockState(), 1).add(SmashingBlocks.TALL_COMMON_POT.get().defaultBlockState(), 1));

    public static void onInit() {
        COMMON_CF = Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation(Smashing.MOD_ID, "common_cf"), Feature.RANDOM_PATCH.configured(new RandomPatchConfiguration(64, 6, 2, () -> Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(COMMON)).filtered(POT_PREDICATE))));
        COMMON_PF = Registry.register(BuiltinRegistries.PLACED_FEATURE, new ResourceLocation(Smashing.MOD_ID, "common_pf"), COMMON_CF.placed(CountPlacement.of(UniformInt.of(2, 3)), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(5), VerticalAnchor.belowTop(275)), BiomeFilter.biome()));

        BiomeModifications.create(new ResourceLocation(Smashing.MOD_ID, "common_placed")).add(ModificationPhase.ADDITIONS, (context) -> {
            Biome.BiomeCategory category = context.getBiome().getBiomeCategory();
            return category != Biome.BiomeCategory.NETHER && category != Biome.BiomeCategory.THEEND && category != Biome.BiomeCategory.NONE;
        }, context -> context.getGenerationSettings().addBuiltInFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, COMMON_PF));

    }
}
