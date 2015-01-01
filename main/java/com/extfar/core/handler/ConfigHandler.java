package com.extfar.core.handler;

import java.io.File;

import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class ConfigHandler 
{
	
	public static Configuration config;
	
	public static void LoadFile(File configFile)
	{
		config = new Configuration(configFile);
		
		config.load();
		syncConfig();
		
		FMLCommonHandler.instance().bus().register(new ConfigChanger());
	}
	
	public static void syncConfig()
	{
		
		
		if(config.hasChanged())	
		config.save();
	}
	
	public static class ConfigChanger 
	{
	@SubscribeEvent
		public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent eventArgs) {
			if(eventArgs.modID.equals("extfar"))
				syncConfig();
	}
	}
}
		