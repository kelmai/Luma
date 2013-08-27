package com.kelmai.luma.blocks.tileEntities;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;

public class TileEntityFixture extends TileEntity {
	public TileEntityFixture() {
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
