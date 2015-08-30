package com.extfar.core.handler;

import net.minecraft.item.Item;
import net.minecraftforge.event.world.BlockEvent;

import com.extfar.init.ExtendedFarmingAchievementsBook;
import com.extfar.init.ExtendedFarmingBlocks;
import com.extfar.init.ExtendedFarmingItems;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;

public class ExtendedFarmingEventHandler 
{	
	@SubscribeEvent
	public void OnItemPickUp(PlayerEvent.ItemPickupEvent event)
	{
		
	}
	@SubscribeEvent
	public void OnLogIn(PlayerEvent.PlayerLoggedInEvent event)
	{
		event.player.addStat(ExtendedFarmingAchievementsBook.AchievementextfarLogIn, 1);	
	}
	@SubscribeEvent
	public void OnBlockBreak(BlockEvent.BreakEvent event)
	{
		if(event.blockMetadata == 7)
		{
			if(event.block == ExtendedFarmingBlocks.Beans_Block)
				event.getPlayer().addStat(ExtendedFarmingAchievementsBook.AchievementextfarBeans, 1);
			if(event.block == ExtendedFarmingBlocks.Peas_Block)
				event.getPlayer().addStat(ExtendedFarmingAchievementsBook.AchievementextfarPeas, 1);
			if(event.block == ExtendedFarmingBlocks.ChilliPepper_Block)
				event.getPlayer().addStat(ExtendedFarmingAchievementsBook.AchievementextfarPeppers, 1);
			if(event.block == ExtendedFarmingBlocks.SugarBeet_Block)
				event.getPlayer().addStat(ExtendedFarmingAchievementsBook.AchievementextfarSugarBeets, 1);
			if(event.block == ExtendedFarmingBlocks.Beets_Block)
				event.getPlayer().addStat(ExtendedFarmingAchievementsBook.AchievementextfarBeets, 1);
			if(event.block == ExtendedFarmingBlocks.NetherBeets  || event.block == ExtendedFarmingBlocks.NetherPeppers  || event.block == ExtendedFarmingBlocks.NetherPeas  || event.block == ExtendedFarmingBlocks.NetherBeans)
				event.getPlayer().addStat(ExtendedFarmingAchievementsBook.AchievementextfarShortcut, 1);
		}
	}
	@SubscribeEvent
	public void OnCrafted(PlayerEvent.ItemCraftedEvent event)
	{
		if(event.crafting.getItem() == ExtendedFarmingItems.QuartzHoe)
		{
			event.player.addStat(ExtendedFarmingAchievementsBook.AchievementextfarNetherFarming, 1);
		}
		if(event.crafting.getItem() == Item.getItemFromBlock(ExtendedFarmingBlocks.Sprayer))
		{
			event.player.addStat(ExtendedFarmingAchievementsBook.AchievementextfarSprinkler, 1);
		}
		if(event.crafting.getItem() == Item.getItemFromBlock(ExtendedFarmingBlocks.Pump))
		{
			event.player.addStat(ExtendedFarmingAchievementsBook.AchievementextfarPump, 1);
		}
		if(event.crafting.getItem() == Item.getItemFromBlock(ExtendedFarmingBlocks.NetherSprayer))
		{
			event.player.addStat(ExtendedFarmingAchievementsBook.AchievementextfarLavaSprinkler, 1);
		}
		if(event.crafting.getItem() == Item.getItemFromBlock(ExtendedFarmingBlocks.NetherPump))
		{
			event.player.addStat(ExtendedFarmingAchievementsBook.AchievementextfarLavaPump, 1);
		}
	}
	
}
