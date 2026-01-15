package com.euphony.defiled_lands_reborn.common.init;

import com.euphony.defiled_lands_reborn.DefiledLandsReborn;
import com.euphony.defiled_lands_reborn.common.worldgen.features.tree.placer.TenebraFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class DLFoliagePlacers {
    
    public static final DeferredRegister<FoliagePlacerType<?>> PLACERS =
            DeferredRegister.create(ForgeRegistries.FOLIAGE_PLACER_TYPES, DefiledLandsReborn.MOD_ID);
    
    public static final RegistryObject<FoliagePlacerType<TenebraFoliagePlacer>> TENEBRA_FOLIAGE_PLACER =
            PLACERS.register("tenebra_foliage_placer",
                    () -> new FoliagePlacerType<>(TenebraFoliagePlacer.CODEC));
}
