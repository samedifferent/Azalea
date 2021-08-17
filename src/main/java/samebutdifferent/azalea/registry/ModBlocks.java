package samebutdifferent.azalea.registry;

import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import samebutdifferent.azalea.Azalea;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Azalea.MOD_ID);

    public static final RegistryObject<RotatedPillarBlock> AZALEA_LOG = registerBlock("azalea_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
    public static final RegistryObject<RotatedPillarBlock> STRIPPED_AZALEA_LOG = registerBlock("stripped_azalea_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final RegistryObject<RotatedPillarBlock> FLOWERING_AZALEA_LOG = registerBlock("flowering_azalea_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
    public static final RegistryObject<RotatedPillarBlock> AZALEA_WOOD = registerBlock("azalea_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));
    public static final RegistryObject<RotatedPillarBlock> STRIPPED_AZALEA_WOOD = registerBlock("stripped_azalea_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)));
    public static final RegistryObject<Block> AZALEA_PLANKS = registerBlock("azalea_planks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<Block> FLOWERING_AZALEA_PLANKS = registerBlock("flowering_azalea_planks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<SlabBlock> AZALEA_SLAB = registerBlock("azalea_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<StairBlock> AZALEA_STAIRS = registerBlock("azalea_stairs", () -> new StairBlock(Blocks.OAK_PLANKS::defaultBlockState, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<FenceBlock> AZALEA_FENCE = registerBlock("azalea_fence", () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<FenceGateBlock> AZALEA_FENCE_GATE = registerBlock("azalea_fence_gate", () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<DoorBlock> AZALEA_DOOR = registerBlock("azalea_door", () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR)));
    public static final RegistryObject<TrapDoorBlock> AZALEA_TRAPDOOR = registerBlock("azalea_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR)));
    public static final RegistryObject<WoodButtonBlock> AZALEA_BUTTON = registerBlock("azalea_button", () -> new WoodButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON)));
    public static final RegistryObject<PressurePlateBlock> AZALEA_PRESSURE_PLATE = registerBlock("azalea_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE)));
    public static final RegistryObject<FlowerBlock> AZALEA_FLOWER = registerBlock("azalea_flower", () -> new FlowerBlock(MobEffects.DIG_SPEED, 4, BlockBehaviour.Properties.copy(Blocks.AZURE_BLUET)));
    //    public static final RegistryObject<SaplingBlock> AZALEA_SAPLING = registerBlock("azalea_sapling", () -> new SaplingBlock(new AzaleaTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = ModBlocks.BLOCKS.register(name, block);
        ModItems.ITEMS.register(name, () -> new BlockItem(toReturn.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
        return toReturn;
    }
}
