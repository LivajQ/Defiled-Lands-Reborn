package com.euphony.defiled_lands_reborn.config;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

public class ConfigHolder {
    public static CommonConfig common;
    
    private static ForgeConfigSpec configCommonSpec;
    
    public static void init(ModLoadingContext context, IEventBus modBus) {
        final Pair<CommonConfig, ForgeConfigSpec> specPair =
                new ForgeConfigSpec.Builder().configure(CommonConfig::new);
        
        common = specPair.getLeft();
        configCommonSpec = specPair.getRight();
        
        context.registerConfig(ModConfig.Type.COMMON, configCommonSpec);
    }
}
