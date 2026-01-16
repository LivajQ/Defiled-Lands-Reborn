package com.euphony.defiled_lands_reborn.client;

import com.euphony.defiled_lands_reborn.DefiledLandsReborn;
import com.euphony.defiled_lands_reborn.client.model.BookWyrmModel;
import com.euphony.defiled_lands_reborn.client.renderer.*;
import com.euphony.defiled_lands_reborn.client.renderer.boss.DestroyerBossRenderer;
import com.euphony.defiled_lands_reborn.client.renderer.boss.MournerBossRenderer;
import com.euphony.defiled_lands_reborn.common.init.DLBlocks;
import com.euphony.defiled_lands_reborn.common.init.DLEntities;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.client.event.EntityRenderersEvent;

@Mod.EventBusSubscriber(modid = DefiledLandsReborn.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientHandler {
    
    @SubscribeEvent
    public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(DLEntities.DEFILED_SLIME.get(), DefiledSlimeRenderer::new);
        event.registerEntityRenderer(DLEntities.BOOK_WYRM.get(), BookWyrmRenderer::new);
        event.registerEntityRenderer(DLEntities.GOLDEN_BOOK_WYRM.get(), GoldenBookWyrmRenderer::new);
        event.registerEntityRenderer(DLEntities.SCUTTLER.get(), ScuttlerRenderer::new);
        event.registerEntityRenderer(DLEntities.HOST.get(), HostRenderer::new);
        event.registerEntityRenderer(DLEntities.SHAMBLER.get(), ShamblerRenderer::new);
        event.registerEntityRenderer(DLEntities.TWISTED_SHAMBLER.get(), TwistedShamblerRenderer::new);
        
        event.registerEntityRenderer(DLEntities.MOURNER.get(), MournerBossRenderer::new);
        event.registerEntityRenderer(DLEntities.DESTROYER.get(), DestroyerBossRenderer::new);
        
        event.registerEntityRenderer(DLEntities.RAVAGER_PROJECTILE.get(), ThrownItemRenderer::new);
        event.registerEntityRenderer(DLEntities.BLASTEM_FRUIT_PROJECTILE.get(), ThrownItemRenderer::new);
        event.registerEntityRenderer(DLEntities.BLAZING_BLASTEM_FRUIT_PROJECTILE.get(), ThrownItemRenderer::new);
        
        ItemBlockRenderTypes.setRenderLayer(DLBlocks.VILESPINE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(DLBlocks.BLASTEM.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(DLBlocks.SCURONOTTE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(DLBlocks.TENEBRA_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(DLBlocks.TENEBRA_DOOR.get(), RenderType.cutout());
    }
    
    @SubscribeEvent
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(BookWyrmModel.MODEL, BookWyrmModel::createBodyLayer);
    }
}
