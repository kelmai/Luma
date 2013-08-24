package com.kelmai.luma.blocksbb;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

/**
 * Created with IntelliJ IDEA.
 * User: KelMai
 * Date: 24.08.13
 * Time: 18:13
 */
public class BlockCustom  extends Block {

    public BlockCustom(int id, Material material, String unlocalizedName, CreativeTabs creativeTab) {
        super(id, material);

        this.setUnlocalizedName(unlocalizedName);

        if (creativeTab != null) {
            this.setCreativeTab(creativeTab);
        }
    }

    /**
     * Called throughout the code as a replacement for block instanceof BlockContainer
     * Moving this to the Block base class allows for mods that wish to extend vinella
     * blocks, and also want to have a tile entity on that block, may.
     *
     * Return true from this function to specify this block has a tile entity.
     *
     * @param metadata Metadata of the current block
     * @return True if block has a tile entity, false otherwise
     */
    @Override
    public boolean hasTileEntity(int metadata) {
        return true;
    }

    /**
     * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
     */
    @Override
    public boolean renderAsNormalBlock(){
        return false;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    /**
     * The type of render function that is called for this block
     */
    @Override
    public int getRenderType() {
        return -1;
    }
}
