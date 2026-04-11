package com.euphony.defiled_lands_reborn.common.item;

import com.euphony.defiled_lands_reborn.common.item.tool.DLToolMaterials;
import com.euphony.defiled_lands_reborn.config.ConfigHolder;
import com.euphony.defiled_lands_reborn.utils.ItemUtils;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;

public class ScarliteReaverItem extends SwordItem {
    
    public ScarliteReaverItem(Properties properties) {
        super(DLToolMaterials.SCARLITE, 0, -2.4F, properties.durability(DLToolMaterials.SCARLITE.getUses()));
    }
    
    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        MobEffect effect = ForgeRegistries.MOB_EFFECTS.getValue(ConfigHolder.common.scarliteReaverEffectType);
        if (effect != null) attacker.addEffect(new MobEffectInstance(effect, ConfigHolder.common.scarliteReaverEffectDuration, ConfigHolder.common.scarliteReaverEffectLevel - 1));
        else attacker.addEffect(new MobEffectInstance(MobEffects.REGENERATION, ConfigHolder.common.scarliteReaverEffectDuration, ConfigHolder.common.scarliteReaverEffectLevel - 1));
        return super.hurtEnemy(stack, target, attacker);
    }
    
    @Override
    public int getMaxDamage(ItemStack stack) {
        return ConfigHolder.common.materialScarliteDurability;
    }
    
    @Override
    public void appendHoverText(ItemStack stack, Level level, List<Component> tooltip, TooltipFlag flag) {
        ItemUtils.addTooltip(tooltip::add, "item.defiled_lands_preborn.scarlite_reaver.tooltip");
    }
    
    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlot slot, ItemStack stack) {
        if (slot != EquipmentSlot.MAINHAND)
            return super.getAttributeModifiers(slot, stack);
        
        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();

        builder.put(
                Attributes.ATTACK_DAMAGE,
                new AttributeModifier(
                        BASE_ATTACK_DAMAGE_UUID,
                        "Weapon modifier",
                        ConfigHolder.common.scarliteReaverDamage,
                        AttributeModifier.Operation.ADDITION
                )
        );
        
        builder.put(
                Attributes.ATTACK_SPEED,
                new AttributeModifier(
                        BASE_ATTACK_SPEED_UUID,
                        "Weapon modifier",
                        ConfigHolder.common.scarliteReaverSpeed - 4,
                        AttributeModifier.Operation.ADDITION
                )
        );
        
        return builder.build();
    }
    
}