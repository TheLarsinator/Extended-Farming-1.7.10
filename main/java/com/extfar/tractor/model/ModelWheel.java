package com.extfar.tractor.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * TractorWPlow.tcn - TechneToTabulaImporter
 * Created using Tabula 4.1.1
 */
public class ModelWheel extends ModelBase {
    public ModelRenderer LeftWheel4;
    public ModelRenderer LeftWheelCenter;
    public ModelRenderer LeftWheel3;
    public ModelRenderer LeftWheel2;
    public ModelRenderer LeftWeel1;

    public ModelWheel() {
        this.textureWidth = 256;
        this.textureHeight = 256;
        this.LeftWheel2 = new ModelRenderer(this, 182, 0);
        this.LeftWheel2.setRotationPoint(-3.0F, 19.0F, -12.0F);
        this.LeftWheel2.addBox(0.0F, 0.0F, 0.0F, 8, 5, 24, 0.0F);
        this.LeftWheel4 = new ModelRenderer(this, 182, 40);
        this.LeftWheel4.setRotationPoint(-3.0F, 0.0F, -12.0F);
        this.LeftWheel4.addBox(0.0F, 0.0F, 0.0F, 8, 24, 5, 0.0F);
        this.LeftWeel1 = new ModelRenderer(this, 182, 40);
        this.LeftWeel1.setRotationPoint(-3.0F, 0.0F, 7.0F);
        this.LeftWeel1.addBox(0.0F, 0.0F, 0.0F, 8, 24, 5, 0.0F);
        this.LeftWheel3 = new ModelRenderer(this, 182, 0);
        this.LeftWheel3.setRotationPoint(-3.0F, 0.0F, -12.0F);
        this.LeftWheel3.addBox(0.0F, 0.0F, 0.0F, 8, 5, 24, 0.0F);
        this.LeftWheelCenter = new ModelRenderer(this, 182, 80);
        this.LeftWheelCenter.setRotationPoint(-3.0F, 12.0F, 0.0F);
        this.LeftWheelCenter.addBox(0.0F, -7.0F, -7.0F, 4, 14, 14, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.LeftWheel2.render(f5);
        this.LeftWheel4.render(f5);
        this.LeftWeel1.render(f5);
        this.LeftWheel3.render(f5);
        this.LeftWheelCenter.render(f5);
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
