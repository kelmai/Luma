package com.kelmai.luma.blocks.tileEntities;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet132TileEntityData;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;

public class TileEntityFixture extends TileEntity {

    private byte side = -1;



    public void setSide(byte val) {
        if (!worldObj.isRemote) {
            this.side = val;
            worldObj.addBlockEvent(xCoord, yCoord, zCoord, getBlockType().blockID, 1, val);
        }

    }
    public byte getSide() {
        return side;
    }



    /**
     * Called when a client event is received with the event number and argument, see World.sendClientEvent
     */
    @Override
    public boolean receiveClientEvent(int id, int value) {
        if (worldObj.isRemote && id == 1) {
            this.side = (byte)value;
            worldObj.markBlockForRenderUpdate(xCoord, yCoord, zCoord);
        }

        return true;
    }
    @Override
    public void writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);
        compound.setByte("side", side);

    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);

        side = compound.getByte("side");

    }


    /**
     * Return an {@link net.minecraft.util.AxisAlignedBB} that controls the visible scope of a TileEntitySpecialRenderer associated with this {@link TileEntity}
     * Defaults to the collision bounding box {@link net.minecraft.block.Block#getCollisionBoundingBoxFromPool(net.minecraft.world.World, int, int, int)} associated with the block
     * at this location.
     *
     * @return an appropriately size {@link net.minecraft.util.AxisAlignedBB} for the {@link TileEntity}
     */
    @SideOnly(Side.CLIENT)
    public AxisAlignedBB getRenderBoundingBox() {
        return AxisAlignedBB.getAABBPool().getAABB(xCoord, yCoord, zCoord, xCoord + 1, yCoord + 1, zCoord + 1);
    }

    public Packet getDescriptionPacket()
    {
        NBTTagCompound var1 = new NBTTagCompound();
        writeToNBT(var1);
        return new Packet132TileEntityData(this.xCoord, this.yCoord, this.zCoord, 1, var1);
    }
    public void onDataPacket(INetworkManager net, Packet132TileEntityData pkt) {
        readFromNBT(pkt.customParam1);
        if (worldObj.isRemote) {
            worldObj.markBlockForRenderUpdate(xCoord, yCoord, zCoord);
        }
    }
}
