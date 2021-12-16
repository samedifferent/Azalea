package com.samebutdifferent.azalea.block.vanilla;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.BlockState;
import net.minecraft.block.StairsBlock;

public class PublicStairsBlock extends StairsBlock {
    public PublicStairsBlock(BlockState baseBlockState, FabricBlockSettings settings) {
        super(baseBlockState, settings);
    }
}
