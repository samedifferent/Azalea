package samebutdifferent.azalea.registry;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;

@Mod.EventBusSubscriber
public class ModConfig {
    public static ForgeConfigSpec COMMON_CONFIG;

    public static final ForgeConfigSpec.BooleanValue OVERRIDE_VANILLA_TREE;
    public static final ForgeConfigSpec.BooleanValue GENERATE_TREE_NATURALLY;
    public static final ForgeConfigSpec.DoubleValue TREE_SPAWN_CHANCE_MULTIPLIER;

    static {
        ForgeConfigSpec.Builder COMMON_BUILDER = new ForgeConfigSpec.Builder();
        OVERRIDE_VANILLA_TREE = COMMON_BUILDER.comment("Should bonemealing the vanilla Azalea Bush grow the modded Azalea tree instead of the vanilla one?")
                .define("overrideVanillaTree", true);
        GENERATE_TREE_NATURALLY = COMMON_BUILDER.comment("Should the modded azalea tree generate in the world naturally?")
                .define("generateTreeNaturally", true);
        TREE_SPAWN_CHANCE_MULTIPLIER = COMMON_BUILDER.comment("Multiply the chance that azalea trees generate")
                .defineInRange("treeSpawnChanceMultiplier", 1.0, 0.1, 50.0);

        COMMON_CONFIG = COMMON_BUILDER.build();
    }

    @SubscribeEvent
    public static void onLoad(final ModConfigEvent.Loading configEvent) { }

    @SubscribeEvent
    public static void onReload(final ModConfigEvent.Reloading configEvent) { }
}
