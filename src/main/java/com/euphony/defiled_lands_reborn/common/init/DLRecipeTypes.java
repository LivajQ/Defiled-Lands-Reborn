package com.euphony.defiled_lands_reborn.common.init;

import com.euphony.defiled_lands_reborn.DefiledLandsReborn;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class DLRecipeTypes {
    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, DefiledLandsReborn.MOD_ID);
}
