package com.samebutdifferent.azalea.init;

import com.google.common.collect.ImmutableList;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.Heightmap;
import net.minecraft.world.gen.blockpredicate.BlockPredicate;
import net.minecraft.world.gen.decorator.*;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static net.minecraft.world.gen.feature.VegetationPlacedFeatures.NOT_IN_SURFACE_WATER_MODIFIER;

public class CustomPlacedFeatures {
    public static final PlacedFeature NEW_ROOTED_AZALEA_TREE;
    public static final PlacedFeature SURFACE_MOSS;

    public CustomPlacedFeatures() {
    }

    static {
        NEW_ROOTED_AZALEA_TREE = PlacedFeatures.register("new_rooted_azalea_tree", CustomUndergroundConfiguredFeatures.NEW_ROOTED_AZALEA_TREE.withPlacement(CountPlacementModifier.of(UniformIntProvider.create(1, 2)), SquarePlacementModifier.of(), PlacedFeatures.BOTTOM_TO_120_RANGE, EnvironmentScanPlacementModifier.of(Direction.UP, BlockPredicate.solid(), BlockPredicate.IS_AIR, 12), RandomOffsetPlacementModifier.vertically(ConstantIntProvider.create(-1)), BiomePlacementModifier.of()));
        SURFACE_MOSS = PlacedFeatures.register("surface_moss", CustomUndergroundConfiguredFeatures.SURFACE_MOSS.withPlacement(CountPlacementModifier.of(UniformIntProvider.create(256, 256)), PlacedFeatures.BOTTOM_TO_120_RANGE, SquarePlacementModifier.of(), SurfaceThresholdFilterPlacementModifier.of(Heightmap.Type.OCEAN_FLOOR_WG, -2147483648, -13), BiomePlacementModifier.of()));
    }
}
