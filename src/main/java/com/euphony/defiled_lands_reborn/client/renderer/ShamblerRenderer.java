package com.euphony.defiled_lands_reborn.client.renderer;

import com.euphony.defiled_lands_reborn.common.entity.Shambler;
import com.euphony.defiled_lands_reborn.utils.Utils;
import net.minecraft.client.model.EndermanModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class ShamblerRenderer extends MobRenderer<Shambler, EndermanModel<Shambler>> {
    
    private static final ResourceLocation SHAMBLER_LOCATION =
            Utils.prefix("textures/entity/shambler.png");
    
    public ShamblerRenderer(EntityRendererProvider.Context context) {
        super(context, new EndermanModel<>(context.bakeLayer(ModelLayers.ENDERMAN)), 0.5F);
    }
    
    @Override
    public ResourceLocation getTextureLocation(Shambler entity) {
        return SHAMBLER_LOCATION;
    }
}
