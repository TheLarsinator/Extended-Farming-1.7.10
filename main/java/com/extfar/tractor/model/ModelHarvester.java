package com.extfar.tractor.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * TractorWPlow.tcn - TechneToTabulaImporter
 * Created using Tabula 4.1.1
 */
public class ModelHarvester extends ModelBase {
    public ModelRenderer HarvesterConnect5;
    public ModelRenderer HarvesterConnect1;
    public ModelRenderer HarvesterConnect2;
    public ModelRenderer HarvesterConnect3;
    public ModelRenderer HarvesterPlate2;
    public ModelRenderer HarvesterConnect4;
    public ModelRenderer HarvesterRod12;
    public ModelRenderer HarvesterPlate1;
    public ModelRenderer HarvesterAxis;
    public ModelRenderer HarvesterRod1;
    public ModelRenderer HarvesterRod2;
    public ModelRenderer HarvesterRod3;
    public ModelRenderer HarvesterRod4;
    public ModelRenderer HarvesterRod5;
    public ModelRenderer HarvesterRod6;
    public ModelRenderer HarvesterRod7;
    public ModelRenderer HarvesterRod13;
    public ModelRenderer HarvesterRod10;
    public ModelRenderer HarvesterRod11;
    public ModelRenderer HarvesterRod9;

