package com.samebutdifferent.azalea.init;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.collection.DataPool;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.RandomSpreadFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.trunk.BendingTrunkPlacer;

public class CustomTreeConfiguredFeatures extends TreeConfiguredFeatures {
    public static final ConfiguredFeature<?, ?> NEW_AZALEA_TREE;

    static {
        NEW_AZALEA_TREE = ConfiguredFeatures.register("new_azalea_tree", Feature.TREE.configure((new TreeFeatureConfig.Builder(new WeightedBlockStateProvider(DataPool.<BlockState>builder().add(BlocksRegistry.AZALEA_LOG.getDefaultState(), 3).add(BlocksRegistry.FLOWERING_AZALEA_LOG.getDefaultState(), 1)), new BendingTrunkPlacer(4, 2, 0, 3, UniformIntProvider.create(1, 2)), new WeightedBlockStateProvider(DataPool.<BlockState>builder().add(Blocks.AZALEA_LEAVES.getDefaultState(), 3).add(Blocks.FLOWERING_AZALEA_LEAVES.getDefaultState(), 1)), new RandomSpreadFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(0), ConstantIntProvider.create(2), 50), new TwoLayersFeatureSize(1, 0, 1))).dirtProvider(BlockStateProvider.of(Blocks.ROOTED_DIRT)).forceDirt().build()));
    }
}
