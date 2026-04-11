package com.euphony.defiled_lands_reborn.common.item;

import com.euphony.defiled_lands_reborn.common.init.DLItems;
import com.euphony.defiled_lands_reborn.common.item.api.IEnchantDestructive;
import com.euphony.defiled_lands_reborn.config.ConfigHolder;
import com.euphony.defiled_lands_reborn.utils.ItemUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import java.util.List;

public class ConcussionSmasherItem extends Item implements IEnchantDestructive {
    public ConcussionSmasherItem(Properties properties) {
        super(properties.stacksTo(1).durability(50));
    }
    
    @Override
    public void appendHoverText(ItemStack stack, Level level, List<Component> tooltip, TooltipFlag flag) {
        ItemUtils.addTooltip(tooltip::add, "item.defiled_lands_preborn.concussion_smasher.tooltip");
    }
    
    @Override
    public void releaseUsing(ItemStack stack, Level level, LivingEntity entity, int timeLeft) {
        if (entity instanceof Player player) {
            int useDuration = getUseDuration(stack) - timeLeft;
            float strength = getExplosionStrength(useDuration);
            
            if (strength >= 0.1F) {
                if (!level.isClientSide) {
                    strength *= (float) (ConfigHolder.common.concussionSmasherStrength * getDestructiveBonus(level.registryAccess(), stack));
                    
                    level.explode(
                            entity,
                            player.damageSources().playerAttack(player),
                            null,
                            entity.getX(),
                            entity.getEyeY() - 0.1,
                            entity.getZ(),
                            strength,
                            false,
                            Level.ExplosionInteraction.NONE
                    );
                    
                    stack.hurtAndBreak(1, player, p -> p.broadcastBreakEvent(player.getUsedItemHand()));
                }
                
                player.awardStat(Stats.ITEM_USED.get(this));
            }
        }
    }
    
    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        player.startUsingItem(hand);
        return InteractionResultHolder.consume(stack);
    }
    
    @Override
    public void onUseTick(Level level, LivingEntity entity, ItemStack stack, int remainingUseTicks) {
        super.onUseTick(level, entity, stack, remainingUseTicks);
        
        int used = getUseDuration(stack) - remainingUseTicks;

        if (used >= 60) {
            releaseUsing(stack, level, entity, remainingUseTicks);
            entity.stopUsingItem();
        }
    }
    
    public static float getExplosionStrength(int charge) {
        float ratio = (float) charge / 60.0F;
        return Math.min(ratio, 1.0F);
    }
    
    @Override
    public int getMaxDamage(ItemStack stack) {
        return ConfigHolder.common.concussionSmasherDurability;
    }
    
    @Override
    public int getUseDuration(ItemStack stack) {
        return 72000;
    }
    
    @Override
    public boolean isValidRepairItem(ItemStack toRepair, ItemStack repair) {
        return repair.is(DLItems.UMBRIUM_INGOT.get());
    }
    
    @Override
    public boolean isEnchantable(ItemStack stack) {
        return true;
    }
    
    @Override
    public int getEnchantmentValue() {
        return 1;
    }
}
