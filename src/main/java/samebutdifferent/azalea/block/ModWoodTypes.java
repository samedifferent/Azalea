package samebutdifferent.azalea.block;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.properties.WoodType;
import samebutdifferent.azalea.Azalea;

public class ModWoodTypes {
    public static final WoodType AZALEA = WoodType.create(new ResourceLocation(Azalea.MOD_ID, "azalea").toString());
    public static final WoodType FLOWERING_AZALEA = WoodType.create(new ResourceLocation(Azalea.MOD_ID, "flowering_azalea").toString());
}
