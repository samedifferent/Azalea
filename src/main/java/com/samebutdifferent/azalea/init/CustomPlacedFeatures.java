package com.samebutdifferent.azalea.init;

import com.google.common.collect.ImmutableList;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.gen.blockpredicate.BlockPredicate;
import net.minecraft.world.gen.decorator.*;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static net.minecraft.world.gen.feature.VegetationPlacedFeatures.NOT_IN_SURFACE_WATER_MODIFIER;

public class CustomPlacedFeatures {
    public static final PlacedFeature NEW_ROOTED_AZALEA_TREE;

    public CustomPlacedFeatures() {
    }

    public static List<PlacementModifier> modifiers(int count) {
        return List.of(CountPlacementModifier.of(count), SquarePlacementModifier.of(), PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, BiomePlacementModifier.of());
    }

    private static List<PlacementModifier> modifiersWithChance(int chance, @Nullable PlacementModifier modifier) {
        ImmutableList.Builder<PlacementModifier> builder = ImmutableList.builder();
        if (modifier != null) {
            builder.add(modifier);
        }

        if (chance != 0) {
            builder.add(RarityFilterPlacementModifier.of(chance));
        }

        builder.add(SquarePlacementModifier.of());
        builder.add(PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP);
        builder.add(BiomePlacementModifier.of());
        return builder.build();
    }

    private static ImmutableList.Builder<Object> modifiersBuilder(PlacementModifier countModifier) {
        return ImmutableList.builder().add(countModifier).add(SquarePlacementModifier.of()).add(NOT_IN_SURFACE_WATER_MODIFIER).add(PlacedFeatures.OCEAN_FLOOR_HEIGHTMAP).add(BiomePlacementModifier.of());
    }

    public static ImmutableList<Object> modifiers(PlacementModifier modifier) {
        return modifiersBuilder(modifier).build();
    }

    public static ImmutableList<Object> modifiersWithWouldSurvive(PlacementModifier modifier, Block block) {
        return modifiersBuilder(modifier).add(BlockFilterPlacementModifier.of(BlockPredicate.wouldSurvive(block.getDefaultState(), BlockPos.ORIGIN))).build();
    }

    static {
        NEW_ROOTED_AZALEA_TREE = PlacedFeatures.register("new_rooted_azalea_tree", CustomUndergroundConfiguredFeatures.NEW_ROOTED_AZALEA_TREE.withPlacement(CountPlacementModifier.of(UniformIntProvider.create(1, 2)), SquarePlacementModifier.of(), PlacedFeatures.BOTTOM_TO_120_RANGE, EnvironmentScanPlacementModifier.of(Direction.UP, BlockPredicate.solid(), BlockPredicate.IS_AIR, 12), RandomOffsetPlacementModifier.vertically(ConstantIntProvider.create(-1)), BiomePlacementModifier.of()));
    }
}
