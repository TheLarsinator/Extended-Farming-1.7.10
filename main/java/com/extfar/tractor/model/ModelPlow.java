package com.extfar.tractor.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * TractorWPlow.tcn - TechneToTabulaImporter
 * Created using Tabula 4.1.1
 */
public class ModelPlow extends ModelBase {
    public ModelRenderer PlowBladeCon2;
    public ModelRenderer PlowBladeCon1;
    public ModelRenderer PlowBladeCon3;
    public ModelRenderer PlowBlade2;
    public ModelRenderer PlowBlade1;
    public ModelRenderer PlowBlade3;
    public ModelRenderer Support1;
    public ModelRenderer Support2;
    public ModelRenderer PlowBeam;
    public ModelRenderer Connect;

    public ModelPlow() {
        this.textureWidth = 256;
        this.textureHeight = 256;
        this.Support2 = new ModelRenderer(this, 191, 150);
        this.Support2.setRotationPoint(-7.0F, 15.0F, -8.199999999999996F);
        this.Support2.addBox(0.0F, 0.0F, 0.0F, 1, 1, 13, 0.0F);
        this.setRotateAngle(Support2, 2.788395881652832F, -0.4833219647407532F, 0.0F);
        this.PlowBladeCon2 = new ModelRenderer(this, 200, 180);
        this.PlowBladeCon2.setRotationPoint(3.0F, 14.0F, 1.8000000000000007F);
        this.PlowBladeCon2.addBox(0.0F, 0.0F, 0.0F, 4, 4, 10, 0.0F);
        this.setRotateAngle(PlowBladeCon2, -0.14871443808078766F, -0.6320360898971558F, 0.0F);
        this.Connect = new ModelRenderer(this, 200, 120);
        this.Connect.setRotationPoint(-2.0F, 8.0F, -20.7F);
        this.Connect.addBox(0.0F, 0.0F, 0.0F, 4, 3, 20, 0.0F);
        this.setRotateAngle(Connect, -0.2602502703666687F, 0.0F, 0.0F);
        this.PlowBladeCon1 = new ModelRenderer(this, 200, 180);
        this.PlowBladeCon1.setRotationPoint(-12.0F, 14.0F, -8.199999999999996F);
        this.PlowBladeCon1.addBox(0.0F, 0.0F, 0.0F, 4, 4, 10, 0.0F);
        this.setRotateAngle(PlowBladeCon1, -0.14871443808078766F, -0.6320360898971558F, 0.0F);
        this.PlowBlade2 = new ModelRenderer(this, 229, 180);
        this.PlowBlade2.setRotationPoint(1.0F, 18.0F, 5.799999999999997F);
        this.PlowBlade2.addBox(0.0F, 0.0F, 0.0F, 1, 7, 12, 0.0F);
        this.setRotateAngle(PlowBlade2, -0.028958515160072255F, -0.37070890871612844F, 0.07978750175819799F);
        this.Support1 = new ModelRenderer(this, 200, 150);
        this.Support1.setRotationPoint(12.0F, 15.0F, 6.799999999999997F);
        this.Support1.addBox(0.0F, 0.0F, 0.0F, 1, 1, 26, 0.0F);
        this.setRotateAngle(Support1, 3.011467456817627F, 0.4461433291435241F, 0.0F);
        this.PlowBlade1 = new ModelRenderer(this, 229, 180);
        this.PlowBlade1.setRotationPoint(-13.0F, 18.0F, -6.199999999999996F);
        this.PlowBlade1.addBox(0.0F, 0.0F, 0.0F, 1, 7, 12, 0.0F);
        this.setRotateAngle(PlowBlade1, -0.028958515160072255F, -0.37070890871612844F, 0.07978750175819799F);
        this.PlowBeam = new ModelRenderer(this, 154, 232);
        this.PlowBeam.setRotationPoint(-13.0F, 13.0F, -13.199999999999996F);
        this.PlowBeam.addBox(0.0F, 0.0F, 0.0F, 45, 5, 4, 0.0F);
        this.setRotateAngle(PlowBeam, 0.0F, -0.6320363879203796F, 0.0F);
        this.PlowBlade3 = new ModelRenderer(this, 229, 180);
        this.PlowBlade3.setRotationPoint(17.0F, 18.0F, 15.799999999999997F);
        this.PlowBlade3.addBox(0.0F, 0.0F, 0.0F, 1, 7, 12, 0.0F);
        this.setRotateAngle(PlowBlade3, -0.028958515160072255F, -0.37070890871612844F, 0.07978750175819799F);
        this.PlowBladeCon3 = new ModelRenderer(this, 200, 180);
        this.PlowBladeCon3.setRotationPoint(18.0F, 14.0F, 12.799999999999997F);
        this.PlowBladeCon3.addBox(0.0F, 0.0F, 0.0F, 4, 4, 10, 0.0F);
        this.setRotateAngle(PlowBladeCon3, -0.14871443808078766F, -0.6320360898971558F, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.Support2.render(f5);
        this.PlowBladeCon2.render(f5);
        this.Connect.render(f5);
        this.PlowBladeCon1.render(f5);
        this.PlowBlade2.render(f5);
        this.Support1.render(f5);
        this.PlowBlade1.render(f5);
        this.PlowBeam.render(f5);
        this.PlowBlade3.render(f5);
        this.PlowBladeCon3.render(f5);
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
