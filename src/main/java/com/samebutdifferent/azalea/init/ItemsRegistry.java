package com.samebutdifferent.azalea.init;

import com.samebutdifferent.azalea.Azalea;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;


@SuppressWarnings("unused")
public final class ItemsRegistry {
    public static final Item AZALEA_PLANKS = register("azalea_planks", new BlockItem(BlocksRegistry.AZALEA_PLANKS, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));
    public static final Item AZALEA_SLAB = register("azalea_slab", new BlockItem(BlocksRegistry.AZALEA_SLAB, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));
    public static final Item AZALEA_STAIRS = register("azalea_stairs", new BlockItem(BlocksRegistry.AZALEA_STAIRS, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));
    public static final Item AZALEA_FENCE = register("azalea_fence", new BlockItem(BlocksRegistry.AZALEA_FENCE, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));
    public static final Item FLOWERING_AZALEA_PLANKS = register("flowering_azalea_planks", new BlockItem(BlocksRegistry.FLOWERING_AZALEA_PLANKS, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));
    public static final Item FLOWERING_AZALEA_SLAB = register("flowering_azalea_slab", new BlockItem(BlocksRegistry.FLOWERING_AZALEA_SLAB, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));
    public static final Item FLOWERING_AZALEA_STAIRS = register("flowering_azalea_stairs", new BlockItem(BlocksRegistry.FLOWERING_AZALEA_STAIRS, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));
    public static final Item FLOWERING_AZALEA_FENCE = register("flowering_azalea_fence", new BlockItem(BlocksRegistry.FLOWERING_AZALEA_FENCE, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));

    public static final Item AZALEA_LOG = register("azalea_log", new BlockItem(BlocksRegistry.AZALEA_LOG, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));
    public static final Item AZALEA_WOOD = register("azalea_wood", new BlockItem(BlocksRegistry.AZALEA_WOOD, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));
    public static final Item FLOWERING_AZALEA_LOG = register("flowering_azalea_log", new BlockItem(BlocksRegistry.FLOWERING_AZALEA_LOG, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));
    public static final Item FLOWERING_AZALEA_WOOD = register("flowering_azalea_wood", new BlockItem(BlocksRegistry.FLOWERING_AZALEA_WOOD, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));
    public static final Item STRIPPED_AZALEA_LOG = register("stripped_azalea_log", new BlockItem(BlocksRegistry.STRIPPED_AZALEA_LOG, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));
    public static final Item STRIPPED_AZALEA_WOOD = register("stripped_azalea_wood", new BlockItem(BlocksRegistry.STRIPPED_AZALEA_WOOD, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));
    public static final Item AZALEA_FLOWER = register("azalea_flower", new BlockItem(BlocksRegistry.AZALEA_FLOWER, new FabricItemSettings().group(ItemGroup.DECORATIONS)));

    public static final Item AZALEA_DOOR = register("azalea_door", new BlockItem(BlocksRegistry.AZALEA_DOOR, new FabricItemSettings().group(ItemGroup.REDSTONE)));
    public static final Item AZALEA_BUTTON = register("azalea_button", new BlockItem(BlocksRegistry.AZALEA_BUTTON, new FabricItemSettings().group(ItemGroup.REDSTONE)));
    public static final Item AZALEA_PRESSURE_PLATE = register("azalea_pressure_plate", new BlockItem(BlocksRegistry.AZALEA_PRESSURE_PLATE, new FabricItemSettings().group(ItemGroup.REDSTONE)));
    public static final Item AZALEA_FENCE_GATE = register("azalea_fence_gate", new BlockItem(BlocksRegistry.AZALEA_FENCE_GATE, new FabricItemSettings().group(ItemGroup.REDSTONE)));
    public static final Item FLOWERING_AZALEA_DOOR = register("flowering_azalea_door", new BlockItem(BlocksRegistry.FLOWERING_AZALEA_DOOR, new FabricItemSettings().group(ItemGroup.REDSTONE)));
    public static final Item FLOWERING_AZALEA_FENCE_GATE = register("flowering_azalea_fence_gate", new BlockItem(BlocksRegistry.FLOWERING_AZALEA_FENCE_GATE, new FabricItemSettings().group(ItemGroup.REDSTONE)));
    public static final Item AZALEA_TRAPDOOR = register("azalea_trapdoor", new BlockItem(BlocksRegistry.AZALEA_TRAPDOOR, new FabricItemSettings().group(ItemGroup.REDSTONE)));
    public static final Item FLOWERING_AZALEA_TRAPDOOR = register("flowering_azalea_trapdoor", new BlockItem(BlocksRegistry.FLOWERING_AZALEA_TRAPDOOR, new FabricItemSettings().group(ItemGroup.REDSTONE)));
    public static final Item SURFACE_MOSS = register("surface_moss", new BlockItem(BlocksRegistry.SURFACE_MOSS, new FabricItemSettings().group(ItemGroup.DECORATIONS)));

    private static Item register(String id, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(Azalea.MOD_ID, id), item);
    }
}
