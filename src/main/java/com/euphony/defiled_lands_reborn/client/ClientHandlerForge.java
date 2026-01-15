package com.euphony.defiled_lands_reborn.client;

import com.euphony.defiled_lands_reborn.DefiledLandsReborn;
import com.euphony.defiled_lands_reborn.common.block.CorruptedColoredFallingBlock;
import com.euphony.defiled_lands_reborn.common.init.DLBlocks;
import net.minecraft.world.item.BlockItem;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = DefiledLandsReborn.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ClientHandlerForge {
    
    @SubscribeEvent
    public static void registerBlockColors(RegisterColorHandlersEvent.Block event) {
        event.register(
                (state, world, pos, tintIndex) ->
                        ((CorruptedColoredFallingBlock) state.getBlock()).getDustColor(),
                DLBlocks.DEFILED_SAND.get(),
                DLBlocks.DEFILED_GRAVEL.get()
        );
    }
    
    @SubscribeEvent
    public static void registerItemColors(RegisterColorHandlersEvent.Item event) {
        event.register(
                (stack, tintIndex) ->
                        ((CorruptedColoredFallingBlock) ((BlockItem) stack.getItem()).getBlock()).getDustColor(),
                DLBlocks.DEFILED_SAND.get(),
                DLBlocks.DEFILED_GRAVEL.get()
        );
    }
}
