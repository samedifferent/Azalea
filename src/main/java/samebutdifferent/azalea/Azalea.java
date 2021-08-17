package samebutdifferent.azalea;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
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

        MinecraftForge.EVENT_BUS.register(this);
    }

}
