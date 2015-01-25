package com.extfar.tractor.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * Engine - TheLarsinator
 * Created using Tabula 4.1.1
 */
public class ModelEngine extends ModelBase {
    public ModelRenderer shape3;
    public ModelRenderer shape1;
    public ModelRenderer shape2;
    public ModelRenderer shape4;
    public ModelRenderer shape7;
    public ModelRenderer shape6;
    public ModelRenderer shape5;
    public ModelRenderer shape8;
    public ModelRenderer shape9;
    public ModelRenderer shape10;
    public ModelRenderer shape11;
    public ModelRenderer shape12;
    public ModelRenderer shape14;

    public ModelEngine() {
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.shape8 = new ModelRenderer(this, 0, 0);
        this.shape8.setRotationPoint(0.0F, 15.0F, -5.0F);
        this.shape8.addBox(0.0F, 0.0F, 0.0F, 2, 1, 2, 0.0F);
        this.shape9 = new ModelRenderer(this, 0, 0);
        this.shape9.setRotationPoint(0.0F, 15.0F, -1.0F);
        this.shape9.addBox(0.0F, 0.0F, 0.0F, 2, 1, 2, 0.0F);
        this.shape1 = new ModelRenderer(this, 0, 0);
        this.shape1.setRotationPoint(-5.0F, 18.0F, -9.0F);
        this.shape1.addBox(0.0F, 0.0F, 0.0F, 10, 6, 14, 0.0F);
        this.shape6 = new ModelRenderer(this, 0, 0);
        this.shape6.setRotationPoint(-3.0F, 15.0F, 3.0F);
        this.shape6.addBox(0.0F, 0.0F, 0.0F, 2, 1, 2, 0.0F);
        this.shape10 = new ModelRenderer(this, 0, 0);
        this.shape10.setRotationPoint(-3.0F, 15.0F, -9.0F);
        this.shape10.addBox(0.0F, 0.0F, 0.0F, 2, 1, 2, 0.0F);
        this.shape11 = new ModelRenderer(this, 0, 0);
        this.shape11.setRotationPoint(-3.0F, 15.0F, -5.0F);
        this.shape11.addBox(0.0F, 0.0F, 0.0F, 2, 1, 2, 0.0F);
        this.shape3 = new ModelRenderer(this, 0, 0);
        this.shape3.setRotationPoint(-8.0F, 18.0F, -10.0F);
        this.shape3.addBox(0.0F, 0.0F, 0.0F, 5, 3, 16, 0.0F);
        this.setRotateAngle(shape3, 0.0F, 0.0F, -0.4553564018453205F);
        this.shape5 = new ModelRenderer(this, 0, 0);
        this.shape5.setRotationPoint(0.0F, 15.0F, -9.0F);
        this.shape5.addBox(0.0F, 0.0F, 0.0F, 2, 1, 2, 0.0F);
        this.shape14 = new ModelRenderer(this, 0, 0);
        this.shape14.setRotationPoint(-2.5F, 22.0F, 0.0F);
        this.shape14.addBox(0.0F, 0.0F, 0.0F, 4, 2, 8, 0.0F);
        this.shape4 = new ModelRenderer(this, 0, 0);
        this.shape4.setRotationPoint(-3.0F, 16.0F, -10.0F);
        this.shape4.addBox(0.0F, 0.0F, 0.0F, 5, 3, 16, 0.0F);
        this.shape12 = new ModelRenderer(this, 0, 0);
        this.shape12.setRotationPoint(-3.0F, 15.0F, -1.0F);
        this.shape12.addBox(0.0F, 0.0F, 0.0F, 2, 1, 2, 0.0F);
        this.shape2 = new ModelRenderer(this, 0, 0);
        this.shape2.setRotationPoint(7.0F, 18.0F, -10.0F);
        this.shape2.addBox(-5.0F, 0.0F, 0.0F, 5, 3, 16, 0.0F);
        this.setRotateAngle(shape2, 0.0F, 0.0F, 0.5009094953223726F);
        this.shape7 = new ModelRenderer(this, 0, 0);
        this.shape7.setRotationPoint(0.0F, 15.0F, 3.0F);
        this.shape7.addBox(0.0F, 0.0F, 0.0F, 2, 1, 2, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.shape8.render(f5);
        this.shape9.render(f5);
        this.shape1.render(f5);
        this.shape6.render(f5);
        this.shape10.render(f5);
        this.shape11.render(f5);
        this.shape3.render(f5);
        this.shape5.render(f5);
        this.shape14.render(f5);
        this.shape4.render(f5);
        this.shape12.render(f5);
        this.shape2.render(f5);
        this.shape7.render(f5);
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
