package com.kelmai.luma.blocks.tileEntities;

import com.kelmai.luma.BlockManager;
import com.kelmai.luma.Luma;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;

public class TileEntityFixture extends TileEntity {

    private byte side;


	public TileEntityFixture() {
        Luma.log("init");
        side = 0;
	}

    public void setSide(byte val) {
        Luma.log("setSide "+val);
        side = val;
    }
    public byte getSide() {
        Luma.log("getSide "+side);
        return side;
    }

    private void spread(int x, int y, int z) {
        if(worldObj.isAirBlock(x, y, z)) {
            worldObj.setBlock(x,y,z, BlockManager.blockLumaLampOff.blockID);
        }
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
}
