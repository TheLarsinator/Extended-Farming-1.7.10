package com.extfar.tractor.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * TractorWPlow.tcn - TechneToTabulaImporter
 * Created using Tabula 4.1.1
 */
public class ModelChair extends ModelBase {
    public ModelRenderer ChairBack;
    public ModelRenderer Chair;
    public ModelRenderer ChairPanel1;
    public ModelRenderer ChairPanel2;

    public ModelChair() {
        this.textureWidth = 256;
        this.textureHeight = 256;
        this.ChairBack = new ModelRenderer(this, 200, 200);
        this.ChairBack.setRotationPoint(-6.5F, 13.0F, 5.0F);
        this.ChairBack.addBox(0.0F, 0.0F, 0.0F, 13, 2, 2, 0.0F);
        this.Chair = new ModelRenderer(this, 200, 210);
        this.Chair.setRotationPoint(-6.5F, 15.0F, -4.0F);
        this.Chair.addBox(0.0F, 0.0F, 0.0F, 13, 1, 11, 0.0F);
        this.ChairPanel2 = new ModelRenderer(this, 63, 0);
        this.ChairPanel2.setRotationPoint(-6.0F, 16.0F, -4.0F);
        this.ChairPanel2.addBox(0.0F, 0.0F, 0.0F, 2, 8, 10, 0.0F);
        this.ChairPanel1 = new ModelRenderer(this, 93, 0);
        this.ChairPanel1.setRotationPoint(4.0F, 16.0F, -4.0F);
        this.ChairPanel1.addBox(0.0F, 0.0F, 0.0F, 2, 8, 10, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.ChairBack.render(f5);
        this.Chair.render(f5);
        this.ChairPanel2.render(f5);
        this.ChairPanel1.render(f5);
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
