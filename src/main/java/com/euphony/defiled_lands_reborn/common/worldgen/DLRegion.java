package com.euphony.defiled_lands_reborn.common.worldgen;

import com.euphony.defiled_lands_reborn.utils.Utils;
import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.Climate;
import net.minecraftforge.fml.ModList;
import terrablender.api.ParameterUtils;
import terrablender.api.Region;
import terrablender.api.RegionType;
import terrablender.api.VanillaParameterOverlayBuilder;

import java.util.function.Consumer;

public class DLRegion extends Region {
    public static final ResourceLocation LOCATION = Utils.prefix("overworld");

    public DLRegion() {
        super(LOCATION, RegionType.OVERWORLD, 1);
    }

    @Override
    public void addBiomes(Registry<Biome> registry, Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper) {
        /*
        VanillaParameterOverlayBuilder builder = new VanillaParameterOverlayBuilder();
        ParameterPointListBuilder lowMountain = new ParameterPointListBuilder()
                .humidity(Humidity.HUMID)
                .continentalness(Continentalness.COAST, Continentalness.INLAND)
                .erosion(Erosion.FULL_RANGE)
                .depth(Depth.SURFACE, Depth.FLOOR)
                .weirdness(Climate.Parameter.span(-1f, -0.05f), Climate.Parameter.span(0.05f, 1f));

        lowMountain.temperature(Temperature.NEUTRAL, Temperature.WARM)
                .build().forEach(point -> builder.add(point, DLBiomes.DEFILED_PLAINS));
        lowMountain.temperature(Temperature.HOT)
                .build().forEach(point -> builder.add(point, DLBiomes.DEFILED_DESERT));
        lowMountain.temperature(Temperature.span(Temperature.COOL, Temperature.WARM))
                .build().forEach(point -> {
                    builder.add(point, DLBiomes.TENEBRA_FOREST);
                    builder.add(point, DLBiomes.VILESPINE_FOREST);
                });
        lowMountain.temperature(Temperature.FROZEN)
                .build().forEach(point -> builder.add(point, DLBiomes.DEFILED_SNOWY_PLAINS));

        ParameterPointListBuilder windswept = new ParameterPointListBuilder()
                .humidity(Humidity.span(Humidity.ARID, Humidity.NEUTRAL))
                .continentalness(Continentalness.MID_INLAND, Continentalness.FAR_INLAND)
                .erosion(Erosion.EROSION_5)
                .depth(Depth.SURFACE, Depth.FLOOR)
                .weirdness(Weirdness.MID_SLICE_NORMAL_ASCENDING, Weirdness.MID_SLICE_NORMAL_DESCENDING,
                        Weirdness.HIGH_SLICE_NORMAL_ASCENDING, Weirdness.HIGH_SLICE_NORMAL_DESCENDING);
        windswept.temperature(Temperature.span(Temperature.FROZEN, Temperature.NEUTRAL))
                .build().forEach(point -> builder.add(point, DLBiomes.DEFILED_HILLS));

        builder.build().forEach(mapper);
       
         */
        
        if (ModList.get().isLoaded("arcanetweaks")) {
            VanillaParameterOverlayBuilder builder = new VanillaParameterOverlayBuilder();
            
            ParameterUtils.ParameterPointListBuilder stupidBig = new ParameterUtils.ParameterPointListBuilder()
                    .temperature(Climate.Parameter.span(-1.0F, 1.0F))
                    .humidity(Climate.Parameter.span(-1.0F, 1.0F))
                    .continentalness(Climate.Parameter.span(-1.0F, 1.0F))
                    .erosion(Climate.Parameter.span(-1.0F, 1.0F))
                    .depth(Climate.Parameter.span(-1.0F, 1.0F))
                    .weirdness(Climate.Parameter.span(-1.0F, 1.0F));
            
            stupidBig.build().forEach(p ->
                    builder.add(p, DLBiomes.DEFILED_PLAINS)
            );
            
            builder.build().forEach(mapper);
        }
        else {
            this.addModifiedVanillaOverworldBiomes(mapper, builder -> {
                this.addBiomeSimilar(mapper, Biomes.PLAINS, DLBiomes.DEFILED_PLAINS);
                this.addBiomeSimilar(mapper, Biomes.DESERT, DLBiomes.DEFILED_DESERT);
                this.addBiomeSimilar(mapper, Biomes.WINDSWEPT_HILLS, DLBiomes.DEFILED_HILLS);
                this.addBiomeSimilar(mapper, Biomes.SNOWY_PLAINS, DLBiomes.DEFILED_SNOWY_PLAINS);
                this.addBiomeSimilar(mapper, Biomes.BIRCH_FOREST, DLBiomes.TENEBRA_FOREST);
                this.addBiomeSimilar(mapper, Biomes.DARK_FOREST, DLBiomes.VILESPINE_FOREST);
            });
        }
    }
}