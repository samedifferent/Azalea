package com.samebutdifferent.azalea.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

@SuppressWarnings("deprecation")
public class SurfaceMossBlock extends Block {
        public static final IntProperty LAYERS = IntProperty.of("layers", 1, 3);
        public static final DirectionProperty FACING = Properties.FACING;
        protected static final VoxelShape EAST_AABB = Block.createCuboidShape(0.0D, 0.0D, 0.0D, 1.0D, 16.0D, 16.0D);
        protected static final VoxelShape WEST_AABB = Block.createCuboidShape(15.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
        protected static final VoxelShape SOUTH_AABB = Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 1.0D);
        protected static final VoxelShape NORTH_AABB = Block.createCuboidShape(0.0D, 0.0D, 15.0D, 16.0D, 16.0D, 16.0D);
        protected static final VoxelShape UP_AABB = Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 1.0D, 16.0D);
        protected static final VoxelShape DOWN_AABB = Block.createCuboidShape(0.0D, 15.0D, 0.0D, 16.0D, 16.0D, 16.0D);


        public SurfaceMossBlock(FabricBlockSettings settings) {
            super(settings);
            this.setDefaultState(this.stateManager.getDefaultState().with(LAYERS, 1).with(FACING, Direction.NORTH));
        }

        @Override
        public VoxelShape getOutlineShape(BlockState state, BlockView getter, BlockPos pos, ShapeContext context) {
            return switch (state.get(FACING)) {
                default -> NORTH_AABB;
                case SOUTH -> SOUTH_AABB;
                case WEST -> WEST_AABB;
                case EAST -> EAST_AABB;
                case UP -> UP_AABB;
                case DOWN -> DOWN_AABB;
            };
        }
        @Override
        public VoxelShape getCollisionShape(BlockState state, BlockView getter, BlockPos pos, ShapeContext context) {
            return switch (state.get(FACING)) {
                default -> NORTH_AABB;
                case SOUTH -> SOUTH_AABB;
                case WEST -> WEST_AABB;
                case EAST -> EAST_AABB;
                case UP -> UP_AABB;
                case DOWN -> DOWN_AABB;
            };
        }

        @Override
        public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
            Direction direction = state.get(FACING);
            BlockPos blockpos = pos.offset(direction.getOpposite());
            return world.getBlockState(blockpos).isSideSolidFullSquare(world, blockpos, direction);
        }

        @Override
        public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
            return direction == state.get(FACING).getOpposite() && !state.isSolidBlock(world, pos) ? Blocks.AIR.getDefaultState() : super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
        }

        @Override
        public boolean canReplace(BlockState state, ItemPlacementContext context) {
            return !context.shouldCancelInteraction() && context.getStack().isOf(this.asItem()) && state.get(LAYERS) < 3 || super.canReplace(state, context);
        }

        @Override
        public boolean isTranslucent(BlockState state, BlockView getter, BlockPos pos) {
            return state.getFluidState().isEmpty();
        }

        @Nullable
        @Override
        public BlockState getPlacementState(ItemPlacementContext context) {
            BlockState blockstate = context.getWorld().getBlockState(context.getBlockPos());
            for (Direction direction : context.getPlacementDirections()) {
                Direction direction2 = direction.getOpposite();
                if (blockstate.isOf(this)) {
                    return Objects.requireNonNull(super.getPlacementState(context)).with(FACING, blockstate.get(FACING)).with(LAYERS, Math.min(4, blockstate.get(LAYERS) + 1));
                } else {
                    return Objects.requireNonNull(super.getPlacementState(context)).with(FACING, direction2);
                }
            }
            return null;
        }


        @Override
        protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
            builder.add(LAYERS, FACING);
        }

        @Override
        public PistonBehavior getPistonBehavior(BlockState state) {
            return PistonBehavior.DESTROY;
        }
}
