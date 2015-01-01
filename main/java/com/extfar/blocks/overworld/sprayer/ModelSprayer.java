package com.extfar.blocks.overworld.sprayer;

import java.util.Random;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

/**
 * Sprayer - TheLarsinator
 * Created using Tabula 4.0.2
 */
public class ModelSprayer extends ModelBase {
    public ModelRenderer Pole;
    public ModelRenderer SprayHead2;
    public ModelRenderer Hose;
    public ModelRenderer Hose2;
    public ModelRenderer Bar1;
    public ModelRenderer Bar2;
    public ModelRenderer Bar3;
    public ModelRenderer Hose3;
    public ModelRenderer HoseCon1;
    public ModelRenderer HoseCon2;
    public ModelRenderer HoseCon4;
    public ModelRenderer HoseCon3;
    public ModelRenderer SprayHead4;
    public ModelRenderer SprayHead;
    public ModelRenderer SprayHead3;
    public ModelRenderer Floor;
    
    public float f = 0;

    public ModelSprayer() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.Hose2 = new ModelRenderer(this, 36, 18);
        this.Hose2.setRotationPoint(0.1F, 15.5F, 3.0F);
        this.Hose2.addBox(0.0F, 0.0F, 0.0F, 9, 1, 1);
        this.setRotateAngle(Hose2, 0.0F, 0.0F, 1.5707963267948966F);
        this.Bar2 = new ModelRenderer(this, 0, 7);
        this.Bar2.setRotationPoint(1.0F, 9.0F, -1.0F);
        this.Bar2.addBox(0.0F, 0.0F, 0.0F, 1, 1, 5);
        this.Floor = new ModelRenderer(this, 0, 36);
        this.Floor.setRotationPoint(-8.0F, 23.7F, -8.0F);
        this.Floor.addBox(0.0F, 0.0F, 0.0F, 16, 1, 16);
        this.SprayHead = new ModelRenderer(this, 38, 0);
        this.SprayHead.setRotationPoint(1.5F, 12.3F, 1.5F);
        this.SprayHead.addBox(-1.0F, -1.0F, -4.0F, 2, 2, 4);
        this.HoseCon3 = new ModelRenderer(this, 16, 21);
        this.HoseCon3.setRotationPoint(-1.0F, 22.0F, -1.0F);
        this.HoseCon3.addBox(0.0F, 0.0F, 0.0F, 7, 2, 2);
        this.setRotateAngle(HoseCon3, 0.0F, 1.5707963267948966F, 0.0F);
        this.Pole = new ModelRenderer(this, 0, 30);
        this.Pole.setRotationPoint(0.0F, 11.0F, 0.0F);
        this.Pole.addBox(0.0F, 0.0F, 0.0F, 3, 13, 3);
        this.SprayHead2 = new ModelRenderer(this, 38, 0);
        this.SprayHead2.setRotationPoint(1.5F, 12.3F, 1.5F);
        this.SprayHead2.addBox(-1.0F, -1.0F, 0.0F, 2, 2, 4);
        this.Hose3 = new ModelRenderer(this, 39, 24);
        this.Hose3.setRotationPoint(-1.0F, 22.0F, -1.0F);
        this.Hose3.addBox(0.0F, 0.0F, 0.0F, 2, 2, 4);
        this.SprayHead3 = new ModelRenderer(this, 23, 0);
        this.SprayHead3.setRotationPoint(1.5F, 12.3F, 1.5F);
        this.SprayHead3.addBox(0.0F, -1.0F, -1.0F, 4, 2, 2);
        this.Bar1 = new ModelRenderer(this, 0, 16);
        this.Bar1.setRotationPoint(-1.0F, 9.0F, 1.0F);
        this.Bar1.addBox(0.0F, 0.0F, 0.0F, 5, 1, 1);
        this.HoseCon1 = new ModelRenderer(this, 16, 21);
        this.HoseCon1.setRotationPoint(-8.0F, 22.0F, -1.0F);
        this.HoseCon1.addBox(0.0F, 0.0F, 0.0F, 7, 2, 2);
        this.HoseCon2 = new ModelRenderer(this, 16, 21);
        this.HoseCon2.setRotationPoint(1.0F, 22.0F, -1.0F);
        this.HoseCon2.addBox(0.0F, 0.0F, 0.0F, 7, 2, 2);
        this.HoseCon4 = new ModelRenderer(this, 16, 21);
        this.HoseCon4.setRotationPoint(-1.0F, 22.0F, 8.0F);
        this.HoseCon4.addBox(0.0F, 0.0F, 0.0F, 7, 2, 2);
        this.setRotateAngle(HoseCon4, 0.0F, 1.5707963267948966F, 0.0F);
        this.SprayHead4 = new ModelRenderer(this, 23, 0);
        this.SprayHead4.setRotationPoint(1.5F, 12.3F, 1.5F);
        this.SprayHead4.addBox(-4.0F, -1.0F, -1.0F, 4, 2, 2);
        this.Bar3 = new ModelRenderer(this, 4, 22);
        this.Bar3.setRotationPoint(1.0F, 10.0F, 1.0F);
        this.Bar3.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1);
        this.Hose = new ModelRenderer(this, 42, 9);
        this.Hose.setRotationPoint(-0.9F, 12.0F, 0.6F);
        this.Hose.addBox(0.0F, 0.0F, 0.0F, 1, 5, 1);
        this.setRotateAngle(Hose, 0.5235987755982988F, 0.0F, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.Hose2.render(f5);
        this.Bar2.render(f5);
        this.Floor.render(f5);
        this.SprayHead.render(f5);
        this.HoseCon3.render(f5);
        this.Pole.render(f5);
        this.SprayHead2.render(f5);
        this.Hose3.render(f5);
        this.SprayHead3.render(f5);
        this.Bar1.render(f5);
        this.HoseCon1.render(f5);
        this.HoseCon2.render(f5);
        this.HoseCon4.render(f5);
        this.SprayHead4.render(f5);
        this.Bar3.render(f5);
        this.Hose.render(f5);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, null);
    	SprayHead.rotateAngleY = MathHelper.cos(f * 0.662F)* f1;
    	SprayHead2.rotateAngleY = MathHelper.cos(f * 0.662F)* f1;
    	SprayHead3.rotateAngleY = MathHelper.cos(f * 0.662F)* f1;
    	SprayHead4.rotateAngleY = MathHelper.cos(f * 0.662F)* f1;
    }
	public void renderActive() 
	{
		
		f= f + .1F;
		
		if(f>10)
		{
			f=0;
		}
		
	    this.setRotationAngles(f, f, f, f, f, f);
		float f5 = 0.0625F;
        this.Hose2.render(f5);
        this.Bar2.render(f5);
        this.Floor.render(f5);
        this.SprayHead.render(f5);
        this.HoseCon3.render(f5);
        this.Pole.render(f5);
        this.SprayHead2.render(f5);
        this.Hose3.render(f5);
        this.SprayHead3.render(f5);
        this.Bar1.render(f5);
        this.HoseCon1.render(f5);
        this.HoseCon2.render(f5);
        this.HoseCon4.render(f5);
        this.SprayHead4.render(f5);
        this.Bar3.render(f5);
        this.Hose.render(f5);
		
	}
	public void renderPassive() 
	{
		float f5 = 0.0625F;
        this.Hose2.render(f5);
        this.Bar2.render(f5);
        this.Floor.render(f5);
        this.SprayHead.render(f5);
        this.HoseCon3.render(f5);
        this.Pole.render(f5);
        this.SprayHead2.render(f5);
        this.Hose3.render(f5);
        this.SprayHead3.render(f5);
        this.Bar1.render(f5);
        this.HoseCon1.render(f5);
        this.HoseCon2.render(f5);
        this.HoseCon4.render(f5);
        this.SprayHead4.render(f5);
        this.Bar3.render(f5);
        this.Hose.render(f5);
		
	}
}
