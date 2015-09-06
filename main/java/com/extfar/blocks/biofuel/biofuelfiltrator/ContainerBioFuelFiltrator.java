package com.extfar.blocks.biofuel.biofuelfiltrator;

import java.util.Iterator;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerBioFuelFiltrator extends Container
{
private TileEntityBioFuelFiltrator bioCompressor;
private int lastbioCompressorCookTime;
private int lastbioCompressorBurnTime;
private int lastbioCompressorItemBurnTime;

public ContainerBioFuelFiltrator(InventoryPlayer par1InventoryPlayer, TileEntityBioFuelFiltrator par2TileEntitybioCompressor)
{
         lastbioCompressorCookTime = 0;
         lastbioCompressorBurnTime = 0;
         lastbioCompressorItemBurnTime = 0;
         bioCompressor = par2TileEntitybioCompressor;
         
         addSlotToContainer(new Slot(par2TileEntitybioCompressor, 0, 56, 30));
         addSlotToContainer(new Slot(par2TileEntitybioCompressor, 1, 34, 30));
         addSlotToContainer(new SlotBioFuelFiltrator(par1InventoryPlayer.player, par2TileEntitybioCompressor, 2, 99, 30));
         
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
                 if (this.lastbioCompressorCookTime != this.bioCompressor.BioFuelFiltratorCookTime)
                 {
                         var2.sendProgressBarUpdate(this, 0, this.bioCompressor.BioFuelFiltratorCookTime);
                 }
                 if (this.lastbioCompressorBurnTime != this.bioCompressor.BioFuelFiltratorBurnTime)
                 {
                         var2.sendProgressBarUpdate(this, 1, this.bioCompressor.BioFuelFiltratorBurnTime);
                 }
                 if (this.lastbioCompressorItemBurnTime != this.bioCompressor.currentItemBurnTime)
                 {
                         var2.sendProgressBarUpdate(this, 2, this.bioCompressor.currentItemBurnTime);
                 }
         }
         this.lastbioCompressorCookTime = this.bioCompressor.BioFuelFiltratorCookTime;
         this.lastbioCompressorBurnTime = this.bioCompressor.BioFuelFiltratorBurnTime;
         this.lastbioCompressorItemBurnTime = this.bioCompressor.currentItemBurnTime;
}

public void updateProgressBar(int par1, int par2)
{
         if (par1 == 0)
         {
                 bioCompressor.BioFuelFiltratorCookTime = par2;
         }

         if (par1 == 1)
         {
                 bioCompressor.BioFuelFiltratorBurnTime = par2;
         }

         if (par1 == 2)
         {
                 bioCompressor.currentItemBurnTime = par2;
         }
}

public boolean canInteractWith(EntityPlayer par1EntityPlayer)
{
         return bioCompressor.isUseableByPlayer(par1EntityPlayer);
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
            if (RecipesBioFuelFiltrator.smelting().getSmeltingResult(itemstack1) != null)
            {
                if (!this.mergeItemStack(itemstack1, 0, 1, false))
                {
                    return null;
                }
            }
            else if (TileEntityBioFuelFiltrator.isItemFuel(itemstack1))
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