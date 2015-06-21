package com.extfar.blocks.milking;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.extfar.core.ExtendedFarming;

public class TileEntityRendererMilkingStation extends TileEntitySpecialRenderer
{
	
	public TileEntityRendererMilkingStation(){
		model = new ModelMilkingStation();
		}

		public void renderAModelAt(TileEntityMilkingStation tile, double d, double d1, double d2, float f) {

		int rotation = 0;
		if(tile.getWorldObj() != null)
		{
		rotation = tile.getBlockMetadata();
		}
		switch(tile.milkAmount)
		{
		default:
		case 0: Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(ExtendedFarming.modid, "textures/blocks/MilkingStation0.png"));
		break;
		
		case 1: Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(ExtendedFarming.modid, "textures/blocks/MilkingStation1.png"));
		break;
		
		case 2: Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(ExtendedFarming.modid, "textures/blocks/MilkingStation2.png"));
		break;
		
		case 3: Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(ExtendedFarming.modid, "textures/blocks/MilkingStation3.png"));
		break;
		
		case 4: Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(ExtendedFarming.modid, "textures/blocks/MilkingStation4.png"));
		break;
		
		case 5: Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(ExtendedFarming.modid, "textures/blocks/MilkingStation5.png"));
		break;
		
		case 6: Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(ExtendedFarming.modid, "textures/blocks/MilkingStation6.png"));
		break;
		
		case 7: Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(ExtendedFarming.modid, "textures/blocks/MilkingStation7.png"));
		break;
		
		case 8: Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(ExtendedFarming.modid, "textures/blocks/MilkingStation8.png"));
		break;
		}
		GL11.glPushMatrix();
		GL11.glTranslatef((float)d + 0.5F, (float)d1 + 1.5F, (float)d2 + 0.5F);
		GL11.glScalef(1F, -1F, -1F);
		GL11.glRotatef(rotation*90, 0.0F, 1.0F, 0.0F);
		model.renderAll(0.0625F);
		GL11.glPopMatrix(); //end
		}

		private ModelMilkingStation model;

		public void renderTileEntityAt(TileEntity par1TileEntity, double par2, double par4, double par6, float par8)
		{
		this.renderAModelAt((TileEntityMilkingStation)par1TileEntity, par2, par4, par6, par8);
		}
}
    






