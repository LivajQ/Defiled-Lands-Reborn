package com.euphony.defiled_lands_reborn.common.item.tool;//

import com.euphony.defiled_lands_reborn.common.tag.DLItemTags;
import com.euphony.defiled_lands_reborn.config.ConfigHolder;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

public interface DLToolMaterials {
    
    Tier UMBRIUM = new DynamicTier(
            () -> ConfigHolder.common.materialUmbriumHarvestLevel,
            () -> ConfigHolder.common.materialUmbriumDurability,
            () -> (float) ConfigHolder.common.materialUmbriumHarvestSpeed,
            () -> (float) ConfigHolder.common.materialUmbriumDamage,
            () -> 14,
            BlockTags.NEEDS_IRON_TOOL,
            () -> Ingredient.of(DLItemTags.UMBRIUM_TOOL_MATERIALS)
    );
    
    Tier SCARLITE = new DynamicTier(
            () -> ConfigHolder.common.materialScarliteHarvestLevel,
            () -> ConfigHolder.common.materialScarliteDurability,
            () -> (float) ConfigHolder.common.materialScarliteHarvestSpeed,
            () -> (float) ConfigHolder.common.materialScarliteDamage,
            () -> 14,
            BlockTags.NEEDS_IRON_TOOL,
            () -> Ingredient.of(DLItemTags.SCARLITE_TOOL_MATERIALS)
    );
    
    Tier SCARLITE_RAZOR = new DynamicTier(
            () -> ConfigHolder.common.materialScarliteRazorHarvestLevel,
            () -> ConfigHolder.common.materialScarliteRazorDurability,
            () -> (float) ConfigHolder.common.materialScarliteRazorHarvestSpeed,
            () -> (float) ConfigHolder.common.materialScarliteRazorDamage,
            () -> 14,
            BlockTags.NEEDS_IRON_TOOL,
            () -> Ingredient.of(DLItemTags.SCARLITE_RAZOR_TOOL_MATERIALS)
    );
    
    Tier RAVAGING = new DynamicTier(
            () -> ConfigHolder.common.materialRavagingHarvestLevel,
            () -> ConfigHolder.common.materialRavagingDurability,
            () -> (float) ConfigHolder.common.materialRavagingHarvestSpeed,
            () -> (float) ConfigHolder.common.materialRavagingDamage,
            () -> 10,
            BlockTags.NEEDS_IRON_TOOL,
            () -> Ingredient.of(DLItemTags.RAVAGING_TOOL_MATERIALS)
    );
}

final class DynamicTier implements Tier {
    
    private final Supplier<Integer> level;
    private final Supplier<Integer> uses;
    private final Supplier<Float> speed;
    private final Supplier<Float> attackDamageBonus;
    private final Supplier<Integer> enchantmentValue;
    private final TagKey<Block> tag;
    private final Supplier<Ingredient> repairIngredient;
    
    public DynamicTier(
            Supplier<Integer> level,
            Supplier<Integer> uses,
            Supplier<Float> speed,
            Supplier<Float> attackDamageBonus,
            Supplier<Integer> enchantmentValue,
            TagKey<Block> tag,
            Supplier<Ingredient> repairIngredient
    ) {
        this.level = level;
        this.uses = uses;
        this.speed = speed;
        this.attackDamageBonus = attackDamageBonus;
        this.enchantmentValue = enchantmentValue;
        this.tag = tag;
        this.repairIngredient = repairIngredient;
    }
    
    @Override public int getLevel() { return level.get(); }
    @Override public int getUses() { return uses.get(); }
    @Override public float getSpeed() { return speed.get(); }
    @Override public float getAttackDamageBonus() { return attackDamageBonus.get(); }
    @Override public int getEnchantmentValue() { return enchantmentValue.get(); }
    @Override public Ingredient getRepairIngredient() { return repairIngredient.get(); }
    @Override public TagKey<Block> getTag() { return tag; }
}