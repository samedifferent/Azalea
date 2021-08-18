package samebutdifferent.azalea.data;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import samebutdifferent.azalea.registry.ModBlocks;

import java.util.function.Consumer;

public class RecipeGenerator extends RecipeProvider {
    public RecipeGenerator(DataGenerator p_125973_) {
        super(p_125973_);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
        woodFromLogs(consumer, ModBlocks.AZALEA_LOG.get(), ModBlocks.AZALEA_WOOD.get());
        woodFromLogs(consumer, ModBlocks.STRIPPED_AZALEA_LOG.get(), ModBlocks.STRIPPED_AZALEA_WOOD.get());
        planksFromLog(consumer, ModBlocks.AZALEA_PLANKS.get(), ModBlocks.AZALEA_LOG.get().asItem());
        planksFromLog(consumer, ModBlocks.FLOWERING_AZALEA_PLANKS.get(), ModBlocks.FLOWERING_AZALEA_LOG.get().asItem());
        slab(consumer, ModBlocks.AZALEA_SLAB.get(), ModBlocks.AZALEA_PLANKS.get());
        stair(consumer, ModBlocks.AZALEA_STAIRS.get(), ModBlocks.AZALEA_PLANKS.get());
        fence(consumer, ModBlocks.AZALEA_FENCE.get(), ModBlocks.AZALEA_PLANKS.get());
        fenceGate(consumer, ModBlocks.AZALEA_FENCE_GATE.get(), ModBlocks.AZALEA_PLANKS.get());
        door(consumer, ModBlocks.AZALEA_DOOR.get(), ModBlocks.AZALEA_PLANKS.get());
        door(consumer, ModBlocks.FLOWERING_AZALEA_DOOR.get(), ModBlocks.FLOWERING_AZALEA_PLANKS.get());
        trapdoor(consumer, ModBlocks.AZALEA_TRAPDOOR.get(), ModBlocks.AZALEA_PLANKS.get());
        button(consumer, ModBlocks.AZALEA_BUTTON.get(), ModBlocks.AZALEA_PLANKS.get());
        pressurePlate(consumer, ModBlocks.AZALEA_PRESSURE_PLATE.get(), ModBlocks.AZALEA_PLANKS.get());
        ShapelessRecipeBuilder.shapeless(ModBlocks.MOSS.get().asItem(), 9).requires(Items.MOSS_BLOCK).unlockedBy("has_moss_block", has(Items.MOSS_BLOCK)).save(consumer);
        ShapedRecipeBuilder.shaped(Blocks.MOSS_BLOCK.asItem()).define('#', ModBlocks.MOSS_LAYER.get().asItem()).pattern("###").pattern("###").pattern("###").unlockedBy("has_moss_layer", has(ModBlocks.MOSS_LAYER.get())).save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.MOSS_LAYER.get().asItem(), 6).define('#', Items.MOSS_BLOCK).pattern("###").unlockedBy("has_moss_block", has(Items.MOSS_BLOCK)).save(consumer);
    }

    private static void planksFromLog(Consumer<FinishedRecipe> consumer, ItemLike planks, Item log) {
        ShapelessRecipeBuilder.shapeless(planks, 4).requires(log).group("planks").unlockedBy("has_log", has(log)).save(consumer);
    }

    private static void woodFromLogs(Consumer<FinishedRecipe> consumer, ItemLike wood, ItemLike log) {
        ShapedRecipeBuilder.shaped(wood, 3).define('#', log).pattern("##").pattern("##").group("bark").unlockedBy("has_log", has(log)).save(consumer);
    }

    private static void button(Consumer<FinishedRecipe> consumer, ItemLike button, ItemLike planks) {
        buttonBuilder(button, Ingredient.of(planks)).unlockedBy(getHasName(planks), has(planks)).save(consumer);
    }

    private static RecipeBuilder buttonBuilder(ItemLike button, Ingredient planks) {
        return ShapelessRecipeBuilder.shapeless(button).requires(planks);
    }

    private static void door(Consumer<FinishedRecipe> consumer, ItemLike door, ItemLike planks) {
        doorBuilder(door, Ingredient.of(planks)).unlockedBy(getHasName(planks), has(planks)).save(consumer);
    }

    private static RecipeBuilder doorBuilder(ItemLike door, Ingredient planks) {
        return ShapedRecipeBuilder.shaped(door, 3).define('#', planks).pattern("##").pattern("##").pattern("##");
    }

    private static void fence(Consumer<FinishedRecipe> consumer, ItemLike fence, ItemLike planks) {
        fenceBuilder(fence, Ingredient.of(planks)).unlockedBy(getHasName(planks), has(planks)).save(consumer);
    }
    
    private static RecipeBuilder fenceBuilder(ItemLike fence, Ingredient planks) {
        return ShapedRecipeBuilder.shaped(fence, 3).define('W', planks).define('#', Items.STICK).pattern("W#W").pattern("W#W");
    }

    private static void fenceGate(Consumer<FinishedRecipe> consumer, ItemLike fenceGate, ItemLike planks) {
        fenceGateBuilder(fenceGate, Ingredient.of(planks)).unlockedBy(getHasName(planks), has(planks)).save(consumer);
    }

    private static RecipeBuilder fenceGateBuilder(ItemLike fenceGate, Ingredient planks) {
        return ShapedRecipeBuilder.shaped(fenceGate).define('#', Items.STICK).define('W', planks).pattern("#W#").pattern("#W#");
    }

    private static void pressurePlate(Consumer<FinishedRecipe> consumer, ItemLike pressurePlate, ItemLike planks) {
        pressurePlateBuilder(pressurePlate, Ingredient.of(planks)).unlockedBy(getHasName(planks), has(planks)).save(consumer);
    }

    private static RecipeBuilder pressurePlateBuilder(ItemLike pressurePlate, Ingredient planks) {
        return ShapedRecipeBuilder.shaped(pressurePlate).define('#', planks).pattern("##");
    }

    private static void slab(Consumer<FinishedRecipe> consumer, ItemLike slab, ItemLike planks) {
        slabBuilder(slab, Ingredient.of(planks)).unlockedBy(getHasName(planks), has(planks)).save(consumer);
    }

    private static RecipeBuilder slabBuilder(ItemLike slab, Ingredient planks) {
        return ShapedRecipeBuilder.shaped(slab, 6).define('#', planks).pattern("###");
    }

    private static void stair(Consumer<FinishedRecipe> consumer, ItemLike stair, ItemLike planks) {
        stairBuilder(stair, Ingredient.of(planks)).unlockedBy(getHasName(planks), has(planks)).save(consumer);
    }
    
    private static RecipeBuilder stairBuilder(ItemLike stairs, Ingredient planks) {
        return ShapedRecipeBuilder.shaped(stairs, 4).define('#', planks).pattern("#  ").pattern("## ").pattern("###");
    }

    private static void trapdoor(Consumer<FinishedRecipe> consumer, ItemLike trapdoor, ItemLike planks) {
        trapdoorBuilder(trapdoor, Ingredient.of(planks)).unlockedBy(getHasName(planks), has(planks)).save(consumer);
    }

    private static RecipeBuilder trapdoorBuilder(ItemLike trapdoor, Ingredient planks) {
        return ShapedRecipeBuilder.shaped(trapdoor, 2).define('#', planks).pattern("###").pattern("###");
    }

    private static String getHasName(ItemLike item) {
        return "has_" + item.asItem().getRegistryName().getPath();
    }
}
