package com.samebutdifferent.azalea.mixin;


import com.samebutdifferent.azalea.init.CustomTreeConfiguredFeatures;
import net.minecraft.block.sapling.AzaleaSaplingGenerator;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import java.util.Random;

@Mixin(AzaleaSaplingGenerator.class)
public class AzaleaSaplingGeneratorMixin extends SaplingGenerator {

    @Override
    @Nullable
    public ConfiguredFeature<?, ?> getTreeFeature(Random random, boolean bees) {
        return CustomTreeConfiguredFeatures.NEW_AZALEA_TREE;
    }
}
