package com.euphony.defiled_lands_reborn;

import com.euphony.defiled_lands_reborn.common.init.*;
import com.euphony.defiled_lands_reborn.common.worldgen.DLRegion;
import com.euphony.defiled_lands_reborn.common.worldgen.DLSurfaceRuleData;
import com.euphony.defiled_lands_reborn.config.ConfigHolder;
import com.euphony.defiled_lands_reborn.integration.curios.CuriosCompat;
import com.euphony.defiled_lands_reborn.utils.Utils;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;

@Mod(DefiledLandsReborn.MOD_ID)
public class DefiledLandsReborn {
    
    public static final String MOD_ID = "defiled_lands_reborn";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);
    
    public DefiledLandsReborn() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        IEventBus forgeEventBus = MinecraftForge.EVENT_BUS;
        
        ConfigHolder.init(ModLoadingContext.get(), modEventBus);
        
        DLSounds.SOUNDS.register(modEventBus);
        
        DLBlocks.BLOCKS.register(modEventBus);
        DLItems.ITEMS.register(modEventBus);
        DLBlockEntities.BLOCK_ENTITY_TYPES.register(modEventBus);
        DLEntities.ENTITIES.register(modEventBus);
        DLEnchantments.ENCHANTMENTS.register(modEventBus);
        DLEffects.EFFECTS.register(modEventBus);
        DLCreativeTabs.TABS.register(modEventBus);
        DLRecipeTypes.RECIPE_SERIALIZERS.register(modEventBus);
        
        DLFoliagePlacers.PLACERS.register(modEventBus);
        DLTrunkPlacers.PLACERS.register(modEventBus);
        
        DLFeatures.FEATURES.register(modEventBus);
        
        modEventBus.addListener(this::commonSetup);
        
        if (Utils.isModLoaded("curios")) {
            forgeEventBus.addGenericListener(ItemStack.class, CuriosCompat::registerCapabilities);
        }
    }
    
    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            Regions.register(new DLRegion());
            SurfaceRuleManager.addSurfaceRules(
                    SurfaceRuleManager.RuleCategory.OVERWORLD,
                    MOD_ID,
                    DLSurfaceRuleData.makeRules()
            );
        });
    }
}
