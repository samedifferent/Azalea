package com.samebutdifferent.azalea;

import com.google.common.reflect.Reflection;
import com.samebutdifferent.azalea.block.vanilla.AzaleaSignBlock;
import com.samebutdifferent.azalea.block.vanilla.AzaleaWallSignBlock;
import com.samebutdifferent.azalea.init.BlocksRegistry;
import com.samebutdifferent.azalea.init.CustomPlacedFeatures;
import com.samebutdifferent.azalea.init.CustomTreeConfiguredFeatures;
import com.samebutdifferent.azalea.init.ItemsRegistry;
import com.samebutdifferent.azalea.mixin.SignTypeAccessor;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.ModificationPhase;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SignItem;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.SignType;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
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

    public static final SignType FLOWERING_AZALEA_SIGN_TYPE = SignTypeAccessor.registerNew(SignTypeAccessor.newSignType("flowering_azalea"));
    public static final Block FLOWERING_AZALEA_SIGN = new AzaleaSignBlock(AbstractBlock.Settings.of(Material.WOOD, MapColor.TERRACOTTA_RED).noCollision().strength(1.0F).sounds(BlockSoundGroup.WOOD), FLOWERING_AZALEA_SIGN_TYPE);
    public static final Block FLOWERING_AZALEA_WALL_SIGN = new AzaleaWallSignBlock(AbstractBlock.Settings.of(Material.WOOD, MapColor.TERRACOTTA_WHITE).noCollision().strength(1.0F).sounds(BlockSoundGroup.WOOD).dropsLike(FLOWERING_AZALEA_SIGN), FLOWERING_AZALEA_SIGN_TYPE);
    
    public static final SignType AZALEA_SIGN_TYPE = SignTypeAccessor.registerNew(SignTypeAccessor.newSignType("azalea"));
    public static final Block AZALEA_SIGN = new AzaleaSignBlock(AbstractBlock.Settings.of(Material.WOOD, MapColor.TERRACOTTA_RED).noCollision().strength(1.0F).sounds(BlockSoundGroup.WOOD), AZALEA_SIGN_TYPE);
    public static final Block AZALEA_WALL_SIGN = new AzaleaWallSignBlock(AbstractBlock.Settings.of(Material.WOOD, MapColor.TERRACOTTA_WHITE).noCollision().strength(1.0F).sounds(BlockSoundGroup.WOOD).dropsLike(AZALEA_SIGN), AZALEA_SIGN_TYPE);


    @Override
    public void onInitialize() {

        

        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "flowering_azalea_sign"), FLOWERING_AZALEA_SIGN);
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "flowering_azalea_wall_sign"), FLOWERING_AZALEA_WALL_SIGN);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "flowering_azalea_sign"), (Item)(new SignItem(new Item.Settings().maxCount(16).group(ItemGroup.DECORATIONS), FLOWERING_AZALEA_SIGN, FLOWERING_AZALEA_WALL_SIGN)));
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "azalea_sign"), AZALEA_SIGN);
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "azalea_wall_sign"), AZALEA_WALL_SIGN);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "azalea_sign"), (Item)(new SignItem(new Item.Settings().maxCount(16).group(ItemGroup.DECORATIONS), AZALEA_SIGN, AZALEA_WALL_SIGN)));


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
                c.getGenerationSettings().removeBuiltInFeature(UndergroundPlacedFeatures.CLASSIC_VINES_CAVE_FEATURE);
                c.getGenerationSettings().addFeature(VEGETAL_DECORATION, BuiltinRegistries.PLACED_FEATURE.getKey(NEW_ROOTED_AZALEA_TREE).get());
                c.getGenerationSettings().addFeature(VEGETAL_DECORATION, BuiltinRegistries.PLACED_FEATURE.getKey(CustomPlacedFeatures.SURFACE_MOSS).get());

            });
        };

        CompostingChanceRegistry.INSTANCE.add(SURFACE_MOSS, 0.3f);
    }
}
