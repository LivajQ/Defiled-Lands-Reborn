package com.euphony.defiled_lands_reborn.client.model;

import com.euphony.defiled_lands_reborn.common.entity.BookWyrm;
import com.euphony.defiled_lands_reborn.utils.Utils;
import net.minecraft.client.model.QuadrupedModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public class BookWyrmModel extends QuadrupedModel<BookWyrm> {
    
    public static final ModelLayerLocation MODEL =
            new ModelLayerLocation(Utils.prefix("book_wyrm"), "main");
    
    public BookWyrmModel(ModelPart root) {
        super(root, false, 6.0F, 0.0F, 2.0F, 2.0F, 24);
    }
    
    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();
        
        root.addOrReplaceChild("head",
                CubeListBuilder.create()
                        .texOffs(0, 0).addBox(-3, -3, -6, 6, 6, 6)
                        .texOffs(0, 12).addBox("mouth", -2, -1, -12, 4, 3, 6),
                PartPose.offset(0, 17, -6));
        
        root.addOrReplaceChild("body",
                CubeListBuilder.create().texOffs(32, 10).addBox(-5, -10, -2, 10, 16, 6),
                PartPose.offsetAndRotation(0, 20, 3, ((float)Math.PI / 2F), 0.0F, 0.0F));
        
        CubeListBuilder leg = CubeListBuilder.create().texOffs(0, 22).addBox(-2, 0, -2, 4, 6, 4);
        CubeListBuilder legMirrored = CubeListBuilder.create().texOffs(0, 22).mirror().addBox(-2, 0, -2, 4, 6, 4);
        
        root.addOrReplaceChild("right_hind_leg", leg, PartPose.offset(-7, 18, 7));
        root.addOrReplaceChild("left_hind_leg", legMirrored, PartPose.offset(7, 18, 7));
        root.addOrReplaceChild("right_front_leg", leg, PartPose.offset(-7, 18, -5));
        root.addOrReplaceChild("left_front_leg", legMirrored, PartPose.offset(7, 18, -5));
        
        return LayerDefinition.create(mesh, 64, 32);
    }
}
