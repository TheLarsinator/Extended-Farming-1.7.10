package com.extfar.core;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
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
import com.extfar.init.ExtendedFarmingItems;
import com.extfar.tractor.EntityTractor;
import com.extfar.tractor.RenderTractor;
import com.extfar.tractor.TractorType;
import com.extfar.tractor.entity.EntityBody;
import com.extfar.tractor.entity.EntityChair;
import com.extfar.tractor.entity.EntityDriveShaft;
import com.extfar.tractor.entity.EntityEngine;
import com.extfar.tractor.entity.EntityMower;
import com.extfar.tractor.entity.EntityPlow;
import com.extfar.tractor.entity.EntitySprayer;
import com.extfar.tractor.entity.EntitySteeringWheel;
import com.extfar.tractor.entity.EntityWheel;
import com.extfar.tractor.itemrenderer.ItemRendererBody;
import com.extfar.tractor.itemrenderer.ItemRendererChair;
import com.extfar.tractor.itemrenderer.ItemRendererDriveShaft;
import com.extfar.tractor.itemrenderer.ItemRendererEngine;
import com.extfar.tractor.itemrenderer.ItemRendererMower;
import com.extfar.tractor.itemrenderer.ItemRendererPlow;
import com.extfar.tractor.itemrenderer.ItemRendererSteeringWheel;
import com.extfar.tractor.itemrenderer.ItemRendererTractor;
import com.extfar.tractor.itemrenderer.ItemRendererTractorSprayer;
import com.extfar.tractor.itemrenderer.ItemRendererWheel;
import com.extfar.tractor.model.ModelBody;
import com.extfar.tractor.model.ModelChair;
import com.extfar.tractor.model.ModelDriveShaft;
import com.extfar.tractor.model.ModelEngine;
import com.extfar.tractor.model.ModelMower;
import com.extfar.tractor.model.ModelPlow;
import com.extfar.tractor.model.ModelSteeringWheel;
import com.extfar.tractor.model.ModelTractor;
import com.extfar.tractor.model.ModelTractorSprayer;
import com.extfar.tractor.model.ModelWheel;
import com.extfar.tractor.render.RenderPlow;

import cpw.mods.fml.client.FMLClientHandler;
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
		MinecraftForgeClient.registerItemRenderer(ExtendedFarmingItems.Tractor, (IItemRenderer)new ItemRendererTractor(new EntityTractor(FMLClientHandler.instance().getClient().theWorld), new ModelTractor(), new ResourceLocation(ExtendedFarming.modid + ":textures/entities/Tractor.png")));
		MinecraftForgeClient.registerItemRenderer(ExtendedFarmingItems.Plow, (IItemRenderer)new ItemRendererPlow(new EntityPlow(FMLClientHandler.instance().getClient().theWorld), new ModelPlow(), new ResourceLocation(ExtendedFarming.modid + ":textures/entities/Plow.png")));
		MinecraftForgeClient.registerItemRenderer(ExtendedFarmingItems.Mower, (IItemRenderer)new ItemRendererMower(new EntityMower(FMLClientHandler.instance().getClient().theWorld), new ModelMower(), new ResourceLocation(ExtendedFarming.modid + ":textures/entities/TractorWMower.png")));
		MinecraftForgeClient.registerItemRenderer(ExtendedFarmingItems.Sprayer, (IItemRenderer)new ItemRendererTractorSprayer(new EntitySprayer(FMLClientHandler.instance().getClient().theWorld), new ModelTractorSprayer(), new ResourceLocation(ExtendedFarming.modid + ":textures/entities/Tractor.png")));

		MinecraftForgeClient.registerItemRenderer(ExtendedFarmingItems.Engine, (IItemRenderer)new ItemRendererEngine(new EntityEngine(FMLClientHandler.instance().getClient().theWorld), new ModelEngine(), new ResourceLocation(ExtendedFarming.modid + ":textures/items/Engine.png")));
		MinecraftForgeClient.registerItemRenderer(ExtendedFarmingItems.Body, (IItemRenderer)new ItemRendererBody(new EntityBody(FMLClientHandler.instance().getClient().theWorld), new ModelBody(), new ResourceLocation(ExtendedFarming.modid + ":textures/items/Tractor.png")));
		MinecraftForgeClient.registerItemRenderer(ExtendedFarmingItems.DriveShaft, (IItemRenderer)new ItemRendererDriveShaft(new EntityDriveShaft(FMLClientHandler.instance().getClient().theWorld), new ModelDriveShaft(), new ResourceLocation(ExtendedFarming.modid + ":textures/items/Tractor.png")));
		MinecraftForgeClient.registerItemRenderer(ExtendedFarmingItems.Wheel, (IItemRenderer)new ItemRendererWheel(new EntityWheel(FMLClientHandler.instance().getClient().theWorld), new ModelWheel(), new ResourceLocation(ExtendedFarming.modid + ":textures/items/Tractor.png")));
		MinecraftForgeClient.registerItemRenderer(ExtendedFarmingItems.SteeringWheel, (IItemRenderer)new ItemRendererSteeringWheel(new EntitySteeringWheel(FMLClientHandler.instance().getClient().theWorld), new ModelSteeringWheel(), new ResourceLocation(ExtendedFarming.modid + ":textures/items/Tractor.png")));
		MinecraftForgeClient.registerItemRenderer(ExtendedFarmingItems.Chair, (IItemRenderer)new ItemRendererChair(new EntityChair(FMLClientHandler.instance().getClient().theWorld), new ModelChair(), new ResourceLocation(ExtendedFarming.modid + ":textures/items/Tractor.png")));

  		RenderingRegistry.registerEntityRenderingHandler(EntityTractor.class, new RenderTractor(new ModelTractor(), TractorType.DEFUALT));
  		RenderingRegistry.registerEntityRenderingHandler(EntityPlow.class, new RenderPlow(new ModelPlow()));
        }
    public int addArmor(String armor){
    	return RenderingRegistry.addNewArmourRendererPrefix(armor);
    }
    
    public ModelBiped getArmorModel(int id)
    {
		return null;
    	
    }
}
