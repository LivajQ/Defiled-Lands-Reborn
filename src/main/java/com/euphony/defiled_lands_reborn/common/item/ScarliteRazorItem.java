package com.euphony.defiled_lands_reborn.common.item;

import com.euphony.defiled_lands_reborn.common.item.tool.DLToolMaterials;
import com.euphony.defiled_lands_reborn.utils.ItemUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import java.util.List;

public class ScarliteRazorItem extends Item {
    public ScarliteRazorItem(Properties properties) {
        super(properties.durability(DLToolMaterials.SCARLITE_RAZOR.getUses()));
    }
    
    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity livingEntity) {
        if (level.isClientSide) return stack;
        
        if (livingEntity instanceof Player player) {
            DamageSource damageSource = player.damageSources().playerAttack(player);
            
            if (player.hurt(damageSource, 3f)) {
                player.getFoodData().eat(4, 0.4f);
                
                level.playSound(
                        null,
                        player.getX(),
                        player.getY(),
                        player.getZ(),
                        SoundEvents.PLAYER_BURP,
                        SoundSource.PLAYERS,
                        0.5f,
                        level.random.nextFloat() * 0.1f + 0.9f
                );
                
                player.awardStat(Stats.ITEM_USED.get(this));
                
                stack.hurtAndBreak(1, player, p -> p.broadcastBreakEvent(EquipmentSlot.MAINHAND));
            }
        }
        
        return stack;
    }
    
    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        
        if (player.canEat(false)) {
            player.startUsingItem(hand);
            return InteractionResultHolder.success(stack);
        }
        
        return InteractionResultHolder.fail(stack);
    }
    
    @Override
    public int getUseDuration(ItemStack stack) {
        return 12;
    }
    
    @Override
    public void appendHoverText(ItemStack stack, Level level, List<Component> tooltip, TooltipFlag flag) {
        ItemUtils.addTooltip(tooltip::add, "item.defiled_lands_reborn.scarlite_razor.tooltip");
    }
}
