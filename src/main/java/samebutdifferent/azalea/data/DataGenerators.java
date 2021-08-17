package samebutdifferent.azalea.data;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;
import samebutdifferent.azalea.Azalea;

@Mod.EventBusSubscriber(modid = Azalea.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
//        generator.addProvider(new BlockstateGenerator(generator, event.getExistingFileHelper()));
//        generator.addProvider(new ItemModelGenerator(generator, event.getExistingFileHelper()));
//        generator.addProvider(new LangGenerator(generator, "en_us"));
        generator.addProvider(new BlockTagGenerator(generator, event.getExistingFileHelper()));
    }
}
