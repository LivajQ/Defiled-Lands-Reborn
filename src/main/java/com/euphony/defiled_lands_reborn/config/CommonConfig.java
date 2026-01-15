package com.euphony.defiled_lands_reborn.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class CommonConfig {
    
    public static class General {
        public ForgeConfigSpec.BooleanValue enableCorruptionSpread;
    }
    
    public static class Entity {
        public ForgeConfigSpec.IntValue bookWyrmMaxEnchantingLevel;
        public ForgeConfigSpec.DoubleValue goldenBookWyrmProbabilityForZeroGolden;
        public ForgeConfigSpec.DoubleValue goldenBookWyrmProbabilityForOneGolden;
        public ForgeConfigSpec.DoubleValue goldenBookWyrmProbabilityForTwoGolden;
    }
    
    public final General general = new General();
    public final Entity entity = new Entity();
    
    CommonConfig(final ForgeConfigSpec.Builder builder) {
        builder.push("general");
        
        general.enableCorruptionSpread = builder
                .comment("Enable Corruption Spread")
                .define("enable_corruption_spread", true);
        
        entity.goldenBookWyrmProbabilityForZeroGolden = builder
                .comment("The probability for two normal book wyrms to produce a golden book wyrm")
                .defineInRange("golden_book_wyrm_probability_for_zero_golden", 0.01, 0.0, 1.0);
        
        entity.goldenBookWyrmProbabilityForOneGolden = builder
                .comment("The probability for one golden book wyrm and one normal book wyrm to produce a golden book wyrm")
                .defineInRange("golden_book_wyrm_probability_for_one_golden", 0.04, 0.0, 1.0);
        
        entity.goldenBookWyrmProbabilityForTwoGolden = builder
                .comment("The probability for two golden book wyrms to produce a golden book wyrm")
                .defineInRange("golden_book_wyrm_probability_for_two_golden", 0.1, 0.0, 1.0);
        
        entity.bookWyrmMaxEnchantingLevel = builder
                .comment("Maximum enchanting level for Book Wyrm")
                .defineInRange("book_wyrm_max_enchanting_level", 30, 10, 100);
        
        builder.pop();
    }
}
