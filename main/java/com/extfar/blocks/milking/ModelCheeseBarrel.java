package com.extfar.blocks.milking;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * CheeseBarrel - Undefined
 * Created using Tabula 4.1.1
 */
public class ModelCheeseBarrel extends ModelBase {
    public ModelRenderer bottom;
    public ModelRenderer Side3;
    public ModelRenderer Side2;
    public ModelRenderer Side4;
    public ModelRenderer Side1;
    public ModelRenderer Cheese1;
    public ModelRenderer Cheese2;
    public ModelRenderer Cheese3;

    public ModelCheeseBarrel() {
        this.textureWidth = 256;
        this.textureHeight = 128;
        this.Cheese1 = new ModelRenderer(this, 50, 51);
        this.Cheese1.setRotationPoint(-5.5F, 22.0F, -5.5F);
        this.Cheese1.addBox(0.0F, 0.0F, 0.0F, 11, 2, 11, 0.0F);
        this.Side1 = new ModelRenderer(this, 0, 0);
        this.Side1.setRotationPoint(-7.0F, 13.0F, -7.0F);
        this.Side1.addBox(0.0F, 0.0F, 0.0F, 14, 10, 1, 0.0F);
        this.Side3 = new ModelRenderer(this, 0, 0);
        this.Side3.setRotationPoint(-7.0F, 13.0F, 6.0F);
        this.Side3.addBox(0.0F, 0.0F, 0.0F, 14, 10, 1, 0.0F);
        this.Cheese2 = new ModelRenderer(this, 50, 72);
        this.Cheese2.setRotationPoint(-5.5F, 20.0F, -5.5F);
        this.Cheese2.addBox(0.0F, 0.0F, 0.0F, 11, 2, 11, 0.0F);
        this.bottom = new ModelRenderer(this, 45, 0);
        this.bottom.setRotationPoint(-7.0F, 23.0F, -7.0F);
        this.bottom.addBox(0.0F, 0.0F, 0.0F, 14, 1, 14, 0.0F);
        this.Cheese3 = new ModelRenderer(this, 50, 92);
        this.Cheese3.setRotationPoint(-5.5F, 18.0F, -5.5F);
        this.Cheese3.addBox(0.0F, 0.0F, 0.0F, 11, 2, 11, 0.0F);
        this.Side4 = new ModelRenderer(this, 0, 30);
        this.Side4.setRotationPoint(6.0F, 13.0F, -7.0F);
        this.Side4.addBox(0.0F, 0.0F, 0.0F, 1, 10, 14, 0.0F);
        this.Side2 = new ModelRenderer(this, 0, 30);
        this.Side2.setRotationPoint(-7.0F, 13.0F, -7.0F);
        this.Side2.addBox(0.0F, 0.0F, 0.0F, 1, 10, 14, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.Side3.render(f5);
        this.Side1.render(f5);
        this.Cheese2.render(f5);
        this.Side4.render(f5);
        this.Cheese1.render(f5);
        this.bottom.render(f5);
        this.Cheese3.render(f5);
        this.Side2.render(f5);
    }
    public void renderAll(float f5) { 
        this.Side3.render(f5);
        this.Side1.render(f5);
        this.Cheese2.render(f5);
        this.Side4.render(f5);
        this.Cheese1.render(f5);
        this.bottom.render(f5);
        this.Cheese3.render(f5);
        this.Side2.render(f5);
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
