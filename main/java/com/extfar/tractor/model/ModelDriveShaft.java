package com.extfar.tractor.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * TractorWPlow.tcn - TechneToTabulaImporter
 * Created using Tabula 4.1.1
 */
public class ModelDriveShaft extends ModelBase {
    public ModelRenderer BackAxis;
    public ModelRenderer LeftWheel4;
    public ModelRenderer LeftWheelCenter;
    public ModelRenderer RightWeel1;
    public ModelRenderer RightWheel2;
    public ModelRenderer RightWheel3;
    public ModelRenderer LeftWheel3;
    public ModelRenderer RightWheel4;
    public ModelRenderer LeftWheel2;
    public ModelRenderer RightWheelCenter;
    public ModelRenderer LeftWeel1;
    public ModelRenderer AxisBlock1;
    public ModelRenderer AxisBlock2;

    public ModelDriveShaft() {
        this.textureWidth = 256;
        this.textureHeight = 256;
        this.LeftWheel2 = new ModelRenderer(this, 182, 0);
        this.LeftWheel2.setRotationPoint(13.0F, 19.0F, -12.0F);
        this.LeftWheel2.addBox(0.0F, 0.0F, 0.0F, 8, 5, 24, 0.0F);
        this.AxisBlock1 = new ModelRenderer(this, 0, 232);
        this.AxisBlock1.setRotationPoint(-3.0F, 9.0F, -3.0F);
        this.AxisBlock1.addBox(0.0F, 0.0F, 0.0F, 6, 6, 6, 0.0F);
        this.LeftWeel1 = new ModelRenderer(this, 182, 40);
        this.LeftWeel1.setRotationPoint(13.0F, 0.0F, 7.0F);
        this.LeftWeel1.addBox(0.0F, 0.0F, 0.0F, 8, 24, 5, 0.0F);
        this.BackAxis = new ModelRenderer(this, 30, 205);
        this.BackAxis.setRotationPoint(-18.0F, 10.0F, -2.0F);
        this.BackAxis.addBox(0.0F, 0.0F, 0.0F, 36, 4, 4, 0.0F);
        this.LeftWheelCenter = new ModelRenderer(this, 182, 80);
        this.LeftWheelCenter.setRotationPoint(13.0F, 12.0F, 0.0F);
        this.LeftWheelCenter.addBox(0.0F, -7.0F, -7.0F, 4, 14, 14, 0.0F);
        this.LeftWheel3 = new ModelRenderer(this, 182, 0);
        this.LeftWheel3.setRotationPoint(13.0F, 0.0F, -12.0F);
        this.LeftWheel3.addBox(0.0F, 0.0F, 0.0F, 8, 5, 24, 0.0F);
        this.RightWheel2 = new ModelRenderer(this, 182, 0);
        this.RightWheel2.setRotationPoint(-21.0F, 19.0F, -12.0F);
        this.RightWheel2.addBox(0.0F, 0.0F, 0.0F, 8, 5, 24, 0.0F);
        this.RightWheel3 = new ModelRenderer(this, 182, 0);
        this.RightWheel3.setRotationPoint(-13.0F, 12.0F, 0.0F);
        this.RightWheel3.addBox(-8.0F, -12.0F, -12.0F, 8, 5, 24, 0.0F);
        this.AxisBlock2 = new ModelRenderer(this, 29, 233);
        this.AxisBlock2.setRotationPoint(-1.0F, 8.0F, -4.0F);
        this.AxisBlock2.addBox(0.0F, 0.0F, 0.0F, 2, 8, 8, 0.0F);
        this.RightWeel1 = new ModelRenderer(this, 182, 40);
        this.RightWeel1.setRotationPoint(-21.0F, 0.0F, 7.0F);
        this.RightWeel1.addBox(0.0F, 0.0F, 0.0F, 8, 24, 5, 0.0F);
        this.RightWheel4 = new ModelRenderer(this, 182, 40);
        this.RightWheel4.setRotationPoint(-21.0F, 0.0F, -12.0F);
        this.RightWheel4.addBox(0.0F, 0.0F, 0.0F, 8, 24, 5, 0.0F);
        this.RightWheelCenter = new ModelRenderer(this, 182, 80);
        this.RightWheelCenter.setRotationPoint(-13.0F, 12.0F, 0.0F);
        this.RightWheelCenter.addBox(-4.0F, -7.0F, -7.0F, 4, 14, 14, 0.0F);
        this.LeftWheel4 = new ModelRenderer(this, 182, 40);
        this.LeftWheel4.setRotationPoint(13.0F, 0.0F, -12.0F);
        this.LeftWheel4.addBox(0.0F, 0.0F, 0.0F, 8, 24, 5, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.LeftWheel2.render(f5);
        this.AxisBlock1.render(f5);
        this.LeftWeel1.render(f5);
        this.BackAxis.render(f5);
        this.LeftWheelCenter.render(f5);
        this.LeftWheel3.render(f5);
        this.RightWheel2.render(f5);
        this.RightWheel3.render(f5);
        this.AxisBlock2.render(f5);
        this.RightWeel1.render(f5);
        this.RightWheel4.render(f5);
        this.RightWheelCenter.render(f5);
        this.LeftWheel4.render(f5);
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
