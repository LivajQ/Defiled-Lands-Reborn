package com.euphony.defiled_lands_reborn.client.layer;

import com.euphony.defiled_lands_reborn.utils.Utils;
import net.minecraft.client.model.SpiderModel;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.world.entity.monster.Spider;

public class ScuttlerEyesLayer<T extends Spider, M extends SpiderModel<T>>
        extends EyesLayer<T, M> {
    
    private static final RenderType SCUTTLER_EYES =
            RenderType.eyes(Utils.prefix("textures/entity/scuttler_eyes.png"));
    
    public ScuttlerEyesLayer(RenderLayerParent<T, M> parent) {
        super(parent);
    }
    
    @Override
    public RenderType renderType() {
        return SCUTTLER_EYES;
    }
}
