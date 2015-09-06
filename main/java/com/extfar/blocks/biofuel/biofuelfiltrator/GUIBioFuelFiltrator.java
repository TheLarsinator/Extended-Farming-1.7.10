package com.extfar.blocks.biofuel.biofuelfiltrator;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import com.extfar.core.ExtendedFarming;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GUIBioFuelFiltrator extends GuiContainer
{

	private TileEntityBioFuelFiltrator BFCInventory;
	private static final ResourceLocation texture = new ResourceLocation(
			ExtendedFarming.modid, "textures/gui/BioFuelFiltratorGUI.png");

	public GUIBioFuelFiltrator(InventoryPlayer inventory, TileEntityBioFuelFiltrator tileentity)
	{
		super(new ContainerBioFuelFiltrator(inventory, tileentity));
		BFCInventory = tileentity;
	}

	/**
	 * Draw the foreground layer for the GuiContainer (everythin in front of the
	 * items)
	 */
	protected void drawGuiContainerForegroundLayer(int par1, int par2)
	{
		this.fontRendererObj.drawString(StatCollector.translateToLocal("container.inventory"), 8, (ySize - 96) + 2, 0x8b8b8b);
		this.fontRendererObj.drawString(StatCollector.translateToLocal("Biofuel filtrator"), 9, (ySize - 164) + 4, 0x8b8b8b);
	}

	/**s
	 * Draw the background layer for the GuiContainer (everything behind the
	 * items)
	 */
	protected void drawGuiContainerBackgroundLayer(float par1, int par2,
			int par3)
	{
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(texture);
		int j = (width - xSize) / 2;
		int k = (height - ySize) / 2;
		drawTexturedModalRect(j, k, 0, 0, xSize, ySize);

		if (BFCInventory.isBurning())
		{
			drawTexturedModalRect(j + 80, k + 33, 176, 0 , 11, 5);
		

		/*	int update = BFCInventory.getBurnTimeRemainingScaled(31);
			drawTexturedModalRect(j + 81, k + 19 + 31 - update , 176, 35-update , 9, update+2); */
			int update = BFCInventory.getBurnTimeRemainingScaled(12);
			drawTexturedModalRect(j + 81, k + 19 + 12 - update , 176, 16-update , 9, update+2); 	
			int updat1 = BFCInventory.getCookProgressScaled(12);
			drawTexturedModalRect(j + 81, k + 38 + 12 - updat1 , 176, 35-updat1 , 9, updat1+1); 	

		}
	}
}