package com.euphony.defiled_lands_reborn.common.item.armor;

import com.euphony.defiled_lands_reborn.DefiledLandsReborn;
import com.euphony.defiled_lands_reborn.common.tag.DLItemTags;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

public enum DLArmorMaterials implements ArmorMaterial {
    
    UMBRIUM(
            "umbrium",
            18,
            defense(1, 4, 5, 2),
            9,
            SoundEvents.ARMOR_EQUIP_IRON,
            0.0F,
            0.0F,
            () -> Ingredient.of(DLItemTags.REPAIRS_UMBRIUM_ARMOR)
    ),
    
    BOOK_WYRM_SCALE(
            "book_wyrm_scale",
            18,
            defense(1, 3, 4, 2),
            9,
            SoundEvents.ARMOR_EQUIP_LEATHER,
            0.0F,
            0.0F,
            () -> Ingredient.of(DLItemTags.REPAIRS_BOOK_WYRM_SCALE_ARMOR)
    ),
    
    GOLDEN_BOOK_WYRM_SCALE(
            "golden_book_wyrm_scale",
            18,
            defense(1, 3, 4, 2),
            9,
            SoundEvents.ARMOR_EQUIP_LEATHER,
            1.0F,
            0.0F,
            () -> Ingredient.of(DLItemTags.REPAIRS_GOLDEN_BOOK_WYRM_SCALE_ARMOR)
    );
    
    private final String name;
    private final int durabilityMultiplier;
    private final Map<ArmorItem.Type, Integer> defense;
    private final int enchantmentValue;
    private final SoundEvent equipSound;
    private final float toughness;
    private final float knockbackResistance;
    private final Supplier<Ingredient> repairIngredient;
    
    DLArmorMaterials(
            String name,
            int durabilityMultiplier,
            Map<ArmorItem.Type, Integer> defense,
            int enchantmentValue,
            SoundEvent equipSound,
            float toughness,
            float knockbackResistance,
            Supplier<Ingredient> repairIngredient
    ) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.defense = defense;
        this.enchantmentValue = enchantmentValue;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredient = repairIngredient;
    }
    
    private static Map<ArmorItem.Type, Integer> defense(int boots, int legs, int chest, int helmet) {
        Map<ArmorItem.Type, Integer> map = new EnumMap<>(ArmorItem.Type.class);
        map.put(ArmorItem.Type.BOOTS, boots);
        map.put(ArmorItem.Type.LEGGINGS, legs);
        map.put(ArmorItem.Type.CHESTPLATE, chest);
        map.put(ArmorItem.Type.HELMET, helmet);
        return map;
    }
    
    @Override
    public int getDurabilityForType(ArmorItem.Type type) {
        return durabilityMultiplier;
    }
    
    @Override
    public int getDefenseForType(ArmorItem.Type type) {
        return defense.getOrDefault(type, 0);
    }
    
    @Override
    public int getEnchantmentValue() {
        return enchantmentValue;
    }
    
    @Override
    public SoundEvent getEquipSound() {
        return equipSound;
    }
    
    @Override
    public Ingredient getRepairIngredient() {
        return repairIngredient.get();
    }
    
    @Override
    public String getName() {
        return DefiledLandsReborn.MOD_ID + ":" + name;
    }
    
    @Override
    public float getToughness() {
        return toughness;
    }
    
    @Override
    public float getKnockbackResistance() {
        return knockbackResistance;
    }
}
