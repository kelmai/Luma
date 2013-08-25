package com.kelmai.luma.blocks;

import com.kelmai.luma.Luma;
import com.kelmai.luma.blocks.tileEntities.TileEntityFixture;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

import static net.minecraftforge.common.ForgeDirection.*;
import static net.minecraftforge.common.ForgeDirection.EAST;

public class BlockFixture extends BlockCustom
{
	public BlockFixture(int id, Material material, String unlocalizedName, CreativeTabs creativeTab) {
		super(id, material, unlocalizedName, creativeTab);
		setHardness(5f);
        /**
         * Sets the bounds of the block.  minX, minY, minZ, maxX, maxY, maxZ
         */
        this.setBlockBounds(0.125F,  0.0F,      0.125F,
                            0.875F,  0.4375F,   0.875F);
	}

	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer playerEntity, int par6, float par7, float par8, float par9) {
		if(playerEntity.isSneaking())
			return false;

        int meta = world.getBlockMetadata(x,y,z);
        Luma.log("meta: "+meta);
		return false;
	}
	
	@Override
	public TileEntity createTileEntity(World world, int metadata) {
		return new TileEntityFixture();
	}

    /**
     * checks to see if you can place this block can be placed on that side of a block: BlockLever overrides
     */
    public boolean canPlaceBlockOnSide(World par1World, int par2, int par3, int par4, int par5) {
        ForgeDirection dir = ForgeDirection.getOrientation(par5);
        return  (dir == DOWN  && par1World.isBlockSolidOnSide(par2, par3 + 1, par4, DOWN )) ||
                (dir == UP    && par1World.isBlockSolidOnSide(par2, par3 - 1, par4, UP   )) ||
                (dir == NORTH && par1World.isBlockSolidOnSide(par2, par3, par4 + 1, NORTH)) ||
                (dir == SOUTH && par1World.isBlockSolidOnSide(par2, par3, par4 - 1, SOUTH)) ||
                (dir == WEST  && par1World.isBlockSolidOnSide(par2 + 1, par3, par4, WEST )) ||
                (dir == EAST  && par1World.isBlockSolidOnSide(par2 - 1, par3, par4, EAST ));
    }

    /**
     * Checks to see if its valid to put this block at the specified coordinates. Args: world, x, y, z
     */
    public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4) {
        return  par1World.isBlockSolidOnSide(par2 - 1, par3, par4, EAST ) ||
                par1World.isBlockSolidOnSide(par2 + 1, par3, par4, WEST ) ||
                par1World.isBlockSolidOnSide(par2, par3, par4 - 1, SOUTH) ||
                par1World.isBlockSolidOnSide(par2, par3, par4 + 1, NORTH) ||
                par1World.isBlockSolidOnSide(par2, par3 - 1, par4, UP   ) ||
                par1World.isBlockSolidOnSide(par2, par3 + 1, par4, DOWN );
    }

    /**
     * Called when a block is placed using its ItemBlock. Args: World, X, Y, Z, side, hitX, hitY, hitZ, block metadata
     */
    public int onBlockPlaced(World par1World, int par2, int par3, int par4, int par5, float par6, float par7, float par8, int par9) {

        int j1 = par9 & 8;
        int k1 = par9 & 7;
        byte b0 = -1;

        if (par5 == 0 && par1World.isBlockSolidOnSide(par2, par3 + 1, par4, DOWN)) {
            b0 = 0;
        }

        if (par5 == 1 && par1World.isBlockSolidOnSide(par2, par3 - 1, par4, UP)) {
            b0 = 5;
        }

        if (par5 == 2 && par1World.isBlockSolidOnSide(par2, par3, par4 + 1, NORTH)) {
            b0 = 4;
        }

        if (par5 == 3 && par1World.isBlockSolidOnSide(par2, par3, par4 - 1, SOUTH)) {
            b0 = 3;
        }

        if (par5 == 4 && par1World.isBlockSolidOnSide(par2 + 1, par3, par4, WEST)) {
            b0 = 2;
        }

        if (par5 == 5 && par1World.isBlockSolidOnSide(par2 - 1, par3, par4, EAST)) {
            b0 = 1;
        }

        return b0 + j1;
    }

    /**
     * Called when the block is placed in the world.
     */
    public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLivingBase par5EntityLivingBase, ItemStack par6ItemStack) {
        int l = par1World.getBlockMetadata(par2, par3, par4);
        int i1 = l & 7;
        int j1 = l & 8;

        if (i1 == invertMetadata(1)) {
            if ((MathHelper.floor_double((double) (par5EntityLivingBase.rotationYaw * 4.0F / 360.0F) + 0.5D) & 1) == 0) {
                par1World.setBlockMetadataWithNotify(par2, par3, par4, 5 | j1, 2);
            } else {
                par1World.setBlockMetadataWithNotify(par2, par3, par4, 6 | j1, 2);
            }
        } else if (i1 == invertMetadata(0)) {
            if ((MathHelper.floor_double((double)(par5EntityLivingBase.rotationYaw * 4.0F / 360.0F) + 0.5D) & 1) == 0) {
                par1World.setBlockMetadataWithNotify(par2, par3, par4, 7 | j1, 2);
            } else {
                par1World.setBlockMetadataWithNotify(par2, par3, par4, 0 | j1, 2);
            }
        }
    }

    /**
     * only used in ComponentScatteredFeatureJunglePyramid.addComponentParts"
     */
    public static int invertMetadata(int par0) {
        switch (par0) {
            case 0:
                return 0;
            case 1:
                return 5;
            case 2:
                return 4;
            case 3:
                return 3;
            case 4:
                return 2;
            case 5:
                return 1;
            default:
                return -1;
        }
    }

    /**
     * Lets the block know when one of its neighbor changes. Doesn't know which neighbor changed (coordinates passed are
     * their own) Args: x, y, z, neighbor blockID
     */
    public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5)
    {
        if (this.checkIfAttachedToBlock(par1World, par2, par3, par4))
        {
            int i1 = par1World.getBlockMetadata(par2, par3, par4) & 7;
            boolean flag = false;

            if (!par1World.isBlockSolidOnSide(par2 - 1, par3, par4, EAST) && i1 == 1)
            {
                flag = true;
            }

            if (!par1World.isBlockSolidOnSide(par2 + 1, par3, par4, WEST) && i1 == 2)
            {
                flag = true;
            }

            if (!par1World.isBlockSolidOnSide(par2, par3, par4 - 1, SOUTH) && i1 == 3)
            {
                flag = true;
            }

            if (!par1World.isBlockSolidOnSide(par2, par3, par4 + 1, NORTH) && i1 == 4)
            {
                flag = true;
            }

            if (!par1World.isBlockSolidOnSide(par2, par3 - 1, par4, UP) && i1 == 5)
            {
                flag = true;
            }

            if (!par1World.isBlockSolidOnSide(par2, par3 - 1, par4, UP) && i1 == 6)
            {
                flag = true;
            }

            if (!par1World.isBlockSolidOnSide(par2, par3 + 1, par4, DOWN) && i1 == 0)
            {
                flag = true;
            }

            if (!par1World.isBlockSolidOnSide(par2, par3 + 1, par4, DOWN) && i1 == 7)
            {
                flag = true;
            }

            if (flag)
            {
                this.dropBlockAsItem(par1World, par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4), 0);
                par1World.setBlockToAir(par2, par3, par4);
            }
        }
    }

    /**
     * Checks if the block is attached to another block. If it is not, it returns false and drops the block as an item.
     * If it is it returns true.
     */
    private boolean checkIfAttachedToBlock(World par1World, int par2, int par3, int par4)
    {
        if (!this.canPlaceBlockAt(par1World, par2, par3, par4))
        {
            this.dropBlockAsItem(par1World, par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4), 0);
            par1World.setBlockToAir(par2, par3, par4);
            return false;
        }
        else
        {
            return true;
        }
    }
}
