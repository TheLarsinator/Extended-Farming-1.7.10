package com.extfar.tractor;

import org.lwjgl.input.Keyboard;

import io.netty.buffer.ByteBuf;
import net.minecraft.block.BlockBush;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import com.extfar.core.ExtendedFarming;
import com.extfar.init.ExtendedFarmingBlocks;
import com.extfar.init.ExtendedFarmingItems;

import cpw.mods.fml.common.registry.IEntityAdditionalSpawnData;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EntityTractor extends Entity implements IEntityAdditionalSpawnData, IInventory
{
	public double speed;
	public double accelaration;
	public double maxSpeed;

	public boolean isPlowDown = false;
	
	public int tractorColour;
	
	public String owner;

	public int fuel = 0;
	public int water = 0;

	
	public double fuelTime = 0;
	public double waterTime = 0;

	private ItemStack[] invItems = new ItemStack[9];
	
	public TractorType tractorType;
	
	public ResourceLocation TractorTexture = new ResourceLocation(ExtendedFarming.modid + ":textures/entities/Tractor.png");
	public ResourceLocation Tractor2Texture = new ResourceLocation(ExtendedFarming.modid + ":textures/entities/Tractor2.png");
;

	public EntityTractor(World world)
	{
		super(world);
		this.preventEntitySpawning = true;
		this.setSize(1.5F, 0.8F);
		this.yOffset = this.height / 2.0F;
		this.stepHeight = 1.1F;
		this.accelaration = 0.1D;
		this.maxSpeed = 0.5D;
	}

	/**
	 * returns if this entity triggers Block.onEntityWalking on the blocks they walk on. used for spiders and wolves to
	 * prevent them from trampling crops
	 */
	protected boolean canTriggerWalking()
	{
		return false;
	}

	protected void entityInit()
	{
		this.dataWatcher.addObject(17, new Integer(0));
		this.dataWatcher.addObject(18, new Integer(1));
		this.dataWatcher.addObject(19, new Float(0.0F));
//		this.dataWatcher.addObject(20, new Float(this.speed));
//		this.dataWatcher.addObject(21, new Float(this.rotationYaw));
//		this.dataWatcher.addObject(22, new Float(this.motionX));
//		this.dataWatcher.addObject(23, new Float(this.motionY));
//		this.dataWatcher.addObject(24, new Float(this.motionZ));
		this.dataWatcher.addObject(25, new Integer(this.fuel));
        this.dataWatcher.addObject(26, Byte.valueOf((byte)0));
        this.dataWatcher.addObject(27, Byte.valueOf((byte)0));
		this.dataWatcher.addObject(28, new Integer(this.water));
        this.dataWatcher.addObject(29, Byte.valueOf((byte)0));
        this.dataWatcher.addObject(30, Byte.valueOf((byte)0));

	}

	
    /**
     * Gets called every tick from main Entity class
     */
    public void onEntityUpdate()
    {
    	super.onEntityUpdate();
		World world = this.worldObj;

		int i = (int)this.posX;
		int j = (int)this.posY;
		int k = (int)this.posZ;    	
    }
    
	/**
	 * Returns a boundingBox used to collide the entity with other entities and blocks. This enables the entity to be
	 * pushable on contact, like boats or minecarts.
	 */
	public AxisAlignedBB getCollisionBox(Entity entity)
	{
		return entity.boundingBox;
	}

	/**
	 * returns the bounding box for this entity
	 */
	public AxisAlignedBB getBoundingBox()
	{
		return this.boundingBox;
	}

	/**
	 * Returns true if this entity should push and be pushed by other entities when colliding.
	 */
	public boolean canBePushed()
	{
		return false;
	}

	public EntityTractor(World world, int x, int y, int z, int colour, String owner, TractorType type)
	{
		this(world);
		this.setPosition(x, y + (double)this.yOffset, z);
		this.motionX = 0.0D;
		this.motionY = 0.0D;
		this.motionZ = 0.0D;
		this.prevPosX = x;
		this.prevPosY = y;
		this.prevPosZ = z;
		this.tractorColour = colour;
		this.owner = owner;
		this.tractorType = type;
	}

	/**
	 * Returns the Y offset from the entity's position for any entity riding this one.
	 */
	public double getMountedYOffset()
	{
		return (double)this.height;
	}

    /**
     * Check if there is a Plow attached
     */
    public boolean hasPlowOn()
    {
        return (this.dataWatcher.getWatchableObjectByte(26) & 1) != 0;
    }
    public void setPlowOn(boolean p_70904_1_)
    {
        byte b0 = this.dataWatcher.getWatchableObjectByte(26);

        if (p_70904_1_)
        {
            this.dataWatcher.updateObject(26, Byte.valueOf((byte)(b0 | 1)));
        }
        else
        {
            this.dataWatcher.updateObject(26, Byte.valueOf((byte)(b0 & -2)));
        }
    }
    
    /**
     * Check if there is a mower attached
     */
    public boolean hasMowerOn()
    {
        return (this.dataWatcher.getWatchableObjectByte(27) & 1) != 0;
    }
    public void setMowerOn(boolean p_70904_1_)
    {
        byte b0 = this.dataWatcher.getWatchableObjectByte(27);

        if (p_70904_1_)
        {
            this.dataWatcher.updateObject(27, Byte.valueOf((byte)(b0 | 1)));
        }
        else
        {
            this.dataWatcher.updateObject(27, Byte.valueOf((byte)(b0 & -2)));
        }
    }
    /**
     * Check if there is a sprayer attached
     */
    public boolean hasSprayerOn()
    {
        return (this.dataWatcher.getWatchableObjectByte(29) & 1) != 0;
    }
    public void setSprayerOn(boolean p_70904_1_)
    {
        byte b0 = this.dataWatcher.getWatchableObjectByte(29);

        if (p_70904_1_)
        {
            this.dataWatcher.updateObject(29, Byte.valueOf((byte)(b0 | 1)));
        }
        else
        {
            this.dataWatcher.updateObject(29, Byte.valueOf((byte)(b0 & -2)));
        }
    }
    
    /**
     * Check if there is a seeder attached
     */
    public boolean hasSeederOn()
    {
        return (this.dataWatcher.getWatchableObjectByte(30) & 1) != 0;
    }
    public void setSeederOn(boolean p_70904_1_)
    {
        byte b0 = this.dataWatcher.getWatchableObjectByte(30);

        if (p_70904_1_)
        {
            this.dataWatcher.updateObject(30, Byte.valueOf((byte)(b0 | 1)));
        }
        else
        {
            this.dataWatcher.updateObject(30, Byte.valueOf((byte)(b0 & -2)));
        }
    }
    
	/**
	 * Called when the entity is attacked.
	 */
	public boolean attackEntityFrom(DamageSource damageSource, float damage)
	{
		if (this.isEntityInvulnerable())
		{
			return false;
		}
		else if (!this.worldObj.isRemote && !this.isDead)
		{
			this.setForwardDirection(-this.getForwardDirection());
			this.setTimeSinceHit(10);
			this.setDamageTaken(this.getDamageTaken() + damage * 6.0F);
			this.setBeenAttacked();
			boolean isCreativeMode = damageSource.getEntity() instanceof EntityPlayer && ((EntityPlayer)damageSource.getEntity()).capabilities.isCreativeMode;

			if(!isCreativeMode)
			{
				if(damageSource.getEntity() instanceof EntityPlayer)
				{
					EntityPlayer player = (EntityPlayer) damageSource.getEntity();
					if(!player.getCommandSenderName().equalsIgnoreCase(owner))
					{
						player.addChatMessage(new ChatComponentText("You cannot break " + owner + "'s tractor!"));
						return false;
					}
				}
			}

			if (isCreativeMode || this.getDamageTaken() > 40.0F)
			{
				if (this.riddenByEntity != null)
				{
					this.riddenByEntity.mountEntity(this);
				}

				if (!isCreativeMode)
				{
					this.func_145778_a(ExtendedFarmingItems.Tractor, 1, 0.0F);

					if(this.hasPlowOn())
					{
		    	    	   if(this.worldObj.isRemote == false)
		    	    	   {
		    	    		EntityItem item = new EntityItem(this.worldObj, this.posX + rand.nextFloat() * 2, this.posY + 0.2F, this.posZ+ rand.nextFloat() * 2, new ItemStack(ExtendedFarmingItems.Plow));
		    	    		this.worldObj.spawnEntityInWorld(item);
		    	    	   }
					}
					for (int i = 0; i < fuel;) 
					{
						ItemStack itemstack = null;
						
						if((fuel - i) >= 9)
						{
							itemstack = new ItemStack(Blocks.coal_block);
						}
						else
						{
							itemstack = new ItemStack(Items.coal);
						}
						
						if(itemstack != null)
						{
							float f = this.rand.nextFloat() * 0.8F + 0.1F;
							float f1 = this.rand.nextFloat() * 0.8F + 0.1F;
							float f2 = this.rand.nextFloat() * 0.8F + 0.1F;

							while (itemstack.stackSize > 0)
							{
								int j = this.rand.nextInt(21) + 10;

								if (j > itemstack.stackSize)
								{
									j = itemstack.stackSize;
								}

								itemstack.stackSize -= j;
								EntityItem entityitem = new EntityItem(this.worldObj, this.posX + (double)f, this.posY + (double)f1, this.posZ + (double)f2, new ItemStack(itemstack.getItem(), j, itemstack.getItemDamage()));
								float f3 = 0.05F;
								entityitem.motionX = (double)((float)this.rand.nextGaussian() * f3);
								entityitem.motionY = (double)((float)this.rand.nextGaussian() * f3 + 0.2F);
								entityitem.motionZ = (double)((float)this.rand.nextGaussian() * f3);
								this.worldObj.spawnEntityInWorld(entityitem);
							}	
						}
						
						if((fuel - i) >= 9)
						{
							i+=9;
						}
						else
						{
							i+=1;
						}
					}

					for (int i = 0; i < this.getSizeInventory(); ++i)
					{
						ItemStack itemstack = this.getStackInSlot(i);

						if (itemstack != null)
						{
							float f = this.rand.nextFloat() * 0.8F + 0.1F;
							float f1 = this.rand.nextFloat() * 0.8F + 0.1F;
							float f2 = this.rand.nextFloat() * 0.8F + 0.1F;

							while (itemstack.stackSize > 0)
							{
								int j = this.rand.nextInt(21) + 10;

								if (j > itemstack.stackSize)
								{
									j = itemstack.stackSize;
								}

								itemstack.stackSize -= j;
								EntityItem entityitem = new EntityItem(this.worldObj, this.posX + (double)f, this.posY + (double)f1, this.posZ + (double)f2, new ItemStack(itemstack.getItem(), j, itemstack.getItemDamage()));
								float f3 = 0.05F;
								entityitem.motionX = (double)((float)this.rand.nextGaussian() * f3);
								entityitem.motionY = (double)((float)this.rand.nextGaussian() * f3 + 0.2F);
								entityitem.motionZ = (double)((float)this.rand.nextGaussian() * f3);
								this.worldObj.spawnEntityInWorld(entityitem);
							}
						}
					}
				}

				this.setDead();
			}

			return true;
		}
		else
		{
			return true;
		}
	}

	/**
	 * Setups the entity to do the hurt animation. Only used by packets in multiplayer.
	 */
	@SideOnly(Side.CLIENT)
	public void performHurtAnimation()
	{
		this.setForwardDirection(-this.getForwardDirection());
		this.setTimeSinceHit(10);
		this.setDamageTaken(this.getDamageTaken() * 11.0F);
	}

	/**
	 * Returns true if other Entities should be prevented from moving through this Entity.
	 */
	public boolean canBeCollidedWith()
	{
		return !this.isDead;
	}

	public void setPositionAndRotation2(double x, double y, double z, float yaw, float pitch, int par9)
	{
		this.setPositionAndRotation(x, y + 0.026d, z, yaw, pitch);
	}

	/**
	 * Called to update the entity's position/logic.
	 */
	public void onUpdate()
	{
		super.onUpdate();
	
		if (this.getTimeSinceHit() > 0)
		{
			this.setTimeSinceHit(this.getTimeSinceHit() - 1);
		}

		if (this.getDamageTaken() > 0.0F)
		{
			this.setDamageTaken(this.getDamageTaken() - 1.0F);
		}

		this.prevPosX = this.posX;
		this.prevPosY = this.posY;
		this.prevPosZ = this.posZ;

		if(this.worldObj.isRemote)
		{
//			this.speed = this.dataWatcher.getWatchableObjectFloat(20);
//			this.rotationYaw = this.dataWatcher.getWatchableObjectFloat(21);
//			this.motionX = this.dataWatcher.getWatchableObjectFloat(22);
//			this.motionY = this.dataWatcher.getWatchableObjectFloat(23);
//			this.motionZ = this.dataWatcher.getWatchableObjectFloat(24);
			this.fuel = this.dataWatcher.getWatchableObjectInt(25);
		}
		
		double cos = Math.cos(this.rotationYaw * Math.PI / 180.0f);
		double sin = Math.sin(this.rotationYaw * Math.PI / 180.0f);

		this.motionX = -sin * speed;
		this.motionZ = cos * speed;
		this.motionY = -0.5431232;

		if(this.riddenByEntity != null)
		{
			if(this.riddenByEntity instanceof EntityLivingBase)
			{
				EntityLivingBase entity = (EntityLivingBase) this.riddenByEntity;

				if(!this.isInWater())
				{
					if(this.speed > 0.1)
					{
						if(fuel > 0)
						{			
								for (int i = 0; i < 10; i++) 
								{
									//this.worldObj.spawnParticle("splash", posX + (rand.nextDouble() - 0.5D) * (double)width, (posY + rand.nextDouble() * (double)height) - 0.25D, posZ + (rand.nextDouble() - 0.5D) * (double)width, 0, 0, 0);
								}
						}
						if(this.water > 0 && this.hasSprayerOn())
						{
							for (int i = 0; i < 10; i++) 
							{
								this.worldObj.spawnParticle("splash", posX + (rand.nextDouble() - 0.5D) * (double)width, (posY + rand.nextDouble() * (double)height) - 0.25D, posZ + (rand.nextDouble() - 0.5D) * (double)width, 0, 0, 0);
							}
						}
					}
				}


				if(fuel > 0)
				{
					if(!this.isInWater())
					{			
						this.speed += entity.moveForward * this.accelaration;

						if(speed > maxSpeed)
						{
							speed = maxSpeed;
						}
						if(speed < -maxSpeed)
						{
							speed = -maxSpeed;
						}

						if(speed > 0)
						{	
							if(fuelTime <= 0)
							{
								fuel--;
								this.fuelTime = 5000;
							}
							else
							{
								fuelTime -= (this.speed * 50);
							}
							if(this.hasSprayerOn())
							{
							if(waterTime <= 0)
							{
								water--;
								this.waterTime = 5000;
							}
							else
							{
								waterTime -= (this.speed * 80);
							}
							}
						}
					}
					else
					{
						this.speed *= 0.8500;
					}
				}
				else
				{
					if(speed > 0)
					{
						this.speed *= 0.8500;
					}
				}

				if(entity.moveForward <= 0)
				{
					this.speed *= 0.8500;
				}

				this.rotationYaw = MathHelper.wrapAngleTo180_float(entity.getRotationYawHead());
			}
		}
		else
		{
			this.speed *= 0.8500;
		}

		this.setRotation(this.rotationYaw, this.rotationPitch);
		this.moveEntity(motionX, motionY, motionZ);

		if(!this.worldObj.isRemote)
		{
//			this.dataWatcher.updateObject(20, new Float(this.speed));
//			this.dataWatcher.updateObject(21, new Float(this.rotationYaw));
//			this.dataWatcher.updateObject(22, new Float(this.motionX));
//			this.dataWatcher.updateObject(23, new Float(this.motionY));
//			this.dataWatcher.updateObject(24, new Float(this.motionZ));
			this.dataWatcher.updateObject(25, new Integer(this.fuel));
		}
		
		World world = this.worldObj;

		int i = (int)this.posX;
		int j = (int)this.posY;
		int k = (int)this.posZ;
		
		boolean blockPlaced = false;
		
    	if(this.riddenByEntity instanceof EntityPlayer && this.speed > 0)
    	{    			
			for(int xCoord = -1; xCoord < 2; ++xCoord)
			{
					for(int zCoord = -1; zCoord < 2; ++zCoord)
					{
			    		if((world.getBlock(i+xCoord, j-1, k+zCoord) == Blocks.dirt || world.getBlock(i+xCoord, j-1, k+zCoord) == Blocks.grass) && this.hasPlowOn() && !this.hasMowerOn())
			    		{
			    			world.setBlock(i+xCoord, j-1, k+zCoord, Blocks.farmland, 20, 2);			
			    		}
			    		if((world.getBlock(i+xCoord, j, k+zCoord) == Blocks.tallgrass || world.getBlock(i+xCoord, j, k+zCoord) instanceof BlockBush) && this.hasPlowOn() && !this.hasMowerOn())
			    		{
			    			world.setBlockToAir(i+xCoord, j, k+zCoord);			
			    		}
			    		if((world.getBlock(i+xCoord, j, k+zCoord) instanceof BlockBush) && this.hasMowerOn())
			    		{
			    			world.setBlockToAir(i+xCoord, j, k+zCoord);			
			    		}
			    		if((world.getBlock(i+xCoord, j-1, k+zCoord) == Blocks.farmland) && !this.hasPlowOn() && !this.hasMowerOn() && this.hasSprayerOn() && this.water > 0)
			    		{
			    			world.setBlockMetadataWithNotify(i+xCoord, j-1, k+zCoord, 100, 2);			
			    		}
			    		
			    		if(this.hasSeederOn() && !this.hasPlowOn() && !this.hasMowerOn() && !this.hasSprayerOn())
			    		{
			    		if((this.invItems[1] != null))
			    		{
				    		if((world.getBlock(i+xCoord, j-1, k+zCoord) == Blocks.farmland) && (world.getBlock(i+xCoord, j, k+zCoord) == Blocks.air))
				    		{
				    			Item item = this.invItems[1].getItem();
				    			if(item == Items.wheat_seeds)
				    			{
				    			world.setBlock(i+xCoord, j, k+zCoord, Blocks.wheat);
				    			}
				    			else if(item == Items.potato)
				    			{
					    		world.setBlock(i+xCoord, j, k+zCoord, Blocks.potatoes);
				    			}
				    			else if(item == Items.carrot)
				    			{
				    			world.setBlock(i+xCoord, j, k+zCoord, Blocks.carrots);
				    			}
				    			else if(item == ExtendedFarmingItems.SugarBeets)
				    			{
				    			world.setBlock(i+xCoord, j, k+zCoord, ExtendedFarmingBlocks.SugarBeet);
				    			}
				    			else if(item == ExtendedFarmingItems.Beets)
				    			{
				    			world.setBlock(i+xCoord, j, k+zCoord, ExtendedFarmingBlocks.Beets);
				    			}
				    			this.decrStackSize(1, 1);
				    		}	
			    		}
			    		else if((this.invItems[2] != null))
			    		{
				    		if((world.getBlock(i+xCoord, j-1, k+zCoord) == Blocks.farmland) && (world.getBlock(i+xCoord, j, k+zCoord) == Blocks.air))
				    		{
			    			Item item = this.invItems[2].getItem();
			    			if(item == Items.wheat_seeds)
			    			{
			    			world.setBlock(i+xCoord, j, k+zCoord, Blocks.wheat);
			    			}
			    			else if(item == Items.potato)
			    			{
				    		world.setBlock(i+xCoord, j, k+zCoord, Blocks.potatoes);
			    			}
			    			else if(item == Items.carrot)
			    			{
			    			world.setBlock(i+xCoord, j, k+zCoord, Blocks.carrots);
			    			}
			    			else if(item == ExtendedFarmingItems.SugarBeets)
			    			{
			    			world.setBlock(i+xCoord, j, k+zCoord, ExtendedFarmingBlocks.SugarBeet);
			    			}
			    			else if(item == ExtendedFarmingItems.Beets)
			    			{
			    			world.setBlock(i+xCoord, j, k+zCoord, ExtendedFarmingBlocks.Beets);
			    			}
			    			this.decrStackSize(2, 1);}
			    		}
			    		else if((this.invItems[3] != null))
			    		{
				    		if((world.getBlock(i+xCoord, j-1, k+zCoord) == Blocks.farmland) && (world.getBlock(i+xCoord, j, k+zCoord) == Blocks.air))
				    		{
			    			Item item = this.invItems[3].getItem();
			    			if(item == Items.wheat_seeds)
			    			{
			    			world.setBlock(i+xCoord, j, k+zCoord, Blocks.wheat);
			    			}
			    			else if(item == Items.potato)
			    			{
				    		world.setBlock(i+xCoord, j, k+zCoord, Blocks.potatoes);
			    			}
			    			else if(item == Items.carrot)
			    			{
			    			world.setBlock(i+xCoord, j, k+zCoord, Blocks.carrots);
			    			}
			    			else if(item == ExtendedFarmingItems.SugarBeets)
			    			{
			    			world.setBlock(i+xCoord, j, k+zCoord, ExtendedFarmingBlocks.SugarBeet);
			    			}
			    			else if(item == ExtendedFarmingItems.Beets)
			    			{
			    			world.setBlock(i+xCoord, j, k+zCoord, ExtendedFarmingBlocks.Beets);
			    			}
			    			this.decrStackSize(3, 1);}
			    		}
			    		else if((this.invItems[4] != null))
			    		{
				    		if((world.getBlock(i+xCoord, j-1, k+zCoord) == Blocks.farmland) && (world.getBlock(i+xCoord, j, k+zCoord) == Blocks.air))
				    		{
			    			Item item = this.invItems[4].getItem();
			    			if(item == Items.wheat_seeds)
			    			{
			    			world.setBlock(i+xCoord, j, k+zCoord, Blocks.wheat);
			    			}
			    			else if(item == Items.potato)
			    			{
				    		world.setBlock(i+xCoord, j, k+zCoord, Blocks.potatoes);
			    			}
			    			else if(item == Items.carrot)
			    			{
			    			world.setBlock(i+xCoord, j, k+zCoord, Blocks.carrots);
			    			}
			    			else if(item == ExtendedFarmingItems.SugarBeets)
			    			{
			    			world.setBlock(i+xCoord, j, k+zCoord, ExtendedFarmingBlocks.SugarBeet);
			    			}
			    			else if(item == ExtendedFarmingItems.Beets)
			    			{
			    			world.setBlock(i+xCoord, j, k+zCoord, ExtendedFarmingBlocks.Beets);
			    			}
			    			this.decrStackSize(4, 1);	}
			    		}
			    		if((this.invItems[5] != null))
			    		{
				    		if((world.getBlock(i+xCoord, j-1, k+zCoord) == Blocks.farmland) && (world.getBlock(i+xCoord, j, k+zCoord) == Blocks.air))
				    		{
			    			Item item = this.invItems[5].getItem();
			    			if(item == Items.wheat_seeds)
			    			{
			    			world.setBlock(i+xCoord, j, k+zCoord, Blocks.wheat);
			    			}
			    			else if(item == Items.potato)
			    			{
				    		world.setBlock(i+xCoord, j, k+zCoord, Blocks.potatoes);
			    			}
			    			else if(item == Items.carrot)
			    			{
			    			world.setBlock(i+xCoord, j, k+zCoord, Blocks.carrots);
			    			}
			    			else if(item == ExtendedFarmingItems.SugarBeets)
			    			{
			    			world.setBlock(i+xCoord, j, k+zCoord, ExtendedFarmingBlocks.SugarBeet);
			    			}
			    			else if(item == ExtendedFarmingItems.Beets)
			    			{
			    			world.setBlock(i+xCoord, j, k+zCoord, ExtendedFarmingBlocks.Beets);
			    			}
			    			this.decrStackSize(5, 1);	}
			    		}
			    		else if((this.invItems[6] != null))
			    		{
				    		if((world.getBlock(i+xCoord, j-1, k+zCoord) == Blocks.farmland) && (world.getBlock(i+xCoord, j, k+zCoord) == Blocks.air))
				    		{
			    			Item item = this.invItems[6].getItem();
			    			if(item == Items.wheat_seeds)
			    			{
			    			world.setBlock(i+xCoord, j, k+zCoord, Blocks.wheat);
			    			}
			    			else if(item == Items.potato)
			    			{
				    		world.setBlock(i+xCoord, j, k+zCoord, Blocks.potatoes);
			    			}
			    			else if(item == Items.carrot)
			    			{
			    			world.setBlock(i+xCoord, j, k+zCoord, Blocks.carrots);
			    			}
			    			else if(item == ExtendedFarmingItems.SugarBeets)
			    			{
			    			world.setBlock(i+xCoord, j, k+zCoord, ExtendedFarmingBlocks.SugarBeet);
			    			}
			    			else if(item == ExtendedFarmingItems.Beets)
			    			{
			    			world.setBlock(i+xCoord, j, k+zCoord, ExtendedFarmingBlocks.Beets);
			    			}
			    			this.decrStackSize(6, 1);
				    		}
			    		}
			    		else if((this.invItems[7] != null))
			    		{
				    		if((world.getBlock(i+xCoord, j-1, k+zCoord) == Blocks.farmland) && (world.getBlock(i+xCoord, j, k+zCoord) == Blocks.air))
				    		{
			    			Item item = this.invItems[7].getItem();
			    			if(item == Items.wheat_seeds)
			    			{
			    			world.setBlock(i+xCoord, j, k+zCoord, Blocks.wheat);
			    			}
			    			else if(item == Items.potato)
			    			{
				    		world.setBlock(i+xCoord, j, k+zCoord, Blocks.potatoes);
			    			}
			    			else if(item == Items.carrot)
			    			{
			    			world.setBlock(i+xCoord, j, k+zCoord, Blocks.carrots);
			    			}
			    			else if(item == ExtendedFarmingItems.SugarBeets)
			    			{
			    			world.setBlock(i+xCoord, j, k+zCoord, ExtendedFarmingBlocks.SugarBeet);
			    			}
			    			else if(item == ExtendedFarmingItems.Beets)
			    			{
			    			world.setBlock(i+xCoord, j, k+zCoord, ExtendedFarmingBlocks.Beets);
			    			}
			    			this.decrStackSize(7, 1);}
			    		}
			    		else if((this.invItems[8] != null))
			    		{
				    		if((world.getBlock(i+xCoord, j-1, k+zCoord) == Blocks.farmland) && (world.getBlock(i+xCoord, j, k+zCoord) == Blocks.air))
				    		{
			    			Item item = this.invItems[8].getItem();
			    			if(item == Items.wheat_seeds)
			    			{
			    			world.setBlock(i+xCoord, j, k+zCoord, Blocks.wheat);
			    			}
			    			else if(item == Items.potato)
			    			{
				    		world.setBlock(i+xCoord, j, k+zCoord, Blocks.potatoes);
			    			}
			    			else if(item == Items.carrot)
			    			{
			    			world.setBlock(i+xCoord, j, k+zCoord, Blocks.carrots);
			    			}
			    			else if(item == ExtendedFarmingItems.SugarBeets)
			    			{
			    			world.setBlock(i+xCoord, j, k+zCoord, ExtendedFarmingBlocks.SugarBeet);
			    			}
			    			else if(item == ExtendedFarmingItems.Beets)
			    			{
			    			world.setBlock(i+xCoord, j, k+zCoord, ExtendedFarmingBlocks.Beets);
			    			}
			    			this.decrStackSize(8, 1);
				    		}
			    		}			    		
			    		else if((this.invItems[0] != null))
			    		{
				    		if((world.getBlock(i+xCoord, j-1, k+zCoord) == Blocks.farmland) && (world.getBlock(i+xCoord, j, k+zCoord) == Blocks.air))
				    		{
			    			Item item = this.invItems[0].getItem();
			    			if(item == Items.wheat_seeds)
			    			{
			    			world.setBlock(i+xCoord, j, k+zCoord, Blocks.wheat);
			    			}
			    			else if(item == Items.potato)
			    			{
				    		world.setBlock(i+xCoord, j, k+zCoord, Blocks.potatoes);
			    			}
			    			else if(item == Items.carrot)
			    			{
			    			world.setBlock(i+xCoord, j, k+zCoord, Blocks.carrots);
			    			}
			    			else if(item == ExtendedFarmingItems.SugarBeets)
			    			{
			    			world.setBlock(i+xCoord, j, k+zCoord, ExtendedFarmingBlocks.SugarBeet);
			    			}
			    			else if(item == ExtendedFarmingItems.Beets)
			    			{
			    			world.setBlock(i+xCoord, j, k+zCoord, ExtendedFarmingBlocks.Beets);
			    			}
				    	
			    			this.decrStackSize(0, 1);
			    		}
			    		}
			    		}
			    		
					}
			}
    	}
   // 	System.out.println(world.getBlock(i, j-1, k));
	}

	public void updateRiderPosition()
	{
		if (this.riddenByEntity != null)
		{
			double dZ = Math.cos((double)this.rotationYaw * Math.PI / 180.0D) * -0.1D;
			double dX = -Math.sin((double)this.rotationYaw * Math.PI / 180.0D) * -0.1D;
			this.riddenByEntity.setPosition(this.posX + dX, this.posY + this.getMountedYOffset() + this.riddenByEntity.getYOffset(), this.posZ + dZ);
		}
	}

	/**
	 * (abstract) Protected helper method to write subclass entity data to NBT.
	 */
	protected void writeEntityToNBT(NBTTagCompound nbt)
	{
		nbt.setInteger("colour", tractorColour);
		nbt.setString("owner", owner);
		nbt.setInteger("fuel", fuel);
		nbt.setInteger("water", water);
		nbt.setDouble("fuelTime", fuelTime);
		nbt.setDouble("waterTime", waterTime);
		nbt.setBoolean("hasPlowOn", this.hasPlowOn());
		nbt.setBoolean("hasMowerOn", this.hasMowerOn());
		nbt.setBoolean("hasSprayerOn", this.hasSprayerOn());
		nbt.setBoolean("hasSeederOn", this.hasSeederOn());

		NBTTagList nbttaglist = new NBTTagList();

		for (int i = 0; i < this.invItems.length; ++i)
		{
			if (this.invItems[i] != null)
			{
				NBTTagCompound slotTag = new NBTTagCompound();
				slotTag.setByte("Slot", (byte)i);
				this.invItems[i].writeToNBT(slotTag);
				nbttaglist.appendTag(slotTag);
			}
		}

		nbt.setTag("Items", nbttaglist);
	}

	/**
	 * (abstract) Protected helper method to read subclass entity data from NBT.
	 */
	protected void readEntityFromNBT(NBTTagCompound nbt) 
	{
		this.tractorColour = nbt.getInteger("colour");
		this.owner = nbt.getString("owner");
		this.fuel = nbt.getInteger("fuel");
		this.fuelTime = nbt.getDouble("fuelTime");
		this.water = nbt.getInteger("water");
		this.waterTime = nbt.getDouble("waterTime");
		this.setPlowOn(nbt.getBoolean("hasPlowOn"));
		this.setMowerOn(nbt.getBoolean("hasMowerOn"));
		this.setSprayerOn(nbt.getBoolean("hasSprayerOn"));
		this.setSeederOn(nbt.getBoolean("hasSeederOn"));


		NBTTagList nbttaglist = nbt.getTagList("Items", 10);
		this.invItems = new ItemStack[this.getSizeInventory()];

		for (int i = 0; i < nbttaglist.tagCount(); ++i)
		{
			NBTTagCompound slotTag = nbttaglist.getCompoundTagAt(i);
			int j = slotTag.getByte("Slot") & 255;

			if (j >= 0 && j < this.invItems.length)
			{
				this.invItems[j] = ItemStack.loadItemStackFromNBT(slotTag);
			}
		}
	}
	


	@SideOnly(Side.CLIENT)
	public float getShadowSize()
	{
		return 0.0F;
	}

	/**
	 * First layer of player interaction
	 */
	public boolean interactFirst(EntityPlayer player)
	{
        byte b0 = this.dataWatcher.getWatchableObjectByte(26);

		if (this.riddenByEntity != null && this.riddenByEntity instanceof EntityPlayer && this.riddenByEntity != player)
		{
			return true;
		}
		else
		{
			if(player.getCommandSenderName().equalsIgnoreCase(this.owner))
			{
				if(player.isSneaking())
				{
					
					/**
					 * Add fuel and water
					 */
					if(player.getHeldItem() != null && (player.getHeldItem().getItem() == Items.coal || player.getHeldItem().getItem() == Item.getItemFromBlock(Blocks.coal_block)))
					{
						if(player.getHeldItem().getItem() == Items.coal)
						{
							this.fuel += player.getHeldItem().stackSize;
							player.getHeldItem().stackSize = 0;
						}
						else if(player.getHeldItem().getItem() == Item.getItemFromBlock(Blocks.coal_block))
						{
							this.fuel += (player.getHeldItem().stackSize * 9);
							player.getHeldItem().stackSize = 0;
						}
						
						player.addChatMessage(new ChatComponentText("Tractor Fuel: " + fuel));
					}
					else if(player.getHeldItem() != null && player.getHeldItem().getItem() == Items.water_bucket)
					{
							this.water += player.getHeldItem().stackSize*64;
							player.inventory.consumeInventoryItem(Items.water_bucket);
							player.inventory.addItemStackToInventory(new ItemStack(Items.bucket, 1));
							
						player.addChatMessage(new ChatComponentText("Tractor water level: " + water));
					}
					
					
					/**
					 * Add Attachments
					 */
					else if(player.getHeldItem() != null && player.getHeldItem().getItem() == ExtendedFarmingItems.Plow && !this.hasPlowOn() && !this.hasMowerOn()&& !this.hasSeederOn())
					{
						player.inventory.consumeInventoryItem(ExtendedFarmingItems.Plow);
			            this.dataWatcher.updateObject(26, Byte.valueOf((byte)(b0 | 1)));
					}
					else if(player.getHeldItem() != null && player.getHeldItem().getItem() == ExtendedFarmingItems.Mower && !this.hasPlowOn() && !this.hasMowerOn()&& !this.hasSeederOn())
					{
						player.inventory.consumeInventoryItem(ExtendedFarmingItems.Mower);
			            this.dataWatcher.updateObject(27, Byte.valueOf((byte)(b0 | 1)));
					}
					else if(player.getHeldItem() != null && player.getHeldItem().getItem() == ExtendedFarmingItems.Sprayer && !this.hasPlowOn() && !this.hasMowerOn() && !this.hasSprayerOn()&& !this.hasSeederOn())
					{
						player.inventory.consumeInventoryItem(ExtendedFarmingItems.Sprayer);
			            this.dataWatcher.updateObject(29, Byte.valueOf((byte)(b0 | 1)));
					}
					else if(player.getHeldItem() != null && player.getHeldItem().getItem() == ExtendedFarmingItems.Seeder && !this.hasPlowOn() && !this.hasMowerOn() && !this.hasSeederOn() && !this.hasSprayerOn())
					{
						player.inventory.consumeInventoryItem(ExtendedFarmingItems.Seeder);
			            this.dataWatcher.updateObject(30, Byte.valueOf((byte)(b0 | 1)));
					}
					
					/**
					 * Remove Attachments
					 */
					else if(player.getHeldItem() != null && player.getHeldItem().getItem() == ExtendedFarmingItems.Wrench)
					{
						if(this.hasPlowOn())
						{
							if(this.worldObj.isRemote == false)
		    	    	   {
		    	    		EntityItem item = new EntityItem(this.worldObj, this.posX + rand.nextFloat() * 2, this.posY + 0.2F, this.posZ+ rand.nextFloat() * 2, new ItemStack(ExtendedFarmingItems.Plow));
		    	    		this.worldObj.spawnEntityInWorld(item);
		    	    	   }
			            this.dataWatcher.updateObject(26, Byte.valueOf((byte)(b0 & -2)));
						}
						
						else if(this.hasMowerOn())
						{
			    	    	   if(this.worldObj.isRemote == false)
			    	    	   {
			    	    		EntityItem item = new EntityItem(this.worldObj, this.posX + rand.nextFloat() * 2, this.posY + 0.2F, this.posZ+ rand.nextFloat() * 2, new ItemStack(ExtendedFarmingItems.Mower));
			    	    		this.worldObj.spawnEntityInWorld(item);
			    	    	   }
				            this.dataWatcher.updateObject(27, Byte.valueOf((byte)(b0 & -2)));
						}
						
						else if(this.hasSprayerOn())
						{
			    	    	   if(this.worldObj.isRemote == false)
			    	    	   {
			    	    		EntityItem item = new EntityItem(this.worldObj, this.posX + rand.nextFloat() * 2, this.posY + 0.2F, this.posZ+ rand.nextFloat() * 2, new ItemStack(ExtendedFarmingItems.Sprayer));
			    	    		this.worldObj.spawnEntityInWorld(item);
			    	    	   }
				            this.dataWatcher.updateObject(29, Byte.valueOf((byte)(b0 & -2)));
						}
						
						else if(this.hasSeederOn())
						{
			    	    	   if(this.worldObj.isRemote == false)
			    	    	   {
			    	    		EntityItem item = new EntityItem(this.worldObj, this.posX + rand.nextFloat() * 2, this.posY + 0.2F, this.posZ+ rand.nextFloat() * 2, new ItemStack(ExtendedFarmingItems.Seeder));
			    	    		this.worldObj.spawnEntityInWorld(item);
			    	    	   }
				            this.dataWatcher.updateObject(30, Byte.valueOf((byte)(b0 & -2)));
						}
					}
					else
					{
						player.displayGUIChest(this);
					}
				}
				else
				{
					if(!this.worldObj.isRemote)
					{
						player.mountEntity(this);
					}
				}
			}
			else
			{
				if(!this.worldObj.isRemote)
				{
					player.addChatMessage(new ChatComponentText("You are not the owner of this tractor!"));
				}
			}

			return true;
		}
	}

	/**
	 * Takes in the distance the entity has fallen this tick and whether its on the ground to update the fall distance
	 * and deal fall damage if landing on the ground.  Args: distanceFallenThisTick, onGround
	 */
	protected void updateFallState(double distanceFallenThisTick, boolean onGround)
	{
		this.fallDistance = 0.0F;
	}

	/**
	 * Sets the damage taken from the last hit.
	 */
	public void setDamageTaken(float damage)
	{
		this.dataWatcher.updateObject(19, Float.valueOf(damage));
	}

	/**
	 * Gets the damage taken from the last hit.
	 */
	public float getDamageTaken()
	{
		return this.dataWatcher.getWatchableObjectFloat(19);
	}

	/**
	 * Sets the time to count down from since the last time entity was hit.
	 */
	public void setTimeSinceHit(int time)
	{
		this.dataWatcher.updateObject(17, Integer.valueOf(time));
	}

	/**
	 * Gets the time since the last hit.
	 */
	public int getTimeSinceHit()
	{
		return this.dataWatcher.getWatchableObjectInt(17);
	}

	/**
	 * Sets the forward direction of the entity.
	 */
	public void setForwardDirection(int direction)
	{
		this.dataWatcher.updateObject(18, Integer.valueOf(direction));
	}

	/**
	 * Gets the forward direction of the entity.
	 */
	public int getForwardDirection()
	{
		return this.dataWatcher.getWatchableObjectInt(18);
	}

	@Override
	public void readSpawnData(ByteBuf buf) 
	{
		this.tractorColour = buf.readByte();
	}

	@Override
	public void writeSpawnData(ByteBuf buf) 
	{
		buf.writeByte(this.tractorColour);
	}

	/**
	 * Returns the stack in slot i
	 */
	public ItemStack getStackInSlot(int slot)
	{
		return this.invItems[slot];
	}

	/**
	 * Removes from an inventory slot (first arg) up to a specified number (second arg) of items and returns them in a
	 * new stack.
	 */
	public ItemStack decrStackSize(int slot, int amount)
	{
		if (this.invItems[slot] != null)
		{
			ItemStack itemstack;

			if (this.invItems[slot].stackSize <= amount)
			{
				itemstack = this.invItems[slot];
				this.invItems[slot] = null;
				return itemstack;
			}
			else
			{
				itemstack = this.invItems[slot].splitStack(amount);

				if (this.invItems[slot].stackSize == 0)
				{
					this.invItems[slot] = null;
				}

				return itemstack;
			}
		}
		else
		{
			return null;
		}
	}

	/**
	 * When some containers are closed they call this on each slot, then drop whatever it returns as an EntityItem -
	 * like when you close a workbench GUI.
	 */
	public ItemStack getStackInSlotOnClosing(int slot)
	{
		if (this.invItems[slot] != null)
		{
			ItemStack itemstack = this.invItems[slot];
			this.invItems[slot] = null;
			return itemstack;
		}
		else
		{
			return null;
		}
	}

	/**
	 * Sets the given item stack to the specified slot in the inventory (can be crafting or armor sections).
	 */
	public void setInventorySlotContents(int slot, ItemStack stack)
	{
		this.invItems[slot] = stack;

		if (stack != null && stack.stackSize > this.getInventoryStackLimit())
		{
			stack.stackSize = this.getInventoryStackLimit();
		}
	}

	/**
	 * For tile entities, ensures the chunk containing the tile entity is saved to disk later - the game won't think it
	 * hasn't changed and skip it.
	 */
	public void markDirty() {}

	/**
	 * Do not make give this method the name canInteractWith because it clashes with Container
	 */
	public boolean isUseableByPlayer(EntityPlayer player)
	{
		return this.isDead ? false : player.getDistanceSqToEntity(this) <= 64.0D;
	}

	public void openInventory() {}

	public void closeInventory() {}

	/**
	 * Returns true if automation is allowed to insert the given stack (ignoring stack size) into the given slot.
	 */
	public boolean isItemValidForSlot(int slot, ItemStack stack)
	{	
		return true;
	}

	/**
	 * Returns the name of the inventory
	 */
	public String getInventoryName()
	{
		return "Tractor Inventory";
	}

	/**
	 * Returns the maximum stack size for a inventory slot.
	 */
	public int getInventoryStackLimit()
	{
		return 64;
	}

	@Override
	public int getSizeInventory() 
	{
		return invItems.length;
	}

	@Override
	public boolean hasCustomInventoryName()
	{
		return true;
	}
}