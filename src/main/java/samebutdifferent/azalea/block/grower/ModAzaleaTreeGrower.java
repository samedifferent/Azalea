package samebutdifferent.azalea.block.grower;

import net.minecraft.core.Holder;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import org.jetbrains.annotations.Nullable;
import samebutdifferent.azalea.worldgen.ModVegetationFeatures;

import java.util.Random;

public class ModAzaleaTreeGrower extends AbstractTreeGrower {

    @Nullable
    @Override
    protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredFeature(Random p_204307_, boolean p_204308_) {
        return Holder.direct(ModVegetationFeatures.AZALEA_TREE);
    }
}
