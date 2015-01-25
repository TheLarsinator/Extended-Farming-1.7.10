package com.extfar.tractor.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.extfar.tractor.entity.EntitySprayer;

public class RenderSprayer extends Render
{
	public ModelBase model;

	
	public RenderSprayer(ModelBase model)
	{
		this.model = model;
	}

	public void doRenderCar(EntitySprayer car, double x, double y, double z, float rotationYaw, float par1)
	{
		if (!car.isDead)
		{
			GL11.glPushMatrix();
			GL11.glTranslatef((float)x, (float)y + 1.1F, (float)z);
			GL11.glRotatef(180.0F - rotationYaw, 0.0F, 1.0F, 0.0F);

			//GL11.glRotatef(MathHelper.sin(timeSinceHit) * timeSinceHit * damageTaken / 10.0F * (float)car.getForwardDirection(), 0.0F, 0.0F, 1.0F);
			

			float f4 = 0.75F;
			GL11.glScalef(f4, f4, f4);
			GL11.glScalef(1.0F / f4, 1.0F / f4, 1.0F / f4);
			this.bindEntityTexture(car);
			GL11.glScalef(-1.0F, -1.0F, 1.0F);
			this.model.render(car, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
			GL11.glPopMatrix();
		}
	}

	@Override
	public void doRender(Entity entity, double x, double y, double z, float rotationYaw, float par1) 
	{
		doRenderCar((EntitySprayer) entity, x, y, z, rotationYaw, par1);
	}

	@Override
	public ResourceLocation getEntityTexture(Entity entity) 
	{
		EntitySprayer Sprayer = (EntitySprayer)entity;
		return Sprayer.SprayerTexture;
	}

}