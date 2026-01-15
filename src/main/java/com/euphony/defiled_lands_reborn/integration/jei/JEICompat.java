package com.euphony.defiled_lands_reborn.integration.jei;

import com.euphony.defiled_lands_reborn.DefiledLandsReborn;
import com.euphony.defiled_lands_reborn.common.init.DLItems;
import com.euphony.defiled_lands_reborn.integration.RecipeViewerMap;
import com.euphony.defiled_lands_reborn.integration.jei.category.CorruptionCategory;
import com.euphony.defiled_lands_reborn.integration.jei.recipe.CorruptionRecipe;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

@JeiPlugin
public class JEICompat implements IModPlugin {
    
    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(
                new ItemStack(DLItems.DEFILEMENT_POWDER.get()),
                CorruptionCategory.CORRUPTION
        );
    }
    
    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(
                new CorruptionCategory(registration.getJeiHelpers().getGuiHelper())
        );
    }
    
    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        registration.addRecipes(
                CorruptionCategory.CORRUPTION,
                RecipeViewerMap.getCorruptionRecipes().stream()
                        .map(info -> new CorruptionRecipe(info.getLeft(), info.getRight()))
                        .toList()
        );
    }
    
    @Override
    public @NotNull ResourceLocation getPluginUid() {
        return new ResourceLocation(DefiledLandsReborn.MOD_ID, "jei_plugin");
    }
}
