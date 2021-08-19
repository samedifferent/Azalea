package samebutdifferent.azalea.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import samebutdifferent.azalea.registry.ModBlocks;

public class FloweringAzaleaWoodBlock extends RotatedPillarBlock {
    public FloweringAzaleaWoodBlock() {
        super(Properties.copy(Blocks.OAK_WOOD));
    }

    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        ItemStack itemstack = player.getItemInHand(hand);
        if (itemstack.is(Items.SHEARS)) {
            if (!world.isClientSide) {
                Direction direction = hitResult.getDirection().getAxis() == Direction.Axis.Y ? player.getDirection().getOpposite() : hitResult.getDirection();
                FloweringAzaleaLogBlock.shearAzalea(world, player, pos, itemstack, hand, direction, ModBlocks.AZALEA_WOOD.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, state.getValue(AXIS)));
            }

            return InteractionResult.sidedSuccess(world.isClientSide);
        } else {
            return super.use(state, world, pos, player, hand, hitResult);
        }
    }
}
