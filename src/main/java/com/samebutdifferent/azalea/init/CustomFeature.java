package com.samebutdifferent.azalea.init;

import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.ProbabilityConfig;
import net.minecraft.world.gen.feature.*;

public class CustomFeature<FC extends FeatureConfig> {
    public static final MossConfiguredFeature SURFACE_MOSS;
    private static <C extends FeatureConfig, F extends Feature<C>> F register(String name, F feature) {
        return (F) Registry.register(Registry.FEATURE, name, feature);
    }
    static {
        SURFACE_MOSS = register("surface_moss", new MossConfiguredFeature(MossPatchFeatureConfig.CODEC));
    }
}
