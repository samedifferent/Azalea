package samebutdifferent.azalea.data;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.ExistingFileHelper;
import samebutdifferent.azalea.Azalea;
import samebutdifferent.azalea.registry.ModBlocks;

public class BlockTagGenerator extends BlockTagsProvider {
    public BlockTagGenerator(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, Azalea.MOD_ID, exFileHelper);
    }

    @Override
    protected void addTags() {
        this.tag(BlockTags.MINEABLE_WITH_AXE)
                .add(ModBlocks.AZALEA_LOG.get())
                .add(ModBlocks.STRIPPED_AZALEA_LOG.get())
                .add(ModBlocks.FLOWERING_AZALEA_LOG.get())
                .add(ModBlocks.AZALEA_WOOD.get())
                .add(ModBlocks.STRIPPED_AZALEA_WOOD.get())
                .add(ModBlocks.AZALEA_PLANKS.get())
                .add(ModBlocks.FLOWERING_AZALEA_PLANKS.get())
                .add(ModBlocks.AZALEA_SLAB.get())
                .add(ModBlocks.AZALEA_STAIRS.get())
                .add(ModBlocks.AZALEA_FENCE.get())
                .add(ModBlocks.AZALEA_FENCE_GATE.get())
                .add(ModBlocks.AZALEA_DOOR.get())
                .add(ModBlocks.AZALEA_TRAPDOOR.get())
                .add(ModBlocks.AZALEA_BUTTON.get())
                .add(ModBlocks.AZALEA_PRESSURE_PLATE.get());
        this.tag(BlockTags.PLANKS).add(ModBlocks.AZALEA_PLANKS.get()).add(ModBlocks.FLOWERING_AZALEA_PLANKS.get());
        this.tag(BlockTags.LOGS_THAT_BURN).add(ModBlocks.AZALEA_LOG.get()).add(ModBlocks.FLOWERING_AZALEA_LOG.get()).add(ModBlocks.STRIPPED_AZALEA_LOG.get());
        this.tag(BlockTags.WOODEN_STAIRS).add(ModBlocks.AZALEA_STAIRS.get());
        this.tag(BlockTags.WOODEN_SLABS).add(ModBlocks.AZALEA_STAIRS.get());
        this.tag(BlockTags.WOODEN_DOORS).add(ModBlocks.AZALEA_DOOR.get());
        this.tag(BlockTags.WOODEN_TRAPDOORS).add(ModBlocks.AZALEA_TRAPDOOR.get());
        this.tag(BlockTags.WOODEN_BUTTONS).add(ModBlocks.AZALEA_BUTTON.get());
        this.tag(BlockTags.WOODEN_FENCES).add(ModBlocks.AZALEA_FENCE.get());
        this.tag(BlockTags.WOODEN_PRESSURE_PLATES).add(ModBlocks.AZALEA_PRESSURE_PLATE.get());
        this.tag(BlockTags.FENCE_GATES).add(ModBlocks.AZALEA_FENCE_GATE.get());
        this.tag(BlockTags.SMALL_FLOWERS).add(ModBlocks.AZALEA_FLOWER.get());
    }
}
