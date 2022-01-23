package samebutdifferent.azalea.event;

import com.google.common.collect.ImmutableMap;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import samebutdifferent.azalea.Azalea;
import samebutdifferent.azalea.block.ModWoodTypes;
import samebutdifferent.azalea.registry.ModBlocks;
import samebutdifferent.azalea.worldgen.ModFeatures;

@Mod.EventBusSubscriber(modid = Azalea.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventHandler {
    @SubscribeEvent
    public static void init(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            AxeItem.STRIPPABLES = new ImmutableMap.Builder<Block, Block>().putAll(AxeItem.STRIPPABLES)
                    .put(ModBlocks.AZALEA_LOG.get(), ModBlocks.STRIPPED_AZALEA_LOG.get())
                    .put(ModBlocks.FLOWERING_AZALEA_LOG.get(), ModBlocks.STRIPPED_AZALEA_LOG.get())
                    .put(ModBlocks.FLOWERING_AZALEA_WOOD.get(), ModBlocks.STRIPPED_AZALEA_WOOD.get())
                    .put(ModBlocks.AZALEA_WOOD.get(), ModBlocks.STRIPPED_AZALEA_WOOD.get()).build();
            ModFeatures.registerAzaleaTree();
            WoodType.register(ModWoodTypes.AZALEA);
            WoodType.register(ModWoodTypes.FLOWERING_AZALEA);
        });
    }
}
