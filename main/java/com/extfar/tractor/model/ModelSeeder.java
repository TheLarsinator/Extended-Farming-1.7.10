package com.extfar.tractor.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * TractorWPlow.tcn - TechneToTabulaImporter
 * Created using Tabula 4.1.1
 */
public class ModelSeeder extends ModelBase {
    public ModelRenderer SeederPotFloor;
    public ModelRenderer SeederPot;
    public ModelRenderer SeederPot2;
    public ModelRenderer SeederPot3;
    public ModelRenderer SeederConnector;
    public ModelRenderer SeederPot4;
    public ModelRenderer SeederPipe3;
    public ModelRenderer SeederPipe;
    public ModelRenderer SeederPipe2;

    public ModelSeeder() {
        this.textureWidth = 256;
        this.textureHeight = 256;
        this.SeederPot2 = new ModelRenderer(this, 200, 131);
        this.SeederPot2.setRotationPoint(-8.0F, -1.0F, 7.0F);
        this.SeederPot2.addBox(0.0F, 0.0F, 0.0F, 16, 16, 1, 0.0F);
        this.SeederPipe3 = new ModelRenderer(this, 0, 200);
        this.SeederPipe3.setRotationPoint(0.0F, 21.7F, -0.5F);
        this.SeederPipe3.addBox(-2.5F, 0.0F, 0.0F, 5, 1, 1, 0.0F);
        this.SeederPipe = new ModelRenderer(this, 180, 167);
        this.SeederPipe.setRotationPoint(-2.0F, 14.0F, -2.0F);
        this.SeederPipe.addBox(0.0F, 0.0F, 0.0F, 4, 6, 4, 0.0F);
        this.SeederPot3 = new ModelRenderer(this, 200, 131);
        this.SeederPot3.setRotationPoint(-8.0F, -1.0F, 8.0F);
        this.SeederPot3.addBox(0.0F, 0.0F, -16.0F, 1, 16, 16, 0.0F);
        this.SeederConnector = new ModelRenderer(this, 200, 116);
        this.SeederConnector.setRotationPoint(-2.0F, 8.0F, -12.0F);
        this.SeederConnector.addBox(0.0F, 0.0F, 0.0F, 4, 4, 8, 0.0F);
        this.setRotateAngle(SeederConnector, -0.31869712141416456F, 0.0F, 0.0F);
        this.SeederPot4 = new ModelRenderer(this, 200, 131);
        this.SeederPot4.setRotationPoint(7.0F, -1.0F, 8.0F);
        this.SeederPot4.addBox(0.0F, 0.0F, -16.0F, 1, 16, 16, 0.0F);
        this.SeederPotFloor = new ModelRenderer(this, 186, 169);
        this.SeederPotFloor.setRotationPoint(-8.0F, 14.0F, 8.0F);
        this.SeederPotFloor.addBox(0.0F, 0.0F, -16.0F, 16, 1, 16, 0.0F);
        this.SeederPot = new ModelRenderer(this, 200, 131);
        this.SeederPot.setRotationPoint(-8.0F, -1.0F, -8.0F);
        this.SeederPot.addBox(0.0F, 0.0F, 0.0F, 16, 16, 1, 0.0F);
        this.SeederPipe2 = new ModelRenderer(this, 0, 200);
        this.SeederPipe2.setRotationPoint(-0.5F, 18.7F, -0.5F);
        this.SeederPipe2.addBox(0.0F, 0.0F, 0.0F, 1, 3, 1, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.SeederPot2.render(f5);
        this.SeederPipe3.render(f5);
        this.SeederPipe.render(f5);
        this.SeederPot3.render(f5);
        this.SeederConnector.render(f5);
        this.SeederPot4.render(f5);
        this.SeederPotFloor.render(f5);
        this.SeederPot.render(f5);
        this.SeederPipe2.render(f5);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
