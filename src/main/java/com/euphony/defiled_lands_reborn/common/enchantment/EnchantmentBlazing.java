package com.euphony.defiled_lands_reborn.common.enchantment;

import com.euphony.defiled_lands_reborn.common.tag.DLItemTags;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class EnchantmentBlazing extends Enchantment {
    
    public EnchantmentBlazing() {
        super(Enchantment.Rarity.RARE, EnchantmentCategory.BOW, new EquipmentSlot[]{EquipmentSlot.MAINHAND});
    }
    
    @Override
    public int getMinCost(int level) {
        return 20;
    }
    
    @Override
    public int getMaxCost(int level) {
        return 50;
    }
    
    @Override
    public boolean canEnchant(ItemStack stack) {
        return stack.is(DLItemTags.BLASTER_ENCHANTABLE);
    }
}
