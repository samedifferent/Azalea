package samebutdifferent.azalea.block.grower;

import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import samebutdifferent.azalea.worldgen.ModVegetationFeatures;

import javax.annotation.Nullable;
import java.util.Random;

public class ModAzaleaTreeGrower extends AbstractTreeGrower {
    @Nullable
    @Override
    protected ConfiguredFeature<TreeConfiguration, ?> getConfiguredFeature(Random random, boolean b) {
        return ModVegetationFeatures.AZALEA_TREE;
    }
}
