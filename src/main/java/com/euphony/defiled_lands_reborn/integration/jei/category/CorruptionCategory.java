package com.euphony.defiled_lands_reborn.integration.jei.category;

import com.euphony.defiled_lands_reborn.DefiledLandsReborn;
import com.euphony.defiled_lands_reborn.common.init.DLItems;
import com.euphony.defiled_lands_reborn.integration.jei.recipe.CorruptionRecipe;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.gui.widgets.IRecipeExtrasBuilder;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;

public class CorruptionCategory implements IRecipeCategory<CorruptionRecipe> {
    
    public static final RecipeType<CorruptionRecipe> CORRUPTION =
            new RecipeType<>(new ResourceLocation(DefiledLandsReborn.MOD_ID, "corruption"), CorruptionRecipe.class);
    
    private final IDrawable icon;
    private final Component localizedName;
    
    public CorruptionCategory(IGuiHelper helper) {
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(DLItems.DEFILEMENT_POWDER.get()));
        this.localizedName = Component.translatable("gui.defiled_lands_reborn.corruption_jei");
    }
    
    @Override
    public RecipeType<CorruptionRecipe> getRecipeType() {
        return CORRUPTION;
    }
    
    @Override
    public Component getTitle() {
        return this.localizedName;
    }
    
    @Override
    public IDrawable getIcon() {
        return this.icon;
    }
    
    @Override
    public int getWidth() {
        return 82;
    }
    
    @Override
    public int getHeight() {
        return 34;
    }
    
    @Override
    public void draw(CorruptionRecipe recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
        IRecipeCategory.super.draw(recipe, recipeSlotsView, guiGraphics, mouseX, mouseY);
    }
    
    @Override
    public void createRecipeExtras(IRecipeExtrasBuilder builder, CorruptionRecipe recipe, IFocusGroup focuses) {
        builder.addRecipeArrow().setPosition(26, 9);
    }
    
    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, CorruptionRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 1, 9)
                .addIngredients(Ingredient.of(recipe.input()));
        
        builder.addSlot(RecipeIngredientRole.OUTPUT, 61, 9)
                .addItemStack(new ItemStack(recipe.output().asItem()));
    }
}
