package samebutdifferent.azalea;

import com.google.common.collect.ImmutableMap;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import samebutdifferent.azalea.registry.ModBlocks;
import samebutdifferent.azalea.registry.ModItems;

@Mod(Azalea.MOD_ID)
public class Azalea
{
    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "azalea";

    public Azalea() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        ModBlocks.BLOCKS.register(bus);
        ModItems.ITEMS.register(bus);

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        AxeItem.STRIPPABLES = new ImmutableMap.Builder<Block, Block>().putAll(AxeItem.STRIPPABLES)
                .put(ModBlocks.AZALEA_LOG.get(), ModBlocks.STRIPPED_AZALEA_LOG.get())
                .put(ModBlocks.FLOWERING_AZALEA_LOG.get(), ModBlocks.STRIPPED_AZALEA_LOG.get())
                .put(ModBlocks.AZALEA_WOOD.get(), ModBlocks.STRIPPED_AZALEA_WOOD.get()).build();
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.AZALEA_FLOWER.get(), RenderType.cutout());
    }
}
