package com.kelmai.luma.blocks;

import com.kelmai.luma.BlockManager;
import com.kelmai.luma.Luma;
import com.kelmai.luma.blocks.tileEntities.TileEntityFixture;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

import java.util.List;
import java.util.Random;

import static net.minecraftforge.common.ForgeDirection.*;

public class BlockFixture extends BlockContainer {

    public boolean powered;
    public boolean bars;
    public boolean inverted;

	public BlockFixture(int id, Material material, boolean powered, boolean inverted, boolean bars) {
		super(id, material);

        this.powered = powered;
        this.bars = bars;
        this.inverted = inverted;

        if (this.bars) {
            this.setHardness(3f);
            this.setResistance(3f);
        } else {
            this.setHardness(.5f);
            this.setResistance(.5f);
        }

        this.setStepSound(Block.soundGlassFootstep);

        if (this.powered) {
            if (!this.inverted) {
                this.setLightValue(1.0F);
            }
        } else {
            if (this.inverted) {
                this.setLightValue(1.0F);
            }
        }

        /**
         * Sets the bounds of the block.  minX, minY, minZ, maxX, maxY, maxZ
         */
        this.setBlockBounds(0.125F,  0.0F,      0.125F,
                            0.875F,  0.4375F,   0.875F);
	}

    /**
     * Returns the ID of the items to drop on destruction.
     */
    public int idDropped(int par1, Random par2Random, int par3) {
        if (this.inverted) {
            return this.bars ? BlockManager.blockFixtureOffBarsInv.blockID : BlockManager.blockFixtureOffInv.blockID;
        } else {
            return this.bars ? BlockManager.blockFixtureOffBars.blockID : BlockManager.blockFixtureOff.blockID;
        }
    }

    /**
     * Called whenever the block is added into the world. Args: world, x, y, z
     */
    public void onBlockAdded(World par1World, int par2, int par3, int par4) {
        if (!par1World.isRemote) {
            if (this.checkIfAttachedToBlock(par1World, par2, par3, par4)) {
                TileEntityFixture te = (TileEntityFixture)par1World.getBlockTileEntity(par2, par3, par4);
                byte side = te.getSide();
                int i1 = side;
                boolean flag = false;
                if (!par1World.isBlockSolidOnSide(par2 - 1, par3, par4, EAST) && i1 == 1) { flag = true; }
                if (!par1World.isBlockSolidOnSide(par2 + 1, par3, par4, WEST) && i1 == 2) { flag = true; }
                if (!par1World.isBlockSolidOnSide(par2, par3, par4 - 1, SOUTH) && i1 == 3) { flag = true; }
                if (!par1World.isBlockSolidOnSide(par2, par3, par4 + 1, NORTH) && i1 == 4) { flag = true; }
                if (!par1World.isBlockSolidOnSide(par2, par3 - 1, par4, UP) && i1 == 5) { flag = true; }
                if (!par1World.isBlockSolidOnSide(par2, par3 - 1, par4, UP) && i1 == 6) { flag = true; }
                if (!par1World.isBlockSolidOnSide(par2, par3 + 1, par4, DOWN) && i1 == 0) { flag = true; }
                if (!par1World.isBlockSolidOnSide(par2, par3 + 1, par4, DOWN) && i1 == 7) { flag = true; }
                if (flag) {
                    this.dropBlockAsItem(par1World, par2, par3, par4, 0, 0);
                    par1World.setBlockToAir(par2, par3, par4);
                }
            }
            handlePowerInput(par1World, par2, par3, par4);


        }


    }



    /**
     * Ticks the block if it's been scheduled
     */
    public void updateTick(World world, int x, int y, int z, Random par5Random) {
        if (!world.isRemote) {
            if (this.powered && !world.isBlockIndirectlyGettingPowered(x, y, z)) {
                int blockID;
                if (this.inverted) {
                    blockID = this.bars ? BlockManager.blockFixtureOffBarsInv.blockID : BlockManager.blockFixtureOffInv.blockID;
                } else {
                    blockID = this.bars ? BlockManager.blockFixtureOffBars.blockID : BlockManager.blockFixtureOff.blockID;
                }
                setBlockWithTE(world, x, y, z, blockID);
            } else if (!this.powered && world.isBlockIndirectlyGettingPowered(x, y, z)) {
                int blockID;
                if (this.inverted) {
                    blockID = this.bars ? BlockManager.blockFixtureOnBarsInv.blockID : BlockManager.blockFixtureOnInv.blockID;
                } else {
                    blockID = this.bars ? BlockManager.blockFixtureOnBars.blockID : BlockManager.blockFixtureOn.blockID;
                }
                setBlockWithTE(world, x, y, z, blockID);

            }
        }

    }

