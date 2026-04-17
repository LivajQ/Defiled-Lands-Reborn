package com.euphony.defiled_lands_reborn.config;

import com.euphony.defiled_lands_reborn.DefiledLandsPreborn;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Mod.EventBusSubscriber(modid = DefiledLandsPreborn.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CommonConfig {
  
    private final ForgeConfigSpec.ConfigValue<List<? extends String>> BOOK_WYRM_BLACKLIST;
    
    private final ForgeConfigSpec.ConfigValue<String> SCARLITE_REAVER_EFFECT_TYPE;
    
    private final ForgeConfigSpec.BooleanValue ENABLE_CORRUPTION_SPREAD;
    private final ForgeConfigSpec.BooleanValue CONFINED_SPREAD;
    private final ForgeConfigSpec.BooleanValue CAN_GENERATE_DEFILED_PLAINS;
    private final ForgeConfigSpec.BooleanValue CAN_GENERATE_DEFILED_DESERT;
    private final ForgeConfigSpec.BooleanValue CAN_GENERATE_DEFILED_HILLS;
    private final ForgeConfigSpec.BooleanValue CAN_GENERATE_DEFILED_SNOWY_PLAINS;
    private final ForgeConfigSpec.BooleanValue CAN_GENERATE_TENEBRA_FOREST;
    private final ForgeConfigSpec.BooleanValue CAN_GENERATE_VILESPINE_FOREST;
    private final ForgeConfigSpec.BooleanValue BOOK_WYRM_BLACKLIST_IS_WHITELIST;
    
    private final ForgeConfigSpec.DoubleValue GOLDEN_WYRM_CHANCE_FOR_ZERO_GOLDEN;
    private final ForgeConfigSpec.DoubleValue GOLDEN_WYRM_CHANCE_FOR_ONE_GOLDEN;
    private final ForgeConfigSpec.DoubleValue GOLDEN_WYRM_CHANCE_FOR_TWO_GOLDEN;
    private final ForgeConfigSpec.DoubleValue DESTROYER_ATTACK_DAMAGE;
    private final ForgeConfigSpec.DoubleValue DESTROYER_ATTACK_SPEED;
    private final ForgeConfigSpec.DoubleValue DESTROYER_ATTACK_KNOCKBACK;
    private final ForgeConfigSpec.DoubleValue DESTROYER_HEALTH;
    private final ForgeConfigSpec.DoubleValue DESTROYER_ARMOR;
    private final ForgeConfigSpec.DoubleValue DESTROYER_MOVEMENT_SPEED;
    private final ForgeConfigSpec.DoubleValue DESTROYER_KNOCKBACK_RESISTANCE;
    private final ForgeConfigSpec.DoubleValue DESTROYER_FOLLOW_RANGE;
    private final ForgeConfigSpec.DoubleValue MOURNER_ATTACK_DAMAGE;
    private final ForgeConfigSpec.DoubleValue MOURNER_ATTACK_SPEED;
    private final ForgeConfigSpec.DoubleValue MOURNER_ATTACK_KNOCKBACK;
    private final ForgeConfigSpec.DoubleValue MOURNER_HEALTH;
    private final ForgeConfigSpec.DoubleValue MOURNER_ARMOR;
    private final ForgeConfigSpec.DoubleValue MOURNER_MOVEMENT_SPEED;
    private final ForgeConfigSpec.DoubleValue MOURNER_KNOCKBACK_RESISTANCE;
    private final ForgeConfigSpec.DoubleValue MOURNER_FOLLOW_RANGE;
    private final ForgeConfigSpec.DoubleValue BOOK_WYRM_HEALTH;
    private final ForgeConfigSpec.DoubleValue BOOK_WYRM_MOVEMENT_SPEED;
    private final ForgeConfigSpec.DoubleValue HOST_ATTACK_DAMAGE;
    private final ForgeConfigSpec.DoubleValue HOST_ATTACK_SPEED;
    private final ForgeConfigSpec.DoubleValue HOST_ATTACK_KNOCKBACK;
    private final ForgeConfigSpec.DoubleValue HOST_HEALTH;
    private final ForgeConfigSpec.DoubleValue HOST_ARMOR;
    private final ForgeConfigSpec.DoubleValue HOST_MOVEMENT_SPEED;
    private final ForgeConfigSpec.DoubleValue HOST_KNOCKBACK_RESISTANCE;
    private final ForgeConfigSpec.DoubleValue HOST_FOLLOW_RANGE;
    private final ForgeConfigSpec.DoubleValue SCUTTLER_ATTACK_DAMAGE;
    private final ForgeConfigSpec.DoubleValue SCUTTLER_ATTACK_SPEED;
    private final ForgeConfigSpec.DoubleValue SCUTTLER_ATTACK_KNOCKBACK;
    private final ForgeConfigSpec.DoubleValue SCUTTLER_HEALTH;
    private final ForgeConfigSpec.DoubleValue SCUTTLER_ARMOR;
    private final ForgeConfigSpec.DoubleValue SCUTTLER_MOVEMENT_SPEED;
    private final ForgeConfigSpec.DoubleValue SCUTTLER_KNOCKBACK_RESISTANCE;
    private final ForgeConfigSpec.DoubleValue SCUTTLER_FOLLOW_RANGE;
    private final ForgeConfigSpec.DoubleValue SHAMBLER_ATTACK_DAMAGE;
    private final ForgeConfigSpec.DoubleValue SHAMBLER_ATTACK_SPEED;
    private final ForgeConfigSpec.DoubleValue SHAMBLER_ATTACK_KNOCKBACK;
    private final ForgeConfigSpec.DoubleValue SHAMBLER_HEALTH;
    private final ForgeConfigSpec.DoubleValue SHAMBLER_ARMOR;
    private final ForgeConfigSpec.DoubleValue SHAMBLER_MOVEMENT_SPEED;
    private final ForgeConfigSpec.DoubleValue SHAMBLER_KNOCKBACK_RESISTANCE;
    private final ForgeConfigSpec.DoubleValue SHAMBLER_FOLLOW_RANGE;
    private final ForgeConfigSpec.DoubleValue TWISTED_SHAMBLER_ATTACK_DAMAGE;
    private final ForgeConfigSpec.DoubleValue TWISTED_SHAMBLER_ATTACK_SPEED;
    private final ForgeConfigSpec.DoubleValue TWISTED_SHAMBLER_ATTACK_KNOCKBACK;
    private final ForgeConfigSpec.DoubleValue TWISTED_SHAMBLER_HEALTH;
    private final ForgeConfigSpec.DoubleValue TWISTED_SHAMBLER_ARMOR;
    private final ForgeConfigSpec.DoubleValue TWISTED_SHAMBLER_MOVEMENT_SPEED;
    private final ForgeConfigSpec.DoubleValue TWISTED_SHAMBLER_KNOCKBACK_RESISTANCE;
    private final ForgeConfigSpec.DoubleValue TWISTED_SHAMBLER_FOLLOW_RANGE;
    private final ForgeConfigSpec.DoubleValue BLASTEM_DAMAGE;
    private final ForgeConfigSpec.DoubleValue BLASTEM_EXPLOSION;
    private final ForgeConfigSpec.DoubleValue BLAZING_BLASTEM_DAMAGE;
    private final ForgeConfigSpec.DoubleValue BLAZING_BLASTEM_EXPLOSION;
    private final ForgeConfigSpec.DoubleValue UMBRA_BLASTER_DAMAGE_MULTIPLIER;
    private final ForgeConfigSpec.DoubleValue UMBRA_BLASTER_EXPLOSION_MULTIPLIER;
    private final ForgeConfigSpec.DoubleValue UMBRIUM_PELLET_DAMAGE;
    private final ForgeConfigSpec.DoubleValue RAVAGING_PELLET_DAMAGE;
    private final ForgeConfigSpec.DoubleValue SPIKED_PELLET_DAMAGE;
    private final ForgeConfigSpec.DoubleValue CONCUSSION_SMASHER_STRENGTH;
    private final ForgeConfigSpec.DoubleValue SCARLITE_REAVER_DAMAGE;
    private final ForgeConfigSpec.DoubleValue SCARLITE_REAVER_SPEED;
    private final ForgeConfigSpec.DoubleValue UMBRIUM_ARMOR_TOUGHNESS;
    private final ForgeConfigSpec.DoubleValue BOOK_WYRM_SCALE_ARMOR_TOUGHNESS;
    private final ForgeConfigSpec.DoubleValue GOLDEN_BOOK_WYRM_SCALE_ARMOR_TOUGHNESS;
    private final ForgeConfigSpec.DoubleValue MATERIAL_UMBRIUM_DAMAGE;
    private final ForgeConfigSpec.DoubleValue MATERIAL_UMBRIUM_HARVEST_SPEED;
    private final ForgeConfigSpec.DoubleValue MATERIAL_SCARLITE_DAMAGE;
    private final ForgeConfigSpec.DoubleValue MATERIAL_SCARLITE_HARVEST_SPEED;
    private final ForgeConfigSpec.DoubleValue MATERIAL_SCARLITE_RAZOR_DAMAGE;
    private final ForgeConfigSpec.DoubleValue MATERIAL_SCARLITE_RAZOR_HARVEST_SPEED;
    private final ForgeConfigSpec.DoubleValue MATERIAL_RAVAGING_DAMAGE;
    private final ForgeConfigSpec.DoubleValue MATERIAL_RAVAGING_HARVEST_SPEED;
    private final ForgeConfigSpec.DoubleValue ENCHANTMENT_DESTRUCTIVE_STRENGTH;
    
    private final ForgeConfigSpec.IntValue BOOK_WYRM_MAX_ENCHANTING_LEVEL;
    private final ForgeConfigSpec.IntValue UMBRA_BLASTER_DURABILITY;
    private final ForgeConfigSpec.IntValue RAVAGER_DURABILITY;
    private final ForgeConfigSpec.IntValue CONCUSSION_SMASHER_DURABILITY;
    private final ForgeConfigSpec.IntValue SCARLITE_REAVER_EFFECT_LEVEL;
    private final ForgeConfigSpec.IntValue SCARLITE_REAVER_EFFECT_DURATION;
    private final ForgeConfigSpec.IntValue UMBRIUM_ARMOR_DURABILITY_MULTIPLIER;
    private final ForgeConfigSpec.IntValue BOOK_WYRM_SCALE_ARMOR_DURABILITY_MULTIPLIER;
    private final ForgeConfigSpec.IntValue GOLDEN_BOOK_WYRM_SCALE_ARMOR_DURABILITY_MULTIPLIER;
    private final ForgeConfigSpec.IntValue UMBRIUM_HELMET_DEFENSE;
    private final ForgeConfigSpec.IntValue UMBRIUM_CHESTPLATE_DEFENSE;
    private final ForgeConfigSpec.IntValue UMBRIUM_LEGGINGS_DEFENSE;
    private final ForgeConfigSpec.IntValue UMBRIUM_BOOTS_DEFENSE;
    private final ForgeConfigSpec.IntValue BOOK_WYRM_SCALE_HELMET_DEFENSE;
    private final ForgeConfigSpec.IntValue BOOK_WYRM_SCALE_CHESTPLATE_DEFENSE;
    private final ForgeConfigSpec.IntValue BOOK_WYRM_SCALE_LEGGINGS_DEFENSE;
    private final ForgeConfigSpec.IntValue BOOK_WYRM_SCALE_BOOTS_DEFENSE;
    private final ForgeConfigSpec.IntValue GOLDEN_BOOK_WYRM_SCALE_HELMET_DEFENSE;
    private final ForgeConfigSpec.IntValue GOLDEN_BOOK_WYRM_SCALE_CHESTPLATE_DEFENSE;
    private final ForgeConfigSpec.IntValue GOLDEN_BOOK_WYRM_SCALE_LEGGINGS_DEFENSE;
    private final ForgeConfigSpec.IntValue GOLDEN_BOOK_WYRM_SCALE_BOOTS_DEFENSE;
    private final ForgeConfigSpec.IntValue MATERIAL_UMBRIUM_HARVEST_LEVEL;
    private final ForgeConfigSpec.IntValue MATERIAL_UMBRIUM_DURABILITY;
    private final ForgeConfigSpec.IntValue MATERIAL_SCARLITE_HARVEST_LEVEL;
    private final ForgeConfigSpec.IntValue MATERIAL_SCARLITE_DURABILITY;
    private final ForgeConfigSpec.IntValue MATERIAL_SCARLITE_RAZOR_HARVEST_LEVEL;
    private final ForgeConfigSpec.IntValue MATERIAL_SCARLITE_RAZOR_DURABILITY;
    private final ForgeConfigSpec.IntValue MATERIAL_RAVAGING_HARVEST_LEVEL;
    private final ForgeConfigSpec.IntValue MATERIAL_RAVAGING_DURABILITY;
    private final ForgeConfigSpec.IntValue ENCHANTMENT_DESTRUCTIVE_LEVEL;
    
    public CommonConfig (final ForgeConfigSpec.Builder builder) {
    
        builder.push("Corruption");
        
        ENABLE_CORRUPTION_SPREAD = builder.comment("Enable Corruption Spread").define("enable_corruption_spread", true);
        CONFINED_SPREAD = builder.comment("Biomes cannot expand and only corrupt blocks inside said biomes").define("confined_spread", true);
        
        builder.pop();
        
        builder.push("Book Wyrms");
        
        GOLDEN_WYRM_CHANCE_FOR_ZERO_GOLDEN = builder.comment("The probability for two normal book wyrms to produce a golden book wyrm").defineInRange("golden_wyrm_chance_for_zero_golden", 0.01, 0.0, 1.0);
        GOLDEN_WYRM_CHANCE_FOR_ONE_GOLDEN = builder.comment("The probability for one golden book wyrm and one normal book wyrm to produce a golden book wyrm").defineInRange("golden_wyrm_chance_for_one_golden", 0.04, 0.0, 1.0);
        GOLDEN_WYRM_CHANCE_FOR_TWO_GOLDEN = builder.comment("The probability for two golden book wyrms to produce a golden book wyrm").defineInRange("golden_wyrm_chance_for_two_golden", 0.1, 0.0, 1.0);
        BOOK_WYRM_MAX_ENCHANTING_LEVEL = builder.comment("Maximum enchanting level for Book Wyrm").defineInRange("book_wyrm_max_enchanting_level", 30, 10, 1000);
        BOOK_WYRM_BLACKLIST = builder
                .comment("Enchantments that cannot be dropped by bookwyrms")
                .defineListAllowEmpty(
                        List.of("book_wyrm_blacklist"),
                        List.of(
                                "minecraft:blast_protection"
                        ),
                        o -> o instanceof String
                );
        BOOK_WYRM_BLACKLIST_IS_WHITELIST = builder.comment("Whether the blacklist should be treated as a whitelist").define("book_wyrm_blacklist_is_whitelist", false);
        
        builder.pop();
        
        builder.push("Biomes");
        builder.comment("Which biomes are allowed to generate in the world");
        
        CAN_GENERATE_DEFILED_PLAINS = builder.define("defiled_plains", true);
        CAN_GENERATE_DEFILED_DESERT = builder.define("defiled_desert", true);
        CAN_GENERATE_DEFILED_HILLS = builder.define("defiled_hills", true);
        CAN_GENERATE_DEFILED_SNOWY_PLAINS = builder.define("defiled_snowy_plains", true);
        CAN_GENERATE_TENEBRA_FOREST = builder.define("tenebra_forest", true);
        CAN_GENERATE_VILESPINE_FOREST = builder.define("vilespine_forest", true);
        
        builder.pop();
        
        builder.push("Enchantments");
        
        ENCHANTMENT_DESTRUCTIVE_STRENGTH = builder.comment("Explosion strength amplifier per level of the Destructive enchantment").defineInRange("enchantment_destructive_strength", 0.25D, 0.0D, 1000.0D);
        ENCHANTMENT_DESTRUCTIVE_LEVEL = builder.comment("Maximum level of the Destructive enchantment").defineInRange("enchantment_destructive_level", 5, 0, 10);
        
        builder.pop();
        
        builder.push("Attributes");
        builder.comment("Values for items and entities");
        
        builder.push("The Destroyer");
        
        DESTROYER_ATTACK_DAMAGE = builder.comment("Attack damage").defineInRange("destroyer_attack_damage", 16.0D, 0.0D, 2048.0D);
        DESTROYER_ATTACK_SPEED = builder.comment("Attack speed").defineInRange("destroyer_attack_speed", 1.0D, 0.0D, 1024.0D);
        DESTROYER_ATTACK_KNOCKBACK = builder.comment("Attack knockback").defineInRange("destroyer_attack_knockback", 1.5D, 0.0D, 5.0D);
        DESTROYER_HEALTH = builder.comment("Health").defineInRange("destroyer_health", 200.0D, 1.0D, 1024.0D);
        DESTROYER_ARMOR = builder.comment("Armor").defineInRange("destroyer_armor", 10.0D, 0.0D, 30.0D);
        DESTROYER_MOVEMENT_SPEED = builder.comment("Movement speed").defineInRange("destroyer_movement_speed", 0.32D, 0.0D, 1024.0D);
        DESTROYER_KNOCKBACK_RESISTANCE = builder.comment("Knockback resistance").defineInRange("destroyer_knockback_resistance", 1.0D, 0.0D, 1.0D);
        DESTROYER_FOLLOW_RANGE = builder.comment("Follow range").defineInRange("destroyer_follow_range", 128.0D, 0.0D, 2048.0D);
        
        builder.pop();
        
        builder.push("The Mourner");
        
        MOURNER_ATTACK_DAMAGE = builder.comment("Attack damage").defineInRange("mourner_attack_damage", 16.0D, 0.0D, 2048.0D);
        MOURNER_ATTACK_SPEED = builder.comment("Attack speed").defineInRange("mourner_attack_speed", 1.0D, 0.0D, 1024.0D);
        MOURNER_ATTACK_KNOCKBACK = builder.comment("Attack knockback").defineInRange("mourner_attack_knockback", 2.0D, 0.0D, 5.0D);
        MOURNER_HEALTH = builder.comment("Health").defineInRange("mourner_health", 400.0D, 1.0D, 1024.0D);
        MOURNER_ARMOR = builder.comment("Armor").defineInRange("mourner_armor", 10.0D, 0.0D, 30.0D);
        MOURNER_MOVEMENT_SPEED = builder.comment("Movement speed").defineInRange("mourner_movement_speed", 0.7D, 0.0D, 1024.0D);
        MOURNER_KNOCKBACK_RESISTANCE = builder.comment("Knockback resistance").defineInRange("mourner_knockback_resistance", 1.0D, 0.0D, 1.0D);
        MOURNER_FOLLOW_RANGE = builder.comment("Follow range").defineInRange("mourner_follow_range", 128.0D, 0.0D, 2048.0D);
        
        builder.pop();
        
        builder.push("Book Wyrm");
        
        BOOK_WYRM_HEALTH = builder.comment("Health").defineInRange("book_wyrm_health", 12.0D, 1.0D, 1024.0D);
        BOOK_WYRM_MOVEMENT_SPEED = builder.comment("Movement speed").defineInRange("book_wyrm_movement_speed", 0.25D, 0.0D, 1024.0D);
        
        builder.pop();
        
        builder.push("Host");
        
        HOST_ATTACK_DAMAGE = builder.comment("Attack damage").defineInRange("host_attack_damage", 5.0D, 0.0D, 2048.0D);
        HOST_ATTACK_SPEED = builder.comment("Attack speed").defineInRange("host_attack_speed", 1.0D, 0.0D, 1024.0D);
        HOST_ATTACK_KNOCKBACK = builder.comment("Attack knockback").defineInRange("host_attack_knockback", 1.0D, 0.0D, 5.0D);
        HOST_HEALTH = builder.comment("Health").defineInRange("host_health", 20.0D, 1.0D, 1024.0D);
        HOST_ARMOR = builder.comment("Armor").defineInRange("host_armor", 2.0D, 0.0D, 30.0D);
        HOST_MOVEMENT_SPEED = builder.comment("Movement speed").defineInRange("host_movement_speed", 0.27D, 0.0D, 1024.0D);
        HOST_KNOCKBACK_RESISTANCE = builder.comment("Knockback resistance").defineInRange("host_knockback_resistance", 0.0D, 0.0D, 1.0D);
        HOST_FOLLOW_RANGE = builder.comment("Follow range").defineInRange("host_follow_range", 35.0D, 0.0D, 2048.0D);
        
        builder.pop();
        
        builder.push("Scuttler");
        
        SCUTTLER_ATTACK_DAMAGE = builder.comment("Attack damage").defineInRange("scuttler_attack_damage", 3.0D, 0.0D, 2048.0D);
        SCUTTLER_ATTACK_SPEED = builder.comment("Attack speed").defineInRange("scuttler_attack_speed", 1.0D, 0.0D, 1024.0D);
        SCUTTLER_ATTACK_KNOCKBACK = builder.comment("Attack knockback").defineInRange("scuttler_attack_knockback", 1.0D, 0.0D, 5.0D);
        SCUTTLER_HEALTH = builder.comment("Health").defineInRange("scuttler_health", 16.0D, 1.0D, 1024.0D);
        SCUTTLER_ARMOR = builder.comment("Armor").defineInRange("scuttler_armor", 0.0D, 0.0D, 30.0D);
        SCUTTLER_MOVEMENT_SPEED = builder.comment("Movement speed").defineInRange("scuttler_movement_speed", 0.34D, 0.0D, 1024.0D);
        SCUTTLER_KNOCKBACK_RESISTANCE = builder.comment("Knockback resistance").defineInRange("scuttler_knockback_resistance", 0.0D, 0.0D, 1.0D);
        SCUTTLER_FOLLOW_RANGE = builder.comment("Follow range").defineInRange("scuttler_follow_range", 16.0D, 0.0D, 2048.0D);
        
        builder.pop();
        
        builder.push("Shambler");
        
        SHAMBLER_ATTACK_DAMAGE = builder.comment("Attack damage").defineInRange("shambler_attack_damage", 14.0D, 0.0D, 2048.0D);
        SHAMBLER_ATTACK_SPEED = builder.comment("Attack speed").defineInRange("shambler_attack_speed", 1.0D, 0.0D, 1024.0D);
        SHAMBLER_ATTACK_KNOCKBACK = builder.comment("Attack knockback").defineInRange("shambler_attack_knockback", 1.5D, 0.0D, 5.0D);
        SHAMBLER_HEALTH = builder.comment("Health").defineInRange("shambler_health", 40.0D, 1.0D, 1024.0D);
        SHAMBLER_ARMOR = builder.comment("Armor").defineInRange("shambler_armor", 4.0D, 0.0D, 30.0D);
        SHAMBLER_MOVEMENT_SPEED = builder.comment("Movement speed").defineInRange("shambler_movement_speed", 0.14D, 0.0D, 1024.0D);
        SHAMBLER_KNOCKBACK_RESISTANCE = builder.comment("Knockback resistance").defineInRange("shambler_knockback_resistance", 1.0D, 0.0D, 1.0D);
        SHAMBLER_FOLLOW_RANGE = builder.comment("Follow range").defineInRange("shambler_follow_range", 64.0D, 0.0D, 2048.0D);
        
        builder.pop();
        
        builder.push("Twisted Shambler");
        
        TWISTED_SHAMBLER_ATTACK_DAMAGE = builder.comment("Attack damage").defineInRange("twisted_shambler_attack_damage", 22.0D, 0.0D, 2048.0D);
        TWISTED_SHAMBLER_ATTACK_SPEED = builder.comment("Attack speed").defineInRange("twisted_shambler_attack_speed", 1.0D, 0.0D, 1024.0D);
        TWISTED_SHAMBLER_ATTACK_KNOCKBACK = builder.comment("Attack knockback").defineInRange("twisted_shambler_attack_knockback", 2.0D, 0.0D, 5.0D);
        TWISTED_SHAMBLER_HEALTH = builder.comment("Health").defineInRange("twisted_shambler_health", 50.0D, 1.0D, 1024.0D);
        TWISTED_SHAMBLER_ARMOR = builder.comment("Armor").defineInRange("twisted_shambler_armor", 8.0D, 0.0D, 30.0D);
        TWISTED_SHAMBLER_MOVEMENT_SPEED = builder.comment("Movement speed").defineInRange("twisted_shambler_movement_speed", 0.28D, 0.0D, 1024.0D);
        TWISTED_SHAMBLER_KNOCKBACK_RESISTANCE = builder.comment("Knockback resistance").defineInRange("twisted_shambler_knockback_resistance", 1.0D, 0.0D, 1.0D);
        TWISTED_SHAMBLER_FOLLOW_RANGE = builder.comment("Follow range").defineInRange("twisted_shambler_follow_range", 64.0D, 0.0D, 2048.0D);
        
        builder.pop();
        
        builder.push("Blastem");
        
        BLASTEM_DAMAGE = builder.comment("Blastem fruit damage").defineInRange("blastem_damage", 7.0D, 0.0D, 1000000.0D);
        BLASTEM_EXPLOSION = builder.comment("Blastem fruit explosion strength").defineInRange("blastem_explosion", 1.5D, 0.0D, 1000000.0D);
        BLAZING_BLASTEM_DAMAGE = builder.comment("Blazing blastem fruit damage").defineInRange("blazing_blastem_damage", 10.0D, 0.0D, 1000000.0D);
        BLAZING_BLASTEM_EXPLOSION = builder.comment("Blazing blastem fruit explosion strength").defineInRange("blazing_blastem_explosion", 2.0D, 1.0D, 1000000.0D);
        UMBRA_BLASTER_DAMAGE_MULTIPLIER = builder.comment("Damage multiplier for blastem projectiles when fired from an Umbra Blaster").defineInRange("umbra_blaster_damage_multiplier", 2.0D, 0.0D, 1000.0D);
        UMBRA_BLASTER_EXPLOSION_MULTIPLIER = builder.comment("Explosion strength multiplier for blastem projectiles when fired from an Umbra Blaster").defineInRange("umbra_blaster_explosion_multiplier", 2.0D, 0.0D, 1000.0D);
        UMBRA_BLASTER_DURABILITY = builder.comment("Umbra Blaster durability").defineInRange("umbra_blaster_durability", 465, 1, 1000000);
        
        builder.pop();
        
        builder.push("Ravager");
        
        RAVAGER_DURABILITY = builder.comment("Ravager durability").defineInRange("ravager_durability", 2137, 1, 1000000);
        UMBRIUM_PELLET_DAMAGE = builder.comment("Umbrium pellet damage").defineInRange("umbrium_pellet_damage", 12.0D, 0.0D, 1000000.0D);
        RAVAGING_PELLET_DAMAGE = builder.comment("Ravaging pellet damage").defineInRange("ravaging_pellet_damage", 20.0D, 0.0D, 1000000.0D);
        SPIKED_PELLET_DAMAGE = builder.comment("Spiked pellet damage").defineInRange("spiked_pellet_damage", 16.0D, 0.0D, 1000000.0D);
        
        builder.pop();
        
        builder.push("Concussion Smasher");
        
        CONCUSSION_SMASHER_STRENGTH = builder.comment("Concussion Smasher shockwave strength").defineInRange("concussion_smasher_strength", 15.0D, 0.0D, 1000.0D);
        CONCUSSION_SMASHER_DURABILITY = builder.comment("Concussion Smasher durability").defineInRange("concussion_smasher_durability", 178, 1, 1000000);
        
        builder.pop();
        
        builder.push("Scarlite Reaver");
        
        SCARLITE_REAVER_DAMAGE = builder.comment("Bonus damage for the Scarlite Reaver").defineInRange("scarlite_reaver_damage", 2.0D, 0.0D, 1000000.0D);
        SCARLITE_REAVER_SPEED = builder.comment("Attack speed for the Scarlite Reaver").defineInRange("scarlite_reaver_speed", 1.6D, 0.0D, 1000.0D);
        SCARLITE_REAVER_EFFECT_TYPE = builder.comment("Potion effect applied to the user on hit").define("scarlite_reaver_effect_type", "minecraft:regeneration");
        SCARLITE_REAVER_EFFECT_LEVEL = builder.comment("Amplifier of the applied effect").defineInRange("scarlite_reaver_effect_level", 19, 0, 255);
        SCARLITE_REAVER_EFFECT_DURATION = builder.comment("Duration (in ticks) of the applied effect").defineInRange("scarlite_reaver_effect_duration", 3, 1, 1000000);
        
        builder.pop();
        
        builder.push("Armor");
        
        UMBRIUM_ARMOR_DURABILITY_MULTIPLIER = builder.comment("Umbrium armor durability multiplier").defineInRange("umbrium_armor_durability_multiplier", 15, 1, 1000000);
        UMBRIUM_ARMOR_TOUGHNESS = builder.comment("Umbrium armor toughness").defineInRange("umbrium_armor_toughness", 0.0D, 0.0D, 100.0D);
        BOOK_WYRM_SCALE_ARMOR_DURABILITY_MULTIPLIER = builder.comment("Book wyrm scale armor durability multiplier").defineInRange("book_wyrm_scale_armor_durability_multiplier", 11, 1, 1000000);
        BOOK_WYRM_SCALE_ARMOR_TOUGHNESS = builder.comment("Book wyrm scale armor toughness").defineInRange("book_wyrm_scale_armor_toughness", 0.0D, 0.0D, 100.0D);
        GOLDEN_BOOK_WYRM_SCALE_ARMOR_DURABILITY_MULTIPLIER = builder.comment("Golden book wyrm scale armor durability multiplier").defineInRange("golden_book_wyrm_scale_armor_durability_multiplier", 33, 1, 1000000);
        GOLDEN_BOOK_WYRM_SCALE_ARMOR_TOUGHNESS = builder.comment("Golden book wyrm scale armor toughness").defineInRange("golden_book_wyrm_scale_armor_toughness", 1.0D, 0.0D, 100.0D);
        UMBRIUM_HELMET_DEFENSE = builder.comment("Armor value of umbrium helmet").defineInRange("umbrium_helmet_defense", 2, 0, 100);
        UMBRIUM_CHESTPLATE_DEFENSE = builder.comment("Armor value of umbrium chestplate").defineInRange("umbrium_chestplate_defense", 5, 0, 100);
        UMBRIUM_LEGGINGS_DEFENSE = builder.comment("Armor value of umbrium leggings").defineInRange("umbrium_leggings_defense", 4, 0, 100);
        UMBRIUM_BOOTS_DEFENSE = builder.comment("Armor value of umbrium boots").defineInRange("umbrium_boots_defense", 1, 0, 100);
        BOOK_WYRM_SCALE_HELMET_DEFENSE = builder.comment("Armor value of book wyrm scale helmet").defineInRange("book_wyrm_scale_helmet_defense", 2, 0, 100);
        BOOK_WYRM_SCALE_CHESTPLATE_DEFENSE = builder.comment("Armor value of book wyrm scale chestplate").defineInRange("book_wyrm_scale_chestplate_defense", 4, 0, 100);
        BOOK_WYRM_SCALE_LEGGINGS_DEFENSE = builder.comment("Armor value of book wyrm scale leggings").defineInRange("book_wyrm_scale_leggings_defense", 3, 0, 100);
        BOOK_WYRM_SCALE_BOOTS_DEFENSE = builder.comment("Armor value of book wyrm scale boots").defineInRange("book_wyrm_scale_boots_defense", 1, 0, 100);
        GOLDEN_BOOK_WYRM_SCALE_HELMET_DEFENSE = builder.comment("Armor value of golden book wyrm scale helmet").defineInRange("golden_book_wyrm_scale_helmet_defense", 3, 0, 100);
        GOLDEN_BOOK_WYRM_SCALE_CHESTPLATE_DEFENSE = builder.comment("Armor value of golden book wyrm scale chestplate").defineInRange("golden_book_wyrm_scale_chestplate_defense", 6, 0, 100);
        GOLDEN_BOOK_WYRM_SCALE_LEGGINGS_DEFENSE = builder.comment("Armor value of golden book wyrm scale leggings").defineInRange("golden_book_wyrm_scale_leggings_defense", 5, 0, 100);
        GOLDEN_BOOK_WYRM_SCALE_BOOTS_DEFENSE = builder.comment("Armor value of golden book wyrm scale boots").defineInRange("golden_book_wyrm_scale_boots_defense", 2, 0, 100);
        
        builder.pop();
        
        builder.push("Tool materials");
        
        MATERIAL_UMBRIUM_DAMAGE = builder.comment("Bonus damage for umbrium items").defineInRange("material_umbrium_damage", 2.0D, 0.0D, 1000000.0D);
        MATERIAL_UMBRIUM_DURABILITY = builder.comment("Durability of umbrium items").defineInRange("material_umbrium_durability", 302, 1, 1000000);
        MATERIAL_UMBRIUM_HARVEST_LEVEL = builder.comment("Harvesting level of umbrium items").defineInRange("material_umbrium_harvest_level", 2, 0, 100);
        MATERIAL_UMBRIUM_HARVEST_SPEED = builder.comment("Harvesting speed of umbrium items").defineInRange("material_umbrium_harvest_speed", 6.0D, 0.0D, 1000000.0D);
        MATERIAL_SCARLITE_DAMAGE = builder.comment("Bonus damage for scarlite items").defineInRange("material_scarlite_damage", 2.0D, 0.0D, 1000000.0D);
        MATERIAL_SCARLITE_DURABILITY = builder.comment("Durability of scarlite items").defineInRange("material_scarlite_durability", 1561, 1, 1000000);
        MATERIAL_SCARLITE_HARVEST_LEVEL = builder.comment("Harvesting level of scarlite items").defineInRange("material_scarlite_harvest_level", 2, 0, 100);
        MATERIAL_SCARLITE_HARVEST_SPEED = builder.comment("Harvesting speed of scarlite items").defineInRange("material_scarlite_harvest_speed", 6.0D, 0.0D, 1000000.0D);
        MATERIAL_SCARLITE_RAZOR_DAMAGE = builder.comment("Bonus damage for the Scarlite Razor").defineInRange("material_scarlite_razor_damage", 2.0D, 0.0D, 1000000.0D);
        MATERIAL_SCARLITE_RAZOR_DURABILITY = builder.comment("Durability of the Scarlite Razor").defineInRange("material_scarlite_razor_durability", 131, 1, 1000000);
        MATERIAL_SCARLITE_RAZOR_HARVEST_LEVEL = builder.comment("Harvesting level of the Scarlite Razor").defineInRange("material_scarlite_razor_harvest_level", 2, 0, 100);
        MATERIAL_SCARLITE_RAZOR_HARVEST_SPEED = builder.comment("Harvesting speed of the Scarlite Razor").defineInRange("material_scarlite_razor_harvest_speed", 6.0D, 0.0D, 1000000.0D);
        MATERIAL_RAVAGING_DAMAGE = builder.comment("Bonus damage for ravaging items").defineInRange("material_ravaging_damage", 3.0D, 0.0D, 1000000.0D);
        MATERIAL_RAVAGING_DURABILITY = builder.comment("Durability of ravaging items").defineInRange("material_ravaging_durability", 2137, 1, 1000000);
        MATERIAL_RAVAGING_HARVEST_LEVEL = builder.comment("Harvesting level of ravaging items").defineInRange("material_ravaging_harvest_level", 3, 0, 100);
        MATERIAL_RAVAGING_HARVEST_SPEED = builder.comment("Harvesting speed of ravaging items").defineInRange("material_ravaging_harvest_speed", 128.0D, 0.0D, 1000000.0D);
        
        builder.pop();
        
        builder.pop();
    }
    
    public Set<? extends String> bookWyrmBlacklist;
    
    public ResourceLocation scarliteReaverEffectType;
    
    public boolean enableCorruptionSpread;
    public boolean confinedSpread;
    public boolean canGenerateDefiledPlains;
    public boolean canGenerateDefiledDesert;
    public boolean canGenerateDefiledHills;
    public boolean canGenerateDefiledSnowyPlains;
    public boolean canGenerateTenebraForest;
    public boolean canGenerateVilespineForest;
    public boolean bookWyrmBlacklistIsWhitelist;
    
    public double goldenWyrmChanceForZeroGolden;
    public double goldenWyrmChanceForOneGolden;
    public double goldenWyrmChanceForTwoGolden;
    public double destroyerAttackDamage;
    public double destroyerAttackSpeed;
    public double destroyerAttackKnockback;
    public double destroyerHealth;
    public double destroyerArmor;
    public double destroyerMovementSpeed;
    public double destroyerKnockbackResistance;
    public double destroyerFollowRange;
    public double mournerAttackDamage;
    public double mournerAttackSpeed;
    public double mournerAttackKnockback;
    public double mournerHealth;
    public double mournerArmor;
    public double mournerMovementSpeed;
    public double mournerKnockbackResistance;
    public double mournerFollowRange;
    public double bookWyrmHealth;
    public double bookWyrmMovementSpeed;
    public double hostAttackDamage;
    public double hostAttackSpeed;
    public double hostAttackKnockback;
    public double hostHealth;
    public double hostArmor;
    public double hostMovementSpeed;
    public double hostKnockbackResistance;
    public double hostFollowRange;
    public double scuttlerAttackDamage;
    public double scuttlerAttackSpeed;
    public double scuttlerAttackKnockback;
    public double scuttlerHealth;
    public double scuttlerArmor;
    public double scuttlerMovementSpeed;
    public double scuttlerKnockbackResistance;
    public double scuttlerFollowRange;
    public double shamblerAttackDamage;
    public double shamblerAttackSpeed;
    public double shamblerAttackKnockback;
    public double shamblerHealth;
    public double shamblerArmor;
    public double shamblerMovementSpeed;
    public double shamblerKnockbackResistance;
    public double shamblerFollowRange;
    public double twistedShamblerAttackDamage;
    public double twistedShamblerAttackSpeed;
    public double twistedShamblerAttackKnockback;
    public double twistedShamblerHealth;
    public double twistedShamblerArmor;
    public double twistedShamblerMovementSpeed;
    public double twistedShamblerKnockbackResistance;
    public double twistedShamblerFollowRange;
    public double blastemDamage;
    public double blastemExplosion;
    public double blazingBlastemDamage;
    public double blazingBlastemExplosion;
    public double umbraBlasterDamageMultiplier;
    public double umbraBlasterExplosionMultiplier;
    public double umbriumPelletDamage;
    public double ravagingPelletDamage;
    public double spikedPelletDamage;
    public double concussionSmasherStrength;
    public double scarliteReaverDamage;
    public double scarliteReaverSpeed;
    public double umbriumArmorToughness;
    public double bookWyrmScaleArmorToughness;
    public double goldenBookWyrmScaleArmorToughness;
    public double materialUmbriumDamage;
    public double materialUmbriumHarvestSpeed;
    public double materialScarliteDamage;
    public double materialScarliteHarvestSpeed;
    public double materialScarliteRazorDamage;
    public double materialScarliteRazorHarvestSpeed;
    public double materialRavagingDamage;
    public double materialRavagingHarvestSpeed;
    public double enchantmentDestructiveStrength;
    
    public int bookWyrmMaxEnchantingLevel;
    public int umbraBlasterDurability;
    public int ravagerDurability;
    public int concussionSmasherDurability;
    public int scarliteReaverEffectLevel;
    public int scarliteReaverEffectDuration;
    public int umbriumArmorDurabilityMultiplier;
    public int bookWyrmScaleArmorDurabilityMultiplier;
    public int goldenBookWyrmScaleArmorDurabilityMultiplier;
    public int umbriumHelmetDefense;
    public int umbriumChestplateDefense;
    public int umbriumLeggingsDefense;
    public int umbriumBootsDefense;
    public int bookWyrmScaleHelmetDefense;
    public int bookWyrmScaleChestplateDefense;
    public int bookWyrmScaleLeggingsDefense;
    public int bookWyrmScaleBootsDefense;
    public int goldenBookWyrmScaleHelmetDefense;
    public int goldenBookWyrmScaleChestplateDefense;
    public int goldenBookWyrmScaleLeggingsDefense;
    public int goldenBookWyrmScaleBootsDefense;
    public int materialUmbriumDurability;
    public int materialUmbriumHarvestLevel;
    public int materialScarliteDurability;
    public int materialScarliteHarvestLevel;
    public int materialScarliteRazorDurability;
    public int materialScarliteRazorHarvestLevel;
    public int materialRavagingDurability;
    public int materialRavagingHarvestLevel;
    public int enchantmentDestructiveLevel;
    
    public void bake() {
        enableCorruptionSpread = ENABLE_CORRUPTION_SPREAD.get();
        confinedSpread = CONFINED_SPREAD.get();
        canGenerateDefiledPlains = CAN_GENERATE_DEFILED_PLAINS.get();
        canGenerateDefiledDesert = CAN_GENERATE_DEFILED_DESERT.get();
        canGenerateDefiledHills = CAN_GENERATE_DEFILED_HILLS.get();
        canGenerateDefiledSnowyPlains = CAN_GENERATE_DEFILED_SNOWY_PLAINS.get();
        canGenerateTenebraForest = CAN_GENERATE_TENEBRA_FOREST.get();
        canGenerateVilespineForest = CAN_GENERATE_VILESPINE_FOREST.get();
        goldenWyrmChanceForZeroGolden = GOLDEN_WYRM_CHANCE_FOR_ZERO_GOLDEN.get();
        goldenWyrmChanceForOneGolden = GOLDEN_WYRM_CHANCE_FOR_ONE_GOLDEN.get();
        goldenWyrmChanceForTwoGolden = GOLDEN_WYRM_CHANCE_FOR_TWO_GOLDEN.get();
        bookWyrmMaxEnchantingLevel = BOOK_WYRM_MAX_ENCHANTING_LEVEL.get();
        destroyerAttackDamage = DESTROYER_ATTACK_DAMAGE.get();
        destroyerAttackSpeed = DESTROYER_ATTACK_SPEED.get();
        destroyerAttackKnockback = DESTROYER_ATTACK_KNOCKBACK.get();
        destroyerHealth = DESTROYER_HEALTH.get();
        destroyerArmor = DESTROYER_ARMOR.get();
        destroyerMovementSpeed = DESTROYER_MOVEMENT_SPEED.get();
        destroyerKnockbackResistance = DESTROYER_KNOCKBACK_RESISTANCE.get();
        destroyerFollowRange = DESTROYER_FOLLOW_RANGE.get();
        mournerAttackDamage = MOURNER_ATTACK_DAMAGE.get();
        mournerAttackSpeed = MOURNER_ATTACK_SPEED.get();
        mournerAttackKnockback = MOURNER_ATTACK_KNOCKBACK.get();
        mournerHealth = MOURNER_HEALTH.get();
        mournerArmor = MOURNER_ARMOR.get();
        mournerMovementSpeed = MOURNER_MOVEMENT_SPEED.get();
        mournerKnockbackResistance = MOURNER_KNOCKBACK_RESISTANCE.get();
        mournerFollowRange = MOURNER_FOLLOW_RANGE.get();
        bookWyrmHealth = BOOK_WYRM_HEALTH.get();
        bookWyrmMovementSpeed = BOOK_WYRM_MOVEMENT_SPEED.get();
        hostAttackDamage = HOST_ATTACK_DAMAGE.get();
        hostAttackSpeed = HOST_ATTACK_SPEED.get();
        hostAttackKnockback = HOST_ATTACK_KNOCKBACK.get();
        hostHealth = HOST_HEALTH.get();
        hostArmor = HOST_ARMOR.get();
        hostMovementSpeed = HOST_MOVEMENT_SPEED.get();
        hostKnockbackResistance = HOST_KNOCKBACK_RESISTANCE.get();
        hostFollowRange = HOST_FOLLOW_RANGE.get();
        scuttlerAttackDamage = SCUTTLER_ATTACK_DAMAGE.get();
        scuttlerAttackSpeed = SCUTTLER_ATTACK_SPEED.get();
        scuttlerAttackKnockback = SCUTTLER_ATTACK_KNOCKBACK.get();
        scuttlerHealth = SCUTTLER_HEALTH.get();
        scuttlerArmor = SCUTTLER_ARMOR.get();
        scuttlerMovementSpeed = SCUTTLER_MOVEMENT_SPEED.get();
        scuttlerKnockbackResistance = SCUTTLER_KNOCKBACK_RESISTANCE.get();
        scuttlerFollowRange = SCUTTLER_FOLLOW_RANGE.get();
        shamblerAttackDamage = SHAMBLER_ATTACK_DAMAGE.get();
        shamblerAttackSpeed = SHAMBLER_ATTACK_SPEED.get();
        shamblerAttackKnockback = SHAMBLER_ATTACK_KNOCKBACK.get();
        shamblerHealth = SHAMBLER_HEALTH.get();
        shamblerArmor = SHAMBLER_ARMOR.get();
        shamblerMovementSpeed = SHAMBLER_MOVEMENT_SPEED.get();
        shamblerKnockbackResistance = SHAMBLER_KNOCKBACK_RESISTANCE.get();
        shamblerFollowRange = SHAMBLER_FOLLOW_RANGE.get();
        twistedShamblerAttackDamage = TWISTED_SHAMBLER_ATTACK_DAMAGE.get();
        twistedShamblerAttackSpeed = TWISTED_SHAMBLER_ATTACK_SPEED.get();
        twistedShamblerAttackKnockback = TWISTED_SHAMBLER_ATTACK_KNOCKBACK.get();
        twistedShamblerHealth = TWISTED_SHAMBLER_HEALTH.get();
        twistedShamblerArmor = TWISTED_SHAMBLER_ARMOR.get();
        twistedShamblerMovementSpeed = TWISTED_SHAMBLER_MOVEMENT_SPEED.get();
        twistedShamblerKnockbackResistance = TWISTED_SHAMBLER_KNOCKBACK_RESISTANCE.get();
        twistedShamblerFollowRange = TWISTED_SHAMBLER_FOLLOW_RANGE.get();
        blastemDamage = BLASTEM_DAMAGE.get();
        blastemExplosion = BLASTEM_EXPLOSION.get();
        blazingBlastemDamage = BLAZING_BLASTEM_DAMAGE.get();
        blazingBlastemExplosion = BLAZING_BLASTEM_EXPLOSION.get();
        umbraBlasterDamageMultiplier = UMBRA_BLASTER_DAMAGE_MULTIPLIER.get();
        umbraBlasterExplosionMultiplier = UMBRA_BLASTER_EXPLOSION_MULTIPLIER.get();
        umbriumPelletDamage = UMBRIUM_PELLET_DAMAGE.get();
        ravagingPelletDamage = RAVAGING_PELLET_DAMAGE.get();
        spikedPelletDamage = SPIKED_PELLET_DAMAGE.get();
        umbraBlasterDurability = UMBRA_BLASTER_DURABILITY.get();
        ravagerDurability = RAVAGER_DURABILITY.get();
        concussionSmasherStrength = CONCUSSION_SMASHER_STRENGTH.get();
        concussionSmasherDurability = CONCUSSION_SMASHER_DURABILITY.get();
        scarliteReaverEffectType = new ResourceLocation(SCARLITE_REAVER_EFFECT_TYPE.get());
        scarliteReaverDamage = SCARLITE_REAVER_DAMAGE.get();
        scarliteReaverSpeed = SCARLITE_REAVER_SPEED.get();
        scarliteReaverEffectLevel = SCARLITE_REAVER_EFFECT_LEVEL.get();
        scarliteReaverEffectDuration = SCARLITE_REAVER_EFFECT_DURATION.get();
        umbriumArmorDurabilityMultiplier = UMBRIUM_ARMOR_DURABILITY_MULTIPLIER.get();
        umbriumArmorToughness = UMBRIUM_ARMOR_TOUGHNESS.get();
        bookWyrmScaleArmorDurabilityMultiplier = BOOK_WYRM_SCALE_ARMOR_DURABILITY_MULTIPLIER.get();
        bookWyrmScaleArmorToughness = BOOK_WYRM_SCALE_ARMOR_TOUGHNESS.get();
        goldenBookWyrmScaleArmorDurabilityMultiplier = GOLDEN_BOOK_WYRM_SCALE_ARMOR_DURABILITY_MULTIPLIER.get();
        goldenBookWyrmScaleArmorToughness = GOLDEN_BOOK_WYRM_SCALE_ARMOR_TOUGHNESS.get();
        umbriumHelmetDefense = UMBRIUM_HELMET_DEFENSE.get();
        umbriumChestplateDefense = UMBRIUM_CHESTPLATE_DEFENSE.get();
        umbriumLeggingsDefense  = UMBRIUM_LEGGINGS_DEFENSE.get();
        umbriumBootsDefense = UMBRIUM_BOOTS_DEFENSE.get();
        bookWyrmScaleHelmetDefense = BOOK_WYRM_SCALE_HELMET_DEFENSE.get();
        bookWyrmScaleChestplateDefense = BOOK_WYRM_SCALE_CHESTPLATE_DEFENSE.get();
        bookWyrmScaleLeggingsDefense = BOOK_WYRM_SCALE_LEGGINGS_DEFENSE.get();
        bookWyrmScaleBootsDefense = BOOK_WYRM_SCALE_BOOTS_DEFENSE.get();
        goldenBookWyrmScaleHelmetDefense = GOLDEN_BOOK_WYRM_SCALE_HELMET_DEFENSE.get();
        goldenBookWyrmScaleChestplateDefense = GOLDEN_BOOK_WYRM_SCALE_CHESTPLATE_DEFENSE.get();
        goldenBookWyrmScaleLeggingsDefense = GOLDEN_BOOK_WYRM_SCALE_LEGGINGS_DEFENSE.get();
        goldenBookWyrmScaleBootsDefense = GOLDEN_BOOK_WYRM_SCALE_BOOTS_DEFENSE.get();
        materialUmbriumDamage = MATERIAL_UMBRIUM_DAMAGE.get();
        materialUmbriumHarvestSpeed = MATERIAL_UMBRIUM_HARVEST_SPEED.get();
        materialUmbriumDurability = MATERIAL_UMBRIUM_DURABILITY.get();
        materialUmbriumHarvestLevel = MATERIAL_UMBRIUM_HARVEST_LEVEL.get();
        materialScarliteDamage = MATERIAL_SCARLITE_DAMAGE.get();
        materialScarliteHarvestSpeed = MATERIAL_SCARLITE_HARVEST_SPEED.get();
        materialScarliteDurability = MATERIAL_SCARLITE_DURABILITY.get();
        materialScarliteHarvestLevel = MATERIAL_SCARLITE_HARVEST_LEVEL.get();
        materialScarliteRazorDamage = MATERIAL_SCARLITE_RAZOR_DAMAGE.get();
        materialScarliteRazorHarvestSpeed = MATERIAL_SCARLITE_RAZOR_HARVEST_SPEED.get();
        materialScarliteRazorDurability = MATERIAL_SCARLITE_RAZOR_DURABILITY.get();
        materialScarliteRazorHarvestLevel = MATERIAL_SCARLITE_RAZOR_HARVEST_LEVEL.get();
        materialRavagingDamage = MATERIAL_RAVAGING_DAMAGE.get();
        materialRavagingHarvestSpeed = MATERIAL_RAVAGING_HARVEST_SPEED.get();
        materialRavagingDurability = MATERIAL_RAVAGING_DURABILITY.get();
        materialRavagingHarvestLevel = MATERIAL_RAVAGING_HARVEST_LEVEL.get();
        enchantmentDestructiveStrength = ENCHANTMENT_DESTRUCTIVE_STRENGTH.get();
        enchantmentDestructiveLevel =  ENCHANTMENT_DESTRUCTIVE_LEVEL.get();
        bookWyrmBlacklist = new HashSet<>(BOOK_WYRM_BLACKLIST.get());
        bookWyrmBlacklistIsWhitelist = BOOK_WYRM_BLACKLIST_IS_WHITELIST.get();
    }
    
    @SubscribeEvent
    static void onLoad(final ModConfigEvent event) {
        if (event.getConfig().getSpec() != ConfigHolder.configCommonSpec) return;
        CommonConfig config = ConfigHolder.common;
        config.bake();
    }
}