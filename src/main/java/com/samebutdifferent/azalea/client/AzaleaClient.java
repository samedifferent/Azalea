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

                BlocksRegistry.AZALEA_LOG,
                BlocksRegistry.AZALEA_DOOR,
                BlocksRegistry.AZALEA_PLANKS,
                BlocksRegistry.SURFACE_MOSS
        );
    }
}
