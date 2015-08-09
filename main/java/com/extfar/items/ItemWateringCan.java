package com.extfar.items;

import com.extfar.core.ExtendedFarming;
import com.extfar.init.ExtendedFarmingBlocks;
import com.extfar.init.ExtendedFarmingItems;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemWateringCan extends Item
{
	private boolean isEmpty;
	private boolean canHoldLava;

	public ItemWateringCan(boolean par1, boolean lava)
	{
		this.maxStackSize = 1;
		this.setMaxDamage(25);
		this.isEmpty = par1;
		this.canHoldLava = lava;
		this.setCreativeTab(ExtendedFarming.ItemsTab);
	}

	/**
	 * Callback for item usage. If the item does something special on right
	 * clicking, he will have one of those. Return True if something happen and
	 * false if it don't. This is for ITEMS, not BLOCKS
	 */
	public boolean onItemUse(ItemStack itemstack, EntityPlayer player, World world, int x, int y, int z, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_)
	{
		if (!isEmpty)
		{
			if (!this.canHoldLava)
			{
				if (world.getBlock(x, y, z) == Blocks.farmland)
				{
					world.setBlockMetadataWithNotify(x, y, z, world.getBlockMetadata(x, y, z) + 1, 2);

					for(float a = -5.0F; a <= 5F; ++a)
					{
						for(float c = -5.0F; c <= 5.0F; ++c)
						{
					          world.spawnParticle("splash", x + 0.7D, y+1F, z + 0.7D, (double)a/10, 0.0D, (double)c/10);
						}
					}
					
					if (itemstack.getItemDamage() == 25)
					{
						itemstack.damageItem(1, player);
						player.inventory.addItemStackToInventory(new ItemStack(ExtendedFarmingItems.EmptyWateringCan, 1));
					}
					else
					{
						itemstack.damageItem(1, player);
					}
					return true;
				}
			}
			else
			{
				if (world.getBlock(x, y, z) == ExtendedFarmingBlocks.FarmSoulSand)
				{
					world.setBlockMetadataWithNotify(x, y, z, world.getBlockMetadata(x, y, z) + 1, 2);

					for(float a = -1.0F; a <= 1F; ++a)
					{
						for(float c = -1.0F; c <= 1.0F; ++c)
						{
					          world.spawnParticle("flame", x+0.5 , y+1F, z+0.5, (double)a/10, -.0D, (double)c/10);
						}
					}
					if (itemstack.getItemDamage() == 25)
					{
						itemstack.damageItem(1, player);
						player.inventory.addItemStackToInventory(new ItemStack(ExtendedFarmingItems.EmptyWateringCan, 1));
					}
					else
					{
						itemstack.damageItem(1, player);
					}
					return true;
				}
			}

		}
		else
		{
			if (world.getBlock(x, y+1, z) == Blocks.water)
			{
				player.inventory.consumeInventoryItem(ExtendedFarmingItems.EmptyWateringCan);
				player.inventory.addItemStackToInventory(new ItemStack(ExtendedFarmingItems.WateringCan));
			}
			else if (world.getBlock(x, y+1, z) == Blocks.lava)
			{
				player.inventory.consumeInventoryItem(ExtendedFarmingItems.EmptyWateringCan);
				player.inventory.addItemStackToInventory(new ItemStack(ExtendedFarmingItems.LavaingCan));
			}
		}
		return false;

	}
}
