package com.euphony.defiled_lands_reborn.datagen;

import com.euphony.defiled_lands_reborn.common.init.DLBlocks;
import com.euphony.defiled_lands_reborn.common.init.DLItems;
import com.euphony.defiled_lands_reborn.utils.Utils;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;

import java.util.function.Consumer;

public class RecipeGenerator extends RecipeProvider {
    
    public RecipeGenerator(PackOutput output) {
        super(output);
    }
    
    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> writer) {
        addDecorationRecipes(writer);
        addDecorationStoneCuttingRecipes(writer);
        addDecorationSmeltingRecipes(writer);
        addToolRecipes(writer);
        addEquipmentRecipes(writer);
        addMiscRecipes(writer);
        addSmeltingRecipes(writer);
        
        DLBlockFamilies.getAllFamilies().forEach(family -> generateRecipes(writer, family));
    }
    
    private void addDecorationRecipes(Consumer<FinishedRecipe> writer) {
        
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, DLBlocks.DEFILED_SANDSTONE.get())
                .pattern("##")
                .pattern("##")
                .define('#', DLBlocks.DEFILED_SAND.get().asItem())
                .unlockedBy("has_item", has(DLBlocks.DEFILED_SAND.get()))
                .save(writer);
        
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, DLBlocks.TENEBRA_PLANKS.get(), 4)
                .requires(DLBlocks.TENEBRA_LOG.get())
                .unlockedBy("has_item", has(DLBlocks.TENEBRA_LOG.get()))
                .save(writer);
        
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, DLBlocks.HEPHAESTITE_BLOCK.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', DLItems.HEPHAESTITE_SHARD.get())
                .unlockedBy("has_item", has(DLItems.HEPHAESTITE_SHARD.get()))
                .save(writer);
        
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, DLBlocks.UMBRIUM_BLOCK.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', DLItems.UMBRIUM_INGOT.get())
                .unlockedBy("has_item", has(DLItems.UMBRIUM_INGOT.get()))
                .save(writer);
        
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, DLBlocks.SCARLITE_BLOCK.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', DLItems.SCARLITE.get())
                .unlockedBy("has_item", has(DLItems.SCARLITE.get()))
                .save(writer);
        
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, DLBlocks.RAVAGING_STONE.get())
                .pattern("###")
                .pattern("#X#")
                .pattern("#X#")
                .define('#', DLBlocks.DEFILED_STONE.get())
                .define('X', DLItems.RAVAGING_ESSENCE.get())
                .unlockedBy("has_stone", has(DLBlocks.DEFILED_STONE.get()))
                .unlockedBy("has_essence", has(DLItems.RAVAGING_ESSENCE.get()))
                .save(writer);
        
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, DLBlocks.RAVAGING_BRICKS.get())
                .pattern("###")
                .pattern("#X#")
                .pattern("###")
                .define('#', Blocks.BRICKS)
                .define('X', DLItems.RAVAGING_ESSENCE.get())
                .unlockedBy("has_bricks", has(Blocks.BRICKS))
                .unlockedBy("has_essence", has(DLItems.RAVAGING_ESSENCE.get()))
                .save(writer);
        
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, DLBlocks.DEFILED_STONE_BRICKS.get())
                .pattern("##")
                .pattern("##")
                .define('#', DLBlocks.DEFILED_STONE.get())
                .unlockedBy("has_item", has(DLBlocks.DEFILED_STONE.get()))
                .save(writer);
        
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, DLBlocks.DEFILED_MOSSY_STONE.get())
                .requires(DLBlocks.DEFILED_STONE.get())
                .requires(Blocks.MOSS_BLOCK)
                .unlockedBy("has_stone", has(DLBlocks.DEFILED_STONE.get()))
                .unlockedBy("has_moss", has(Blocks.MOSS_BLOCK))
                .save(writer, createKey("defiled_mossy_stone_from_moss"));
        
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, DLBlocks.DEFILED_MOSSY_STONE.get())
                .requires(DLBlocks.DEFILED_STONE.get())
                .requires(Blocks.VINE)
                .unlockedBy("has_stone", has(DLBlocks.DEFILED_STONE.get()))
                .unlockedBy("has_vine", has(Blocks.VINE))
                .save(writer, createKey("defiled_mossy_stone_from_vine"));
        
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, DLBlocks.DEFILED_MOSSY_STONE_BRICKS.get())
                .pattern("##")
                .pattern("##")
                .define('#', DLBlocks.DEFILED_MOSSY_STONE.get())
                .unlockedBy("has_item", has(DLBlocks.DEFILED_MOSSY_STONE.get()))
                .save(writer);
    }
    
    private void addDecorationStoneCuttingRecipes(Consumer<FinishedRecipe> writer) {
        
        SingleItemRecipeBuilder.stonecutting(
                        Ingredient.of(DLBlocks.DEFILED_STONE.get()),
                        RecipeCategory.BUILDING_BLOCKS,
                        DLBlocks.DEFILED_STONE_BRICKS.get(),
                        1)
                .unlockedBy("has_item", has(DLBlocks.DEFILED_STONE.get()))
                .save(writer, createKey("defiled_stone_bricks_from_stonecutting"));
        
        SingleItemRecipeBuilder.stonecutting(
                        Ingredient.of(DLBlocks.DEFILED_MOSSY_STONE.get()),
                        RecipeCategory.BUILDING_BLOCKS,
                        DLBlocks.DEFILED_MOSSY_STONE_BRICKS.get(),
                        1)
                .unlockedBy("has_item", has(DLBlocks.DEFILED_MOSSY_STONE.get()))
                .save(writer, createKey("defiled_mossy_stone_bricks_from_stonecutting"));
        
        SingleItemRecipeBuilder.stonecutting(
                        Ingredient.of(DLBlocks.DEFILED_STONE.get()),
                        RecipeCategory.BUILDING_BLOCKS,
                        DLBlocks.DEFILED_STONE_SLAB.get(),
                        2)
                .unlockedBy("has_item", has(DLBlocks.DEFILED_STONE.get()))
                .save(writer, createKey("defiled_stone_slab_from_stonecutting"));
        
        SingleItemRecipeBuilder.stonecutting(
                        Ingredient.of(DLBlocks.DEFILED_STONE.get()),
                        RecipeCategory.BUILDING_BLOCKS,
                        DLBlocks.DEFILED_STONE_STAIRS.get(),
                        1)
                .unlockedBy("has_item", has(DLBlocks.DEFILED_STONE.get()))
                .save(writer, createKey("defiled_stone_stairs_from_stonecutting"));
        
        SingleItemRecipeBuilder.stonecutting(
                        Ingredient.of(DLBlocks.DEFILED_SANDSTONE.get()),
                        RecipeCategory.BUILDING_BLOCKS,
                        DLBlocks.DEFILED_SANDSTONE_SLAB.get(),
                        2)
                .unlockedBy("has_item", has(DLBlocks.DEFILED_SANDSTONE.get()))
                .save(writer, createKey("defiled_sandstone_slab_from_stonecutting"));
        
        SingleItemRecipeBuilder.stonecutting(
                        Ingredient.of(DLBlocks.DEFILED_SANDSTONE.get()),
                        RecipeCategory.BUILDING_BLOCKS,
                        DLBlocks.DEFILED_SANDSTONE_STAIRS.get(),
                        1)
                .unlockedBy("has_item", has(DLBlocks.DEFILED_SANDSTONE.get()))
                .save(writer, createKey("defiled_sandstone_stairs_from_stonecutting"));
        
        SingleItemRecipeBuilder.stonecutting(
                        Ingredient.of(DLBlocks.DEFILED_STONE_BRICKS.get()),
                        RecipeCategory.BUILDING_BLOCKS,
                        DLBlocks.DEFILED_STONE_BRICK_SLAB.get(),
                        2)
                .unlockedBy("has_item", has(DLBlocks.DEFILED_STONE_BRICKS.get()))
                .save(writer, createKey("defiled_stone_brick_slab_from_stonecutting"));
        
        SingleItemRecipeBuilder.stonecutting(
                        Ingredient.of(DLBlocks.DEFILED_STONE_BRICKS.get()),
                        RecipeCategory.BUILDING_BLOCKS,
                        DLBlocks.DEFILED_STONE_BRICK_STAIRS.get(),
                        1)
                .unlockedBy("has_item", has(DLBlocks.DEFILED_STONE_BRICKS.get()))
                .save(writer, createKey("defiled_stone_brick_stairs_from_stonecutting"));
    }
    
    private void addDecorationSmeltingRecipes(Consumer<FinishedRecipe> writer) {
        
        SimpleCookingRecipeBuilder.smelting(
                        Ingredient.of(DLBlocks.DEFILED_STONE_BRICKS.get()),
                        RecipeCategory.BUILDING_BLOCKS,
                        DLBlocks.DEFILED_CRACKED_STONE_BRICKS.get(),
                        0.1f,
                        200)
                .unlockedBy("has_item", has(DLBlocks.DEFILED_STONE_BRICKS.get()))
                .save(writer);
    }
    
    private void addToolRecipes(Consumer<FinishedRecipe> writer) {
        
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, DLItems.UMBRIUM_AXE.get())
                .pattern("## ")
                .pattern("#S ")
                .pattern(" S ")
                .define('#', DLItems.UMBRIUM_INGOT.get())
                .define('S', Items.STICK)
                .unlockedBy("has_umbrium", has(DLItems.UMBRIUM_INGOT.get()))
                .unlockedBy("has_stick", has(Items.STICK))
                .save(writer);
        
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, DLItems.UMBRIUM_PICKAXE.get())
                .pattern("###")
                .pattern(" S ")
                .pattern(" S ")
                .define('#', DLItems.UMBRIUM_INGOT.get())
                .define('S', Items.STICK)
                .unlockedBy("has_umbrium", has(DLItems.UMBRIUM_INGOT.get()))
                .unlockedBy("has_stick", has(Items.STICK))
                .save(writer);
        
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, DLItems.UMBRIUM_SHOVEL.get())
                .pattern("#")
                .pattern("S")
                .pattern("S")
                .define('#', DLItems.UMBRIUM_INGOT.get())
                .define('S', Items.STICK)
                .unlockedBy("has_umbrium", has(DLItems.UMBRIUM_INGOT.get()))
                .unlockedBy("has_stick", has(Items.STICK))
                .save(writer);
        
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, DLItems.UMBRIUM_SWORD.get())
                .pattern("#")
                .pattern("#")
                .pattern("S")
                .define('#', DLItems.UMBRIUM_INGOT.get())
                .define('S', Items.STICK)
                .unlockedBy("has_umbrium", has(DLItems.UMBRIUM_INGOT.get()))
                .unlockedBy("has_stick", has(Items.STICK))
                .save(writer);
        
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, DLItems.UMBRIUM_HOE.get())
                .pattern("##")
                .pattern(" S")
                .pattern(" S")
                .define('#', DLItems.UMBRIUM_INGOT.get())
                .define('S', Items.STICK)
                .unlockedBy("has_umbrium", has(DLItems.UMBRIUM_INGOT.get()))
                .unlockedBy("has_stick", has(Items.STICK))
                .save(writer);
        
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, DLItems.RAVAGING_AXE.get())
                .pattern("## ")
                .pattern("#S ")
                .pattern(" S ")
                .define('#', DLItems.RAVAGING_INGOT.get())
                .define('S', Items.STICK)
                .unlockedBy("has_ravaging", has(DLItems.RAVAGING_INGOT.get()))
                .unlockedBy("has_stick", has(Items.STICK))
                .save(writer);
        
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, DLItems.RAVAGING_PICKAXE.get())
                .pattern("###")
                .pattern(" S ")
                .pattern(" S ")
                .define('#', DLItems.RAVAGING_INGOT.get())
                .define('S', Items.STICK)
                .unlockedBy("has_ravaging", has(DLItems.RAVAGING_INGOT.get()))
                .unlockedBy("has_stick", has(Items.STICK))
                .save(writer);
        
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, DLItems.RAVAGING_SHOVEL.get())
                .pattern("#")
                .pattern("S")
                .pattern("S")
                .define('#', DLItems.RAVAGING_INGOT.get())
                .define('S', Items.STICK)
                .unlockedBy("has_ravaging", has(DLItems.RAVAGING_INGOT.get()))
                .unlockedBy("has_stick", has(Items.STICK))
                .save(writer);
        
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, DLItems.SCARLITE_RAZOR.get())
                .pattern("# ")
                .pattern("#S")
                .pattern(" X")
                .define('#', DLItems.UMBRIUM_INGOT.get())
                .define('S', DLItems.BLACK_HEART.get())
                .define('X', DLItems.SCARLITE.get())
                .unlockedBy("has_umbrium", has(DLItems.UMBRIUM_INGOT.get()))
                .unlockedBy("has_scarlite", has(DLItems.SCARLITE.get()))
                .unlockedBy("has_heart", has(DLItems.BLACK_HEART.get()))
                .save(writer);
        
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, DLItems.SCARLITE_REAVER.get())
                .pattern("X  ")
                .pattern("XSX")
                .pattern(" # ")
                .define('#', DLItems.UMBRIUM_INGOT.get())
                .define('S', DLItems.BLACK_HEART.get())
                .define('X', DLItems.SCARLITE.get())
                .unlockedBy("has_umbrium", has(DLItems.UMBRIUM_INGOT.get()))
                .unlockedBy("has_scarlite", has(DLItems.SCARLITE.get()))
                .unlockedBy("has_heart", has(DLItems.BLACK_HEART.get()))
                .save(writer);
    }
    
    private void addEquipmentRecipes(Consumer<FinishedRecipe> writer) {

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, DLItems.UMBRIUM_HELMET.get())
                .pattern("###")
                .pattern("# #")
                .define('#', DLItems.UMBRIUM_INGOT.get())
                .unlockedBy("has_item", has(DLItems.UMBRIUM_INGOT.get()))
                .save(writer);
        
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, DLItems.UMBRIUM_CHESTPLATE.get())
                .pattern("# #")
                .pattern("###")
                .pattern("###")
                .define('#', DLItems.UMBRIUM_INGOT.get())
                .unlockedBy("has_item", has(DLItems.UMBRIUM_INGOT.get()))
                .save(writer);
        
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, DLItems.UMBRIUM_LEGGINGS.get())
                .pattern("###")
                .pattern("# #")
                .pattern("# #")
                .define('#', DLItems.UMBRIUM_INGOT.get())
                .unlockedBy("has_item", has(DLItems.UMBRIUM_INGOT.get()))
                .save(writer);
        
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, DLItems.UMBRIUM_BOOTS.get())
                .pattern("# #")
                .pattern("# #")
                .define('#', DLItems.UMBRIUM_INGOT.get())
                .unlockedBy("has_item", has(DLItems.UMBRIUM_INGOT.get()))
                .save(writer);
        
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, DLItems.BOOK_WYRM_SCALE_HELMET.get())
                .pattern("###")
                .pattern("# #")
                .define('#', DLItems.BOOK_WYRM_SCALE.get())
                .unlockedBy("has_item", has(DLItems.BOOK_WYRM_SCALE.get()))
                .save(writer);
        
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, DLItems.BOOK_WYRM_SCALE_CHESTPLATE.get())
                .pattern("# #")
                .pattern("###")
                .pattern("###")
                .define('#', DLItems.BOOK_WYRM_SCALE.get())
                .unlockedBy("has_item", has(DLItems.BOOK_WYRM_SCALE.get()))
                .save(writer);
        
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, DLItems.BOOK_WYRM_SCALE_LEGGINGS.get())
                .pattern("###")
                .pattern("# #")
                .pattern("# #")
                .define('#', DLItems.BOOK_WYRM_SCALE.get())
                .unlockedBy("has_item", has(DLItems.BOOK_WYRM_SCALE.get()))
                .save(writer);
        
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, DLItems.BOOK_WYRM_SCALE_BOOTS.get())
                .pattern("# #")
                .pattern("# #")
                .define('#', DLItems.BOOK_WYRM_SCALE.get())
                .unlockedBy("has_item", has(DLItems.BOOK_WYRM_SCALE.get()))
                .save(writer);
        
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, DLItems.GOLDEN_BOOK_WYRM_SCALE_HELMET.get())
                .pattern("###")
                .pattern("# #")
                .define('#', DLItems.GOLDEN_BOOK_WYRM_SCALE.get())
                .unlockedBy("has_item", has(DLItems.GOLDEN_BOOK_WYRM_SCALE.get()))
                .save(writer);
        
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, DLItems.GOLDEN_BOOK_WYRM_SCALE_CHESTPLATE.get())
                .pattern("# #")
                .pattern("###")
                .pattern("###")
                .define('#', DLItems.GOLDEN_BOOK_WYRM_SCALE.get())
                .unlockedBy("has_item", has(DLItems.GOLDEN_BOOK_WYRM_SCALE.get()))
                .save(writer);
        
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, DLItems.GOLDEN_BOOK_WYRM_SCALE_LEGGINGS.get())
                .pattern("###")
                .pattern("# #")
                .pattern("# #")
                .define('#', DLItems.GOLDEN_BOOK_WYRM_SCALE.get())
                .unlockedBy("has_item", has(DLItems.GOLDEN_BOOK_WYRM_SCALE.get()))
                .save(writer);
        
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, DLItems.GOLDEN_BOOK_WYRM_SCALE_BOOTS.get())
                .pattern("# #")
                .pattern("# #")
                .define('#', DLItems.GOLDEN_BOOK_WYRM_SCALE.get())
                .unlockedBy("has_item", has(DLItems.GOLDEN_BOOK_WYRM_SCALE.get()))
                .save(writer);
    }
    
    private void addMiscRecipes(Consumer<FinishedRecipe> writer) {
        
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, DLItems.HEPHAESTITE_SHARD.get(), 9)
                .requires(DLBlocks.HEPHAESTITE_BLOCK.get())
                .unlockedBy("has_item", has(DLBlocks.HEPHAESTITE_BLOCK.get()))
                .save(writer, createKey("hephaestite_shard_from_block"));
        
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, DLItems.UMBRIUM_INGOT.get(), 9)
                .requires(DLBlocks.UMBRIUM_BLOCK.get())
                .unlockedBy("has_item", has(DLBlocks.UMBRIUM_BLOCK.get()))
                .save(writer, createKey("umrium_ingot_from_block"));
        
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, DLItems.SCARLITE.get(), 9)
                .requires(DLBlocks.SCARLITE_BLOCK.get())
                .unlockedBy("has_item", has(DLBlocks.SCARLITE_BLOCK.get()))
                .save(writer, createKey("scarlite_from_block"));
        
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, DLItems.UMBRIUM_NUGGET.get(), 9)
                .requires(DLItems.UMBRIUM_INGOT.get())
                .unlockedBy("has_item", has(DLItems.UMBRIUM_INGOT.get()))
                .save(writer, createKey("umrium_nugget_from_ingot"));
        
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, DLItems.UMBRIUM_INGOT.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', DLItems.UMBRIUM_NUGGET.get())
                .unlockedBy("has_item", has(DLItems.UMBRIUM_NUGGET.get()))
                .save(writer, createKey("umrium_ingot_from_nugget"));
        
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, DLItems.UMBRA_BLASTER.get())
                .pattern("  S")
                .pattern("##X")
                .pattern("  #")
                .define('#', DLItems.UMBRIUM_INGOT.get())
                .define('S', DLItems.SCUTTLER_EYE.get())
                .define('X', DLBlocks.UMBRIUM_BLOCK.get().asItem())
                .unlockedBy("has_umbrium_ingot", has(DLItems.UMBRIUM_INGOT.get()))
                .unlockedBy("has_umbrium_block", has(DLBlocks.UMBRIUM_BLOCK.get()))
                .unlockedBy("has_eye", has(DLItems.SCUTTLER_EYE.get()))
                .save(writer);
        
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, DLItems.SCARLITE_RING.get())
                .pattern("#X ")
                .pattern("XSX")
                .pattern(" X ")
                .define('#', DLItems.SCARLITE.get())
                .define('X', DLItems.UMBRIUM_INGOT.get())
                .define('S', DLItems.BLACK_HEART.get())
                .unlockedBy("has_scarlite", has(DLItems.SCARLITE.get()))
                .unlockedBy("has_umbrium", has(DLItems.UMBRIUM_INGOT.get()))
                .unlockedBy("has_heart", has(DLItems.BLACK_HEART.get()))
                .save(writer);
        
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, DLItems.PHYTOPROSTASIA_AMULET.get())
                .pattern("###")
                .pattern("X X")
                .pattern("SPS")
                .define('#', Items.STRING)
                .define('X', DLItems.UMBRIUM_INGOT.get())
                .define('S', DLBlocks.VILESPINE.get().asItem())
                .define('P', DLItems.SCUTTLER_EYE.get())
                .unlockedBy("has_string", has(Items.STRING))
                .unlockedBy("has_umbrium", has(DLItems.UMBRIUM_INGOT.get()))
                .unlockedBy("has_vilespine", has(DLBlocks.VILESPINE.get()))
                .unlockedBy("has_eye", has(DLItems.SCUTTLER_EYE.get()))
                .save(writer);
        
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, DLItems.DEFILEMENT_POWDER.get())
                .requires(DLBlocks.SCURONOTTE.get().asItem())
                .unlockedBy("has_item", has(DLBlocks.SCURONOTTE.get()))
                .save(writer);
        
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, DLItems.RAVAGING_INGOT.get())
                .pattern(" # ")
                .pattern("#X#")
                .pattern(" # ")
                .define('#', DLItems.RAVAGING_ESSENCE.get())
                .define('X', DLItems.UMBRIUM_INGOT.get())
                .unlockedBy("has_essence", has(DLItems.RAVAGING_ESSENCE.get()))
                .unlockedBy("has_umbrium", has(DLItems.UMBRIUM_INGOT.get()))
                .save(writer);
        
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, DLItems.REMORSEFUL_GEM.get())
                .pattern(" # ")
                .pattern("#X#")
                .pattern(" # ")
                .define('#', DLItems.REMORSEFUL_ESSENCE.get())
                .define('X', DLItems.SCARLITE.get())
                .unlockedBy("has_essence", has(DLItems.REMORSEFUL_ESSENCE.get()))
                .unlockedBy("has_scarlite", has(DLItems.SCARLITE.get()))
                .save(writer);
        
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, DLBlocks.HEALING_PAD.get())
                .pattern("#X#")
                .pattern("SPS")
                .define('#', DLItems.UMBRIUM_INGOT.get())
                .define('X', DLItems.SCARLITE.get())
                .define('S', DLBlocks.DEFILED_STONE.get())
                .define('P', DLItems.BLACK_HEART.get())
                .unlockedBy("has_umbrium", has(DLItems.UMBRIUM_INGOT.get()))
                .unlockedBy("has_scarlite", has(DLItems.SCARLITE.get()))
                .unlockedBy("has_stone", has(DLBlocks.DEFILED_STONE.get()))
                .unlockedBy("has_heart", has(DLItems.BLACK_HEART.get()))
                .save(writer);
        
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, DLItems.RAVAGING_PELLET.get())
                .pattern(" S ")
                .pattern("SRS")
                .pattern(" S ")
                .define('S', DLBlocks.DEFILED_STONE.get())
                .define('R', DLItems.RAVAGING_INGOT.get())
                .unlockedBy("has_stone", has(DLBlocks.DEFILED_STONE.get()))
                .unlockedBy("has_ravaging", has(DLItems.RAVAGING_INGOT.get()))
                .save(writer);
        
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, DLItems.RAVAGING_PELLET.get())
                .requires(DLItems.RAVAGING_ESSENCE.get())
                .requires(DLItems.UMBRIUM_PELLET.get(), 2)
                .unlockedBy("has_essence", has(DLItems.RAVAGING_ESSENCE.get()))
                .unlockedBy("has_pellet", has(DLItems.UMBRIUM_PELLET.get()))
                .save(writer, createKey("ravaging_pellet_upgrade"));
        
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, DLItems.SPIKED_PELLET.get())
                .pattern("V V")
                .pattern(" S ")
                .pattern("V V")
                .define('V', DLBlocks.VILESPINE.get())
                .define('S', DLItems.UMBRIUM_PELLET.get())
                .unlockedBy("has_vilespine", has(DLBlocks.VILESPINE.get()))
                .unlockedBy("has_pellet", has(DLItems.UMBRIUM_PELLET.get()))
                .save(writer);
        
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, DLItems.UMBRIUM_PELLET.get())
                .pattern(" S ")
                .pattern("SUS")
                .pattern(" S ")
                .define('S', DLBlocks.DEFILED_STONE.get())
                .define('U', DLItems.UMBRIUM_INGOT.get())
                .unlockedBy("has_stone", has(DLBlocks.DEFILED_STONE.get()))
                .unlockedBy("has_umbrium", has(DLItems.UMBRIUM_INGOT.get()))
                .save(writer);
        
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, DLItems.CALLING_STONE.get())
                .pattern("TST")
                .pattern("SHS")
                .pattern("TST")
                .define('T', DLBlocks.DEFILED_STONE.get())
                .define('S', DLItems.SCARLITE.get())
                .define('H', DLItems.BLACK_HEART.get())
                .unlockedBy("has_stone", has(DLBlocks.DEFILED_STONE.get()))
                .unlockedBy("has_scarlite", has(DLItems.SCARLITE.get()))
                .unlockedBy("has_heart", has(DLItems.BLACK_HEART.get()))
                .save(writer);
        
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, DLItems.IDOL_SORROW.get())
                .pattern(" R ")
                .pattern("USU")
                .pattern(" U ")
                .define('R', DLItems.RAVAGING_INGOT.get())
                .define('U', DLItems.UMBRIUM_INGOT.get())
                .define('S', DLItems.SCARLITE.get())
                .unlockedBy("has_ravaging", has(DLItems.RAVAGING_INGOT.get()))
                .unlockedBy("has_umbrium", has(DLItems.UMBRIUM_INGOT.get()))
                .unlockedBy("has_scarlite", has(DLItems.SCARLITE.get()))
                .save(writer);
        
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.ARROW)
                .pattern("V")
                .pattern("S")
                .pattern("F")
                .define('V', DLBlocks.VILESPINE.get())
                .define('S', Items.STICK)
                .define('F', Items.FEATHER)
                .unlockedBy("has_vilespine", has(DLBlocks.VILESPINE.get()))
                .unlockedBy("has_stick", has(Items.STICK))
                .unlockedBy("has_feather", has(Items.FEATHER))
                .save(writer);
        
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.TORCH)
                .pattern("R")
                .pattern("S")
                .define('R', DLItems.HEPHAESTITE_SHARD.get())
                .define('S', Items.STICK)
                .unlockedBy("has_hephaestite", has(DLItems.HEPHAESTITE_SHARD.get()))
                .unlockedBy("has_stick", has(Items.STICK))
                .save(writer);
        
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, DLItems.THE_RAVAGER.get())
                .pattern("  E")
                .pattern("RUC")
                .pattern("  L")
                .define('U', DLItems.UMBRIUM_INGOT.get())
                .define('R', DLItems.RAVAGING_INGOT.get())
                .define('C', DLItems.SCARLITE.get())
                .define('E', DLItems.SCUTTLER_EYE.get())
                .define('L', Items.LEATHER)
                .unlockedBy("has_ravaging", has(DLItems.RAVAGING_INGOT.get()))
                .unlockedBy("has_leather", has(Items.LEATHER))
                .unlockedBy("has_umbrium", has(DLItems.UMBRIUM_INGOT.get()))
                .unlockedBy("has_scarlite", has(DLItems.SCARLITE.get()))
                .unlockedBy("has_eye", has(DLItems.SCUTTLER_EYE.get()))
                .save(writer);
        
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, DLItems.TEARS_FLAME.get())
                .pattern("MRM")
                .pattern(" U ")
                .pattern(" U ")
                .define('M', DLBlocks.HEPHAESTITE_BLOCK.get())
                .define('R', DLItems.REMORSEFUL_GEM.get())
                .define('U', DLItems.UMBRIUM_INGOT.get())
                .unlockedBy("has_hephaestite", has(DLBlocks.HEPHAESTITE_BLOCK.get()))
                .unlockedBy("has_gem", has(DLItems.REMORSEFUL_GEM.get()))
                .unlockedBy("has_umbrium", has(DLItems.UMBRIUM_INGOT.get()))
                .save(writer);
        
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, DLItems.TEARS_SHULKER.get())
                .pattern("MRM")
                .pattern(" U ")
                .pattern(" U ")
                .define('M', Items.SHULKER_SHELL)
                .define('R', DLItems.REMORSEFUL_GEM.get())
                .define('U', DLItems.UMBRIUM_INGOT.get())
                .unlockedBy("has_shell", has(Items.SHULKER_SHELL))
                .unlockedBy("has_gem", has(DLItems.REMORSEFUL_GEM.get()))
                .unlockedBy("has_umbrium", has(DLItems.UMBRIUM_INGOT.get()))
                .save(writer);
        
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, DLItems.CONCUSSION_SMASHER.get())
                .pattern("UEE")
                .pattern("USU")
                .pattern("UUU")
                .define('U', DLItems.UMBRIUM_INGOT.get())
                .define('S', DLItems.SCARLITE.get())
                .define('E', DLItems.SCUTTLER_EYE.get())
                .unlockedBy("has_umbrium", has(DLItems.UMBRIUM_INGOT.get()))
                .unlockedBy("has_scarlite", has(DLItems.SCARLITE.get()))
                .unlockedBy("has_eye", has(DLItems.SCUTTLER_EYE.get()))
                .save(writer);
        
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, DLItems.BOOK_WYRM_ANALYZER.get())
                .pattern("UUU")
                .pattern("UGU")
                .pattern("UEU")
                .define('U', DLItems.UMBRIUM_INGOT.get())
                .define('G', Items.GLASS)
                .define('E', DLItems.SCUTTLER_EYE.get())
                .unlockedBy("has_umbrium", has(DLItems.UMBRIUM_INGOT.get()))
                .unlockedBy("has_glass", has(Items.GLASS))
                .unlockedBy("has_eye", has(DLItems.SCUTTLER_EYE.get()))
                .save(writer);
        
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, DLItems.BLAZING_BLASTEM_FRUIT.get(), 4)
                .requires(DLItems.HEPHAESTITE_SHARD.get())
                .requires(DLItems.BLASTEM_FRUIT.get(), 4)
                .unlockedBy("has_hephaestite", has(DLItems.HEPHAESTITE_SHARD.get()))
                .unlockedBy("has_fruit", has(DLItems.BLASTEM_FRUIT.get()))
                .save(writer);
        
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, DLItems.FOUL_CANDY.get())
                .requires(DLItems.FOUL_SLIME.get())
                .requires(DLItems.DEFILEMENT_POWDER.get())
                .requires(Items.SUGAR)
                .unlockedBy("has_slime", has(DLItems.FOUL_SLIME.get()))
                .unlockedBy("has_powder", has(DLItems.DEFILEMENT_POWDER.get()))
                .unlockedBy("has_sugar", has(Items.SUGAR))
                .save(writer);
    }
    
    private void addSmeltingRecipes(Consumer<FinishedRecipe> writer) {
        
        smeltingAndBlasting(
                DLBlocks.HEPHAESTITE_ORE.get(),
                RecipeCategory.MISC,
                DLItems.HEPHAESTITE_SHARD.get(),
                0.1f, 200,
                "hephaestite_shard",
                writer
        );
        
        smeltingAndBlasting(
                DLBlocks.UMBRIUM_ORE.get(),
                RecipeCategory.MISC,
                DLItems.UMBRIUM_INGOT.get(),
                0.1f, 200,
                "umbrium_ingot",
                writer
        );
        
        smeltingAndBlasting(
                DLBlocks.SCARLITE_ORE.get(),
                RecipeCategory.MISC,
                DLItems.SCARLITE.get(),
                0.1f, 200,
                "scarlite",
                writer
        );
        
        smeltingAndSmoking(
                DLItems.RAW_BOOK_WYRM.get(),
                RecipeCategory.FOOD,
                DLItems.COOKED_BOOK_WYRM.get(),
                0.1f, 200,
                "cooked_book_wyrm",
                writer
        );
    }
    
    public void smeltingAndBlasting(ItemLike ingredient, RecipeCategory category, ItemLike result, float experience, int cookingTime, String name, Consumer<FinishedRecipe> writer) {
        smelting(ingredient, category, result, experience, cookingTime, name, writer);
        blasting(ingredient, category, result, experience, cookingTime / 2, name, writer);
    }
    
    public void smeltingAndSmoking(ItemLike ingredient, RecipeCategory category, ItemLike result, float experience, int cookingTime, String name, Consumer<FinishedRecipe> writer) {
        smelting(ingredient, category, result, experience, cookingTime, name, writer);
        smoking(ingredient, category, result, experience, cookingTime / 2, name, writer);
    }
    
    public void smelting(ItemLike ingredient, RecipeCategory category, ItemLike result, float experience, int cookingTime, String name, Consumer<FinishedRecipe> writer) {
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ingredient), category, result, experience, cookingTime)
                .unlockedBy("has_item", has(ingredient))
                .save(writer, createKey(name + "_smelting"));
    }
    
    public void blasting(ItemLike ingredient, RecipeCategory category, ItemLike result, float experience, int cookingTime, String name, Consumer<FinishedRecipe> writer) {
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(ingredient), category, result, experience, cookingTime)
                .unlockedBy("has_item", has(ingredient))
                .save(writer, createKey(name + "_blasting"));
    }
    
    public void smoking(ItemLike ingredient, RecipeCategory category, ItemLike result, float experience, int cookingTime, String name, Consumer<FinishedRecipe> writer) {
        SimpleCookingRecipeBuilder.smoking(Ingredient.of(ingredient), category, result, experience, cookingTime)
                .unlockedBy("has_item", has(ingredient))
                .save(writer, createKey(name + "_smoking"));
    }
    
    protected ResourceLocation createLocation(String name) {
        return Utils.prefix(name);
    }
    
    private ResourceLocation createKey(String name) {
        return new ResourceLocation("defiled_lands_reborn", name);
    }
}
