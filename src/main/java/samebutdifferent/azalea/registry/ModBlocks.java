package samebutdifferent.azalea.registry;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import samebutdifferent.azalea.Azalea;
import samebutdifferent.azalea.block.*;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Azalea.MOD_ID);

    public static final RegistryObject<AzaleaLogBlock> AZALEA_LOG = registerBuildingBlock("azalea_log", AzaleaLogBlock::new);
    public static final RegistryObject<FloweringAzaleaLogBlock> FLOWERING_AZALEA_LOG = registerBuildingBlock("flowering_azalea_log", FloweringAzaleaLogBlock::new);
    public static final RegistryObject<RotatedPillarBlock> STRIPPED_AZALEA_LOG = registerBuildingBlock("stripped_azalea_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final RegistryObject<RotatedPillarBlock> AZALEA_WOOD = registerBuildingBlock("azalea_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));
    public static final RegistryObject<FloweringAzaleaWoodBlock> FLOWERING_AZALEA_WOOD = registerBuildingBlock("flowering_azalea_wood", FloweringAzaleaWoodBlock::new);
    public static final RegistryObject<RotatedPillarBlock> STRIPPED_AZALEA_WOOD = registerBuildingBlock("stripped_azalea_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)));
    public static final RegistryObject<Block> AZALEA_PLANKS = registerBuildingBlock("azalea_planks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<Block> FLOWERING_AZALEA_PLANKS = registerBuildingBlock("flowering_azalea_planks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<SlabBlock> AZALEA_SLAB = registerBuildingBlock("azalea_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<SlabBlock> FLOWERING_AZALEA_SLAB = registerBuildingBlock("flowering_azalea_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<StairBlock> AZALEA_STAIRS = registerBuildingBlock("azalea_stairs", () -> new StairBlock(Blocks.OAK_PLANKS::defaultBlockState, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<StairBlock> FLOWERING_AZALEA_STAIRS = registerBuildingBlock("flowering_azalea_stairs", () -> new StairBlock(Blocks.OAK_PLANKS::defaultBlockState, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<FenceBlock> AZALEA_FENCE = registerBlockToTab("azalea_fence", () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<FenceBlock> FLOWERING_AZALEA_FENCE = registerBlockToTab("flowering_azalea_fence", () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<FenceGateBlock> AZALEA_FENCE_GATE = registerBlockToTab("azalea_fence_gate", () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), CreativeModeTab.TAB_REDSTONE);
    public static final RegistryObject<FenceGateBlock> FLOWERING_AZALEA_FENCE_GATE = registerBlockToTab("flowering_azalea_fence_gate", () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), CreativeModeTab.TAB_REDSTONE);
    public static final RegistryObject<DoorBlock> AZALEA_DOOR = registerBlockToTab("azalea_door", () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR)), CreativeModeTab.TAB_REDSTONE);
    public static final RegistryObject<DoorBlock> FLOWERING_AZALEA_DOOR = registerBlockToTab("flowering_azalea_door", () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR)), CreativeModeTab.TAB_REDSTONE);
    public static final RegistryObject<TrapDoorBlock> AZALEA_TRAPDOOR = registerBlockToTab("azalea_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR)), CreativeModeTab.TAB_REDSTONE);
    public static final RegistryObject<TrapDoorBlock> FLOWERING_AZALEA_TRAPDOOR = registerBlockToTab("flowering_azalea_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR)), CreativeModeTab.TAB_REDSTONE);
    public static final RegistryObject<WoodButtonBlock> AZALEA_BUTTON = registerBlockToTab("azalea_button", () -> new WoodButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON)), CreativeModeTab.TAB_REDSTONE);
    public static final RegistryObject<PressurePlateBlock> AZALEA_PRESSURE_PLATE = registerBlockToTab("azalea_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE)), CreativeModeTab.TAB_REDSTONE);
    public static final RegistryObject<AzaleaFlowerBlock> AZALEA_FLOWER = registerBlockToTab("azalea_flower", AzaleaFlowerBlock::new, CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<SurfaceMossBlock> MOSS = registerBlockToTab("moss", SurfaceMossBlock::new, CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<MossLayerBlock> MOSS_LAYER = registerBlockToTab("moss_layer", MossLayerBlock::new, CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<FlowerPotBlock> POTTED_AZALEA_FLOWER = BLOCKS.register("potted_azalea_flower", () -> new FlowerPotBlock(ModBlocks.AZALEA_FLOWER.get(), BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()));
    public static final RegistryObject<ModStandingSignBlock> AZALEA_SIGN = BLOCKS.register("azalea_sign", () -> new ModStandingSignBlock(BlockBehaviour.Properties.of(Material.WOOD).noCollission().strength(1.0F).sound(SoundType.WOOD), ModWoodTypes.AZALEA));
    public static final RegistryObject<ModWallSignBlock> AZALEA_WALL_SIGN = BLOCKS.register("azalea_wall_sign", () -> new ModWallSignBlock(BlockBehaviour.Properties.of(Material.WOOD).noCollission().strength(1.0F).sound(SoundType.WOOD).dropsLike(AZALEA_SIGN.get()), ModWoodTypes.AZALEA));
    public static final RegistryObject<ModStandingSignBlock> FLOWERING_AZALEA_SIGN = BLOCKS.register("flowering_azalea_sign", () -> new ModStandingSignBlock(BlockBehaviour.Properties.of(Material.WOOD).noCollission().strength(1.0F).sound(SoundType.WOOD), ModWoodTypes.FLOWERING_AZALEA));
    public static final RegistryObject<ModWallSignBlock> FLOWERING_AZALEA_WALL_SIGN = BLOCKS.register("flowering_azalea_wall_sign", () -> new ModWallSignBlock(BlockBehaviour.Properties.of(Material.WOOD).noCollission().strength(1.0F).sound(SoundType.WOOD).dropsLike(FLOWERING_AZALEA_SIGN.get()), ModWoodTypes.FLOWERING_AZALEA));

    private static <T extends Block> RegistryObject<T> registerBuildingBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = ModBlocks.BLOCKS.register(name, block);
        ModItems.ITEMS.register(name, () -> new BlockItem(toReturn.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
        return toReturn;
    }

    private static <T extends Block> RegistryObject<T> registerBlockToTab(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = ModBlocks.BLOCKS.register(name, block);
        ModItems.ITEMS.register(name, () -> new BlockItem(toReturn.get(), new Item.Properties().tab(tab)));
        return toReturn;
    }
}
