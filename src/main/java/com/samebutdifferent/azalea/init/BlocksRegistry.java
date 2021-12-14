package com.samebutdifferent.azalea.init;


import com.samebutdifferent.azalea.block.SurfaceMossBlock;
import com.samebutdifferent.azalea.block.vanilla.PublicDoorBlock;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.*;
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
    public static final Block FLOWERING_AZALEA_LOG = register("flowering_azalea_log", new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG).sounds(BlockSoundGroup.WOOD)));
    public static final Block STRIPPED_AZALEA_LOG = register("stripped_azalea_log", new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_LOG).sounds(BlockSoundGroup.WOOD)));
    public static final Block AZALEA_DOOR = register("azalea_door", new PublicDoorBlock(FabricBlockSettings.copyOf(Blocks.OAK_DOOR).sounds(BlockSoundGroup.WOOD)));
    public static final Block AZALEA_PLANKS = register("azalea_planks", new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).sounds(BlockSoundGroup.WOOD)));



    static {
        UseBlockCallback.EVENT.register((player, world, hand, hit) -> {
            BlockPos pos = hit.getBlockPos();
            BlockState state = world.getBlockState(pos);
            if (state.isOf(Blocks.FLOWERING_AZALEA)) {
                ItemStack stack = player.getStackInHand(hand);
                if (stack.isIn(FabricToolTags.SHEARS)) {
                    world.setBlockState(pos, Blocks.AZALEA.getDefaultState());
                    world.playSoundFromEntity(null, player, SoundEvents.ENTITY_SHEEP_SHEAR, SoundCategory.PLAYERS, 1.0F, 1.0F);
                    Block.dropStack(world, pos.up(), new ItemStack(SURFACE_MOSS, world.random.nextInt(2) + 1));
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
