package samebutdifferent.azalea.data;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fmllegacy.RegistryObject;
import samebutdifferent.azalea.Azalea;
import samebutdifferent.azalea.registry.ModBlocks;

public class ItemModelGenerator extends ItemModelProvider {
    public ItemModelGenerator(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, Azalea.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
/*        ofBlock(ModBlocks.AZALEA_LOG);
        ofBlock(ModBlocks.STRIPPED_AZALEA_LOG);
        ofBlock(ModBlocks.FLOWERING_AZALEA_LOG);
        ofBlock(ModBlocks.AZALEA_PLANKS);
        ofBlock(ModBlocks.FLOWERING_AZALEA_PLANKS);
        ofBlock(ModBlocks.AZALEA_SLAB);
        ofBlock(ModBlocks.AZALEA_STAIRS);
        fence(ModBlocks.AZALEA_FENCE, ModBlocks.AZALEA_PLANKS);
        ofBlock(ModBlocks.AZALEA_FENCE_GATE);
        ofBlock(ModBlocks.AZALEA_FENCE_GATE);
        blockToItemGenerated(ModBlocks.AZALEA_FLOWER);
        trapdoor(ModBlocks.AZALEA_TRAPDOOR);
        generated(ModBlocks.AZALEA_DOOR);
        generated(ModBlocks.FLOWERING_AZALEA_DOOR);*/
    }

    private void ofBlock(RegistryObject block) {
        withExistingParent(block.getId().getPath(), modLoc("block/" + block.getId().getPath()));
    }

    private ItemModelBuilder generated(RegistryObject item) {
        return getBuilder(item.getId().getPath()).parent(getExistingFile(mcLoc("item/generated"))).texture("layer0", "item/" + item.getId().getPath());
    }

    private ItemModelBuilder blockToItemGenerated(RegistryObject block) {
        return getBuilder(block.getId().getPath()).parent(getExistingFile(mcLoc("item/generated"))).texture("layer0", "block/" + block.getId().getPath());
    }

    private ItemModelBuilder fence (RegistryObject fence, RegistryObject planks) {
        return getBuilder(fence.getId().getPath()).parent(getExistingFile(mcLoc("block/fence_inventory"))).texture("texture", "block/" + planks.getId().getPath());
    }

    private void trapdoor (RegistryObject trapdoor) {
        withExistingParent(trapdoor.getId().getPath(), modLoc("block/" + trapdoor.getId().getPath() + "_bottom"));
    }
}
