package com.samebutdifferent.azalea.init;


import com.samebutdifferent.azalea.block.MossLayerBlock;
import com.samebutdifferent.azalea.block.SurfaceMossBlock;
import com.samebutdifferent.azalea.block.vanilla.*;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.*;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;

import java.util.function.ToIntFunction;

import static com.samebutdifferent.azalea.Azalea.MOD_ID;


@SuppressWarnings("unused")
public final class BlocksRegistry {


    public static final Block SURFACE_MOSS = register("surface_moss", new SurfaceMossBlock(FabricBlockSettings.of(Material.PLANT).breakInstantly().sounds(BlockSoundGroup.MOSS_CARPET).noCollision()));
    public static final Block AZALEA_LOG = register("azalea_log", new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG).sounds(BlockSoundGroup.WOOD)));
    public static final Block AZALEA_WOOD = register("azalea_wood", new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_WOOD).sounds(BlockSoundGroup.WOOD)));
    public static final Block FLOWERING_AZALEA_LOG = register("flowering_azalea_log", new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG).sounds(BlockSoundGroup.WOOD)));
    public static final Block FLOWERING_AZALEA_WOOD = register("flowering_azalea_wood", new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_WOOD).sounds(BlockSoundGroup.WOOD)));
    public static final Block STRIPPED_AZALEA_LOG = register("stripped_azalea_log", new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_LOG).sounds(BlockSoundGroup.WOOD)));
    public static final Block STRIPPED_AZALEA_WOOD = register("stripped_azalea_wood", new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_LOG).sounds(BlockSoundGroup.WOOD)));
    public static final Block AZALEA_DOOR = register("azalea_door", new PublicDoorBlock(FabricBlockSettings.copyOf(Blocks.OAK_DOOR).sounds(BlockSoundGroup.WOOD)));
    public static final Block AZALEA_TRAPDOOR = register("azalea_trapdoor", new PublicTrapdoorBlock(FabricBlockSettings.copyOf(Blocks.OAK_TRAPDOOR).sounds(BlockSoundGroup.WOOD)));
    public static final Block FLOWERING_AZALEA_DOOR = register("flowering_azalea_door", new PublicDoorBlock(FabricBlockSettings.copyOf(Blocks.OAK_DOOR).sounds(BlockSoundGroup.WOOD)));
    public static final Block FLOWERING_AZALEA_TRAPDOOR = register("flowering_azalea_trapdoor", new PublicTrapdoorBlock(FabricBlockSettings.copyOf(Blocks.OAK_TRAPDOOR).sounds(BlockSoundGroup.WOOD)));
    public static final Block AZALEA_PLANKS = register("azalea_planks", new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).sounds(BlockSoundGroup.WOOD)));
    public static final Block AZALEA_SLAB = register("azalea_slab", new SlabBlock(FabricBlockSettings.copyOf(Blocks.OAK_SLAB).sounds(BlockSoundGroup.WOOD)));
    public static final Block AZALEA_STAIRS = register("azalea_stairs", new PublicStairsBlock(AZALEA_PLANKS.getDefaultState(), FabricBlockSettings.copyOf(Blocks.OAK_SLAB).sounds(BlockSoundGroup.WOOD)));
    public static final Block AZALEA_FENCE = register("azalea_fence", new FenceBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).sounds(BlockSoundGroup.WOOD)));
    public static final Block AZALEA_FENCE_GATE = register("azalea_fence_gate", new FenceGateBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).sounds(BlockSoundGroup.WOOD)));
    public static final Block FLOWERING_AZALEA_PLANKS = register("flowering_azalea_planks", new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).sounds(BlockSoundGroup.WOOD)));
    public static final Block FLOWERING_AZALEA_STAIRS = register("flowering_azalea_stairs", new PublicStairsBlock(FLOWERING_AZALEA_PLANKS.getDefaultState(), FabricBlockSettings.copyOf(Blocks.OAK_SLAB).sounds(BlockSoundGroup.WOOD)));
    public static final Block FLOWERING_AZALEA_SLAB = register("flowering_azalea_slab", new SlabBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).sounds(BlockSoundGroup.WOOD)));
    public static final Block FLOWERING_AZALEA_FENCE = register("flowering_azalea_fence", new FenceBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).sounds(BlockSoundGroup.WOOD)));
    public static final Block FLOWERING_AZALEA_FENCE_GATE = register("flowering_azalea_fence_gate", new FenceGateBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).sounds(BlockSoundGroup.WOOD)));
    public static final Block AZALEA_FLOWER = register("azalea_flower", new FlowerBlock(StatusEffects.LUCK, 15, FabricBlockSettings.copyOf(Blocks.POPPY).sounds(BlockSoundGroup.GRASS)));
    public static final Block POTTED_AZALEA_FLOWER = register("potted_azalea_flower", new FlowerPotBlock(AZALEA_FLOWER, FabricBlockSettings.copyOf(Blocks.POPPY).sounds(BlockSoundGroup.GRASS)));
    public static final Block AZALEA_BUTTON = register("azalea_button", new PublicWoodenButtonBlock(FabricBlockSettings.copyOf(Blocks.OAK_BUTTON).sounds(BlockSoundGroup.WOOD)));
    public static final Block AZALEA_PRESSURE_PLATE = register("azalea_pressure_plate", new PublicPressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.copyOf(Blocks.OAK_PRESSURE_PLATE).sounds(BlockSoundGroup.WOOD)));
    public static final Block MOSS_LAYER = register("moss_layer", new MossLayerBlock(FabricBlockSettings.copyOf(Blocks.SNOW).sounds(BlockSoundGroup.MOSS_CARPET).breakByHand(true)));

    static {
        UseBlockCallback.EVENT.register((player, world, hand, hit) -> {
            BlockPos pos = hit.getBlockPos();
            BlockState state = world.getBlockState(pos);
            if (state.isOf(Blocks.FLOWERING_AZALEA)) {
                ItemStack stack = player.getStackInHand(hand);
                if (stack.isIn(FabricToolTags.SHEARS)) {
                    world.setBlockState(pos, Blocks.AZALEA.getDefaultState());
                    world.playSoundFromEntity(null, player, SoundEvents.ENTITY_SHEEP_SHEAR, SoundCategory.PLAYERS, 1.0F, 1.0F);
                    Block.dropStack(world, pos.up(), new ItemStack(AZALEA_FLOWER, world.random.nextInt(2) + 1));
                    stack.damage(1, player, p -> p.sendToolBreakStatus(hand));
                    return ActionResult.success(world.isClient);
                }
            }
            return ActionResult.PASS;
        });
        UseBlockCallback.EVENT.register((player, world, hand, hit) -> {
            BlockPos pos = hit.getBlockPos();
            BlockState state = world.getBlockState(pos);
            if (state.isOf(Blocks.FLOWERING_AZALEA_LEAVES)) {
                ItemStack stack = player.getStackInHand(hand);
                if (stack.isIn(FabricToolTags.SHEARS)) {
                    world.setBlockState(pos, Blocks.AZALEA_LEAVES.getDefaultState());
                    world.playSoundFromEntity(null, player, SoundEvents.ENTITY_SHEEP_SHEAR, SoundCategory.PLAYERS, 1.0F, 1.0F);
                    Block.dropStack(world, pos.up(), new ItemStack(AZALEA_FLOWER, world.random.nextInt(2) + 1));
                    stack.damage(1, player, p -> p.sendToolBreakStatus(hand));
                    return ActionResult.success(world.isClient);
                }
            }
            return ActionResult.PASS;
        });
        UseBlockCallback.EVENT.register((player, world, hand, hit) -> {
            BlockPos pos = hit.getBlockPos();
            BlockState state = world.getBlockState(pos);
            if (state.isOf(BlocksRegistry.FLOWERING_AZALEA_LOG)) {
                ItemStack stack = player.getStackInHand(hand);
                if (stack.isIn(FabricToolTags.SHEARS)) {
                    world.setBlockState(pos, BlocksRegistry.AZALEA_LOG.getDefaultState());
                    world.playSoundFromEntity(null, player, SoundEvents.ENTITY_SHEEP_SHEAR, SoundCategory.PLAYERS, 1.0F, 1.0F);
                    Block.dropStack(world, pos.up(), new ItemStack(AZALEA_FLOWER, world.random.nextInt(2) + 1));
                    stack.damage(1, player, p -> p.sendToolBreakStatus(hand));
                    return ActionResult.success(world.isClient);
                }
            }
            return ActionResult.PASS;
        });
    }

    private static Block register(String id, Block block) {
        Block registered = Registry.register(Registry.BLOCK, new Identifier(MOD_ID, id), block);
        return registered;
    }
}
