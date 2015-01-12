package com.extfar.init;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;

public class ExtendedFarmingAchievementsBook 
{		
	
	public static Achievement AchievementextfarLogIn;
	public static Achievement AchievementextfarPump;
	public static Achievement AchievementextfarSprinkler;
	public static Achievement AchievementextfarNetherFarming;
	public static Achievement AchievementextfarLavaPump;
	public static Achievement AchievementextfarLavaSprinkler;

	//Harvest them crops!
	public static Achievement AchievementextfarBeans;
	public static Achievement AchievementextfarPeas;
	public static Achievement AchievementextfarPeppers;
	public static Achievement AchievementextfarSugarBeets;
	public static Achievement AchievementextfarBeets;
	public static Achievement AchievementextfarShortcut;

	public static void init()
	{

		
		AchievementextfarLogIn = new Achievement("achievement.extfarlogin", "extfarlogin", 0, 0, Items.map, (Achievement)null).registerStat();

		AchievementextfarPump = new Achievement("achievement.extfarpump", "extfarpump", 2, 2, Item.getItemFromBlock(ExtendedFarmingBlocks.Pump), (Achievement)AchievementextfarLogIn).registerStat();
		AchievementextfarSprinkler = new Achievement("achievement.extfarsprinkler", "extfarsprinkler", 4, 2, Item.getItemFromBlock(ExtendedFarmingBlocks.Sprayer), (Achievement)AchievementextfarLogIn).registerStat();

		AchievementextfarNetherFarming = new Achievement("achievement.extfarnether", "extfarnether", 2, -1, ExtendedFarmingItems.QuartzHoe, (Achievement)AchievementextfarLogIn).registerStat();
		AchievementextfarLavaPump = new Achievement("achievement.extfarlavapump", "extfarlavapump", 2, -4, ExtendedFarmingBlocks.NetherPump, (Achievement)AchievementextfarNetherFarming).registerStat();
		AchievementextfarLavaSprinkler = new Achievement("achievement.extfarlavasprinkler", "extfarlavasprinkler", 4, -4, ExtendedFarmingBlocks.NetherSprayer, (Achievement)AchievementextfarNetherFarming).registerStat();
		AchievementextfarShortcut = new Achievement("achievement.extfarshortcut", "extfarshortcut", 6, -2, Blocks.furnace, (Achievement)AchievementextfarNetherFarming).registerStat();

		AchievementextfarBeans = new Achievement("achievement.extfarbeans", "extfarbeans", -4, 0, ExtendedFarmingItems.Beans, (Achievement)AchievementextfarLogIn).registerStat();
		AchievementextfarPeas = new Achievement("achievement.extfarpeas", "extfarpeas", -4, -2, ExtendedFarmingItems.Peas, (Achievement)AchievementextfarLogIn).registerStat();
		AchievementextfarPeppers = new Achievement("achievement.extfarpeppers", "extfarpeppers", -4, 2, ExtendedFarmingItems.ChilliPeppers, (Achievement)AchievementextfarLogIn).registerStat();
		AchievementextfarSugarBeets = new Achievement("achievement.extfarsugarbeets", "extfarsugarbeets", -4, -4, ExtendedFarmingItems.SugarBeets, (Achievement)AchievementextfarLogIn).registerStat();
		AchievementextfarBeets = new Achievement("achievement.extfarbeets", "extfarbeets", -4, 4, ExtendedFarmingItems.Beets, (Achievement)AchievementextfarLogIn).registerStat();

        AchievementPage AchievementPageExtendedFarming = new AchievementPage("ExtendedFarming", new Achievement[]
        		{AchievementextfarLogIn,
        		AchievementextfarPump,
        		AchievementextfarSprinkler,
        		AchievementextfarNetherFarming,
        		AchievementextfarLavaPump,
        		AchievementextfarLavaSprinkler,
        		AchievementextfarBeans,
        		AchievementextfarPeas,
        		AchievementextfarPeppers,
        		AchievementextfarSugarBeets,
        		AchievementextfarBeets,
        		AchievementextfarShortcut
        		});
        AchievementPage.registerAchievementPage(AchievementPageExtendedFarming);
	}

}
