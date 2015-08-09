package com.extfar.biofuelcompressor;

import java.util.Iterator;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerBioFuelCompressor extends Container
{
private TileEntityBioFuelCompressor goldOven;
private int lastGoldOvenCookTime;
private int lastGoldOvenBurnTime;
private int lastGoldOvenItemBurnTime;

public ContainerBioFuelCompressor(InventoryPlayer par1InventoryPlayer, TileEntityBioFuelCompressor par2TileEntityGoldOven)
{
         lastGoldOvenCookTime = 0;
         lastGoldOvenBurnTime = 0;
         lastGoldOvenItemBurnTime = 0;
         goldOven = par2TileEntityGoldOven;
         addSlotToContainer(new Slot(par2TileEntityGoldOven, 0, 61, 16));
         addSlotToContainer(new Slot(par2TileEntityGoldOven, 1, 101, 16));
         addSlotToContainer(new SlotBioFuelCompressor(par1InventoryPlayer.player, par2TileEntityGoldOven, 2, 81, 53));
         
        //slotNumber 0 = "Smelting Slot"
        //slotNumber 1 = "input Slot"
        //slotNumber 2= "output Slot"

         for (int i = 0; i < 3; i++)
         {
                 for (int k = 0; k < 9; k++)
                 {
                         addSlotToContainer(new Slot(par1InventoryPlayer, k + i * 9 + 9, 8 + k * 18, 84 + i * 18));
                 }
         }

         for (int j = 0; j < 9; j++)
         {
                 addSlotToContainer(new Slot(par1InventoryPlayer, j, 8 + j * 18, 142));
         }
}

/**
         * Updates crafting matrix; called from onCraftMatrixChanged. Args: none
         */
public void detectAndSendChanges()
{
         super.detectAndSendChanges();
         Iterator var1 = this.crafters.iterator();
         while (var1.hasNext())
         {
                 ICrafting var2 = (ICrafting)var1.next();
                 if (this.lastGoldOvenCookTime != this.goldOven.BioFuelCompressorCookTime)
                 {
                         var2.sendProgressBarUpdate(this, 0, this.goldOven.BioFuelCompressorCookTime);
                 }
                 if (this.lastGoldOvenBurnTime != this.goldOven.BioFuelCompressorBurnTime)
                 {
                         var2.sendProgressBarUpdate(this, 1, this.goldOven.BioFuelCompressorBurnTime);
                 }
                 if (this.lastGoldOvenItemBurnTime != this.goldOven.currentItemBurnTime)
                 {
                         var2.sendProgressBarUpdate(this, 2, this.goldOven.currentItemBurnTime);
                 }
         }
         this.lastGoldOvenCookTime = this.goldOven.BioFuelCompressorCookTime;
         this.lastGoldOvenBurnTime = this.goldOven.BioFuelCompressorBurnTime;
         this.lastGoldOvenItemBurnTime = this.goldOven.currentItemBurnTime;
}

public void updateProgressBar(int par1, int par2)
{
         if (par1 == 0)
         {
                 goldOven.BioFuelCompressorCookTime = par2;
         }

         if (par1 == 1)
         {
                 goldOven.BioFuelCompressorBurnTime = par2;
         }

         if (par1 == 2)
         {
                 goldOven.currentItemBurnTime = par2;
         }
}

public boolean canInteractWith(EntityPlayer par1EntityPlayer)
{
         return goldOven.isUseableByPlayer(par1EntityPlayer);
}

/**
 * Called when a player shift-clicks on a slot. You must override this or you will crash when someone does that.
 */
public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2)
{
    ItemStack itemstack = null;
    Slot slot = (Slot)this.inventorySlots.get(par2);

    if (slot != null && slot.getHasStack())
    {
        ItemStack itemstack1 = slot.getStack();
        itemstack = itemstack1.copy();

        if (par2 == 2)
        {
            if (!this.mergeItemStack(itemstack1, 3, 39, true))
            {
                return null;
            }

            slot.onSlotChange(itemstack1, itemstack);
        }
        else if (par2 != 1 && par2 != 0)
        {
            if (RecipesBioFuelCompressor.smelting().getSmeltingResult(itemstack1) != null)
            {
                if (!this.mergeItemStack(itemstack1, 0, 1, false))
                {
                    return null;
                }
            }
            else if (TileEntityBioFuelCompressor.isItemFuel(itemstack1))
            {
                if (!this.mergeItemStack(itemstack1, 1, 2, false))
                {
                    return null;
                }
            }
            else if (par2 >= 3 && par2 < 30)
            {
                if (!this.mergeItemStack(itemstack1, 30, 39, false))
                {
                    return null;
                }
            }
            else if (par2 >= 30 && par2 < 39 && !this.mergeItemStack(itemstack1, 3, 30, false))
            {
                return null;
            }
        }
        else if (!this.mergeItemStack(itemstack1, 3, 39, false))
        {
            return null;
        }

        if (itemstack1.stackSize == 0)
        {
            slot.putStack((ItemStack)null);
        }
        else
        {
            slot.onSlotChanged();
        }

        if (itemstack1.stackSize == itemstack.stackSize)
        {
            return null;
        }

        slot.onPickupFromSlot(par1EntityPlayer, itemstack1);
    }

    return itemstack;
}
}