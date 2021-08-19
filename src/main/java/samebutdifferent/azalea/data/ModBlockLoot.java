package samebutdifferent.azalea.data;

import net.minecraft.data.loot.BlockLoot;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.fmllegacy.RegistryObject;
import samebutdifferent.azalea.registry.ModBlocks;

public class ModBlockLoot extends BlockLoot {
    @Override
    protected void addTables() {
        for (RegistryObject<Block> block : ModBlocks.BLOCKS.getEntries()) {
            dropSelf(block.get());
        }
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
