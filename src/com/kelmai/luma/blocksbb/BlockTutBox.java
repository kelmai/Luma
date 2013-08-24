package com.kelmai.luma.blocksbb;

import com.kelmai.luma.blocksbb.tileEntities.TileEntityTutBox;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockTutBox extends BlockCustom
{
	public BlockTutBox(int id, Material material, String unlocalizedName, CreativeTabs creativeTab) {
		super(id, material, unlocalizedName, creativeTab);
		setHardness(5f);
	}

	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer playerEntity, int par6, float par7, float par8, float par9) {
		if(playerEntity.isSneaking())
			return false;
		
		//playerEntity.setEntityHealth(0);
		return true;
	}
	
	@Override
	public TileEntity createTileEntity(World world, int metadata) {
		return new TileEntityTutBox();
	}

}
