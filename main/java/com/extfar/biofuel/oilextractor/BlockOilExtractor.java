package com.extfar.biofuel.oilextractor;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import com.extfar.core.ExtendedFarming;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockOilExtractor extends BlockContainer
{

	private static boolean keepInventory = false;

	/** True if this is an active OilExtractor, false if idle */
	private final Random field_149933_a = new Random();
	private static boolean field_149934_M;
	public static boolean isActive;
	// TEXTUREN
	private IIcon theIcon;
	private IIcon theIcon2;
	private IIcon theIcon3;
	private IIcon theIcon4;

	/**
	 * Is the random generator used by OilExtractor to drop the inventory
	 * contents in random directions.
	 */
	private Random goldRand;

	public BlockOilExtractor(Material material, boolean active)
	{
		super(material);
		goldRand = new Random();
		this.setCreativeTab(ExtendedFarming.ItemsTab);
		this.isActive = active;
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2)
	{
		return new TileEntityOilExtractor();
	}

	/**
	 * Called whenever the block is added into the world. Args: world, x, y, z
	 */
	public void onBlockAdded(World par1World, int par2, int par3, int par4)
	{
		super.onBlockAdded(par1World, par2, par3, par4);
		this.setDefaultDirection(par1World, par2, par3, par4);

	}

	/**
	 * set a blocks direction
	 */
	private void setDefaultDirection(World par1World, int x, int y, int z)
	{
		TileEntity blockEntity = par1World.getTileEntity(x, y, z);
		if (par1World.isRemote)
		{
			return;
		}

		Block block = par1World.getBlock(x, y, z - 1);
		Block block1 = par1World.getBlock(x, y, z + 1);
		Block block2 = par1World.getBlock(x - 1, y, z);
		Block block3 = par1World.getBlock(x + 1, y, z);
		byte b0 = 3;
		byte byte0 = 3;

		if (block.func_149730_j() && !block1.func_149730_j())
		{
			b0 = 3;
		}

		if (block1.func_149730_j() && !block.func_149730_j())
		{
			b0 = 2;
		}

		if (block2.func_149730_j() && !block3.func_149730_j())
		{
			b0 = 5;
		}

		if (block3.func_149730_j() && !block2.func_149730_j())
		{
			b0 = 4;
		}

		par1World.setBlockMetadataWithNotify(x, y, z, b0, 2);
	}

	/**
	 * Retrieves the block texture to use based on the display side. Args:
	 * iBlockAccess, x, y, z, side /*
	 */
	@Override
	public IIcon getIcon(IBlockAccess access, int x, int y, int z, int side)
	{
		int front = 0;

		TileEntity tile = access.getTileEntity(x, y, z);
		int Meta = access.getBlockMetadata(x, y, z);

		if (Meta == 0)
		{
			switch (side)
			{
				case 0:
					return theIcon;
				case 1:
					return blockIcon;
				case 2:
					return theIcon2;
				case 3:
					if (((TileEntityOilExtractor) tile).isActive())
					{
						return theIcon4;
					}
					else
					{
						return theIcon3;
					}
				case 4:
					return theIcon2;
				case 5:
					return theIcon2;
				default:
					return theIcon2;
			}
		}
		else if (Meta == 1)
		{
			switch (side)
			{
				case 0:
					return theIcon;
				case 1:
					return blockIcon;
				case 2:
					return theIcon2;
				case 4:
					if (((TileEntityOilExtractor) tile).isActive())
					{
						return theIcon4;
					}
					else
					{
						return theIcon3;
					}
				case 3:
					return theIcon2;
				case 5:
					return theIcon2;
				default:
					return theIcon2;
			}
		}
		else if (Meta == 2)
		{
			switch (side)
			{
				case 0:
					return theIcon;
				case 1:
					return blockIcon;
				case 3:
					return theIcon2;
				case 2:
					if (((TileEntityOilExtractor) tile).isActive())
					{
						return theIcon4;
					}
					else
					{
						return theIcon3;
					}
				case 4:
					return theIcon2;
				case 5:
					return theIcon2;
				default:
					return theIcon2;
			}
		}
		else
		{
			switch (side)
			{
				case 0:
					return theIcon;
				case 1:
					return blockIcon;
				case 2:
					return theIcon2;
				case 5:
					if (((TileEntityOilExtractor) tile).isActive())
					{
						return theIcon4;
					}
					else
					{
						return theIcon3;
					}
				case 4:
					return theIcon2;
				case 3:
					return theIcon2;
				default:
					return theIcon2;
			}
		}

	}

	String modid =  ExtendedFarming.modid + ":";
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister par1IconRegister)
	{
		this.blockIcon = par1IconRegister.registerIcon(modid + "OilExtractorSide");
		this.theIcon = par1IconRegister.registerIcon(modid + "OilExtractorSide");
		this.theIcon2 = par1IconRegister.registerIcon(modid + "OilExtractorSide");
		this.theIcon4 = par1IconRegister.registerIcon(modid + "OilExtractorActiveFront");
		this.theIcon3 = par1IconRegister.registerIcon(modid + "OilExtractorFront");

	}

	/**
	 * From the specified side and block metadata retrieves the blocks texture.
	 * Args: side, metadata
	 */
	public IIcon getIcon(int par1, int par2)
	{
		switch (par2)
		{
			default:
			case 0:
			{
				switch (par1)
				{
					case 0:
						return theIcon;
					case 1:
						return blockIcon;
					case 2:
						return theIcon2;
					case 3:
					{
						if (this.isActive == true)
						{
							return theIcon4;
						}
						else
						{
							return theIcon3;
						}
					}
					case 4:
						return theIcon2;
					case 5:
						return theIcon2;
					default:
						return theIcon2;
				}
			}
			case 1:
			{
				switch (par1)
				{
					case 0:
						return theIcon;
					case 1:
						return blockIcon;
					case 2:
						return theIcon2;
					case 3:
						return theIcon2;
					case 4:
					{
						if (this.isActive == true)
						{
							return theIcon4;
						}
						else
						{
							return theIcon3;
						}
					}
					case 5:
						return theIcon2;
					default:
						return theIcon2;
				}
			}
			case 2:
			{
				switch (par1)
				{
					case 0:
						return theIcon;
					case 1:
						return blockIcon;
					case 2:
					{
						if (this.isActive == true)
						{
							return theIcon4;
						}
						else
						{
							return theIcon3;
						}
					}
					case 3:
						return theIcon2;
					case 4:
						return theIcon2;
					case 5:
						return theIcon2;
					default:
						return theIcon2;
				}
			}
			case 3:
			{
				switch (par1)
				{
					case 0:
						return theIcon;
					case 1:
						return blockIcon;
					case 2:
						return theIcon2;
					case 3:
						return theIcon2;
					case 4:
						return theIcon2;
					case 5:
					{
						if (this.isActive == true)
						{
							return theIcon4;
						}
						else
						{
							return theIcon3;
						}
					}
					default:
						return theIcon2;
				}
			}
		}
	}

	/**
	 * called everytime the player right clicks this block
	 */
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z,
			EntityPlayer player, int i, float a, float b, float c)
	{
		TileEntityOilExtractor tile = (TileEntityOilExtractor) world
				.getTileEntity(x, y, z);
		if (world.isRemote)
		{

			return true;

		}
		else
		{
			System.out.println(this.isActive);
			if (tile != null && !player.isSneaking())
			{
				player.openGui(ExtendedFarming.modid, 2, world, x, y, z);
			}
			return true;
		}

	}

	public void onBlockPlacedBy(World par1World, int par2, int par3, int par4,
			EntityLivingBase par5EntityLivingBase, ItemStack par6ItemStack)
	{
		int l = MathHelper
				.floor_double((double) (par5EntityLivingBase.rotationYaw * 4.0F / 360.0F) + 2.5D) & 3;
		par1World.setBlockMetadataWithNotify(par2, par3, par4, l, 2);
	}

	/**
	 * ejects contained items into the world, and notifies neighbours of an
	 * update, as appropriate
	 */
	public void breakBlock(World p_149749_1_, int p_149749_2_, int p_149749_3_,
			int p_149749_4_, Block p_149749_5_, int p_149749_6_)
	{
		if (!field_149934_M)
		{
			TileEntityOilExtractor tileentityOilExtractor = (TileEntityOilExtractor) p_149749_1_
					.getTileEntity(p_149749_2_, p_149749_3_, p_149749_4_);

			if (tileentityOilExtractor != null)
			{
				for (int i1 = 0; i1 < tileentityOilExtractor.getSizeInventory(); ++i1)
				{
					ItemStack itemstack = tileentityOilExtractor
							.getStackInSlot(i1);

					if (itemstack != null)
					{
						float f = this.field_149933_a.nextFloat() * 0.8F + 0.1F;
						float f1 = this.field_149933_a.nextFloat() * 0.8F + 0.1F;
						float f2 = this.field_149933_a.nextFloat() * 0.8F + 0.1F;

						while (itemstack.stackSize > 0)
						{
							int j1 = this.field_149933_a.nextInt(21) + 10;

							if (j1 > itemstack.stackSize)
							{
								j1 = itemstack.stackSize;
							}

							itemstack.stackSize -= j1;
							EntityItem entityitem = new EntityItem(p_149749_1_,
									(double) ((float) p_149749_2_ + f),
									(double) ((float) p_149749_3_ + f1),
									(double) ((float) p_149749_4_ + f2),
									new ItemStack(itemstack.getItem(), j1,
											itemstack.getItemDamage()));

							if (itemstack.hasTagCompound())
							{
								entityitem.getEntityItem().setTagCompound(
										(NBTTagCompound) itemstack
												.getTagCompound().copy());
							}

							float f3 = 0.05F;
							entityitem.motionX = (double) ((float) this.field_149933_a
									.nextGaussian() * f3);
							entityitem.motionY = (double) ((float) this.field_149933_a
									.nextGaussian() * f3 + 0.2F);
							entityitem.motionZ = (double) ((float) this.field_149933_a
									.nextGaussian() * f3);
							p_149749_1_.spawnEntityInWorld(entityitem);
						}
					}
				}

				p_149749_1_.func_147453_f(p_149749_2_, p_149749_3_,
						p_149749_4_, p_149749_5_);
			}
		}

		super.breakBlock(p_149749_1_, p_149749_2_, p_149749_3_, p_149749_4_,
				p_149749_5_, p_149749_6_);
	}

	/*
	 * public void breakBlock(World par1World, int par2, int par3, int par4, int
	 * par5, int par6) { if (!keepInventory) { TileEntityOilExtractor gold =
	 * (TileEntityOilExtractor)par1World.getBlockTileEntity(par2, par3, par4);
	 * if (gold != null) { for (int var8 = 0; var8 < gold.getSizeInventory();
	 * ++var8) { ItemStack item = gold.getStackInSlot(var8); if (item != null) {
	 * float var10 = this.goldRand.nextFloat() * 0.8F + 0.1F; float var11 =
	 * this.goldRand.nextFloat() * 0.8F + 0.1F; float var12 =
	 * this.goldRand.nextFloat() * 0.8F + 0.1F; while (item.stackSize > 0) { int
	 * var13 = this.goldRand.nextInt(21) + 10; if (var13 > item.stackSize) {
	 * var13 = item.stackSize; } item.stackSize -= var13; EntityItem var14 = new
	 * EntityItem(par1World, (double)((float)par2 + var10), (double)((float)par3
	 * + var11), (double)((float)par4 + var12), new ItemStack(item.itemID,
	 * var13, item.getItemDamage())); if (item.hasTagCompound()) {
	 * var14.getEntityItem
	 * ().setTagCompound((NBTTagCompound)item.getTagCompound().copy()); } float
	 * var15 = 0.05F; var14.motionX =
	 * (double)((float)this.goldRand.nextGaussian() * var15); var14.motionY =
	 * (double)((float)this.goldRand.nextGaussian() * var15 + 0.2F);
	 * var14.motionZ = (double)((float)this.goldRand.nextGaussian() * var15);
	 * par1World.spawnEntityInWorld(var14); } } } } }
	 * super.breakBlock(par1World, par2, par3, par4, par5, par6); }
	 */
}