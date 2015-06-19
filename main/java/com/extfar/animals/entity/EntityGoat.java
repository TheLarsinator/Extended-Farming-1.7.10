package com.extfar.animals.entity;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIFollowParent;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.extfar.init.ExtendedFarmingItems;

public class EntityGoat extends EntityAnimal
{
    private static final String __OBFID = "CL_00001640";
    int x;
    
    public EntityGoat(World p_i1683_1_)
    {
        super(p_i1683_1_);
        this.setSize(0.9F, 1.3F);
        this.getNavigator().setAvoidsWater(true);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIPanic(this, 2.0D));
        this.tasks.addTask(2, new EntityAIMate(this, 1.0D));
        this.tasks.addTask(3, new EntityAITempt(this, 1.25D, Items.carrot, false));
        this.tasks.addTask(4, new EntityAIFollowParent(this, 1.25D));
        this.tasks.addTask(5, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(7, new EntityAILookIdle(this));
        this.x = 0;
    }

    protected void entityInit()
    {
        super.entityInit();
        this.dataWatcher.addObject(16, new Byte((byte)0));
    }
    
    /**
     * Called to update the entity's position/logic.
     */
    public void onUpdate()
    {
        super.onUpdate();
        
        if(!this.IsGoatMilkable())
        {
        
        
        Random rand = new Random();
        
        x = x + rand.nextInt(5);
        //System.out.println(x);
        if(x > 20)
        {
        	x = 0;
        	this.setIsGoatMilkable(true);
        	//System.out.println("Im milkable!");
        }
        }
    }
    
    /**
     * Returns true if the newer Entity AI code should be run
     */
    public boolean isAIEnabled()
    {
        return true;
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(10.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.20000000298023224D);
    }

    /**
     * Returns the sound this mob makes while it's alive.
     */
    protected String getLivingSound()
    {
        return "mob.sheep.say";
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
    protected String getHurtSound()
    {
        return "mob.sheep.say";
    }

    /**
     * Returns the sound this mob makes on death.
     */
    protected String getDeathSound()
    {
        return "mob.sheep.say";
    }

    protected void func_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Block p_145780_4_)
    {
        this.playSound("mob.sheep.step", 0.15F, 1.0F);
    }

    /**
     * Returns the volume for the sounds this mob makes.
     */
    protected float getSoundVolume()
    {
        return 0.4F;
    }

    protected Item getDropItem()
    {
        return ExtendedFarmingItems.RawGoatMeat;
    }

    /**
     * Drop 0-2 items of this living's type. @param par1 - Whether this entity has recently been hit by a player. @param
     * par2 - Level of Looting used to kill this mob.
     */
    protected void dropFewItems(boolean p_70628_1_, int p_70628_2_)
    {
        int j = this.rand.nextInt(3) + this.rand.nextInt(1 + p_70628_2_);
        int k;

        for (k = 0; k < j; ++k)
        {
            this.dropItem(Item.getItemFromBlock(Blocks.wool), 1);
        }

        j = this.rand.nextInt(3) + 1 + this.rand.nextInt(1 + p_70628_2_);

        for (k = 0; k < j; ++k)
        {
            if (this.isBurning())
            {
                this.dropItem(ExtendedFarmingItems.GoatMeat, 1);
            }
            else
            {
                this.dropItem(ExtendedFarmingItems.RawGoatMeat, 1);
            }
        }
    }

    
    public boolean IsGoatMilkable()
    {
        return (this.dataWatcher.getWatchableObjectByte(16) & 1) != 0;
    }
    
    
    public void setIsGoatMilkable(boolean par1)
    {
        byte b0 = this.dataWatcher.getWatchableObjectByte(16);

        if(par1)
        {
            this.dataWatcher.updateObject(16, Byte.valueOf((byte)(b0 | 1)));
        }
        else
        {
            this.dataWatcher.updateObject(16, Byte.valueOf((byte)(b0 & -2)));
        }
    }

    /**
     * Called when a player interacts with a mob. e.g. gets milk from a Goat, gets into the saddle on a pig.
     */
    public boolean interact(EntityPlayer p_70085_1_)
    {
        ItemStack itemstack = p_70085_1_.inventory.getCurrentItem();

        if (itemstack != null && itemstack.getItem() == Items.bucket && !p_70085_1_.capabilities.isCreativeMode && !this.isChild() && this.IsGoatMilkable())
        {
            if (itemstack.stackSize-- == 1)
            {
                p_70085_1_.inventory.setInventorySlotContents(p_70085_1_.inventory.currentItem, new ItemStack(ExtendedFarmingItems.GoatMilk_Bucket));
            }
            else if (!p_70085_1_.inventory.addItemStackToInventory(new ItemStack(ExtendedFarmingItems.GoatMilk_Bucket)))
            {
                p_70085_1_.dropPlayerItemWithRandomChoice(new ItemStack(ExtendedFarmingItems.GoatMilk_Bucket, 1, 0), false);
            }
            
            this.setIsGoatMilkable(false);
            return true;
        }
        else
        {
            return super.interact(p_70085_1_);
        }
    }

    public EntityGoat createChild(EntityAgeable p_90011_1_)
    {
        return new EntityGoat(this.worldObj);
    }
    
    public boolean isBreedingItem(ItemStack par1ItemStack)
    {
        return par1ItemStack.getItem() == Items.carrot;
    }
}