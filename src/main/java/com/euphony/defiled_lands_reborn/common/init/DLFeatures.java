package com.euphony.defiled_lands_reborn.common.init;

import com.euphony.defiled_lands_reborn.DefiledLandsReborn;
import com.euphony.defiled_lands_reborn.common.worldgen.features.AltarFeature;
import com.euphony.defiled_lands_reborn.common.worldgen.features.VilespineConfiguration;
import com.euphony.defiled_lands_reborn.common.worldgen.features.VilespineFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class DLFeatures {
    
    public static final DeferredRegister<Feature<?>> FEATURES =
            DeferredRegister.create(ForgeRegistries.FEATURES, DefiledLandsReborn.MOD_ID);
    
    public static final RegistryObject<Feature<VilespineConfiguration>> VILESPINE =
            FEATURES.register("vilespine", () -> new VilespineFeature(VilespineConfiguration.CODEC));
    
    public static final RegistryObject<Feature<NoneFeatureConfiguration>> ALTAR =
            FEATURES.register("altar", () -> new AltarFeature(NoneFeatureConfiguration.CODEC));
}
