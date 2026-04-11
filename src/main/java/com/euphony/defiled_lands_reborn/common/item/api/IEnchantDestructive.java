package com.euphony.defiled_lands_reborn.common.item.api;

import com.euphony.defiled_lands_reborn.common.init.DLEnchantments;
import com.euphony.defiled_lands_reborn.config.ConfigHolder;
import com.euphony.defiled_lands_reborn.utils.ItemUtils;
import net.minecraft.core.RegistryAccess;
import net.minecraft.world.item.ItemStack;

public interface IEnchantDestructive {
    default float getDestructiveBonus(RegistryAccess registryAccess, ItemStack stack) {
        int level = ItemUtils.getEnchantmentLevel(registryAccess, stack, DLEnchantments.DESTRUCTIVE.getKey());
        if (level > 0) return (float) (1.0F + (level + 1) * ConfigHolder.common.enchantmentDestructiveStrength);
        else return 1.0F;
    }
}