package com.kelmai.luma.blocks;

import com.kelmai.luma.BlockManager;
import com.kelmai.luma.Luma;
import cpw.mods.fml.common.registry.GameData;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: KelMai
 * Date: 13.08.13
 * Time: 21:30
 */

// TODO fix indirect power

public class BlockMultiLamp extends Block {
    @SideOnly(Side.CLIENT)
    private Icon[] iconArray;
    private Icon offIcon;

    private boolean powered;
    private boolean bars;

    public BlockMultiLamp(int id, boolean powered, boolean bars) {
        super(id, Material.glass);

        this.bars = bars;
        this.powered = powered;

        if (this.bars) {
            this.setHardness(3f);
            this.setResistance(3f);
        } else {
            this.setHardness(.5f);
            this.setResistance(.5f);
        }

        this.setStepSound(Block.soundGlassFootstep);

        if (this.powered) {
            this.setLightValue(1f);
        } else {
            this.setLightValue(0f);
        }



    }

    public int damageDropped (int metadata) {
        return this.powered ? metadata : 0;
    }

    /**
     * Called whenever the block is added into the world. Args: world, x, y, z
     */
    public void onBlockAdded(World par1World, int par2, int par3, int par4) {
        if (!par1World.isRemote) {
            par1World.scheduleBlockUpdate(par2, par3, par4, this.blockID, 1);
        }
    }

    /**
     * Lets the block know when one of its neighbor changes. Doesn't know which neighbor changed (coordinates passed are
     * their own) Args: x, y, z, neighbor blockID
     */
    public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5) {
        if (!par1World.isRemote) {
            par1World.scheduleBlockUpdate(par2, par3, par4, this.blockID, 1);
        }
    }

    /**
     * Ticks the block if it's been scheduled
     */
    public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random) {
        if (!par1World.isRemote) {

            if (this.powered) {
                if (!par1World.isBlockIndirectlyGettingPowered(par2, par3, par4)) {
                    int blockID = this.bars ? BlockManager.blockMultiLampBarOff.blockID : BlockManager.blockMultiLampOff.blockID;
                    par1World.setBlock(par2, par3, par4, blockID, 0, 2);
                }
                par1World.setBlockMetadataWithNotify(par2, par3, par4,  par1World.getStrongestIndirectPower(par2, par3, par4), 2);
            } else {
                if (par1World.isBlockIndirectlyGettingPowered(par2, par3, par4)) {
                    int blockID = this.bars ? BlockManager.blockMultiLampBarOn.blockID : BlockManager.blockMultiLampOn.blockID;
                    par1World.setBlock(par2, par3, par4, blockID,  par1World.getStrongestIndirectPower(par2, par3, par4), 2);
                }
            }
        }
    }

    /**
     * Returns the ID of the items to drop on destruction.
     */
    public int idDropped(int par1, Random par2Random, int par3) {
        return this.bars ? BlockManager.blockMultiLampBarOff.blockID : BlockManager.blockMultiLampOff.blockID;
    }

    @Override
    @SideOnly(Side.CLIENT)

    /**
     * When this method is called, your block should register all the icons it needs with the given IconRegister. This
     * is the only chance you get to register icons.
     */
    public void registerIcons(IconRegister par1IconRegister) {

        if (this.powered) {
            this.iconArray = new Icon[16];
            for (int i = 0; i < 16; i++) {
                String barsString = this.bars ? "Bars" : "";
                String textureString = ":blockMultiLamp"+barsString+"On_";
                this.iconArray[i] = par1IconRegister.registerIcon(Luma.modID + textureString + i);
            }
        } else {
            String barsString = this.bars ? "Bars" : "";
            String textureString = ":blockMultiLamp"+barsString+"Off";
            this.offIcon = par1IconRegister.registerIcon(Luma.modID + textureString);
        }

    }

    @Override
    @SideOnly(Side.CLIENT)
    public Icon getIcon(int side, int metadata) {
        if (this.powered) {
            return this.iconArray[15-metadata];
        } else {
            return this.offIcon;
        }
    }
}
