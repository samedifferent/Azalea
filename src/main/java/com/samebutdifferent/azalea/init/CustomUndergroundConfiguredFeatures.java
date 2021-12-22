package com.samebutdifferent.azalea.init;

import com.samebutdifferent.azalea.block.SurfaceMossBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.collection.DataPool;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.gen.ProbabilityConfig;
import net.minecraft.world.gen.blockpredicate.BlockPredicate;
import net.minecraft.world.gen.decorator.PlacementModifier;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;

import java.util.List;
import java.util.function.Supplier;

public class CustomUndergroundConfiguredFeatures {
    public static final ConfiguredFeature<RootSystemFeatureConfig, ?> NEW_ROOTED_AZALEA_TREE;
    public static final ConfiguredFeature<MossPatchFeatureConfig, ?> SURFACE_MOSS;

    public CustomUndergroundConfiguredFeatures() {
    }

    private static MossPatchFeatureConfig createNewRandomMossPatchFeatureConfig(BlockStateProvider block, int tries) {
        return createRandomMossPatchFeatureConfig(tries, CustomFeature.SURFACE_MOSS.configure(new MossPatchFeatureConfig(tries, 5, 6, true, true, true,  List.of(Blocks.STONE, Blocks.ANDESITE, Blocks.DIORITE, Blocks.GRANITE, Blocks.DRIPSTONE_BLOCK, Blocks.CALCITE, Blocks.TUFF, Blocks.DEEPSLATE))).withInAirFilter());
    }


    public static MossPatchFeatureConfig createRandomMossPatchFeatureConfig(int tries, PlacedFeature feature) {
        return new MossPatchFeatureConfig(tries, 7, 3, true,true,true, List.of(Blocks.STONE, Blocks.ANDESITE, Blocks.DIORITE, Blocks.GRANITE, Blocks.DRIPSTONE_BLOCK, Blocks.CALCITE, Blocks.TUFF, Blocks.DEEPSLATE));
    }

    static {
        SURFACE_MOSS = ConfiguredFeatures.register("surface_moss", CustomFeature.SURFACE_MOSS.configure(createNewRandomMossPatchFeatureConfig(BlockStateProvider.of(BlocksRegistry.SURFACE_MOSS), 96)));
        NEW_ROOTED_AZALEA_TREE = ConfiguredFeatures.register("new_rooted_azalea_tree", Feature.ROOT_SYSTEM.configure(new RootSystemFeatureConfig(() -> {
            return CustomTreeConfiguredFeatures.NEW_AZALEA_TREE.withPlacement(new PlacementModifier[0]);
        }, 3, 3, BlockTags.AZALEA_ROOT_REPLACEABLE.getId(), BlockStateProvider.of(Blocks.ROOTED_DIRT), 20, 100, 3, 2, BlockStateProvider.of(Blocks.HANGING_ROOTS), 20, 2, BlockPredicate.bothOf(BlockPredicate.anyOf(new BlockPredicate[]{BlockPredicate.matchingBlocks(List.of(Blocks.AIR, Blocks.CAVE_AIR, Blocks.VOID_AIR, Blocks.WATER)), BlockPredicate.matchingBlockTag(BlockTags.LEAVES), BlockPredicate.matchingBlockTag(BlockTags.REPLACEABLE_PLANTS)}), BlockPredicate.matchingBlockTag(BlockTags.AZALEA_GROWS_ON, Direction.DOWN.getVector())))));
    }
}

