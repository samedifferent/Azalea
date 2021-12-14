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
    public static final Item AZALEA_LOG = register("azalea_log", new BlockItem(BlocksRegistry.AZALEA_LOG, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));
    public static final Item FLOWERING_AZALEA_LOG = register("flowering_azalea_log", new BlockItem(BlocksRegistry.FLOWERING_AZALEA_LOG, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));
    public static final Item STRIPPED_AZALEA_LOG = register("stripped_azalea_log", new BlockItem(BlocksRegistry.STRIPPED_AZALEA_LOG, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));

    public static final Item AZALEA_DOOR = register("azalea_door", new BlockItem(BlocksRegistry.AZALEA_DOOR, new FabricItemSettings().group(ItemGroup.REDSTONE)));
    public static final Item SURFACE_MOSS = register("surface_moss", new BlockItem(BlocksRegistry.SURFACE_MOSS, new FabricItemSettings().group(ItemGroup.DECORATIONS)));

    private static Item register(String id, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(Azalea.MOD_ID, id), item);
    }
}
