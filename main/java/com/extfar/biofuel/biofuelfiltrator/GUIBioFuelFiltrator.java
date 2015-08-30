package com.extfar.biofuel.biofuelfiltrator;

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
		this.fontRendererObj.drawString(StatCollector.translateToLocal("Biofuel filtrator"), 8, (ySize - 164) + 2, 0x8b8b8b);
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
			int burn = BFCInventory.getBurnTimeRemainingScaled(9);
			drawTexturedModalRect(j + 36, k + 33  + 9-burn , 176, 40-burn , 18 , burn+2);
		}

		int update = BFCInventory.getCookProgressScaled(58);
		drawTexturedModalRect(j + 55, k + 19, 176, 42,  update, 38);

	}
}