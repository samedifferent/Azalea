package com.samebutdifferent.azalea.init;

import net.minecraft.block.Blocks;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.math.Direction;
import net.minecraft.world.gen.ProbabilityConfig;
import net.minecraft.world.gen.blockpredicate.BlockPredicate;
import net.minecraft.world.gen.decorator.PlacementModifier;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

import java.util.List;
import java.util.function.Supplier;

public class CustomUndergroundConfiguredFeatures {
    public static final ConfiguredFeature<RootSystemFeatureConfig, ?> NEW_ROOTED_AZALEA_TREE;
    public static final ConfiguredFeature<RandomPatchFeatureConfig, ?> SURFACE_MOSS;

    public CustomUndergroundConfiguredFeatures() {
    }

    private static RandomPatchFeatureConfig createRandomPatchFeatureConfig(BlockStateProvider block, int tries) {
        return ConfiguredFeatures.createRandomPatchFeatureConfig(tries, Feature.GLOW_LICHEN.configure(new GlowLichenFeatureConfig(1, true, true, true, 1.0F, List.of(Blocks.STONE, Blocks.ANDESITE, Blocks.DIORITE, Blocks.GRANITE, Blocks.DRIPSTONE_BLOCK, Blocks.CLAY, Blocks.TUFF, Blocks.DEEPSLATE))).withInAirFilter());
    }


    static {
        SURFACE_MOSS = ConfiguredFeatures.register("surface_moss", CustomFeature.SURFACE_MOSS.configure(createRandomPatchFeatureConfig(BlockStateProvider.of(BlocksRegistry.SURFACE_MOSS), 256)));

        NEW_ROOTED_AZALEA_TREE = ConfiguredFeatures.register("new_rooted_azalea_tree", Feature.ROOT_SYSTEM.configure(new RootSystemFeatureConfig(() -> {
            return CustomTreeConfiguredFeatures.NEW_AZALEA_TREE.withPlacement(new PlacementModifier[0]);
        }, 3, 3, BlockTags.AZALEA_ROOT_REPLACEABLE.getId(), BlockStateProvider.of(Blocks.ROOTED_DIRT), 20, 100, 3, 2, BlockStateProvider.of(Blocks.HANGING_ROOTS), 20, 2, BlockPredicate.bothOf(BlockPredicate.anyOf(new BlockPredicate[]{BlockPredicate.matchingBlocks(List.of(Blocks.AIR, Blocks.CAVE_AIR, Blocks.VOID_AIR, Blocks.WATER)), BlockPredicate.matchingBlockTag(BlockTags.LEAVES), BlockPredicate.matchingBlockTag(BlockTags.REPLACEABLE_PLANTS)}), BlockPredicate.matchingBlockTag(BlockTags.AZALEA_GROWS_ON, Direction.DOWN.getVector())))));
    }
}

