package samebutdifferent.azalea.event;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.entity.player.BonemealEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import samebutdifferent.azalea.Azalea;
import samebutdifferent.azalea.block.FloweringAzaleaLogBlock;
import samebutdifferent.azalea.block.grower.ModAzaleaTreeGrower;

@Mod.EventBusSubscriber(modid = Azalea.MOD_ID)
public class CommonEventHandler {

    @SubscribeEvent
    public static void onBoneMeal(BonemealEvent event) {
            if (!event.getWorld().isClientSide) {
                if (event.getBlock().getBlock() == Blocks.AZALEA || event.getBlock().getBlock() == Blocks.FLOWERING_AZALEA) {
                    event.setResult(Event.Result.ALLOW);
                    ServerLevel world = (ServerLevel) event.getWorld();
                    ModAzaleaTreeGrower tree = new ModAzaleaTreeGrower();
                    tree.growTree(world, world.getChunkSource().getGenerator(), event.getPos(), event.getBlock(), world.random);
                }
            }
    }

    @SubscribeEvent
    public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
        if (!event.getWorld().isClientSide) {
            Level world = event.getWorld();
            Player player = event.getPlayer();
            BlockPos pos = event.getPos();
            BlockState state = world.getBlockState(pos);
            ItemStack stack = event.getItemStack();
            InteractionHand hand = event.getHand();
            Direction direction = event.getHitVec().getDirection().getAxis() == Direction.Axis.Y ? event.getHitVec().getDirection().getOpposite() : event.getHitVec().getDirection();
            if (stack.is(Items.SHEARS)) {
                if (state.is(Blocks.FLOWERING_AZALEA)) {
                    FloweringAzaleaLogBlock.shearAzalea(world, player, pos, stack, hand, direction, Blocks.AZALEA.defaultBlockState());
                    player.swing(hand, true);
                }
                if (state.is(Blocks.FLOWERING_AZALEA_LEAVES)) {
                    FloweringAzaleaLogBlock.shearAzalea(world, player, pos, stack, hand, direction, Blocks.AZALEA_LEAVES.defaultBlockState());
                    player.swing(hand, true);
                }
            }
        }
    }
}
