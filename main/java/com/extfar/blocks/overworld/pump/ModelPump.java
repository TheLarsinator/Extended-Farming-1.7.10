package com.extfar.blocks.overworld.pump;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * SuperPump.tcn - TechneToTabulaImporter
 * Created using Tabula 4.0.2
 */
public class ModelPump extends ModelBase {
    public ModelRenderer Bottom;
    public ModelRenderer Corner3;
    public ModelRenderer Corner4;
    public ModelRenderer Corner1;
    public ModelRenderer Corner2;
    public ModelRenderer Hose2;
    public ModelRenderer Hose4;
    public ModelRenderer Hose1;
    public ModelRenderer Hose3;
    public ModelRenderer Bar4;
    public ModelRenderer Bar3;
    public ModelRenderer Bar2;
    public ModelRenderer Bar1;
    public ModelRenderer Top;
    public ModelRenderer Pipe;
    public ModelRenderer Floor;

    public ModelPump() {
        this.textureWidth = 64;
        this.textureHeight = 128;
        this.Floor = new ModelRenderer(this, 0, 1);
        this.Floor.setRotationPoint(-8.0F, 24.0F, -8.0F);
        this.Floor.addBox(0.0F, 0.0F, 0.0F, 16, 1, 16);
        this.Bar2 = new ModelRenderer(this, 43, 37);
        this.Bar2.setRotationPoint(0.5F, 13.0F, -0.20000000298023224F);
        this.Bar2.addBox(0.0F, 0.0F, 0.0F, 9, 1, 1);
        this.setRotateAngle(Bar2, -0.6154797395790078F, -0.5235987755982983F, 0.9553166490331294F);
        this.Pipe = new ModelRenderer(this, 15, 37);
        this.Pipe.setRotationPoint(-0.5F, 14.0F, -0.5F);
        this.Pipe.addBox(0.0F, 0.0F, 0.0F, 1, 15, 1);
        this.Hose4 = new ModelRenderer(this, 52, 8);
        this.Hose4.setRotationPoint(-1.0F, 22.0F, 4.0F);
        this.Hose4.addBox(0.0F, 0.0F, 0.0F, 2, 2, 4);
        this.Corner2 = new ModelRenderer(this, 0, 37);
        this.Corner2.setRotationPoint(3.0F, 19.0F, 3.0F);
        this.Corner2.addBox(0.0F, 0.0F, 0.0F, 3, 5, 3);
        this.Corner3 = new ModelRenderer(this, 0, 37);
        this.Corner3.setRotationPoint(-6.0F, 19.0F, 3.0F);
        this.Corner3.addBox(0.0F, 0.0F, 0.0F, 3, 5, 3);
        this.Bar4 = new ModelRenderer(this, 43, 22);
        this.Bar4.setRotationPoint(0.20000000298023224F, 13.0F, -0.5F);
        this.Bar4.addBox(0.0F, 0.0F, 0.0F, 1, 1, 9);
        this.setRotateAngle(Bar4, 2.35619446833665F, -0.7853981574350081F, 3.141592653589793F);
        this.Hose3 = new ModelRenderer(this, 52, 0);
        this.Hose3.setRotationPoint(-4.0F, 22.0F, -1.0F);
        this.Hose3.addBox(-4.0F, 0.0F, 0.0F, 4, 2, 2);
        this.Bar3 = new ModelRenderer(this, 43, 22);
        this.Bar3.setRotationPoint(-0.800000011920929F, 13.399999618530273F, 0.20000000298023224F);
        this.Bar3.addBox(0.0F, 0.0F, 0.0F, 1, 1, 9);
        this.setRotateAngle(Bar3, -0.7853981852531433F, -0.7853981852531433F, 0.0F);
        this.Top = new ModelRenderer(this, 1, 49);
        this.Top.setRotationPoint(-1.0F, 12.0F, -1.0F);
        this.Top.addBox(0.0F, 0.0F, 0.0F, 2, 2, 2);
        this.Corner1 = new ModelRenderer(this, 0, 37);
        this.Corner1.setRotationPoint(3.0F, 19.0F, -6.0F);
        this.Corner1.addBox(0.0F, 0.0F, 0.0F, 3, 5, 3);
        this.Corner4 = new ModelRenderer(this, 0, 37);
        this.Corner4.setRotationPoint(-6.0F, 19.0F, -6.0F);
        this.Corner4.addBox(0.0F, 0.0F, 0.0F, 3, 5, 3);
        this.Hose2 = new ModelRenderer(this, 52, 8);
        this.Hose2.setRotationPoint(-1.0F, 22.0F, -4.0F);
        this.Hose2.addBox(0.0F, 0.0F, -4.0F, 2, 2, 4);
        this.Bar1 = new ModelRenderer(this, 43, 37);
        this.Bar1.setRotationPoint(-0.20000000298023224F, 13.0F, -0.5F);
        this.Bar1.addBox(0.0F, 0.0F, 0.0F, 9, 1, 1);
        this.setRotateAngle(Bar1, 0.6154797395790078F, 0.5235987755982983F, 0.9553166490331294F);
        this.Bottom = new ModelRenderer(this, 0, 19);
        this.Bottom.setRotationPoint(-5.0F, 21.0F, -5.0F);
        this.Bottom.addBox(0.0F, 0.0F, 0.0F, 10, 3, 10);
        this.Hose1 = new ModelRenderer(this, 52, 0);
        this.Hose1.setRotationPoint(4.0F, 22.0F, -1.0F);
        this.Hose1.addBox(0.0F, 0.0F, 0.0F, 4, 2, 2);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.Floor.render(f5);
        this.Bar2.render(f5);
        this.Pipe.render(f5);
        this.Hose4.render(f5);
        this.Corner2.render(f5);
        this.Corner3.render(f5);
        this.Bar4.render(f5);
        this.Hose3.render(f5);
        this.Bar3.render(f5);
        this.Top.render(f5);
        this.Corner1.render(f5);
        this.Corner4.render(f5);
        this.Hose2.render(f5);
        this.Bar1.render(f5);
        this.Bottom.render(f5);
        this.Hose1.render(f5);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
    
        public void renderAll() 
        {
	float f5 = 0.0625F;
    Bottom.render(f5);
    Corner4.render(f5);
    Corner1.render(f5);
    Corner2.render(f5);
    Corner3.render(f5);
    Top.render(f5);
    Bar2.render(f5);
    Bar1.render(f5);
    Bar4.render(f5);
    Bar3.render(f5);
    Pipe.render(f5);
    Hose3.render(f5);
    Hose1.render(f5);
    Hose2.render(f5);
    Hose4.render(f5);
    Floor.render(f5);	
        }
  

}
