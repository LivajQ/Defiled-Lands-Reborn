package com.euphony.defiled_lands_reborn.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class CommonConfig {
    
    public static class Corruption {
        public ForgeConfigSpec.BooleanValue enableCorruptionSpread;
        public ForgeConfigSpec.BooleanValue confinedSpread;
    }
    
    public static class Bookwyrm {
        public ForgeConfigSpec.IntValue bookWyrmMaxEnchantingLevel;
        public ForgeConfigSpec.DoubleValue goldenBookWyrmProbabilityForZeroGolden;
        public ForgeConfigSpec.DoubleValue goldenBookWyrmProbabilityForOneGolden;
        public ForgeConfigSpec.DoubleValue goldenBookWyrmProbabilityForTwoGolden;
    }
    
    public static class Biome {
        public ForgeConfigSpec.BooleanValue canGenerateDefiledPlains;
        public ForgeConfigSpec.BooleanValue canGenerateDefiledDesert;
        public ForgeConfigSpec.BooleanValue canGenerateDefiledHills;
        public ForgeConfigSpec.BooleanValue canGenerateDefiledSnowyPlains;
        public ForgeConfigSpec.BooleanValue canGenerateTenebraForest;
        public ForgeConfigSpec.BooleanValue canGenerateVilespineForest;
    }
    
    public final Corruption corruption = new Corruption();
    public final Bookwyrm bookwyrm = new Bookwyrm();
    public final Biome biome = new Biome();
    
    CommonConfig(final ForgeConfigSpec.Builder builder) {
        builder.push("Corruption");
        
        corruption.enableCorruptionSpread = builder.comment("Enable Corruption Spread").define("enable_corruption_spread", true);
        corruption.confinedSpread = builder.comment("Biomes cannot expand and only corrupt blocks inside said biomes").define("confined_spread", true);
        
        builder.pop();
        
        builder.push("Bookwyrms");
        
        bookwyrm.goldenBookWyrmProbabilityForZeroGolden = builder.comment("The probability for two normal book wyrms to produce a golden book wyrm").defineInRange("golden_book_wyrm_probability_for_zero_golden", 0.01, 0.0, 1.0);
        bookwyrm.goldenBookWyrmProbabilityForOneGolden = builder.comment("The probability for one golden book wyrm and one normal book wyrm to produce a golden book wyrm").defineInRange("golden_book_wyrm_probability_for_one_golden", 0.04, 0.0, 1.0);
        bookwyrm.goldenBookWyrmProbabilityForTwoGolden = builder.comment("The probability for two golden book wyrms to produce a golden book wyrm").defineInRange("golden_book_wyrm_probability_for_two_golden", 0.1, 0.0, 1.0);
        bookwyrm.bookWyrmMaxEnchantingLevel = builder.comment("Maximum enchanting level for Book Wyrm").defineInRange("book_wyrm_max_enchanting_level", 30, 10, 100);
        
        builder.pop();
        
        builder.push("Biomes");
        builder.comment("Which biomes are allowed to generate in the world");
        
        biome.canGenerateDefiledPlains = builder.define("defiled_plains", true);
        biome.canGenerateDefiledDesert = builder.define("defiled_desert", true);
        biome.canGenerateDefiledHills = builder.define("defiled_hills", true);
        biome.canGenerateDefiledSnowyPlains = builder.define("defiled_snowy_plains", true);
        biome.canGenerateTenebraForest = builder.define("tenebra_forest", true);
        biome.canGenerateVilespineForest = builder.define("vilespine_forest", true);
        
        builder.pop();
    }
}
