package com.extfar.animals.model;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelGoat extends ModelBase
{
  //fields
    ModelRenderer body1;
    ModelRenderer fr_leg;
    ModelRenderer bl_leg;
    ModelRenderer fl_leg;
    ModelRenderer br_leg;
    ModelRenderer neck1;
    ModelRenderer head;
    ModelRenderer neck2;
    ModelRenderer tail_scruff;
    ModelRenderer body2;
    ModelRenderer body3;
    ModelRenderer body4;
    ModelRenderer body5;
    ModelRenderer jaw;
    ModelRenderer goaty;
    ModelRenderer left_ear;
    ModelRenderer right_ear;
    ModelRenderer left_horn;
    ModelRenderer right_horn;
    ModelRenderer Uier;
  
  public ModelGoat()
  {
    textureWidth = 64;
    textureHeight = 64;
    
      body1 = new ModelRenderer(this, 1, 0);
      body1.addBox(0F, 0F, 0F, 7, 6, 14);
      body1.setRotationPoint(-3.5F, 12F, -7F);
      body1.setTextureSize(64, 64);
      body1.mirror = true;
      setRotation(body1, 0F, 0F, 0F);
      fr_leg = new ModelRenderer(this, 14, 31);
      fr_leg.addBox(0F, 0F, -4F, 2, 6, 2);
      fr_leg.setRotationPoint(-3F, 18F, -2.5F);
      fr_leg.setTextureSize(64, 64);
      fr_leg.mirror = true;
      setRotation(fr_leg, -0.0349066F, 0F, 0F);
      bl_leg = new ModelRenderer(this, 24, 41);
      bl_leg.addBox(0F, 0F, 0F, 2, 6, 2);
      bl_leg.setRotationPoint(1F, 18F, 4.5F);
      bl_leg.setTextureSize(64, 64);
      bl_leg.mirror = true;
      setRotation(bl_leg, -0.0733038F, 0F, 0F);
      fl_leg = new ModelRenderer(this, 24, 31);
      fl_leg.addBox(0F, 0F, 0F, 2, 6, 2);
      fl_leg.setRotationPoint(1F, 18F, -6.5F);
      fl_leg.setTextureSize(64, 64);
      fl_leg.mirror = true;
      setRotation(fl_leg, -0.0349066F, 0F, 0F);
      br_leg = new ModelRenderer(this, 14, 41);
      br_leg.addBox(0F, 0F, 0F, 2, 6, 2);
      br_leg.setRotationPoint(-3F, 18F, 4.5F);
      br_leg.setTextureSize(64, 64);
      br_leg.mirror = true;
      setRotation(br_leg, -0.0733038F, 0F, 0F);
      neck1 = new ModelRenderer(this, 44, 11);
      neck1.addBox(0F, 0F, 0F, 4, 6, 3);
      neck1.setRotationPoint(-2F, 13F, -10F);
      neck1.setTextureSize(64, 64);
      neck1.mirror = true;
      setRotation(neck1, 1.198081F, 0F, 0F);
      head = new ModelRenderer(this, 0, 22);
      head.addBox(0F, 0F, 0F, 3, 2, 5);
      head.setRotationPoint(-1.5F, 10.53333F, -13.33333F);
      head.setTextureSize(64, 64);
      head.mirror = true;
      setRotation(head, 0.296706F, 0F, 0F);
      neck2 = new ModelRenderer(this, 44, 1);
      neck2.addBox(0F, 0F, 0F, 5, 5, 2);
      neck2.setRotationPoint(-2.5F, 12.4F, -8F);
      neck2.setTextureSize(64, 64);
      neck2.mirror = true;
      setRotation(neck2, 0.1487144F, 0F, 0F);
      tail_scruff = new ModelRenderer(this, 34, 22);
      tail_scruff.addBox(0F, 0F, 0F, 2, 3, 1);
      tail_scruff.setRotationPoint(-1F, 10.2F, 7F);
      tail_scruff.setTextureSize(64, 64);
      tail_scruff.mirror = true;
      setRotation(tail_scruff, -0.1487144F, 0F, 0F);
      body2 = new ModelRenderer(this, 0, 52);
      body2.addBox(0F, 0F, 0F, 3, 2, 3);
      body2.setRotationPoint(0.5333334F, 18F, 3.666667F);
      body2.setTextureSize(64, 64);
      body2.mirror = true;
      setRotation(body2, 0.148353F, 0F, 0F);
      body3 = new ModelRenderer(this, 0, 45);
      body3.addBox(0F, 0F, 0F, 3, 2, 3);
      body3.setRotationPoint(-3.54F, 18F, 3.7F);
      body3.setTextureSize(64, 64);
      body3.mirror = true;
      setRotation(body3, 0.148353F, 0F, 0F);
      body4 = new ModelRenderer(this, 0, 38);
      body4.addBox(0F, 0F, 0F, 3, 2, 3);
      body4.setRotationPoint(0.5F, 17F, -7F);
      body4.setTextureSize(64, 64);
      body4.mirror = true;
      setRotation(body4, 0.0789013F, 0F, 0F);
      body5 = new ModelRenderer(this, 0, 31);
      body5.addBox(0F, 0F, 0F, 3, 2, 3);
      body5.setRotationPoint(-3.5F, 17F, -7F);
      body5.setTextureSize(64, 64);
      body5.mirror = true;
      setRotation(body5, 0.0789013F, 0F, 0F);
      jaw = new ModelRenderer(this, 18, 22);
      jaw.addBox(0F, -0.3F, -0.4F, 2, 1, 5);
      jaw.setRotationPoint(-1F, 12.5F, -12.3F);
      jaw.setTextureSize(64, 64);
      jaw.mirror = true;
      setRotation(jaw, 0.296706F, 0F, 0F);
      goaty = new ModelRenderer(this, 34, 40);
      goaty.addBox(-0.5F, 0F, -0.1F, 1, 2, 0);
      goaty.setRotationPoint(0F, 13F, -12F);
      goaty.setTextureSize(64, 64);
      goaty.mirror = true;
      setRotation(goaty, 0.0743572F, 0F, 0F);
      left_ear = new ModelRenderer(this, 34, 28);
      left_ear.addBox(0F, 0F, 0F, 1, 3, 1);
      left_ear.setRotationPoint(1F, 10F, -10.2F);
      left_ear.setTextureSize(64, 64);
      left_ear.mirror = true;
      setRotation(left_ear, -0.0366519F, 0F, -0.445059F);
      right_ear = new ModelRenderer(this, 34, 34);
      right_ear.addBox(0F, 0F, 0F, 3, 1, 1);
      right_ear.setRotationPoint(-3.3F, 12.3F, -10.2F);
      right_ear.setTextureSize(64, 64);
      right_ear.mirror = true;
      setRotation(right_ear, -0.0366519F, 0F, -1.077095F);
      left_horn = new ModelRenderer(this, 14, 51);
      left_horn.addBox(0F, 0F, 0F, 1, 3, 1);
      left_horn.setRotationPoint(1F, 8F, -8F);
      left_horn.setTextureSize(64, 64);
      left_horn.mirror = true;
      setRotation(left_horn, -0.6283185F, 0.5201081F, 0F);
      right_horn = new ModelRenderer(this, 20, 51);
      right_horn.addBox(-0.1F, 0.3F, -0.4F, 1, 3, 1);
      right_horn.setRotationPoint(-2F, 8F, -8F);
      right_horn.setTextureSize(64, 64);
      right_horn.mirror = true;
      setRotation(right_horn, -0.6283185F, -0.5201081F, 0F);
      Uier = new ModelRenderer(this, 0, 0);
      Uier.addBox(0F, 0F, 0F, 2, 1, 2);
      Uier.setRotationPoint(-1F, 18F, 2F);
      Uier.setTextureSize(64, 64);
      Uier.mirror = true;
      setRotation(Uier, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5);
    if (this.isChild)
    {
        float var8 = 2.0F;
        GL11.glPushMatrix();
        GL11.glTranslatef(0.0F, 5.0F * f5, 2.0F * f5);
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        GL11.glScalef(1.0F / var8, 1.0F / var8, 1.0F / var8);
        GL11.glTranslatef(0.0F, 24.0F * f5, 0.0F);
        body1.render(f5);
        fr_leg.render(f5);
        bl_leg.render(f5);
        fl_leg.render(f5);
        br_leg.render(f5);
        neck1.render(f5);
        head.render(f5);
        neck2.render(f5);
        tail_scruff.render(f5);
        body2.render(f5);
        body3.render(f5);
        body4.render(f5);
        body5.render(f5);
        jaw.render(f5);
        goaty.render(f5);
        left_ear.render(f5);
        right_ear.render(f5);
        left_horn.render(f5);
        right_horn.render(f5);
        Uier.render(f5);
        GL11.glPopMatrix();
        
    }
    else
    {
    body1.render(f5);
    fr_leg.render(f5);
    bl_leg.render(f5);
    fl_leg.render(f5);
    br_leg.render(f5);
    neck1.render(f5);
    head.render(f5);
    neck2.render(f5);
    tail_scruff.render(f5);
    body2.render(f5);
    body3.render(f5);
    body4.render(f5);
    body5.render(f5);
    jaw.render(f5);
    goaty.render(f5);
    left_ear.render(f5);
    right_ear.render(f5);
    left_horn.render(f5);
    right_horn.render(f5);
    Uier.render(f5);
    }
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, null);
    this.fr_leg.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
    this.fl_leg.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
    this.br_leg.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
    this.bl_leg.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
  }

}