    public ModelHarvester() {
        this.textureWidth = 256;
        this.textureHeight = 256;
        this.HarvesterConnect1 = new ModelRenderer(this, 200, 230);
        this.HarvesterConnect1.setRotationPoint(-2.0F, 8.0F, -13.0F);
        this.HarvesterConnect1.addBox(0.0F, -1.0F, 0.0F, 4, 4, 11, 0.0F);
        this.setRotateAngle(HarvesterConnect1, -0.36425021489121656F, 0.0F, 0.0F);
        this.HarvesterConnect2 = new ModelRenderer(this, 200, 229);
        this.HarvesterConnect2.setRotationPoint(-2.0F, 11.0F, -2.3999999999999986F);
        this.HarvesterConnect2.addBox(0.0F, 0.0F, 0.0F, 4, 4, 9, 0.0F);
        this.setRotateAngle(HarvesterConnect2, -1.3203415791337103F, 0.0F, 0.0F);
        this.HarvesterConnect4 = new ModelRenderer(this, 200, 237);
        this.HarvesterConnect4.setRotationPoint(-22.0F, 18.0F, -2.3999999999999986F);
        this.HarvesterConnect4.addBox(0.0F, 0.0F, 0.0F, 2, 2, 12, 0.0F);
        this.HarvesterRod4 = new ModelRenderer(this, 100, 200);
        this.HarvesterRod4.setRotationPoint(-20.0F, 19.0F, 4.5F);
        this.HarvesterRod4.addBox(2.0F, -4.0F, 1.0F, 36, 1, 1, 0.0F);
        this.HarvesterRod9 = new ModelRenderer(this, 100, 200);
        this.HarvesterRod9.setRotationPoint(-20.0F, 19.0F, 4.5F);
        this.HarvesterRod9.addBox(2.0F, 3.0F, 1.0F, 36, 1, 1, 0.0F);
        this.HarvesterConnect3 = new ModelRenderer(this, 100, 231);
        this.HarvesterConnect3.setRotationPoint(-22.0F, 18.0F, -2.3999999999999986F);
        this.HarvesterConnect3.addBox(0.0F, 0.0F, 0.0F, 44, 2, 2, 0.0F);
        this.HarvesterRod2 = new ModelRenderer(this, 100, 200);
        this.HarvesterRod2.setRotationPoint(-20.0F, 19.0F, 4.5F);
        this.HarvesterRod2.addBox(2.0F, -4.0F, -4.0F, 36, 1, 1, 0.0F);
        this.HarvesterRod6 = new ModelRenderer(this, 100, 200);
        this.HarvesterRod6.setRotationPoint(-20.0F, 19.0F, 4.5F);
        this.HarvesterRod6.addBox(2.0F, -2.0F, 3.0F, 36, 1, 1, 0.0F);
        this.HarvesterConnect5 = new ModelRenderer(this, 220, 237);
        this.HarvesterConnect5.setRotationPoint(20.0F, 18.0F, -2.3999999999999986F);
        this.HarvesterConnect5.addBox(0.0F, 0.0F, 0.0F, 2, 2, 12, 0.0F);
        this.HarvesterRod13 = new ModelRenderer(this, 100, 200);
        this.HarvesterRod13.setRotationPoint(-20.0F, 19.0F, 4.5F);
        this.HarvesterRod13.addBox(2.0F, 3.0F, 3.0F, 36, 1, 1, 0.0F);
        this.HarvesterRod1 = new ModelRenderer(this, 100, 200);
        this.HarvesterRod1.setRotationPoint(-20.0F, 19.0F, 4.5F);
        this.HarvesterRod1.addBox(2.0F, -2.0F, -4.0F, 36, 1, 1, 0.0F);
        this.HarvesterPlate2 = new ModelRenderer(this, 230, 105);
        this.HarvesterPlate2.setRotationPoint(18.0F, 19.0F, 4.5F);
        this.HarvesterPlate2.addBox(0.0F, -4.0F, -4.0F, 1, 8, 8, 0.0F);
        this.HarvesterPlate1 = new ModelRenderer(this, 230, 105);
        this.HarvesterPlate1.setRotationPoint(-19.0F, 19.0F, 4.5F);
        this.HarvesterPlate1.addBox(0.0F, -4.0F, -4.0F, 1, 8, 8, 0.0F);
        this.HarvesterRod7 = new ModelRenderer(this, 100, 200);
        this.HarvesterRod7.setRotationPoint(-20.0F, 19.0F, 4.5F);
        this.HarvesterRod7.addBox(2.0F, 1.0F, 3.0F, 36, 1, 1, 0.0F);
        this.HarvesterRod11 = new ModelRenderer(this, 100, 200);
        this.HarvesterRod11.setRotationPoint(-20.0F, 19.0F, 4.5F);
        this.HarvesterRod11.addBox(2.0F, 3.0F, -4.0F, 36, 1, 1, 0.0F);
        this.HarvesterAxis = new ModelRenderer(this, 100, 220);
        this.HarvesterAxis.setRotationPoint(-20.0F, 19.0F, 4.5F);
        this.HarvesterAxis.addBox(0.0F, -1.0F, -1.0F, 40, 2, 2, 0.0F);
        this.HarvesterRod5 = new ModelRenderer(this, 100, 200);
        this.HarvesterRod5.setRotationPoint(-20.0F, 19.0F, 4.5F);
        this.HarvesterRod5.addBox(2.0F, -4.0F, 3.0F, 36, 1, 1, 0.0F);
        this.HarvesterRod10 = new ModelRenderer(this, 100, 200);
        this.HarvesterRod10.setRotationPoint(-20.0F, 19.0F, 4.5F);
        this.HarvesterRod10.addBox(2.0F, 3.0F, -2.0F, 36, 1, 1, 0.0F);
        this.HarvesterRod3 = new ModelRenderer(this, 100, 200);
        this.HarvesterRod3.setRotationPoint(-20.0F, 19.0F, 4.5F);
        this.HarvesterRod3.addBox(2.0F, -4.0F, -2.0F, 36, 1, 1, 0.0F);
        this.HarvesterRod12 = new ModelRenderer(this, 100, 200);
        this.HarvesterRod12.setRotationPoint(-20.0F, 19.0F, 4.5F);
        this.HarvesterRod12.addBox(2.0F, 1.0F, -4.0F, 36, 1, 1, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.HarvesterConnect1.render(f5);
        this.HarvesterConnect2.render(f5);
        this.HarvesterConnect4.render(f5);
        this.HarvesterRod4.render(f5);
        this.HarvesterRod9.render(f5);
        this.HarvesterConnect3.render(f5);
        this.HarvesterRod2.render(f5);
        this.HarvesterRod6.render(f5);
        this.HarvesterConnect5.render(f5);
        this.HarvesterRod13.render(f5);
        this.HarvesterRod1.render(f5);
        this.HarvesterPlate2.render(f5);
        this.HarvesterPlate1.render(f5);
        this.HarvesterRod7.render(f5);
        this.HarvesterRod11.render(f5);
        this.HarvesterAxis.render(f5);
        this.HarvesterRod5.render(f5);
        this.HarvesterRod10.render(f5);
        this.HarvesterRod3.render(f5);
        this.HarvesterRod12.render(f5);
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
