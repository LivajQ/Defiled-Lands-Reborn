package com.euphony.defiled_lands_reborn.common.item.armor;

import com.euphony.defiled_lands_reborn.DefiledLandsPreborn;
import com.euphony.defiled_lands_reborn.common.tag.DLItemTags;
import com.euphony.defiled_lands_reborn.config.ConfigHolder;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.Map;
import java.util.function.Supplier;

public enum DLArmorMaterials implements ArmorMaterial {
    
    UMBRIUM(
            "umbrium",
            () -> ConfigHolder.common.umbriumArmorDurabilityMultiplier,
            Map.of(
                    ArmorItem.Type.BOOTS,      () -> ConfigHolder.common.umbriumBootsDefense,
                    ArmorItem.Type.LEGGINGS,   () -> ConfigHolder.common.umbriumLeggingsDefense,
                    ArmorItem.Type.CHESTPLATE, () -> ConfigHolder.common.umbriumChestplateDefense,
                    ArmorItem.Type.HELMET,     () -> ConfigHolder.common.umbriumHelmetDefense
            ),
            () -> 9,
            SoundEvents.ARMOR_EQUIP_IRON,
            () -> (float) ConfigHolder.common.umbriumArmorToughness,
            () -> 0.0F,
            () -> Ingredient.of(DLItemTags.REPAIRS_UMBRIUM_ARMOR)
    ),
    
    BOOK_WYRM_SCALE(
            "book_wyrm_scale",
            () -> ConfigHolder.common.bookWyrmScaleArmorDurabilityMultiplier,
            Map.of(
                    ArmorItem.Type.BOOTS,      () -> ConfigHolder.common.bookWyrmScaleBootsDefense,
                    ArmorItem.Type.LEGGINGS,   () -> ConfigHolder.common.bookWyrmScaleLeggingsDefense,
                    ArmorItem.Type.CHESTPLATE, () -> ConfigHolder.common.bookWyrmScaleChestplateDefense,
                    ArmorItem.Type.HELMET,     () -> ConfigHolder.common.bookWyrmScaleHelmetDefense
            ),
            () -> 9,
            SoundEvents.ARMOR_EQUIP_LEATHER,
            () -> (float) ConfigHolder.common.bookWyrmScaleArmorToughness,
            () -> 0.0F,
            () -> Ingredient.of(DLItemTags.REPAIRS_BOOK_WYRM_SCALE_ARMOR)
    ),
    
    GOLDEN_BOOK_WYRM_SCALE(
            "golden_book_wyrm_scale",
            () -> ConfigHolder.common.goldenBookWyrmScaleArmorDurabilityMultiplier,
            Map.of(
                    ArmorItem.Type.BOOTS,      () -> ConfigHolder.common.goldenBookWyrmScaleBootsDefense,
                    ArmorItem.Type.LEGGINGS,   () -> ConfigHolder.common.goldenBookWyrmScaleLeggingsDefense,
                    ArmorItem.Type.CHESTPLATE, () -> ConfigHolder.common.goldenBookWyrmScaleChestplateDefense,
                    ArmorItem.Type.HELMET,     () -> ConfigHolder.common.goldenBookWyrmScaleHelmetDefense
            ),
            () -> 9,
            SoundEvents.ARMOR_EQUIP_LEATHER,
            () -> (float) ConfigHolder.common.goldenBookWyrmScaleArmorToughness,
            () -> 0.0F,
            () -> Ingredient.of(DLItemTags.REPAIRS_GOLDEN_BOOK_WYRM_SCALE_ARMOR)
    );
    
    private static final Map<ArmorItem.Type, Integer> BASE_DURABILITY = Map.of(
            ArmorItem.Type.BOOTS,      13,
            ArmorItem.Type.LEGGINGS,   15,
            ArmorItem.Type.CHESTPLATE, 16,
            ArmorItem.Type.HELMET,     11
    );
    
    private final String name;
    private final Supplier<Integer> durabilityMultiplier;
    private final Map<ArmorItem.Type, Supplier<Integer>> defense;
    private final Supplier<Integer> enchantmentValue;
    private final SoundEvent equipSound;
    private final Supplier<Float> toughness;
    private final Supplier<Float> knockbackResistance;
    private final Supplier<Ingredient> repairIngredient;
    
    DLArmorMaterials(
            String name,
            Supplier<Integer> durabilityMultiplier,
            Map<ArmorItem.Type, Supplier<Integer>> defense,
            Supplier<Integer> enchantmentValue,
            SoundEvent equipSound,
            Supplier<Float> toughness,
            Supplier<Float> knockbackResistance,
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
    
    @Override
    public int getDurabilityForType(ArmorItem.Type type) {
        return BASE_DURABILITY.get(type) * durabilityMultiplier.get();
    }
    
    @Override
    public int getDefenseForType(ArmorItem.Type type) {
        return defense.get(type).get();
    }
    
    @Override
    public int getEnchantmentValue() {
        return enchantmentValue.get();
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
        return DefiledLandsPreborn.MOD_ID + ":" + name;
    }
    
    @Override
    public float getToughness() {
        return toughness.get();
    }
    
    @Override
    public float getKnockbackResistance() {
        return knockbackResistance.get();
    }
}