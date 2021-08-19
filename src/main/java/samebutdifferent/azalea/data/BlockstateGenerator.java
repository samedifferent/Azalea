package samebutdifferent.azalea.data;

import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import samebutdifferent.azalea.Azalea;
import samebutdifferent.azalea.registry.ModBlocks;

public class BlockstateGenerator extends BlockStateProvider {
    public BlockstateGenerator(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, Azalea.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
/*
        logBlock(ModBlocks.AZALEA_LOG.get());
        logBlock(ModBlocks.STRIPPED_AZALEA_LOG.get());
        logBlock(ModBlocks.FLOWERING_AZALEA_LOG.get());
        ResourceLocation planksTex = modLoc("block/" + ModBlocks.AZALEA_PLANKS.get().getRegistryName().getPath());
        simpleBlock(ModBlocks.AZALEA_PLANKS.get());
        simpleBlock(ModBlocks.FLOWERING_AZALEA_PLANKS.get());
        slabBlock(ModBlocks.AZALEA_SLAB.get(), planksTex, planksTex);
        stairsBlock(ModBlocks.AZALEA_STAIRS.get(), planksTex);
        fenceBlock(ModBlocks.AZALEA_FENCE.get(), planksTex);
        fenceGateBlock(ModBlocks.AZALEA_FENCE_GATE.get(), planksTex);
        crossModel(ModBlocks.AZALEA_FLOWER.get());
        doorBlock(ModBlocks.AZALEA_DOOR.get(), modLoc("block/azalea_door_bottom"), modLoc("block/azalea_door_top"));
        trapdoorBlock(ModBlocks.AZALEA_TRAPDOOR.get(), modLoc("block/azalea_trapdoor"), true);
        doorBlock(ModBlocks.FLOWERING_AZALEA_DOOR.get(), modLoc("block/flowering_azalea_door_bottom"), modLoc("block/flowering_azalea_door_top"));
*/
        ResourceLocation flowerPlanksTex = modLoc("block/" + ModBlocks.FLOWERING_AZALEA_PLANKS.get().getRegistryName().getPath());
        slabBlock(ModBlocks.FLOWERING_AZALEA_SLAB.get(), flowerPlanksTex, flowerPlanksTex);
        stairsBlock(ModBlocks.FLOWERING_AZALEA_STAIRS.get(), flowerPlanksTex);
        fenceBlock(ModBlocks.FLOWERING_AZALEA_FENCE.get(), flowerPlanksTex);
        fenceGateBlock(ModBlocks.FLOWERING_AZALEA_FENCE_GATE.get(), flowerPlanksTex);
        trapdoorBlock(ModBlocks.FLOWERING_AZALEA_TRAPDOOR.get(), modLoc("block/flowering_azalea_trapdoor"), true);
    }

    private void crossModel(Block plant) {
        simpleBlock(plant, models().cross(plant.getRegistryName().getPath(), modLoc("block/" + plant.getRegistryName().getPath())));
    }
}
