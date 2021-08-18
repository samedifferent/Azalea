package samebutdifferent.azalea.worldgen;

import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.RandomSpreadFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.BendingTrunkPlacer;
import samebutdifferent.azalea.registry.ModBlocks;

public class ModFeatures {
    public static ConfiguredFeature<TreeConfiguration, ?> MOD_AZALEA_TREE;

    public static void registerAzaleaTree() {
        MOD_AZALEA_TREE = Feature.TREE.configured(new TreeConfiguration.TreeConfigurationBuilder(
                new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(ModBlocks.AZALEA_LOG.get().defaultBlockState(), 2).add(ModBlocks.FLOWERING_AZALEA_LOG.get().defaultBlockState(), 2).build()),
                new BendingTrunkPlacer(4, 2, 0, 3, UniformInt.of(1, 2)),
                new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(Blocks.AZALEA_LEAVES.defaultBlockState(), 3).add(Blocks.FLOWERING_AZALEA_LEAVES.defaultBlockState(), 1).build()),
                new SimpleStateProvider(ModBlocks.AZALEA_SAPLING.get().defaultBlockState()),
                new RandomSpreadFoliagePlacer(ConstantInt.of(3), ConstantInt.of(0), ConstantInt.of(2), 50),
                new TwoLayersFeatureSize(1, 0, 1))
                .dirt(new SimpleStateProvider(Blocks.ROOTED_DIRT.defaultBlockState())).forceDirt()
                .build());
    }
}
