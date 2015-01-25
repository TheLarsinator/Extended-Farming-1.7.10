package com.extfar.tractor.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * TractorWPlow.tcn - TechneToTabulaImporter
 * Created using Tabula 4.1.1
 */
public class ModelSteeringWheel extends ModelBase {
    public ModelRenderer SteeringWheel;
    public ModelRenderer SteeringPole;

    public ModelSteeringWheel() {
        this.textureWidth = 256;
        this.textureHeight = 256;
        this.SteeringPole = new ModelRenderer(this, 26, 215);
        this.SteeringPole.setRotationPoint(-1.0F, 10.0F, 3.0F);
        this.SteeringPole.addBox(0.0F, 0.0F, 0.0F, 2, 15, 2, 0.0F);
        this.setRotateAngle(SteeringPole, -0.40896472334861755F, 0.0F, 0.0F);
        this.SteeringWheel = new ModelRenderer(this, 134, 0);
        this.SteeringWheel.setRotationPoint(-3.0F, 9.0F, 1.0F);
        this.SteeringWheel.addBox(0.0F, 0.0F, 0.0F, 6, 1, 6, 0.0F);
        this.setRotateAngle(SteeringWheel, -0.408965528011322F, 0.0F, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.SteeringPole.render(f5);
        this.SteeringWheel.render(f5);
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
