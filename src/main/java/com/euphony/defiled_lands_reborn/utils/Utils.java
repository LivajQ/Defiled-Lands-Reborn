package com.euphony.defiled_lands_reborn.utils;

import com.euphony.defiled_lands_reborn.DefiledLandsPreborn;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.fml.ModList;

public class Utils {
    public static ResourceLocation prefix(String path) {
        return new ResourceLocation(DefiledLandsPreborn.MOD_ID, path);
    }
    
    public static boolean isModLoaded(String modId) {
        return ModList.get().isLoaded(modId);
    }
}
