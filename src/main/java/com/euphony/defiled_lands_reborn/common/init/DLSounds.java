package com.euphony.defiled_lands_reborn.common.init;

import com.euphony.defiled_lands_reborn.DefiledLandsReborn;
import com.euphony.defiled_lands_reborn.utils.Utils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class DLSounds {
    
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, DefiledLandsReborn.MOD_ID);
    public static final RegistryObject<SoundEvent> WYRM_IDLE = register("entity.bookwyrm.idle");
    public static final RegistryObject<SoundEvent> WYRM_HURT = register("entity.bookwyrm.hurt");
    public static final RegistryObject<SoundEvent> WYRM_DEATH = register("entity.bookwyrm.death");
    //public static final RegistryObject<SoundEvent> WYRM_BOOK = register("entity.bookwyrm.book");
    //public static final RegistryObject<SoundEvent> WYRM_INDIGESTION = register("entity.bookwyrm.indigestion");
    //public static final RegistryObject<SoundEvent> MUTAGEN = register("item.wyrmutagen.use");
    
    private static RegistryObject<SoundEvent> register(String name) {
        ResourceLocation id = Utils.prefix(name);
        return SOUNDS.register(name, () -> SoundEvent.createVariableRangeEvent(id));
    }
}
