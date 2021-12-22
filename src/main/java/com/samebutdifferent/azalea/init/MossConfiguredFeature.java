//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.samebutdifferent.azalea.init;

import com.mojang.serialization.Codec;
import com.samebutdifferent.azalea.block.SurfaceMossBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.VineBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.ProbabilityConfig;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.GlowLichenFeatureConfig;
import net.minecraft.world.gen.feature.RandomPatchFeatureConfig;
import net.minecraft.world.gen.feature.util.FeatureContext;

import static com.samebutdifferent.azalea.block.SurfaceMossBlock.FACING;

public class MossConfiguredFeature extends Feature<MossPatchFeatureConfig> {
    public MossConfiguredFeature(Codec<MossPatchFeatureConfig> codec) {
        super(codec);
    }

    public boolean generate(FeatureContext<MossPatchFeatureConfig> context) {
        StructureWorldAccess structureWorldAccess = context.getWorld();
        BlockPos blockPos = context.getOrigin();
        context.getConfig();
        if (!structureWorldAccess.isAir(blockPos)) {
            return false;
        } else {
            Direction[] var4 = Direction.values();
            int var5 = var4.length;

            for (Direction direction : var4) {
                if (direction != Direction.DOWN && VineBlock.shouldConnectTo(structureWorldAccess, blockPos.offset(direction), direction)) {
                    structureWorldAccess.setBlockState(blockPos, (BlockState) BlocksRegistry.SURFACE_MOSS.getDefaultState().with(SurfaceMossBlock.LAYERS, getRandomNumber(1, 3)).with(FACING, direction.getOpposite()), 2);
                    return true;
                }
            }

            return false;
        }
    }

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
