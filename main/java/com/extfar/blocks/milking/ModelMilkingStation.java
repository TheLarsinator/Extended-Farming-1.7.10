package com.extfar.blocks.milking;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * MilkingStation - TheLarsinator
 * Created using Tabula 4.1.1
 */
public class ModelMilkingStation extends ModelBase 
{
    public ModelRenderer Bottom;
    public ModelRenderer Side1;
    public ModelRenderer Side2;
    public ModelRenderer Side3;
    public ModelRenderer Side4;
    public ModelRenderer Bar1;
    public ModelRenderer Bar2;
    public ModelRenderer Bar3;
    public ModelRenderer Bar4;
    public ModelRenderer Bar5;
    public ModelRenderer Bar6;
    public ModelRenderer Bar7;
    public ModelRenderer Bar8;
    public ModelRenderer Bar9;
    public ModelRenderer Bar10;
    public ModelRenderer Bar11;
    public ModelRenderer Bar12;

    public ModelMilkingStation() {
        this.textureWidth = 256;
        this.textureHeight = 256;
        this.Bar10 = new ModelRenderer(this, 0, 0);
        this.Bar10.setRotationPoint(-10.0F, -2.0F, -2.0F);
        this.Bar10.addBox(0.0F, 0.0F, 0.0F, 1, 7, 1, 0.0F);
        this.Bar8 = new ModelRenderer(this, 0, 0);
        this.Bar8.setRotationPoint(-10.0F, -2.0F, -8.0F);
        this.Bar8.addBox(0.0F, 0.0F, 0.0F, 1, 7, 1, 0.0F);
        this.Bottom = new ModelRenderer(this, 68, 0);
        this.Bottom.setRotationPoint(-8.0F, 8.0F, -8.0F);
        this.Bottom.addBox(0.0F, 0.0F, 0.0F, 16, 16, 16, 0.0F);
        this.Bar11 = new ModelRenderer(this, 0, 0);
        this.Bar11.setRotationPoint(-10.0F, -2.0F, 1.0F);
        this.Bar11.addBox(0.0F, 0.0F, 0.0F, 1, 7, 1, 0.0F);
        this.Side2 = new ModelRenderer(this, 0, 35);
        this.Side2.setRotationPoint(8.0F, 5.0F, -8.0F);
        this.Side2.addBox(0.0F, 0.0F, 0.0F, 3, 3, 16, 0.0F);
        this.Bar4 = new ModelRenderer(this, 0, 0);
        this.Bar4.setRotationPoint(9.0F, -2.0F, -2.0F);
        this.Bar4.addBox(0.0F, 0.0F, 0.0F, 1, 7, 1, 0.0F);
        this.Bar7 = new ModelRenderer(this, 0, 0);
        this.Bar7.setRotationPoint(-10.0F, -2.0F, 7.0F);
        this.Bar7.addBox(0.0F, 0.0F, 0.0F, 1, 7, 1, 0.0F);
        this.Bar2 = new ModelRenderer(this, 0, 0);
        this.Bar2.setRotationPoint(9.0F, -2.0F, -8.0F);
        this.Bar2.addBox(0.0F, 0.0F, 0.0F, 1, 7, 1, 0.0F);
        this.Bar5 = new ModelRenderer(this, 0, 0);
        this.Bar5.setRotationPoint(9.0F, -2.0F, 1.0F);
        this.Bar5.addBox(0.0F, 0.0F, 0.0F, 1, 7, 1, 0.0F);
        this.Bar1 = new ModelRenderer(this, 0, 0);
        this.Bar1.setRotationPoint(9.0F, -2.0F, 7.0F);
        this.Bar1.addBox(0.0F, 0.0F, 0.0F, 1, 7, 1, 0.0F);
        this.Bar12 = new ModelRenderer(this, 0, 0);
        this.Bar12.setRotationPoint(-10.0F, -2.0F, 4.0F);
        this.Bar12.addBox(0.0F, 0.0F, 0.0F, 1, 7, 1, 0.0F);
        this.Bar9 = new ModelRenderer(this, 0, 0);
        this.Bar9.setRotationPoint(-10.0F, -2.0F, -5.0F);
        this.Bar9.addBox(0.0F, 0.0F, 0.0F, 1, 7, 1, 0.0F);
        this.Side3 = new ModelRenderer(this, 55, 40);
        this.Side3.setRotationPoint(8.0F, -5.0F, -8.0F);
        this.Side3.addBox(0.0F, 0.0F, 0.0F, 3, 3, 16, 0.0F);
        this.Side1 = new ModelRenderer(this, 0, 35);
        this.Side1.setRotationPoint(-11.0F, 5.0F, -8.0F);
        this.Side1.addBox(0.0F, 0.0F, 0.0F, 3, 3, 16, 0.0F);
        this.Bar6 = new ModelRenderer(this, 0, 0);
        this.Bar6.setRotationPoint(9.0F, -2.0F, 4.0F);
        this.Bar6.addBox(0.0F, 0.0F, 0.0F, 1, 7, 1, 0.0F);
        this.Side4 = new ModelRenderer(this, 55, 40);
        this.Side4.setRotationPoint(-11.0F, -5.0F, -8.0F);
        this.Side4.addBox(0.0F, 0.0F, 0.0F, 3, 3, 16, 0.0F);
        this.Bar3 = new ModelRenderer(this, 0, 0);
        this.Bar3.setRotationPoint(9.0F, -2.0F, -5.0F);
        this.Bar3.addBox(0.0F, 0.0F, 0.0F, 1, 7, 1, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.Bar10.render(f5);
        this.Bar8.render(f5);
        this.Bottom.render(f5);
        this.Bar11.render(f5);
        this.Side2.render(f5);
        this.Bar4.render(f5);
        this.Bar7.render(f5);
        this.Bar2.render(f5);
        this.Bar5.render(f5);
        this.Bar1.render(f5);
        this.Bar12.render(f5);
        this.Bar9.render(f5);
        this.Side3.render(f5);
        this.Side1.render(f5);
        this.Bar6.render(f5);
        this.Side4.render(f5);
        this.Bar3.render(f5);
    }
    
    public void renderAll(float f5)
    {
        this.Bar10.render(f5);
        this.Bar8.render(f5);
        this.Bottom.render(f5);
        this.Bar11.render(f5);
        this.Side2.render(f5);
        this.Bar4.render(f5);
        this.Bar7.render(f5);
        this.Bar2.render(f5);
        this.Bar5.render(f5);
        this.Bar1.render(f5);
        this.Bar12.render(f5);
        this.Bar9.render(f5);
        this.Side3.render(f5);
        this.Side1.render(f5);
        this.Bar6.render(f5);
        this.Side4.render(f5);
        this.Bar3.render(f5);
    }
    
    public void renderItem(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) 
    {
        this.Bottom.render(f5);
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
