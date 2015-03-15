package com.extfar.tractor;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.extfar.tractor.model.ModelTractor;
import com.extfar.tractor.model.ModelTractor2;

public class RenderTractor extends Render
{
	public ModelBase model = new ModelTractor();
	public ModelBase model2 = new ModelTractor2();

	
	public RenderTractor()
	{
	}

	public void doRendertractor(EntityTractor tractor, double x, double y, double z, float rotationYaw, float par1)
	{
		if (!tractor.isDead)
		{
			GL11.glPushMatrix();
			GL11.glTranslatef((float)x, (float)y + 1.1F, (float)z);
			GL11.glRotatef(180.0F - rotationYaw, 0.0F, 1.0F, 0.0F);
			float timeSinceHit = (float)tractor.getTimeSinceHit() - par1;
			float damageTaken = tractor.getDamageTaken() - par1;

			if (damageTaken < 0.0F)
			{
				damageTaken = 0.0F;
			}

			if (timeSinceHit > 0.0F)
			{
				GL11.glRotatef(MathHelper.sin(timeSinceHit) * timeSinceHit * damageTaken / 10.0F * (float)tractor.getForwardDirection(), 0.0F, 0.0F, 1.0F);
			}

			float f4 = 0.75F;
			GL11.glScalef(f4, f4, f4);
			GL11.glScalef(1.0F / f4, 1.0F / f4, 1.0F / f4);
			this.bindEntityTexture(tractor);
			GL11.glScalef(-1.0F, -1.0F, 1.0F);
			
			if(tractor.hasSeederOn() || tractor.hasHarvesterOn())
			this.model2.render(tractor, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
			else
			this.model.render(tractor, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
			GL11.glPopMatrix();
		}
	}

	@Override
	public void doRender(Entity entity, double x, double y, double z, float rotationYaw, float par1) 
	{
		doRendertractor((EntityTractor) entity, x, y, z, rotationYaw, par1);
	}

	@Override
	public ResourceLocation getEntityTexture(Entity entity) 
	{
		EntityTractor tractor = (EntityTractor)entity;
		if(tractor.hasSeederOn() || tractor.hasHarvesterOn())
		return tractor.Tractor2Texture;
		else
		return tractor.TractorTexture;
	}

}