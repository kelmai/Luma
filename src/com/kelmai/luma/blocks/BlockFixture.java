package com.kelmai.luma.blocks;

import com.kelmai.luma.blocks.tileEntities.TileEntityFixture;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

import static net.minecraftforge.common.ForgeDirection.*;
import static net.minecraftforge.common.ForgeDirection.EAST;

public class BlockFixture extends BlockCustom
{
	public BlockFixture(int id, Material material, String unlocalizedName, CreativeTabs creativeTab) {
		super(id, material, unlocalizedName, creativeTab);
		setHardness(5f);
	}

	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer playerEntity, int par6, float par7, float par8, float par9) {
		if(playerEntity.isSneaking())
			return false;
		
		//playerEntity.setEntityHealth(0);
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

}
