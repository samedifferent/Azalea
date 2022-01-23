package samebutdifferent.azalea.event;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.BlockPredicateFilter;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.SurfaceWaterDepthFilter;
import net.minecraftforge.event.entity.player.BonemealEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import samebutdifferent.azalea.Azalea;
import samebutdifferent.azalea.block.FloweringAzaleaLogBlock;
import samebutdifferent.azalea.block.grower.ModAzaleaTreeGrower;
import samebutdifferent.azalea.registry.ModBlocks;
import samebutdifferent.azalea.registry.ModConfig;
import samebutdifferent.azalea.worldgen.ModFeatures;

@Mod.EventBusSubscriber(modid = Azalea.MOD_ID)
public class CommonEventHandler {

    @SubscribeEvent
    public static void onBiomeLoad(BiomeLoadingEvent event) {
        if (ModConfig.GENERATE_TREE_NATURALLY.get()) {
            if (event.getCategory() == Biome.BiomeCategory.FOREST || event.getCategory() == Biome.BiomeCategory.PLAINS) {
                event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION).add(() -> ModFeatures.MOD_AZALEA_TREE.placed(
                        PlacementUtils.countExtra(0, 0.05F * ModConfig.TREE_SPAWN_CHANCE_MULTIPLIER.get().floatValue(), 1),
                        InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR,
                        BlockPredicateFilter.forPredicate(BlockPredicate.wouldSurvive(ModBlocks.AZALEA_FLOWER.get().defaultBlockState(), BlockPos.ZERO)),
                        BiomeFilter.biome()));
            }
        }
    }

    @SubscribeEvent
    public static void onBoneMeal(BonemealEvent event) {
        if (ModConfig.OVERRIDE_VANILLA_TREE.get()) {
            if (!event.getWorld().isClientSide) {
                if (event.getBlock().getBlock() == Blocks.AZALEA || event.getBlock().getBlock() == Blocks.FLOWERING_AZALEA) {
                    event.setResult(Event.Result.ALLOW);
                    ServerLevel world = (ServerLevel) event.getWorld();
                    ModAzaleaTreeGrower tree = new ModAzaleaTreeGrower();
                    tree.growTree(world, world.getChunkSource().getGenerator(), event.getPos(), event.getBlock(), world.random);
                }
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
