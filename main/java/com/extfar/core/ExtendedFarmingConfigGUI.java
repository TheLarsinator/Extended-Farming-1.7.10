package com.extfar.core;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.gui.GuiScreen;
import cpw.mods.fml.client.config.GuiConfig;
import cpw.mods.fml.client.config.IConfigElement;

public class ExtendedFarmingConfigGUI extends GuiConfig 
{
    public ExtendedFarmingConfigGUI(GuiScreen parent) 
    {
    	super(parent, getConfigElements(), "lom", false, false, "LotsOMobs Config");
    }
    
    private static List<IConfigElement> getConfigElements()
    {
        List<IConfigElement> list = new ArrayList<IConfigElement>();
        //list.add(new DummyCategoryElement("LotsOMobs Mobs", "LotsOMobsMobs", LotsOMobsMobConfig.class));
        return list;
    }
    
   /* public static class LotsOMobsMobConfig extends CategoryEntry
    {
        public LotsOMobsMobConfig(GuiConfig owningScreen, GuiConfigEntries owningEntryList, IConfigElement prop)
        {
            super(owningScreen, owningEntryList, prop);
        }
        
        @Override
        protected GuiScreen buildChildScreen()
        {
            // This GuiConfig object specifies the configID of the object and as such will force-save when it is closed. The parent
            // GuiConfig object's entryList will also be refreshed to reflect the changes.
            return new GuiConfig(this.owningScreen, 
                    new ConfigElement(ConfigHandler.config.getCategory("mobs")).getChildElements(), "lom", false, false, "LotsOMobs Config", GuiConfig.getAbridgedConfigPath(ConfigHandler.config.toString()));
        }
    }*/
    
}