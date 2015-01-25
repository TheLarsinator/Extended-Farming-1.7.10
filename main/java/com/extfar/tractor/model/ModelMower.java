package com.extfar.tractor.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * TractorWPlow.tcn - TechneToTabulaImporter
 * Created using Tabula 4.1.1
 */
public class ModelMower extends ModelBase {
    public ModelRenderer MowerConnector3;
    public ModelRenderer MowerConnector;
    public ModelRenderer MowerDeck2;
    public ModelRenderer MowerConnector2;
    public ModelRenderer MowerDeck;
    public ModelRenderer MowerBlade2;
    public ModelRenderer MowerBladeCon2;
    public ModelRenderer MowerBlade1;
    public ModelRenderer MowerBladeCon1;

    public ModelMower() {
        this.textureWidth = 256;
        this.textureHeight = 256;
        this.MowerConnector3 = new ModelRenderer(this, 160, 200);
        this.MowerConnector3.setRotationPoint(-2.5F, 15.0F, 2.8999999999999986F);
        this.MowerConnector3.addBox(0.0F, 0.0F, 0.0F, 5, 5, 4, 0.0F);
        this.setRotateAngle(MowerConnector3, -1.5707963267948966F, 0.0F, 0.0F);
        this.MowerBladeCon1 = new ModelRenderer(this, 0, 200);
        this.MowerBladeCon1.setRotationPoint(8.0F, 21.0F, 3.0F);
        this.MowerBladeCon1.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
        this.MowerBladeCon2 = new ModelRenderer(this, 0, 200);
        this.MowerBladeCon2.setRotationPoint(-9.0F, 21.0F, 3.0F);
        this.MowerBladeCon2.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
        this.MowerDeck = new ModelRenderer(this, 31, 54);
        this.MowerDeck.setRotationPoint(-19.0F, 19.0F, -8.0F);
        this.MowerDeck.addBox(0.0F, 0.0F, 0.0F, 38, 2, 17, 0.0F);
        this.MowerDeck2 = new ModelRenderer(this, 114, 200);
        this.MowerDeck2.setRotationPoint(-19.0F, 21.0F, -8.0F);
        this.MowerDeck2.addBox(0.0F, 0.0F, 0.0F, 38, 2, 2, 0.0F);
        this.MowerConnector = new ModelRenderer(this, 160, 200);
        this.MowerConnector.setRotationPoint(-1.5F, 8.0F, -15.0F);
        this.MowerConnector.addBox(0.0F, 0.0F, 0.0F, 3, 3, 5, 0.0F);
        this.MowerBlade1 = new ModelRenderer(this, 0, 200);
        this.MowerBlade1.setRotationPoint(8.0F, 23.0F, 3.0F);
        this.MowerBlade1.addBox(0.0F, 0.0F, -8.5F, 1, 1, 17, 0.0F);
        this.MowerConnector2 = new ModelRenderer(this, 135, 200);
        this.MowerConnector2.setRotationPoint(-1.5F, 7.9F, -10.399999999999999F);
        this.MowerConnector2.addBox(0.0F, 0.0F, 0.0F, 3, 3, 15, 0.0F);
        this.setRotateAngle(MowerConnector2, -0.5009094953223726F, 0.0F, 0.0F);
        this.MowerBlade2 = new ModelRenderer(this, 0, 200);
        this.MowerBlade2.setRotationPoint(-9.0F, 23.0F, 3.0F);
        this.MowerBlade2.addBox(0.0F, 0.0F, -8.5F, 1, 1, 17, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.MowerConnector3.render(f5);
        this.MowerBladeCon1.render(f5);
        this.MowerBladeCon2.render(f5);
        this.MowerDeck.render(f5);
        this.MowerDeck2.render(f5);
        this.MowerConnector.render(f5);
        this.MowerBlade1.render(f5);
        this.MowerConnector2.render(f5);
        this.MowerBlade2.render(f5);
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
