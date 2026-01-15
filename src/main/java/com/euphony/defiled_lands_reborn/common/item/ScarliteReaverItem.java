package com.euphony.defiled_lands_reborn.common.item;

import com.euphony.defiled_lands_reborn.common.item.tool.DLToolMaterials;
import com.euphony.defiled_lands_reborn.utils.ItemUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import java.util.List;

public class ScarliteReaverItem extends Item {
    public ScarliteReaverItem(Properties properties) {
        super(properties.durability(DLToolMaterials.SCARLITE.getUses()));
    }
    
    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        attacker.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 3, 18));
        return super.hurtEnemy(stack, target, attacker);
    }
    
    @Override
    public void appendHoverText(ItemStack stack, Level level, List<Component> tooltip, TooltipFlag flag) {
        ItemUtils.addTooltip(tooltip::add, "item.defiled_lands_reborn.scarlite_reaver.tooltip");
    }
}
