package com.extfar.tractor.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * TractorWPlow.tcn - TechneToTabulaImporter
 * Created using Tabula 4.1.1
 */
public class ModelTractorSprayer extends ModelBase {
    public ModelRenderer ConnectSprayer;
    public ModelRenderer SprayerBeam;
    public ModelRenderer SprayHead12;
    public ModelRenderer SprayHead2;
    public ModelRenderer SprayHead3;
    public ModelRenderer SprayHead4;
    public ModelRenderer SprayHead5;
    public ModelRenderer SprayHead6;
    public ModelRenderer SprayHead7;
    public ModelRenderer SprayHead8;
    public ModelRenderer SprayHead9;
    public ModelRenderer SprayHead10;
    public ModelRenderer SprayHead11;
    public ModelRenderer SprayHead1;
    public ModelRenderer WaterPipe;
    public ModelRenderer WaterPipe1;
    public ModelRenderer WaterPipe2;
    public ModelRenderer WaterPipe3;

    public ModelTractorSprayer() {
        this.textureWidth = 256;
        this.textureHeight = 256;
        this.SprayHead7 = new ModelRenderer(this, 0, 180);
        this.SprayHead7.setRotationPoint(-4.0F, 19.0F, 7.0F);
        this.SprayHead7.addBox(0.0F, 0.0F, 0.0F, 1, 4, 1, 0.0F);
        this.setRotateAngle(SprayHead7, 0.136659280431156F, 0.0F, 0.0F);
        this.SprayHead9 = new ModelRenderer(this, 0, 180);
        this.SprayHead9.setRotationPoint(-10.0F, 19.0F, 7.0F);
        this.SprayHead9.addBox(0.0F, 0.0F, 0.0F, 1, 4, 1, 0.0F);
        this.setRotateAngle(SprayHead9, 0.136659280431156F, 0.0F, 0.0F);
        this.WaterPipe1 = new ModelRenderer(this, 17, 180);
        this.WaterPipe1.setRotationPoint(-1.0F, 18.2F, 7.0F);
        this.WaterPipe1.addBox(0.0F, -2.5F, 0.0F, 2, 3, 1, 0.0F);
        this.setRotateAngle(WaterPipe1, 0.136659280431156F, 0.0F, 0.0F);
        this.WaterPipe2 = new ModelRenderer(this, 0, 161);
        this.WaterPipe2.setRotationPoint(-1.0F, 15.7F, 7.0F);
        this.WaterPipe2.addBox(0.0F, 0.1F, 0.0F, 2, 5, 1, 0.0F);
        this.setRotateAngle(WaterPipe2, -1.593485607070823F, 0.0F, 0.0F);
        this.SprayHead2 = new ModelRenderer(this, 0, 180);
        this.SprayHead2.setRotationPoint(15.0F, 19.0F, 7.0F);
        this.SprayHead2.addBox(0.0F, 0.0F, 0.0F, 1, 4, 1, 0.0F);
        this.setRotateAngle(SprayHead2, 0.136659280431156F, 0.0F, 0.0F);
        this.SprayHead1 = new ModelRenderer(this, 0, 180);
        this.SprayHead1.setRotationPoint(18.0F, 19.0F, 7.0F);
        this.SprayHead1.addBox(0.0F, 0.0F, 0.0F, 1, 4, 1, 0.0F);
        this.setRotateAngle(SprayHead1, 0.136659280431156F, 0.0F, 0.0F);
        this.SprayHead6 = new ModelRenderer(this, 0, 180);
        this.SprayHead6.setRotationPoint(3.0F, 19.0F, 7.0F);
        this.SprayHead6.addBox(0.0F, 0.0F, 0.0F, 1, 4, 1, 0.0F);
        this.setRotateAngle(SprayHead6, 0.136659280431156F, 0.0F, 0.0F);
        this.SprayHead10 = new ModelRenderer(this, 0, 180);
        this.SprayHead10.setRotationPoint(-13.0F, 19.0F, 7.0F);
        this.SprayHead10.addBox(0.0F, 0.0F, 0.0F, 1, 4, 1, 0.0F);
        this.setRotateAngle(SprayHead10, 0.136659280431156F, 0.0F, 0.0F);
        this.SprayHead5 = new ModelRenderer(this, 0, 180);
        this.SprayHead5.setRotationPoint(6.0F, 19.0F, 7.0F);
        this.SprayHead5.addBox(0.0F, 0.0F, 0.0F, 1, 4, 1, 0.0F);
        this.setRotateAngle(SprayHead5, 0.136659280431156F, 0.0F, 0.0F);
        this.SprayHead3 = new ModelRenderer(this, 0, 180);
        this.SprayHead3.setRotationPoint(12.0F, 19.0F, 7.0F);
        this.SprayHead3.addBox(0.0F, 0.0F, 0.0F, 1, 4, 1, 0.0F);
        this.setRotateAngle(SprayHead3, 0.136659280431156F, 0.0F, 0.0F);
        this.SprayHead11 = new ModelRenderer(this, 0, 180);
        this.SprayHead11.setRotationPoint(-16.0F, 19.0F, 7.0F);
        this.SprayHead11.addBox(0.0F, 0.0F, 0.0F, 1, 4, 1, 0.0F);
        this.setRotateAngle(SprayHead11, 0.136659280431156F, 0.0F, 0.0F);
        this.SprayHead12 = new ModelRenderer(this, 0, 180);
        this.SprayHead12.setRotationPoint(-19.0F, 19.0F, 7.0F);
        this.SprayHead12.addBox(0.0F, 0.0F, 0.0F, 1, 4, 1, 0.0F);
        this.setRotateAngle(SprayHead12, 0.136659280431156F, 0.0F, 0.0F);
        this.SprayHead4 = new ModelRenderer(this, 0, 180);
        this.SprayHead4.setRotationPoint(9.0F, 19.0F, 7.0F);
        this.SprayHead4.addBox(0.0F, 0.0F, 0.0F, 1, 4, 1, 0.0F);
        this.setRotateAngle(SprayHead4, 0.136659280431156F, 0.0F, 0.0F);
        this.ConnectSprayer = new ModelRenderer(this, 200, 120);
        this.ConnectSprayer.setRotationPoint(-2.0F, 14.0F, -7.5F);
        this.ConnectSprayer.addBox(0.0F, 0.0F, 0.0F, 4, 3, 12, 0.0F);
        this.setRotateAngle(ConnectSprayer, -0.2602285914723545F, 0.0F, 0.0F);
        this.SprayerBeam = new ModelRenderer(this, 158, 247);
        this.SprayerBeam.setRotationPoint(0.0F, 17.0F, 3.1999999999999993F);
        this.SprayerBeam.addBox(-20.0F, 0.0F, 0.0F, 40, 4, 4, 0.0F);
        this.SprayHead8 = new ModelRenderer(this, 0, 180);
        this.SprayHead8.setRotationPoint(-7.0F, 19.0F, 7.0F);
        this.SprayHead8.addBox(0.0F, 0.0F, 0.0F, 1, 4, 1, 0.0F);
        this.setRotateAngle(SprayHead8, 0.136659280431156F, 0.0F, 0.0F);
        this.WaterPipe = new ModelRenderer(this, 0, 194);
        this.WaterPipe.setRotationPoint(18.0F, 18.2F, 7.0F);
        this.WaterPipe.addBox(-37.0F, 0.0F, 0.0F, 38, 1, 1, 0.0F);
        this.setRotateAngle(WaterPipe, 0.136659280431156F, 0.0F, 0.0F);
        this.WaterPipe3 = new ModelRenderer(this, 0, 139);
        this.WaterPipe3.setRotationPoint(-1.0F, 15.600000000000001F, 2.3999999999999986F);
        this.WaterPipe3.addBox(0.0F, 0.1F, 0.0F, 2, 10, 1, 0.0F);
        this.setRotateAngle(WaterPipe3, -1.8212510744560826F, 0.0F, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.SprayHead7.render(f5);
        this.SprayHead9.render(f5);
        this.WaterPipe1.render(f5);
        this.WaterPipe2.render(f5);
        this.SprayHead2.render(f5);
        this.SprayHead1.render(f5);
        this.SprayHead6.render(f5);
        this.SprayHead10.render(f5);
        this.SprayHead5.render(f5);
        this.SprayHead3.render(f5);
        this.SprayHead11.render(f5);
        this.SprayHead12.render(f5);
        this.SprayHead4.render(f5);
        this.ConnectSprayer.render(f5);
        this.SprayerBeam.render(f5);
        this.SprayHead8.render(f5);
        this.WaterPipe.render(f5);
        this.WaterPipe3.render(f5);
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
