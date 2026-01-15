package com.euphony.defiled_lands_reborn.common.item;

import com.euphony.defiled_lands_reborn.common.init.DLEnchantments;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.Registries;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.Level;

public abstract class GunItem extends Item {
    public GunItem(Properties properties) {
        super(properties);
    }
    
    @Override
    public boolean isEnchantable(ItemStack stack) {
        return true;
    }
    
    @Override
    public int getEnchantmentValue() {
        return 1;
    }
    
    protected float getSharpshooterBonus(RegistryAccess registryAccess, ItemStack gun) {
        Enchantment sharpShooter = registryAccess.registryOrThrow(Registries.ENCHANTMENT).get(DLEnchantments.SHARP_SHOOTER.getId());
        
        int sharpShooterLevel = gun.getEnchantmentLevel(sharpShooter);
        return 1.0F + 0.5F * sharpShooterLevel;
    }
    
    protected void consumeAmmo(ItemStack gun, ItemStack ammo, Player player, RandomSource rand) {
        Level level = player.level();
        Enchantment economical = level.registryAccess().registryOrThrow(Registries.ENCHANTMENT).get(DLEnchantments.ECONOMICAL.getId());
        int economicalLevel = gun.getEnchantmentLevel(economical);
        
        if (economicalLevel > 0 && rand.nextInt(economicalLevel + 2) > 1) {
            return;
        }
        
        if (!player.getAbilities().instabuild) {
            ammo.shrink(1);
        }
    }
    
    protected abstract boolean isAmmo(ItemStack stack);
    
    protected ItemStack findAmmo(Player player, ItemStack defaultAmmo) {
        if (isAmmo(player.getItemInHand(InteractionHand.OFF_HAND))) {
            return player.getItemInHand(InteractionHand.OFF_HAND);
        }
        else if (isAmmo(player.getItemInHand(InteractionHand.MAIN_HAND))) {
            return player.getItemInHand(InteractionHand.MAIN_HAND);
        }
        
        for (int i = 0; i < player.getInventory().getContainerSize(); i++) {
            ItemStack stack = player.getInventory().getItem(i);
            if (isAmmo(stack)) {
                return stack;
            }
        }
        
        if (player.isCreative()) {
            return defaultAmmo;
        }
        
        return ItemStack.EMPTY;
    }
}
