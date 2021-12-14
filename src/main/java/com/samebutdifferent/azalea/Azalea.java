package com.samebutdifferent.azalea;

import com.google.common.reflect.Reflection;
import com.samebutdifferent.azalea.init.BlocksRegistry;
import com.samebutdifferent.azalea.init.ItemsRegistry;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;

import static com.samebutdifferent.azalea.init.BlocksRegistry.*;

public class Azalea implements ModInitializer {
    public static final String MOD_ID = "betterazalea";



    @Override
    public void onInitialize() {
        StrippableBlockRegistry.register(AZALEA_LOG, STRIPPED_AZALEA_LOG);
        StrippableBlockRegistry.register(FLOWERING_AZALEA_LOG, STRIPPED_AZALEA_LOG);
        Reflection.initialize(
                BlocksRegistry.class,
                ItemsRegistry.class
        );
    }
}
