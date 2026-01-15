package com.euphony.defiled_lands_reborn.common.init;

import com.euphony.defiled_lands_reborn.DefiledLandsReborn;
import com.euphony.defiled_lands_reborn.common.enchantment.*;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class DLEnchantments {
    
    public static final DeferredRegister<Enchantment> ENCHANTMENTS = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, DefiledLandsReborn.MOD_ID);
    
    public static final RegistryObject<Enchantment> SHARP_SHOOTER = ENCHANTMENTS.register("sharp_shooter", EnchantmentSharpshooter::new);
    
    public static final RegistryObject<Enchantment> ECONOMICAL = ENCHANTMENTS.register("economical", EnchantmentEconomical::new);
    
    public static final RegistryObject<Enchantment> DESTRUCTIVE = ENCHANTMENTS.register("destructive", EnchantmentDestructive::new);
    
    public static final RegistryObject<Enchantment> SAFE_GUARD = ENCHANTMENTS.register("safe_guard", EnchantmentSafeguard::new);
    
    public static final RegistryObject<Enchantment> BLAZING = ENCHANTMENTS.register("blazing", EnchantmentBlazing::new);
}