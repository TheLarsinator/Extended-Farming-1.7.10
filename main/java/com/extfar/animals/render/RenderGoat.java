package com.extfar.animals.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

import com.extfar.animals.entity.EntityGoat;
import com.extfar.core.ExtendedFarming;



import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


@SideOnly(Side.CLIENT)
public class RenderGoat extends RenderLiving
{

    public RenderGoat(ModelBase modelbase, float f)
    {
        super(modelbase, f); 
    }

    public void func_177_a(EntityGoat entityGoat, double d, double d1, double d2, 
            float f, float f1)
    {
        super.doRender(entityGoat, d, d1, d2, f, f1);
    }

    public void doRenderLiving(EntityLiving entityliving, double d, double d1, double d2, 
            float f, float f1)
    {
    	func_177_a((EntityGoat)entityliving, d, d1, d2, f, f1);
    }

    public void doRender(Entity entity, double d, double d1, double d2, 
            float f, float f1)
    {
    	func_177_a((EntityGoat)entity, d, d1, d2, f, f1);
    }
	private static final ResourceLocation texture = new ResourceLocation(ExtendedFarming.modid + ":textures/entities/Goat.png");
	
	 protected ResourceLocation func_110872_a(EntityGoat par1Entity)
	    {

			return texture;
		}
	 @Override
	    protected ResourceLocation getEntityTexture(Entity par1Entity)
	    {
	        return this.func_110872_a((EntityGoat)par1Entity);
	    }
}