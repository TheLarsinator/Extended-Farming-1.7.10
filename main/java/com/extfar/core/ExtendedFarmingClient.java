package com.extfar.core;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;

import com.extfar.blocks.nether.hose.TileEntityActiveNetherHose;
import com.extfar.blocks.nether.hose.TileEntityNetherHose;
import com.extfar.blocks.nether.hose.TileEntityPassiveNetherHose;
import com.extfar.blocks.nether.hose.TileEntityRendererActiveNetherHose;
import com.extfar.blocks.nether.hose.TileEntityRendererNetherHose;
import com.extfar.blocks.nether.hose.TileEntityRendererPassiveNetherHose;
import com.extfar.blocks.nether.pump.ItemRenderNetherPump;
import com.extfar.blocks.nether.pump.TileEntityNetherPump;
import com.extfar.blocks.nether.pump.TileEntityRendererNetherPump;
import com.extfar.blocks.nether.sprayer.ItemRenderNetherSprayer;
import com.extfar.blocks.nether.sprayer.TileEntityActiveNetherSprayer;
import com.extfar.blocks.nether.sprayer.TileEntityNetherSprayer;
import com.extfar.blocks.nether.sprayer.TileEntityRendererActiveNetherSprayer;
import com.extfar.blocks.nether.sprayer.TileEntityRendererNetherSprayer;
import com.extfar.blocks.overworld.hose.TileEntityActiveHose;
import com.extfar.blocks.overworld.hose.TileEntityHose;
import com.extfar.blocks.overworld.hose.TileEntityPassiveHose;
import com.extfar.blocks.overworld.hose.TileEntityRendererActiveHose;
import com.extfar.blocks.overworld.hose.TileEntityRendererHose;
import com.extfar.blocks.overworld.hose.TileEntityRendererPassiveHose;
import com.extfar.blocks.overworld.pump.ItemRenderPump;
import com.extfar.blocks.overworld.pump.TileEntityPump;
import com.extfar.blocks.overworld.pump.TileEntityRendererPump;
import com.extfar.blocks.overworld.sprayer.ItemRenderSprayer;
import com.extfar.blocks.overworld.sprayer.TileEntityActiveSprayer;
import com.extfar.blocks.overworld.sprayer.TileEntityRendererActiveSprayer;
import com.extfar.blocks.overworld.sprayer.TileEntityRendererSprayer;
import com.extfar.blocks.overworld.sprayer.TileEntitySprayer;
import com.extfar.init.ExtendedFarmingBlocks;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ExtendedFarmingClient extends ExtendedFarmingProxy{
    
	@SideOnly(Side.CLIENT)
	public void registerRenderInformation()
        {
  		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityHose.class, new TileEntityRendererHose());
  		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityActiveHose.class, new TileEntityRendererActiveHose());
  		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPassiveHose.class, new TileEntityRendererPassiveHose());
  		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPump.class, new TileEntityRendererPump());
  		ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySprayer.class, new TileEntityRendererSprayer());
  		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityActiveSprayer.class, new TileEntityRendererActiveSprayer());
  		
  		
  		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ExtendedFarmingBlocks.Pump), (new ItemRenderPump()));
  		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ExtendedFarmingBlocks.Sprayer), (new ItemRenderSprayer()));

  		
  		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityNetherHose.class, new TileEntityRendererNetherHose());
  		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityActiveNetherHose.class, new TileEntityRendererActiveNetherHose());
  		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPassiveNetherHose.class, new TileEntityRendererPassiveNetherHose());
  		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityNetherPump.class, new TileEntityRendererNetherPump());
  		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityNetherSprayer.class, new TileEntityRendererNetherSprayer());
  		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityActiveNetherSprayer.class, new TileEntityRendererActiveNetherSprayer());
  		
  		
  		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ExtendedFarmingBlocks.NetherPump), (new ItemRenderNetherPump()));
  		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ExtendedFarmingBlocks.NetherSprayer), (new ItemRenderNetherSprayer()));
        }
    public int addArmor(String armor){
    	return RenderingRegistry.addNewArmourRendererPrefix(armor);
    }
    
    public ModelBiped getArmorModel(int id)
    {
		return null;
    	
    }
}
