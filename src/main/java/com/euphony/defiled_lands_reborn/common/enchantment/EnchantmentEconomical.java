package com.euphony.defiled_lands_reborn.common.enchantment;

import com.euphony.defiled_lands_reborn.common.tag.DLItemTags;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class EnchantmentEconomical extends Enchantment {
    
    public EnchantmentEconomical() {
        super(Enchantment.Rarity.UNCOMMON, EnchantmentCategory.BOW, new EquipmentSlot[]{EquipmentSlot.MAINHAND});
    }
    
    @Override
    public int getMinCost(int level) {
        return 15 + level * 9;
    }
    
    @Override
    public int getMaxCost(int level) {
        return 65 + level * 9;
    }
    
    @Override
    public int getMaxLevel() {
        return 4;
    }
    
    @Override
    public boolean canEnchant(ItemStack stack) {
        return stack.is(DLItemTags.GUN_ENCHANTABLE);
    }
}
