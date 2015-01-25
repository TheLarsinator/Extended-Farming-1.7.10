package com.extfar.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import com.extfar.core.ExtendedFarming;
import com.extfar.tractor.EntityTractor;
import com.extfar.tractor.TractorType;

public class ItemTractor extends Item
{
	public int colour;

	public ItemTractor(int colour)
	{
		super();
		this.setUnlocalizedName("Tractor_" + colour);
		this.colour = colour;
		this.setMaxStackSize(1);
		this.setCreativeTab(ExtendedFarming.ItemsTab);
	}

	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int par7, float par8, float par9, float par10)
	{
		if (!player.capabilities.isCreativeMode)
		{
			--stack.stackSize;
		}

		if (!world.isRemote)
		{
			EntityTractor entityBasicTractor = new EntityTractor(world, x, y + 2, z, colour, player.getCommandSenderName(), TractorType.DEFUALT);
			entityBasicTractor.rotationYaw = (float)((((MathHelper.floor_double((double)(player.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3) - 1) * 90) - 90);
			world.spawnEntityInWorld(entityBasicTractor); 
		}

		if(player.capabilities.isCreativeMode)
		{
			stack.stackSize--;
		}

		return true;
	}
}
