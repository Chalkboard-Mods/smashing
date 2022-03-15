package chalkboardmods.smashing.core.forge.registry;

import chalkboardmods.smashing.core.registry.SmashingBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.placement.*;

public class ForgeFeatures {
    public static class WeightedStateProviders {
        public static final WeightedStateProvider COMMON = new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(SmashingBlocks.COMMON_POT.get().defaultBlockState(), 3).add(SmashingBlocks.LARGE_COMMON_POT.get().defaultBlockState(), 1).add(SmashingBlocks.TALL_COMMON_POT.get().defaultBlockState(), 1));
    }

    public static class Configured {
        public static final ConfiguredFeature<?, ?> COMMON = FeatureUtils.register("common_configured", Feature.RANDOM_PATCH.configured(new RandomPatchConfiguration(64, 6, 2, () -> Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(WeightedStateProviders.COMMON)).filtered(POT_PREDICATE))));

    }

    public static class Placed {
        public static final PlacedFeature COMMON = PlacementUtils.register("common_placed", Configured.COMMON.placed(CountPlacement.of(UniformInt.of(2, 3)), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(5), VerticalAnchor.belowTop(275)), BiomeFilter.biome()));
    }

    private static final BlockPredicate POT_PREDICATE = BlockPredicate.allOf(
            BlockPredicate.ONLY_IN_AIR_PREDICATE,
            BlockPredicate.solid(BlockPos.ZERO.below())
    );
}
