package com.samebutdifferent.azalea.client;

import com.samebutdifferent.azalea.init.BlocksRegistry;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

@net.fabricmc.api.Environment(net.fabricmc.api.EnvType.CLIENT)
public class AzaleaClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlocks(
                RenderLayer.getCutout(),

                BlocksRegistry.AZALEA_DOOR,
                BlocksRegistry.FLOWERING_AZALEA_DOOR,
                BlocksRegistry.AZALEA_PLANKS,
                BlocksRegistry.AZALEA_SLAB,
                BlocksRegistry.AZALEA_STAIRS,
                BlocksRegistry.FLOWERING_AZALEA_PLANKS,
                BlocksRegistry.FLOWERING_AZALEA_SLAB,
                BlocksRegistry.FLOWERING_AZALEA_STAIRS,
                BlocksRegistry.FLOWERING_AZALEA_LOG,
                BlocksRegistry.FLOWERING_AZALEA_DOOR,
                BlocksRegistry.AZALEA_TRAPDOOR,
                BlocksRegistry.FLOWERING_AZALEA_TRAPDOOR,
                BlocksRegistry.AZALEA_FLOWER,
                BlocksRegistry.POTTED_AZALEA_FLOWER,
                BlocksRegistry.SURFACE_MOSS
        );
    }
}
