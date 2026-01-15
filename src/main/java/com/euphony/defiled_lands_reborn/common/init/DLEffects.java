package com.euphony.defiled_lands_reborn.common.init;

import com.euphony.defiled_lands_reborn.DefiledLandsReborn;
import com.euphony.defiled_lands_reborn.common.effect.BleedingEffect;
import com.euphony.defiled_lands_reborn.common.effect.GroundedEffect;
import com.euphony.defiled_lands_reborn.common.effect.VulnerabilityEffect;
import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class DLEffects {
    
    public static final DeferredRegister<MobEffect> EFFECTS =
            DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, DefiledLandsReborn.MOD_ID);
    
    public static final RegistryObject<MobEffect> VULNERABILITY =
            EFFECTS.register("vulnerability", VulnerabilityEffect::new);
    
    public static final RegistryObject<MobEffect> GROUNDED =
            EFFECTS.register("grounded", GroundedEffect::new);
    
    public static final RegistryObject<MobEffect> BLEEDING =
            EFFECTS.register("bleeding", BleedingEffect::new);
}
