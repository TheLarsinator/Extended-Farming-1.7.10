package com.extfar.blocks.biofuel.oilextractor;

import com.extfar.init.ExtendedFarmingItems;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TileEntityOilExtractor extends TileEntity implements ISidedInventory
{
    private static final int[] slotsTop = new int[] {0};
    private static final int[] slotsBottom = new int[] {2, 1};
    private static final int[] slotsSides = new int[] {1};
    /**
     * The ItemStacks that hold the items currently being used in the OilExtractor
     */
    private ItemStack[] OilExtractorItemStacks = new ItemStack[3];
    /** The number of ticks that the OilExtractor will keep burning */
    public int OilExtractorBurnTime;
    /**
     * The number of ticks that a fresh copy of the currently-burning item would keep the OilExtractor burning for
     */
    public int currentItemBurnTime;
    private boolean isActive;

    /** The number of ticks that the current item has been cooking for */
    public int OilExtractorCookTime;
    private String field_145958_o;
    private static final String __OBFID = "CL_00000357";

    /**
     * Returns the number of slots in the inventory.
     */
    public int getSizeInventory()
    {
        return this.OilExtractorItemStacks.length;
    }

    /**
     * Returns the stack in slot i
     */
    public ItemStack getStackInSlot(int par1)
    {
        return this.OilExtractorItemStacks[par1];
    }

    /**
     * Removes from an inventory slot (first arg) up to a specified number (second arg) of items and returns them in a
     * new stack.
     */
    public ItemStack decrStackSize(int par1, int par2)
    {
        if (this.OilExtractorItemStacks[par1] != null)
        {
            ItemStack itemstack;

            if (this.OilExtractorItemStacks[par1].stackSize <= par2)
            {
                itemstack = this.OilExtractorItemStacks[par1];
                this.OilExtractorItemStacks[par1] = null;
                return itemstack;
            }
            else
            {
                itemstack = this.OilExtractorItemStacks[par1].splitStack(par2);

                if (this.OilExtractorItemStacks[par1].stackSize == 0)
                {
                    this.OilExtractorItemStacks[par1] = null;
                }

                return itemstack;
            }
        }
        else
        {
            return null;
        }
    }
    public boolean isActive()
    {
    return this.isActive;
    }

    /**
     * When some containers are closed they call this on each slot, then drop whatever it returns as an EntityItem -
     * like when you close a workbench GUI.
     */
    public ItemStack getStackInSlotOnClosing(int par1)
    {
        if (this.OilExtractorItemStacks[par1] != null)
        {
            ItemStack itemstack = this.OilExtractorItemStacks[par1];
            this.OilExtractorItemStacks[par1] = null;
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
    public void setInventorySlotContents(int par1, ItemStack par2ItemStack)
    {
        this.OilExtractorItemStacks[par1] = par2ItemStack;

        if (par2ItemStack != null && par2ItemStack.stackSize > this.getInventoryStackLimit())
        {
            par2ItemStack.stackSize = this.getInventoryStackLimit();
        }
    }

    /**
     * Returns the name of the inventory
     */
    public String getInventoryName()
    {
        return this.hasCustomInventoryName() ? this.field_145958_o : "container.OilExtractor";
    }

    /**
     * Returns if the inventory is named
     */
    public boolean hasCustomInventoryName()
    {
        return this.field_145958_o != null && this.field_145958_o.length() > 0;
    }

    public void func_145951_a(String p_145951_1_)
    {
        this.field_145958_o = p_145951_1_;
    }

    public void readFromNBT(NBTTagCompound p_145839_1_)
    {
        super.readFromNBT(p_145839_1_);
        NBTTagList nbttaglist = p_145839_1_.getTagList("Items", 10);
        this.OilExtractorItemStacks = new ItemStack[this.getSizeInventory()];

        for (int i = 0; i < nbttaglist.tagCount(); ++i)
        {
            NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
            byte b0 = nbttagcompound1.getByte("Slot");

            if (b0 >= 0 && b0 < this.OilExtractorItemStacks.length)
            {
                this.OilExtractorItemStacks[b0] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
            }
        }

        this.OilExtractorBurnTime = p_145839_1_.getShort("BurnTime");
        this.OilExtractorCookTime = p_145839_1_.getShort("CookTime");
        this.currentItemBurnTime = getItemBurnTime(this.OilExtractorItemStacks[1]);

        if (p_145839_1_.hasKey("CustomName", 8))
        {
            this.field_145958_o = p_145839_1_.getString("CustomName");
        }
    }

    public void writeToNBT(NBTTagCompound p_145841_1_)
    {
        super.writeToNBT(p_145841_1_);
        p_145841_1_.setShort("BurnTime", (short)this.OilExtractorBurnTime);
        p_145841_1_.setShort("CookTime", (short)this.OilExtractorCookTime);
        NBTTagList nbttaglist = new NBTTagList();

        for (int i = 0; i < this.OilExtractorItemStacks.length; ++i)
        {
            if (this.OilExtractorItemStacks[i] != null)
            {
                NBTTagCompound nbttagcompound1 = new NBTTagCompound();
                nbttagcompound1.setByte("Slot", (byte)i);
                this.OilExtractorItemStacks[i].writeToNBT(nbttagcompound1);
                nbttaglist.appendTag(nbttagcompound1);
            }
        }

        p_145841_1_.setTag("Items", nbttaglist);

        if (this.hasCustomInventoryName())
        {
            p_145841_1_.setString("CustomName", this.field_145958_o);
        }
    }

    /**
     * Returns the maximum stack size for a inventory slot.
     */
    public int getInventoryStackLimit()
    {
        return 64;
    }

    /**
     * Returns an integer between 0 and the passed value representing how close the current item is to being completely
     * cooked
     */
    @SideOnly(Side.CLIENT)
    public int getCookProgressScaled(int p_145953_1_)
    {
        return this.OilExtractorCookTime * p_145953_1_ / 1000;
    }

    /**
     * Returns an integer between 0 and the passed value representing how much burn time is left on the current fuel
     * item, where 0 means that the item is exhausted and the passed value means that the item is fresh
     */
    @SideOnly(Side.CLIENT)
    public int getBurnTimeRemainingScaled(int p_145955_1_)
    {
        if (this.currentItemBurnTime == 0)
        {
            this.currentItemBurnTime = 1000;
        }

        return this.OilExtractorBurnTime * p_145955_1_ / this.currentItemBurnTime;
    }

    /**
     * OilExtractor isBurning
     */
    public boolean isBurning()
    {
        return this.OilExtractorBurnTime > 0;
    }

    public void updateEntity()
    {
        boolean flag = this.OilExtractorBurnTime > 0;
        boolean flag1 = false;
        if (this.OilExtractorBurnTime > 0)
        {
            --this.OilExtractorBurnTime;
        }

        if (!this.worldObj.isRemote)
        {
            if (this.OilExtractorBurnTime == 0 && this.canSmelt())
            {
                this.currentItemBurnTime = this.OilExtractorBurnTime = getItemBurnTime(this.OilExtractorItemStacks[1]);

                if (this.OilExtractorBurnTime > 0)
                {
                    flag1 = true;

                    if (this.OilExtractorItemStacks[1] != null)
                    {
                        --this.OilExtractorItemStacks[1].stackSize;

                        if (this.OilExtractorItemStacks[1].stackSize == 0)
                        {
                            this.OilExtractorItemStacks[1] = OilExtractorItemStacks[1].getItem().getContainerItem(OilExtractorItemStacks[1]);
                        }
                    }
                }
            }

            if (this.isBurning() && this.canSmelt())
            {
                ++this.OilExtractorCookTime;

                if (this.OilExtractorCookTime == 1000)
                {
                    this.OilExtractorCookTime = 0;
                    this.smeltItem();
                    flag1 = true;
                }
            }
            else
            {
                this.OilExtractorCookTime = 0;
            }

        }

        if (flag1)
        {
            this.markDirty();
        }
        boolean check = isActive;
        isActive = isBurning();
        if(isActive != check)
        {
                this.worldObj.markBlockForUpdate(this.xCoord, this.yCoord, this.zCoord);
        }
    }

    /**
     * Returns true if the OilExtractor can smelt an item, i.e. has a source item, destination stack isn't full, etc.
     */
    private boolean canSmelt()
    {
        if (this.OilExtractorItemStacks[0] == null)
        {
            return false;
        }
        else
        {
            ItemStack itemstack = RecipesOilExtractor.smelting().getSmeltingResult(this.OilExtractorItemStacks[0]);
            if (itemstack == null) return false;
            if (this.OilExtractorItemStacks[2] == null) return true;
            if (!this.OilExtractorItemStacks[2].isItemEqual(itemstack)) return false;
            int result = OilExtractorItemStacks[2].stackSize + itemstack.stackSize;
            return result <= getInventoryStackLimit() && result <= this.OilExtractorItemStacks[2].getMaxStackSize(); //Forge BugFix: Make it respect stack sizes properly.
        }
    }

    /**
     * Turn one item from the OilExtractor source stack into the appropriate smelted item in the OilExtractor result stack
     */
    public void smeltItem()
    {
        if (this.canSmelt())
        {
            ItemStack itemstack = RecipesOilExtractor.smelting().getSmeltingResult(this.OilExtractorItemStacks[0]);

            if (this.OilExtractorItemStacks[2] == null)
            {
                this.OilExtractorItemStacks[2] = itemstack.copy();
            }
            else if (this.OilExtractorItemStacks[2].getItem() == itemstack.getItem())
            {
                this.OilExtractorItemStacks[2].stackSize += itemstack.stackSize; // Forge BugFix: Results may have multiple items
            }

            --this.OilExtractorItemStacks[0].stackSize;

            if (this.OilExtractorItemStacks[0].stackSize <= 0)
            {
                this.OilExtractorItemStacks[0] = null;
            }
        }
    }

    /**
     * Returns the number of ticks that the supplied fuel item will keep the OilExtractor burning, or 0 if the item isn't
     * fuel
     */
    public static int getItemBurnTime(ItemStack p_145952_0_)
    {
        if (p_145952_0_ == null)
        {
            return 0;
        }
        else
        {
            Item item = p_145952_0_.getItem();
            if (item == item.getItemFromBlock(Blocks.double_plant)) return 1000;
            return GameRegistry.getFuelValue(p_145952_0_);
        }
    }

    public static boolean isItemFuel(ItemStack p_145954_0_)
    {
        /**
         * Returns the number of ticks that the supplied fuel item will keep the OilExtractor burning, or 0 if the item isn't
         * fuel
         */
        return getItemBurnTime(p_145954_0_) > 0;
    }

    /**
     * Do not make give this method the name canInteractWith because it clashes with Container
     */
    public boolean isUseableByPlayer(EntityPlayer par1EntityPlayer)
    {
        return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : par1EntityPlayer.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) <= 64.0D;
    }

    public void openInventory() {}

    public void closeInventory() {}

    /**
     * Returns true if automation is allowed to insert the given stack (ignoring stack size) into the given slot.
     */
    public boolean isItemValidForSlot(int par1, ItemStack par2ItemStack)
    {
        return par1 == 2 ? false : (par1 == 1 ? isItemFuel(par2ItemStack) : true);
    }

    /**
     * Returns an array containing the indices of the slots that can be accessed by automation on the given side of this
     * block.
     */
    public int[] getAccessibleSlotsFromSide(int par1)
    {
        return par1 == 0 ? slotsBottom : (par1 == 1 ? slotsTop : slotsSides);
    }

    /**
     * Returns true if automation can insert the given item in the given slot from the given side. Args: Slot, item,
     * side
     */
    public boolean canInsertItem(int par1, ItemStack par2ItemStack, int par3)
    {
        return this.isItemValidForSlot(par1, par2ItemStack);
    }

    /**
     * Returns true if automation can extract the given item in the given slot from the given side. Args: Slot, item,
     * side
     */
    public boolean canExtractItem(int par1, ItemStack par2ItemStack, int par3)
    {
        return par3 != 0 || par1 != 1 || par2ItemStack.getItem() == Items.bucket;
    }
}