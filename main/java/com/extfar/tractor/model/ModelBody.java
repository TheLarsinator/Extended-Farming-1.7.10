package com.extfar.tractor.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * TractorWPlow.tcn - TechneToTabulaImporter
 * Created using Tabula 4.1.1
 */
public class ModelBody extends ModelBase {
    public ModelRenderer Pipe1;
    public ModelRenderer Pipe2;
    public ModelRenderer LeftLampConnector;
    public ModelRenderer RigthLamp;
    public ModelRenderer LeftLampHolder;
    public ModelRenderer RightLampHolder;
    public ModelRenderer LeftLamp;
    public ModelRenderer RightLampConnector;
    public ModelRenderer Hood;

    public ModelBody() {
        this.textureWidth = 256;
        this.textureHeight = 256;
        this.LeftLampHolder = new ModelRenderer(this, 15, 12);
        this.LeftLampHolder.setRotationPoint(9.0F, 13.0F, -15.0F);
        this.LeftLampHolder.addBox(0.0F, 0.0F, 0.0F, 4, 4, 3, 0.0F);
        this.RightLampHolder = new ModelRenderer(this, 0, 12);
        this.RightLampHolder.setRotationPoint(-13.0F, 13.0F, -15.0F);
        this.RightLampHolder.addBox(0.0F, 0.0F, 0.0F, 4, 4, 3, 0.0F);
        this.RightLampConnector = new ModelRenderer(this, 0, 5);
        this.RightLampConnector.setRotationPoint(-11.0F, 14.0F, -12.0F);
        this.RightLampConnector.addBox(0.0F, 0.0F, 0.0F, 3, 2, 2, 0.0F);
        this.RigthLamp = new ModelRenderer(this, 33, 8);
        this.RigthLamp.setRotationPoint(-12.0F, 14.0F, -16.0F);
        this.RigthLamp.addBox(0.0F, 0.0F, 0.0F, 2, 2, 2, 0.0F);
        this.Pipe2 = new ModelRenderer(this, 16, 215);
        this.Pipe2.setRotationPoint(7.5F, -1.0F, -4.0F);
        this.Pipe2.addBox(0.0F, 0.0F, 0.0F, 1, 10, 1, 0.0F);
        this.LeftLamp = new ModelRenderer(this, 33, 0);
        this.LeftLamp.setRotationPoint(10.0F, 14.0F, -16.0F);
        this.LeftLamp.addBox(0.0F, 0.0F, 0.0F, 2, 2, 2, 0.0F);
        this.Hood = new ModelRenderer(this, 39, 138);
        this.Hood.setRotationPoint(-8.0F, 10.0F, 18.0F);
        this.Hood.addBox(0.0F, 0.0F, -34.0F, 16, 14, 34, 0.0F);
        this.LeftLampConnector = new ModelRenderer(this, 14, 5);
        this.LeftLampConnector.setRotationPoint(8.0F, 14.0F, -12.0F);
        this.LeftLampConnector.addBox(0.0F, 0.0F, 0.0F, 3, 2, 2, 0.0F);
        this.Pipe1 = new ModelRenderer(this, 0, 214);
        this.Pipe1.setRotationPoint(6.5F, 7.0F, -5.0F);
        this.Pipe1.addBox(0.0F, 0.0F, 0.0F, 3, 10, 3, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.LeftLampHolder.render(f5);
        this.RightLampHolder.render(f5);
        this.RightLampConnector.render(f5);
        this.RigthLamp.render(f5);
        this.Pipe2.render(f5);
        this.LeftLamp.render(f5);
        this.Hood.render(f5);
        this.LeftLampConnector.render(f5);
        this.Pipe1.render(f5);
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
