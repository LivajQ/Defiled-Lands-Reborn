package com.euphony.defiled_lands_reborn.client.renderer.boss;

import com.euphony.defiled_lands_reborn.client.model.MournerModel;
import com.euphony.defiled_lands_reborn.common.entity.boss.MournerBoss;
import com.euphony.defiled_lands_reborn.utils.Utils;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Pose;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.common.MinecraftForge;

public class MournerBossRenderer extends MobRenderer<MournerBoss, MournerModel> {
    
    private static final ResourceLocation[] MOURNER_LOCATION = {
            Utils.prefix("textures/entity/the_mourner.png"),
            Utils.prefix("textures/entity/the_mourner_rage1.png"),
            Utils.prefix("textures/entity/the_mourner_rage2.png")
    };
    
    private static final ResourceLocation MOURNER_EXPLOSION_LOCATION =
            Utils.prefix("textures/entity/the_mourner_explosion.png");
    
    public static final RenderType DECAL = RenderType.entityDecal(MOURNER_LOCATION[0]);
    
    public MournerBossRenderer(EntityRendererProvider.Context context) {
        super(context, new MournerModel(context.bakeLayer(ModelLayers.PLAYER)), 0.5f);
    }
    
    @Override
    protected void setupRotations(MournerBoss entity, PoseStack poseStack,
                                  float ageInTicks, float rotationYaw, float partialTicks) {
        
        if (entity.deathTime > 0 || entity.isShaking) {
            rotationYaw += (float)(Math.cos(entity.tickCount * 3.25F) * Math.PI * 0.4F);
        }
        
        if (!entity.hasPose(Pose.SLEEPING)) {
            poseStack.mulPose(Axis.YP.rotationDegrees(180.0F - rotationYaw));
        }
        
        if (entity.isAutoSpinAttack()) {
            poseStack.mulPose(Axis.XP.rotationDegrees(-90.0F - entity.getXRot()));
            poseStack.mulPose(Axis.YP.rotationDegrees(entity.tickCount * -75.0F));
        }
        else if (entity.hasPose(Pose.SLEEPING)) {
            Direction direction = entity.getBedOrientation();
            float f1 = direction != null ? sleepDirectionToRotation(direction) : rotationYaw;
            poseStack.mulPose(Axis.YP.rotationDegrees(f1));
            poseStack.mulPose(Axis.ZP.rotationDegrees(this.getFlipDegrees(entity)));
            poseStack.mulPose(Axis.YP.rotationDegrees(270.0F));
        }
        else {
            String name = entity.getName().getString();
            if (name.equals("Dinnerbone") || name.equals("Grumm")) {
                poseStack.translate(0.0F, entity.getBbHeight() + 0.1F, 0.0F);
                poseStack.mulPose(Axis.ZP.rotationDegrees(180.0F));
            }
        }
    }
    
    private static float sleepDirectionToRotation(Direction facing) {
        return switch (facing) {
            case SOUTH -> 90.0F;
            case WEST -> 0.0F;
            case NORTH -> 270.0F;
            case EAST -> 180.0F;
            default -> 0.0F;
        };
    }
    
    @Override
    public void render(MournerBoss entity, float entityYaw, float partialTicks,
                       PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        
        RenderLivingEvent.Pre<MournerBoss, MournerModel> pre =
                new RenderLivingEvent.Pre<>(entity, this, partialTicks, poseStack, buffer, packedLight);
        
        if (MinecraftForge.EVENT_BUS.post(pre)) return;
        
        poseStack.pushPose();
        
        if (entity.hasPose(Pose.SLEEPING)) {
            Direction direction = entity.getBedOrientation();
            if (direction != null) {
                float f = entity.getEyeHeight() - 0.1F;
                poseStack.translate(-direction.getStepX() * f, 0.0F, -direction.getStepZ() * f);
            }
        }
        
        float scale = entity.getScale();
        poseStack.scale(scale, scale, scale);
        
        this.setupRotations(entity, poseStack, entity.tickCount + partialTicks, entityYaw, partialTicks);
        
        poseStack.scale(-1.0F, -1.0F, 1.0F);
        poseStack.translate(0.0F, -1.501F, 0.0F);
        
        this.model.setupAnim(entity, 0, 0, partialTicks, entity.getYRot(), entity.getXRot());
        
        boolean visible = this.isBodyVisible(entity);
        boolean outline = false;
        entity.isShaking = entity.deathTime > 0;
        
        RenderType type = this.getRenderType(entity, visible, outline, entity.isCurrentlyGlowing());
        
        if (type != null) {
            if (entity.deathTime > 0 || entity.getInvulTime() > 0) {
                
                float progress = entity.deathTime > 0
                        ? entity.deathTime / 200.0F
                        : entity.getInvulTime() / 200.0F;
                
                int argb = (Mth.floor(progress * 255.0F) << 24) | 0xFFFFFF;
                
                float a = ((argb >> 24) & 0xFF) / 255.0F;
                float r = ((argb >> 16) & 0xFF) / 255.0F;
                float g = ((argb >> 8) & 0xFF) / 255.0F;
                float b = (argb & 0xFF) / 255.0F;
                
                VertexConsumer explosion = buffer.getBuffer(RenderType.entityTranslucent(MOURNER_EXPLOSION_LOCATION));
                this.model.renderToBuffer(
                        poseStack, explosion, packedLight, OverlayTexture.NO_OVERLAY,
                        r, g, b, a
                );
                
                VertexConsumer decal = buffer.getBuffer(DECAL);
                this.model.renderToBuffer(
                        poseStack, decal, packedLight, OverlayTexture.NO_OVERLAY,
                        1.0F, 1.0F, 1.0F, 1.0F
                );
                
            } else {
                VertexConsumer normal = buffer.getBuffer(type);
                this.model.renderToBuffer(
                        poseStack, normal, packedLight, OverlayTexture.NO_OVERLAY,
                        1.0F, 1.0F, 1.0F, 1.0F
                );
            }
        }
        
        poseStack.popPose();
        
        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
        
        MinecraftForge.EVENT_BUS.post(new RenderLivingEvent.Post<>(entity, this, partialTicks, poseStack, buffer, packedLight));
    }
    
    @Override
    public ResourceLocation getTextureLocation(MournerBoss entity) {
        return MOURNER_LOCATION[entity.getRageFactor() - 1];
    }
}