    /**
     * Updates the blocks bounds based on its current state. Args: world, x, y, z
     */
    public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess, int x, int y, int z)
    {
        TileEntityFixture te = (TileEntityFixture)par1IBlockAccess.getBlockTileEntity(x, y, z);
        byte side = te.getSide();

        switch (side) {
            case 1: this.setBlockBounds(0.0F,  0.125F,    0.125F,
                                        0.4375F,  0.875F,    0.875F); break;
            case 2: this.setBlockBounds(0.5625F,  0.125F,      0.125F,
                                        1.0F,  0.875F,   0.875F); break;
            case 3: this.setBlockBounds(0.125F,  0.125F,      0.0F,
                                        0.875F,  0.875F,   0.4375F); break;
            case 4: this.setBlockBounds(0.125F,  0.125F,      0.5625F,
                                        0.875F,  0.875F,   1.0F); break;
            case 5: this.setBlockBounds(0.125F,  0.0F,      0.125F,
                                        0.875F,  0.4375F,   0.875F); break;
            default: this.setBlockBounds(0.125F,  0.5625F,      0.125F,
                                        0.875F,  1.0F,   0.875F); break;
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


	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer playerEntity, int par6, float par7, float par8, float par9) {
        return false;
	}


    public TileEntity createNewTileEntity(World world) {

        return new TileEntityFixture();
    }

    /**
     * checks to see if you can place this block can be placed on that side of a block: BlockLever overrides
     */
    public boolean canPlaceBlockOnSide(World par1World, int x, int y, int z, int side) {
        ForgeDirection dir = ForgeDirection.getOrientation(side);
        boolean r = (dir == DOWN  && par1World.isBlockSolidOnSide(x, y + 1, z, DOWN )) ||
                (dir == UP    && par1World.isBlockSolidOnSide(x, y - 1, z, UP   )) ||
                (dir == NORTH && par1World.isBlockSolidOnSide(x, y, z + 1, NORTH)) ||
                (dir == SOUTH && par1World.isBlockSolidOnSide(x, y, z - 1, SOUTH)) ||
                (dir == WEST  && par1World.isBlockSolidOnSide(x + 1, y, z, WEST )) ||
                (dir == EAST  && par1World.isBlockSolidOnSide(x - 1, y, z, EAST ));
        return r;
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
    public int onBlockPlaced(World par1World, int x, int y, int z, int side, float hitX, float hitY, float hitZ, int metadata) {
        return metadata;
    }

    public void onPostBlockPlaced(World par1World, int x, int y, int z, int side) {
        TileEntityFixture te = (TileEntityFixture)par1World.getBlockTileEntity(x,y,z);
        te.setSide((byte)side);
    }


    /**
     * Lets the block know when one of its neighbor changes. Doesn't know which neighbor changed (coordinates passed are
     * their own) Args: x, y, z, neighbor blockID
     */
    public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5) {
        if (!par1World.isRemote) {
            if (this.checkIfAttachedToBlock(par1World, par2, par3, par4)) {
                TileEntityFixture te = (TileEntityFixture)par1World.getBlockTileEntity(par2, par3, par4);
                byte side = te.getSide();
                int i1 = side & 7;
                boolean flag = false;
                if (!par1World.isBlockSolidOnSide(par2 - 1, par3, par4, EAST) && i1 == 1) { flag = true; }
                if (!par1World.isBlockSolidOnSide(par2 + 1, par3, par4, WEST) && i1 == 2) { flag = true; }
                if (!par1World.isBlockSolidOnSide(par2, par3, par4 - 1, SOUTH) && i1 == 3) { flag = true; }
                if (!par1World.isBlockSolidOnSide(par2, par3, par4 + 1, NORTH) && i1 == 4) { flag = true; }
                if (!par1World.isBlockSolidOnSide(par2, par3 - 1, par4, UP) && i1 == 5) { flag = true; }
                if (!par1World.isBlockSolidOnSide(par2, par3 - 1, par4, UP) && i1 == 6) { flag = true; }
                if (!par1World.isBlockSolidOnSide(par2, par3 + 1, par4, DOWN) && i1 == 0) { flag = true; }
                if (!par1World.isBlockSolidOnSide(par2, par3 + 1, par4, DOWN) && i1 == 7) { flag = true; }
                if (flag) {
                    this.dropBlockAsItem(par1World, par2, par3, par4, 0, 0);
                    par1World.setBlockToAir(par2, par3, par4);
                }
            }
            handlePowerInput(par1World, par2, par3, par4);
        }
    }

    /**
     * Checks if the block is attached to another block. If it is not, it returns false and drops the block as an item.
     * If it is it returns true.
     */
    private boolean checkIfAttachedToBlock(World par1World, int par2, int par3, int par4) {
        if (!this.canPlaceBlockAt(par1World, par2, par3, par4)) {
            this.dropBlockAsItem(par1World, par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4), 0);
            par1World.setBlockToAir(par2, par3, par4);
            return false;
        } else {
            return true;
        }
    }

    public int damageDropped (int metadata) {
        return metadata;
    }

    /**
     * When this method is called, your block should register all the icons it needs with the given IconRegister. This
     * is the only chance you get to register icons.
     */
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister) {
        this.blockIcon = par1IconRegister.registerIcon(Luma.modID + ":blockLumaLampOn_0");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(int unknown, CreativeTabs tab, List subItems) {
        for (int ix = 0; ix < 16; ix++) {
            subItems.add(new ItemStack(this, 1, ix));
        }
    }

    public void setBlockWithTE(World world, int x, int y, int z, int blockID) {
        TileEntityFixture te = (TileEntityFixture)world.getBlockTileEntity(x, y, z);
        byte side = te.getSide();

        world.setBlock(x, y, z, blockID, world.getBlockMetadata(x, y, z), 2);

        TileEntityFixture teNew = (TileEntityFixture)world.getBlockTileEntity(x, y, z);
        teNew.setSide(side);
    }

    public void setBlockWithTEAndSide(World world, int x, int y, int z, int blockID, byte side) {
        world.setBlock(x, y, z, blockID, 0, 2);

        TileEntityFixture teNew = (TileEntityFixture)world.getBlockTileEntity(x, y, z);
        teNew.setSide(side);
    }

    public void handlePowerInput(World world, int x, int y, int z) {
        if (this.powered && !world.isBlockIndirectlyGettingPowered(x, y, z)) {
            world.scheduleBlockUpdate(x, y, z, this.blockID, 1);
        } else if (!this.powered && world.isBlockIndirectlyGettingPowered(x, y, z)) {
            world.scheduleBlockUpdate(x, y, z, this.blockID, 1);
        }
    }
}
