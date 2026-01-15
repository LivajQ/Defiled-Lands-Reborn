package com.euphony.defiled_lands_reborn.common.item;

import com.euphony.defiled_lands_reborn.common.entity.projectile.BlastemFruitProjectile;
import com.euphony.defiled_lands_reborn.common.entity.projectile.BlazingBlastemFruitProjectile;
import com.euphony.defiled_lands_reborn.common.init.DLEnchantments;
import com.euphony.defiled_lands_reborn.common.init.DLItems;
import com.euphony.defiled_lands_reborn.common.item.api.IEnchantDestructive;
import com.euphony.defiled_lands_reborn.common.tag.DLItemTags;
import com.euphony.defiled_lands_reborn.utils.ItemUtils;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;

import java.util.List;

public class UmbraBlasterItem extends GunItem implements IEnchantDestructive {
    public UmbraBlasterItem(Properties properties) {
        super(properties.durability(465));
    }
    
    @Override
    public boolean isValidRepairItem(ItemStack toRepair, ItemStack repair) {
        return repair.is(DLItems.UMBRIUM_INGOT.get());
    }
    
    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        RegistryAccess registryAccess = level.registryAccess();
        
        var infinityKey = registryAccess.registryOrThrow(Registries.ENCHANTMENT)
                .getResourceKey(Enchantments.INFINITY_ARROWS)
                .orElseThrow();
        
        boolean flag = player.isCreative()
                || ItemUtils.getEnchantmentLevel(registryAccess, stack, infinityKey) > 0;
        
        ItemStack ammo = findAmmo(player, new ItemStack(DLItems.BLASTEM_FRUIT.get()));
        
        if (ammo.isEmpty() && !flag) {
            return InteractionResultHolder.fail(stack);
        }
        
        level.playSound(null,
                player.getX(), player.getEyeY(), player.getZ(),
                SoundEvents.SNOWBALL_THROW, SoundSource.NEUTRAL,
                0.5F, 0.4F / (level.random.nextFloat() * 0.4F + 0.8F)
        );
        
        player.getCooldowns().addCooldown(stack.getItem(), 10);
        
        if (!level.isClientSide) {
            BlastemFruitProjectile projectile;
            
            var blazingKey = registryAccess.registryOrThrow(Registries.ENCHANTMENT)
                    .getResourceKey(DLEnchantments.BLAZING.get())
                    .orElseThrow();
            
            if (ammo.is(DLItems.BLAZING_BLASTEM_FRUIT.get())
                    || ItemUtils.getEnchantmentLevel(registryAccess, stack, blazingKey) > 0) {
                projectile = new BlazingBlastemFruitProjectile(level, player);
            } else {
                projectile = new BlastemFruitProjectile(level, player);
            }
            
            float i = getSharpshooterBonus(registryAccess, stack);
            projectile.shootFromRotation(player, player.getXRot(), player.getYRot(),
                    0.0F, 1.5F * i, 1.0F / i);
            
            var safeguardKey = registryAccess.registryOrThrow(Registries.ENCHANTMENT)
                    .getResourceKey(DLEnchantments.SAFE_GUARD.get())
                    .orElseThrow();
            
            if (ItemUtils.getEnchantmentLevel(registryAccess, stack, safeguardKey) > 0) {
                projectile.setDestructive(false);
            }
            
            float f = getDestructiveBonus(registryAccess, stack);
            projectile.setDamage(projectile.getDamage() * f);
            projectile.setExplosion(projectile.getExplosion() * f);
            
            level.addFreshEntity(projectile);
            
            stack.hurtAndBreak(1, player, p -> p.broadcastBreakEvent(hand));
        }
        
        consumeAmmo(stack, ammo, player, level.getRandom());
        player.awardStat(Stats.ITEM_USED.get(this));
        
        return InteractionResultHolder.success(stack);
    }
    
    @Override
    public boolean isAmmo(ItemStack stack) {
        return stack.is(DLItemTags.BLASTER_AMMO);
    }
    
    @Override
    public void appendHoverText(ItemStack stack, Level level, List<Component> tooltip, TooltipFlag flag) {
        ItemUtils.addTooltip(tooltip::add, "item.defiled_lands_reborn.umbra_blaster.tooltip");
    }
}
