package com.euphony.defiled_lands_reborn.utils;

import com.euphony.defiled_lands_reborn.common.item.armor.DLArmorMaterials;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.ChatFormatting;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.block.state.BlockState;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Consumer;

public class ItemUtils {
    public static void addTooltip(Consumer<Component> components, String key) {
        components.accept(Component.translatable(key).withStyle(ChatFormatting.GRAY));
    }

    public static void addTooltip(List<Component> components, String key) {
        components.add(Component.translatable(key).withStyle(ChatFormatting.GRAY));
    }
    
    public static int getEnchantmentLevel(RegistryAccess registryAccess, ItemStack stack, ResourceKey<Enchantment> enchantmentKey) {
        Enchantment ench = registryAccess.registryOrThrow(Registries.ENCHANTMENT).get(enchantmentKey);
        return ench == null ? 0 : stack.getEnchantmentLevel(ench);
    }
    
    public static ArmorItem dynamicArmor(DLArmorMaterials mat, ArmorItem.Type type, Item.Properties props) {
        return new ArmorItem(mat, type, props.defaultDurability(1)) {
            
            @Override
            public int getMaxDamage(ItemStack stack) {
                return mat.getDurabilityForType(type);
            }
            
            @Override
            public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot slot) {
                if (slot != type.getSlot()) return ImmutableMultimap.of();
                
                ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
                UUID uuid = DYNAMIC_ARMOR_UUIDS.get(type);
                
                builder.put(
                        Attributes.ARMOR,
                        new AttributeModifier(
                                uuid,
                                "Armor modifier",
                                mat.getDefenseForType(type),
                                AttributeModifier.Operation.ADDITION
                        )
                );
                
                builder.put(
                        Attributes.ARMOR_TOUGHNESS,
                        new AttributeModifier(
                                uuid,
                                "Armor toughness",
                                mat.getToughness(),
                                AttributeModifier.Operation.ADDITION
                        )
                );
                
                if (mat.getKnockbackResistance() > 0.0F) {
                    builder.put(
                            Attributes.KNOCKBACK_RESISTANCE,
                            new AttributeModifier(
                                    uuid,
                                    "Armor knockback resistance",
                                    mat.getKnockbackResistance(),
                                    AttributeModifier.Operation.ADDITION
                            )
                    );
                }
                
                return builder.build();
            }
        };
    }
    
    public static PickaxeItem dynamicPickaxe(Tier mat, int baseDamage, float baseSpeed, Item.Properties props) {
        return new PickaxeItem(mat, baseDamage, baseSpeed, props.defaultDurability(1)) {
            
            @Override
            public int getMaxDamage(ItemStack stack) {
                return mat.getUses();
            }
            
            @Override
            public float getDestroySpeed(ItemStack stack, BlockState state) {
                return state.is(BlockTags.MINEABLE_WITH_PICKAXE) ? mat.getSpeed() : 1.0F;
            }
            
            @Override
            public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot slot) {
                if (slot != EquipmentSlot.MAINHAND) return ImmutableMultimap.of();
                
                ImmutableMultimap.Builder<Attribute, AttributeModifier> b = ImmutableMultimap.builder();
                
                b.put(Attributes.ATTACK_DAMAGE,
                        new AttributeModifier(BASE_ATTACK_DAMAGE_UUID,
                                "Tool damage",
                                baseDamage + mat.getAttackDamageBonus(),
                                AttributeModifier.Operation.ADDITION));
                
                b.put(Attributes.ATTACK_SPEED,
                        new AttributeModifier(BASE_ATTACK_SPEED_UUID,
                                "Tool speed",
                                baseSpeed,
                                AttributeModifier.Operation.ADDITION));
                
                return b.build();
            }
        };
    }
    
    
    public static AxeItem dynamicAxe(Tier mat, float baseDamage, float baseSpeed, Item.Properties props) {
        return new AxeItem(mat, baseDamage, baseSpeed, props.defaultDurability(1)) {
            
            @Override
            public int getMaxDamage(ItemStack stack) {
                return mat.getUses();
            }
            
            @Override
            public float getDestroySpeed(ItemStack stack, BlockState state) {
                return state.is(BlockTags.MINEABLE_WITH_AXE) ? mat.getSpeed() : 1.0F;
            }
            
            @Override
            public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot slot) {
                if (slot != EquipmentSlot.MAINHAND) return ImmutableMultimap.of();
                
                ImmutableMultimap.Builder<Attribute, AttributeModifier> b = ImmutableMultimap.builder();
                
                b.put(Attributes.ATTACK_DAMAGE,
                        new AttributeModifier(BASE_ATTACK_DAMAGE_UUID,
                                "Tool damage",
                                baseDamage + mat.getAttackDamageBonus(),
                                AttributeModifier.Operation.ADDITION));
                
                b.put(Attributes.ATTACK_SPEED,
                        new AttributeModifier(BASE_ATTACK_SPEED_UUID,
                                "Tool speed",
                                baseSpeed,
                                AttributeModifier.Operation.ADDITION));
                
                return b.build();
            }
        };
    }
    
    public static ShovelItem dynamicShovel(Tier mat, float baseDamage, float baseSpeed, Item.Properties props) {
        return new ShovelItem(mat, baseDamage, baseSpeed, props.defaultDurability(1)) {
            
            @Override
            public int getMaxDamage(ItemStack stack) {
                return mat.getUses();
            }
            
            @Override
            public float getDestroySpeed(ItemStack stack, BlockState state) {
                return state.is(BlockTags.MINEABLE_WITH_SHOVEL) ? mat.getSpeed() : 1.0F;
            }
            
            @Override
            public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot slot) {
                if (slot != EquipmentSlot.MAINHAND) return ImmutableMultimap.of();
                
                ImmutableMultimap.Builder<Attribute, AttributeModifier> b = ImmutableMultimap.builder();
                
                b.put(Attributes.ATTACK_DAMAGE,
                        new AttributeModifier(BASE_ATTACK_DAMAGE_UUID,
                                "Tool damage",
                                baseDamage + mat.getAttackDamageBonus(),
                                AttributeModifier.Operation.ADDITION));
                
                b.put(Attributes.ATTACK_SPEED,
                        new AttributeModifier(BASE_ATTACK_SPEED_UUID,
                                "Tool speed",
                                baseSpeed,
                                AttributeModifier.Operation.ADDITION));
                
                return b.build();
            }
        };
    }
    
    public static HoeItem dynamicHoe(Tier mat, int baseDamage, float baseSpeed, Item.Properties props) {
        return new HoeItem(mat, baseDamage, baseSpeed, props.defaultDurability(1)) {
            
            @Override
            public int getMaxDamage(ItemStack stack) {
                return mat.getUses();
            }
            
            @Override
            public float getDestroySpeed(ItemStack stack, BlockState state) {
                return state.is(BlockTags.MINEABLE_WITH_HOE) ? mat.getSpeed() : 1.0F;
            }
            
            @Override
            public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot slot) {
                if (slot != EquipmentSlot.MAINHAND) return ImmutableMultimap.of();
                
                ImmutableMultimap.Builder<Attribute, AttributeModifier> b = ImmutableMultimap.builder();
                
                b.put(Attributes.ATTACK_DAMAGE,
                        new AttributeModifier(BASE_ATTACK_DAMAGE_UUID,
                                "Tool damage",
                                baseDamage + mat.getAttackDamageBonus(),
                                AttributeModifier.Operation.ADDITION));
                
                b.put(Attributes.ATTACK_SPEED,
                        new AttributeModifier(BASE_ATTACK_SPEED_UUID,
                                "Tool speed",
                                baseSpeed,
                                AttributeModifier.Operation.ADDITION));
                
                return b.build();
            }
        };
    }
    
    public static SwordItem dynamicSword(Tier mat, int baseDamage, float baseSpeed, Item.Properties props) {
        return new SwordItem(mat, baseDamage, baseSpeed, props.defaultDurability(1)) {
            
            @Override
            public int getMaxDamage(ItemStack stack) {
                return mat.getUses();
            }
            
            @Override
            public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot slot) {
                if (slot != EquipmentSlot.MAINHAND) return ImmutableMultimap.of();
                
                ImmutableMultimap.Builder<Attribute, AttributeModifier> b = ImmutableMultimap.builder();
                
                b.put(Attributes.ATTACK_DAMAGE,
                        new AttributeModifier(BASE_ATTACK_DAMAGE_UUID,
                                "Tool damage",
                                baseDamage + mat.getAttackDamageBonus(),
                                AttributeModifier.Operation.ADDITION));
                
                b.put(Attributes.ATTACK_SPEED,
                        new AttributeModifier(BASE_ATTACK_SPEED_UUID,
                                "Tool speed",
                                baseSpeed,
                                AttributeModifier.Operation.ADDITION));
                
                return b.build();
            }
        };
    }
    
    private static final Map<ArmorItem.Type, UUID> DYNAMIC_ARMOR_UUIDS = Map.of(
            ArmorItem.Type.HELMET,     UUID.fromString("2AD3F246-FEE1-4E67-B886-69FD380BB150"),
            ArmorItem.Type.CHESTPLATE, UUID.fromString("9F3D476D-C118-4544-8365-64846904B48E"),
            ArmorItem.Type.LEGGINGS,   UUID.fromString("D8499B04-0E66-4726-AB29-64469D734E0D"),
            ArmorItem.Type.BOOTS,      UUID.fromString("845DB27C-C624-495F-8C9F-6020A9A58B6B")
    );
}