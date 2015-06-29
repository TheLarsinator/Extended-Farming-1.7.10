package com.extfar.blocks.grinder;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

/**
 * Grinder - TheLarsinator
 * Created using Tabula 4.1.1
 */
public class ModelGrinder extends ModelBase {
    public ModelRenderer shape4;
    public ModelRenderer shape1;
    public ModelRenderer shape2;
    public ModelRenderer shape3;
    public ModelRenderer shape5;
    public ModelRenderer TopStone;
    public ModelRenderer BottomStone;
    public ModelRenderer shape8;

    public ModelGrinder() {
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.shape3 = new ModelRenderer(this, 0, 35);
        this.shape3.setRotationPoint(-7.0F, 10.0F, -7.0F);
        this.shape3.addBox(0.0F, 0.0F, 0.0F, 1, 14, 14, 0.0F);
        this.shape5 = new ModelRenderer(this, 0, 0);
        this.shape5.setRotationPoint(-7.0F, 23.0F, -7.0F);
        this.shape5.addBox(0.0F, 0.0F, 0.0F, 14, 1, 14, 0.0F);
        this.shape8 = new ModelRenderer(this, 70, 0);
        this.shape8.setRotationPoint(-0.5F, 7.0F, -0.5F);
        this.shape8.addBox(0.0F, 0.0F, 0.0F, 1, 17, 1, 0.0F);
        this.shape4 = new ModelRenderer(this, 0, 35);
        this.shape4.setRotationPoint(6.0F, 10.0F, -7.0F);
        this.shape4.addBox(0.0F, 0.0F, 0.0F, 1, 14, 14, 0.0F);
        this.shape2 = new ModelRenderer(this, 40, 35);
        this.shape2.setRotationPoint(-7.0F, 10.0F, -7.0F);
        this.shape2.addBox(0.0F, 0.0F, 0.0F, 14, 14, 1, 0.0F);
        this.BottomStone = new ModelRenderer(this, 86, 0);
        this.BottomStone.setRotationPoint(0.0F, 19.0F, 0.0F);
        this.BottomStone.addBox(-4.5F, 0.0F, -4.5F, 9, 4, 9, 0.0F);
        this.shape1 = new ModelRenderer(this, 40, 35);
        this.shape1.setRotationPoint(-7.0F, 10.0F, 6.0F);
        this.shape1.addBox(0.0F, 0.0F, 0.0F, 14, 14, 1, 0.0F);
        this.TopStone = new ModelRenderer(this, 86, 0);
        this.TopStone.setRotationPoint(0.0F, 13.0F, 0.0F);
        this.TopStone.addBox(-4.5F, 0.0F, -4.5F, 9, 4, 9, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.shape3.render(f5);
        this.shape5.render(f5);
        this.shape8.render(f5);
        this.shape4.render(f5);
        this.shape2.render(f5);
        this.BottomStone.render(f5);
        this.shape1.render(f5);
        this.TopStone.render(f5);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
    
    public void renderAll(float f5)
    {
        this.shape3.render(f5);
        this.shape5.render(f5);
        this.shape8.render(f5);
        this.shape4.render(f5);
        this.shape2.render(f5);
        this.BottomStone.render(f5);
        this.shape1.render(f5);
        this.TopStone.render(f5);
        setRotationAngles(f5, f5, f5, f5, f5, f5);

    }
    public void renderHalf(float f5)
    {
        this.shape3.render(f5);
        this.shape5.render(f5);
        this.shape8.render(f5);
        this.shape4.render(f5);
        this.shape2.render(f5);
        this.BottomStone.render(f5);
        this.shape1.render(f5);
        //this.TopStone.render(f5);
    }
    private float i;
    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
    {
      super.setRotationAngles(f, f1, f2, f3, f4, f5, null);
      
      i = i + 0.05F;
      
      if(i == 100)
    	  i=0;
      
      this.TopStone.rotateAngleY = i;
    }
}
