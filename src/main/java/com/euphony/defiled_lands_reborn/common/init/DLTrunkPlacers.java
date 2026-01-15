package com.euphony.defiled_lands_reborn.common.init;

import com.euphony.defiled_lands_reborn.DefiledLandsReborn;
import com.euphony.defiled_lands_reborn.common.worldgen.features.tree.placer.TenebraTrunkPlacer;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class DLTrunkPlacers {
    
    public static final DeferredRegister<TrunkPlacerType<?>> PLACERS =
            DeferredRegister.create(Registries.TRUNK_PLACER_TYPE, DefiledLandsReborn.MOD_ID);
    
    public static final RegistryObject<TrunkPlacerType<TenebraTrunkPlacer>> TENEBRA_TRUNK_PLACER =
            PLACERS.register("tenebra_trunk_placer",
                    () -> new TrunkPlacerType<>(TenebraTrunkPlacer.CODEC));
}
