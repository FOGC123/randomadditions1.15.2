package com.fogc123.randomadditions.tilentities;

import com.fogc123.randomadditions.blocks.ModBlocks;
import com.fogc123.randomadditions.containers.WandInfuserContainer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class TileEntityWandInfuser extends TileEntity implements ITickableTileEntity, INamedContainerProvider {
    //only one slot for now for testing
    public static final int BOOK_SLOT = 0;


    //handles inventory
    public final ItemStackHandler inventory = new ItemStackHandler(1) {

        @Override
        public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
            // check if item is valid for slot, just return true for now(all items will be valid)
            return true;
        }

        @Override
        protected void onContentsChanged(int slot) {
            //callled everytime contents of inventory is changed
            super.onContentsChanged(slot);
            //mark entity dirty so game will save chunk to disc
            TileEntityWandInfuser.this.markDirty();
            System.out.println("Tile Entity Inventory Contents Changed!");
        }
    };
    //reduces number of objects i create(more efficient)
    public final LazyOptional<ItemStackHandler> inventoryCapabilityExternal = LazyOptional.of(() -> this.inventory);

    public TileEntityWandInfuser(TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
    }

    @Override
    public void tick() {
        //called every tick

    }



    @Override
    public void remove() {
        super.remove();
        inventoryCapabilityExternal.invalidate();
    }

    @Nonnull
    public CompoundNBT getUpdateTag() {
        return this.write(new CompoundNBT());
    }



    @Override
    public ITextComponent getDisplayName() {
        return new TranslationTextComponent(ModBlocks.WAND_INFUSER.get().getRegistryName().toString());
    }

//    /**
//     * Called from {@link NetworkHooks#openGui}
//     * (which is called from {@link BlockWandInfuser#onBlockActivated} on the logical server)
//     *
//     * @return The logical-server-side Container for this TileEntity
//     */
    @Nullable
    @Override
    public Container createMenu(int windowId, PlayerInventory inv, PlayerEntity player) {
        return new WandInfuserContainer(windowId, inv, this);
    }

}
