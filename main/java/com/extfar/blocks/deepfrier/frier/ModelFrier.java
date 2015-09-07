package com.extfar.blocks.deepfrier.frier;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * Frier - Lars
 * Created using Tabula 4.1.1
 */
public class ModelFrier extends ModelBase {
    public ModelRenderer Backside;
    public ModelRenderer Display;
    public ModelRenderer Bottom;
    public ModelRenderer Side4;
    public ModelRenderer Side3;
    public ModelRenderer Side2;
    public ModelRenderer Side1;

    public ModelFrier() {
        this.textureWidth = 124;
        this.textureHeight = 64;
        this.Bottom = new ModelRenderer(this, 0, 0);
        this.Bottom.setRotationPoint(-7.0F, 23.0F, -7.0F);
        this.Bottom.addBox(0.0F, 0.0F, 0.0F, 14, 1, 14, 0.0F);
        this.Side2 = new ModelRenderer(this, 0, 0);
        this.Side2.setRotationPoint(-7.0F, 13.0F, -7.0F);
        this.Side2.addBox(0.0F, 0.0F, 0.0F, 1, 11, 14, 0.0F);
        this.Side1 = new ModelRenderer(this, 0, 0);
        this.Side1.setRotationPoint(6.0F, 13.0F, -7.0F);
        this.Side1.addBox(0.0F, 0.0F, 0.0F, 1, 11, 14, 0.0F);
        this.Side4 = new ModelRenderer(this, 0, 0);
        this.Side4.setRotationPoint(-7.0F, 13.0F, -7.0F);
        this.Side4.addBox(0.0F, 0.0F, 0.0F, 14, 11, 1, 0.0F);
        this.Backside = new ModelRenderer(this, 0, 34);
        this.Backside.setRotationPoint(-2.0F, 11.0F, 6.0F);
        this.Backside.addBox(0.0F, 0.0F, 0.0F, 4, 13, 2, 0.0F);
        this.Side3 = new ModelRenderer(this, 0, 0);
        this.Side3.setRotationPoint(-7.0F, 13.0F, 5.0F);
        this.Side3.addBox(0.0F, 0.0F, 0.0F, 14, 11, 2, 0.0F);
        this.Display = new ModelRenderer(this, 75, 0);
        this.Display.setRotationPoint(-7.0F, 8.0F, 3.0F);
        this.Display.addBox(0.0F, 0.0F, 0.0F, 14, 6, 6, -2.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.Bottom.render(f5);
        this.Side4.render(f5);
        this.Backside.render(f5);
        this.Display.render(f5);
        this.Side3.render(f5);
        this.Side2.render(f5);
        this.Side1.render(f5);
    }

    public void renderAll(float f5) { 
        this.Bottom.render(f5);
        this.Side4.render(f5);
        this.Backside.render(f5);
        this.Display.render(f5);
        this.Side3.render(f5);
        this.Side2.render(f5);
        this.Side1.render(f5);
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
