package com.samebutdifferent.azalea.init;

import com.google.common.collect.Lists;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.dynamic.Codecs;
import net.minecraft.util.math.Direction;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.PlacedFeature;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

public record MossPatchFeatureConfig(int tries, int xzSpread, int ySpread, boolean onFloor, boolean onCeiling, boolean onWalls, List<Block> canPlaceOn) implements FeatureConfig {
    public static final Codec<MossPatchFeatureConfig> CODEC = RecordCodecBuilder.create((instance) -> {
        return instance.group(Codecs.POSITIVE_INT.fieldOf("tries").orElse(128).forGetter(MossPatchFeatureConfig::tries), Codecs.NONNEGATIVE_INT.fieldOf("xz_spread").orElse(7).forGetter(MossPatchFeatureConfig::xzSpread), Codecs.NONNEGATIVE_INT.fieldOf("y_spread").orElse(3).forGetter(MossPatchFeatureConfig::ySpread), Codec.BOOL.fieldOf("can_place_on_floor").orElse(false).forGetter(MossPatchFeatureConfig::onFloor), Codec.BOOL.fieldOf("can_place_on_ceiling").orElse(false).forGetter(MossPatchFeatureConfig::onCeiling), Codec.BOOL.fieldOf("can_place_on_wall").orElse(false).forGetter(MossPatchFeatureConfig::onWalls), Registry.BLOCK.getCodec().listOf().fieldOf("can_be_placed_on").forGetter(MossPatchFeatureConfig::canPlaceOn)).apply(instance, MossPatchFeatureConfig::new);
    });
    public static List<Direction> directions = Lists.newArrayList();

    public MossPatchFeatureConfig(int tries, int xzSpread, int ySpread, boolean onFloor, boolean onCeiling, boolean onWalls, List<Block> canPlaceOn) {
        this.tries = tries;
        this.xzSpread = xzSpread;
        this.ySpread = ySpread;
        this.onFloor = onFloor;
        this.onCeiling = onCeiling;
        this.onWalls = onWalls;
        this.canPlaceOn = canPlaceOn;
        List<Direction> list = Lists.newArrayList();
        if (onCeiling) {
            list.add(Direction.UP);
        }

        if (onFloor) {
            list.add(Direction.DOWN);
        }

        if (onWalls) {
            Direction.Type var10000 = Direction.Type.HORIZONTAL;
            Objects.requireNonNull(list);
            var10000.forEach(list::add);
        }

        directions = Collections.unmodifiableList(list);
    }

    public int tries() {
        return this.tries;
    }

    public int xzSpread() {
        return this.xzSpread;
    }

    public int ySpread() {
        return this.ySpread;
    }
}

