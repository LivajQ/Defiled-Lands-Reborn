package com.euphony.defiled_lands_reborn.common.enchantment;

import com.euphony.defiled_lands_reborn.common.tag.DLItemTags;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class EnchantmentDestructive extends Enchantment {
    
    public EnchantmentDestructive() {
        super(Enchantment.Rarity.RARE, EnchantmentCategory.WEAPON, new EquipmentSlot[]{EquipmentSlot.MAINHAND});
    }
    
    @Override
    public int getMinCost(int level) {
        return 10 + level * 10;
    }
    
    @Override
    public int getMaxCost(int level) {
        return 25 + level * 8;
    }
    
    @Override
    public int getMaxLevel() {
        return 5;
    }
    
    @Override
    public boolean canEnchant(ItemStack stack) {
        return stack.is(DLItemTags.DESTRUCTIVE_AVAILABLE);
    }
}
