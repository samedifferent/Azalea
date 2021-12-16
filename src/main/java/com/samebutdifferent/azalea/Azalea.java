package com.samebutdifferent.azalea;

import com.google.common.reflect.Reflection;
import com.samebutdifferent.azalea.init.BlocksRegistry;
import com.samebutdifferent.azalea.init.CustomPlacedFeatures;
import com.samebutdifferent.azalea.init.CustomTreeConfiguredFeatures;
import com.samebutdifferent.azalea.init.ItemsRegistry;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.ModificationPhase;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.world.gen.decorator.*;
import net.minecraft.world.gen.feature.UndergroundPlacedFeatures;

import java.util.List;

import static com.samebutdifferent.azalea.init.BlocksRegistry.*;
import static com.samebutdifferent.azalea.init.CustomPlacedFeatures.NEW_ROOTED_AZALEA_TREE;
import static net.minecraft.world.biome.BiomeKeys.LUSH_CAVES;
import static net.minecraft.world.gen.GenerationStep.Feature.VEGETAL_DECORATION;


public class Azalea implements ModInitializer {
    public static final String MOD_ID = "betterazalea";

    private static List<PlacementModifier> modifiers(PlacementModifier countModifier, PlacementModifier heightModifier) {
        return List.of(countModifier, SquarePlacementModifier.of(), heightModifier, BiomePlacementModifier.of());
    }

    private static List<PlacementModifier> modifiersWithCount(int count, PlacementModifier heightModfier) {
        return modifiers(CountPlacementModifier.of(count), heightModfier);
    }

    private static List<PlacementModifier> modifiersWithRarity(int chance, PlacementModifier heightModifier) {
        return modifiers(RarityFilterPlacementModifier.of(chance), heightModifier);
    }


    @Override
    public void onInitialize() {
        Reflection.initialize(
                BlocksRegistry.class,
                CustomTreeConfiguredFeatures.class,
                CustomPlacedFeatures.class,
                ItemsRegistry.class
        );

        StrippableBlockRegistry.register(AZALEA_LOG, STRIPPED_AZALEA_LOG);
        StrippableBlockRegistry.register(AZALEA_WOOD, STRIPPED_AZALEA_WOOD);
        StrippableBlockRegistry.register(FLOWERING_AZALEA_LOG, STRIPPED_AZALEA_LOG);
        StrippableBlockRegistry.register(FLOWERING_AZALEA_WOOD, STRIPPED_AZALEA_WOOD);

        if (BuiltinRegistries.PLACED_FEATURE.getKey(NEW_ROOTED_AZALEA_TREE).isPresent()) {
            BiomeModifications.create(new Identifier(MOD_ID, "remove_azalea_trees")).add(ModificationPhase.REPLACEMENTS, biomeSelectionContext -> (biomeSelectionContext.getBiomeKey().equals(LUSH_CAVES)), (c) -> {
                c.getGenerationSettings().removeBuiltInFeature(UndergroundPlacedFeatures.ROOTED_AZALEA_TREE);
                c.getGenerationSettings().addFeature(VEGETAL_DECORATION, BuiltinRegistries.PLACED_FEATURE.getKey(NEW_ROOTED_AZALEA_TREE).get());
            });
        }
    }
}
