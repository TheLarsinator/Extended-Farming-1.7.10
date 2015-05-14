package com.extfar.blocks.milking;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.extfar.core.ExtendedFarming;
import com.extfar.core.RenderHelper;
import com.extfar.init.ExtendedFarmingBlocks;

public class TileEntityRendererCheeseBarrel extends TileEntitySpecialRenderer
{
	private ModelCheeseBarrel model;

	public TileEntityRendererCheeseBarrel(){
		model = new ModelCheeseBarrel();
		}

		public void renderAModelAt(TileEntityCheeseBarrel tile, double d, double d1, double d2, float f) {

		int rotation = 0;
		if(tile.getWorldObj() != null)
		{
		rotation = tile.getBlockMetadata();
		}
		switch(tile.cheeseAmount)
		{
		case 0:
				Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(ExtendedFarming.modid, "textures/blocks/CheeseBarrel/CheeseBarrel0.png"));
				break;
		case 1:
				Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(ExtendedFarming.modid, "textures/blocks/CheeseBarrel/CheeseBarrel1.png"));
				break;
		case 2:
				Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(ExtendedFarming.modid, "textures/blocks/CheeseBarrel/CheeseBarrel2.png"));
				break;
		case 3:
				Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(ExtendedFarming.modid, "textures/blocks/CheeseBarrel/CheeseBarrel3.png"));
				break;
		}
		GL11.glPushMatrix();
		GL11.glTranslatef((float)d + 0.5F, (float)d1 + 1.5F, (float)d2 + 0.5F);
		GL11.glScalef(1F, -1F, -1F);
		GL11.glRotatef(rotation*90, 0.0F, 1.0F, 0.0F);
		model.renderAll(0.0625F);
		GL11.glPopMatrix(); //end

		}

	    public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float meta)
	    {
			this.renderAModelAt((TileEntityCheeseBarrel)tileEntity, x, y, z, meta);
	        
			TileEntityCheeseBarrel tile = (TileEntityCheeseBarrel) tileEntity;
			
			if(tile.hasMilk)
			{
	        int[] displayList = RenderHelper.getFluidDisplayLists(tile.getWorldObj(), ExtendedFarmingBlocks.MilkFluid, ExtendedFarmingBlocks.MilkLiquid);
	        GL11.glPushMatrix();
	        GL11.glPushAttrib(GL11.GL_ENABLE_BIT);
	        GL11.glEnable(GL11.GL_CULL_FACE);
	        GL11.glDisable(GL11.GL_LIGHTING);
	        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
	        this.bindTexture(TextureMap.locationBlocksTexture);
	        GL11.glTranslatef((float) x, (float) y, (float) z);
	        GL11.glScalef(0.8f, 0.1f, 0.8f);
	        GL11.glTranslatef(0.1f, (float)tile.milkAmount, 0.1f);
	        GL11.glCallList(displayList[7]);
	        GL11.glPopAttrib();
	        GL11.glPopMatrix();
			}
	    }
		
}