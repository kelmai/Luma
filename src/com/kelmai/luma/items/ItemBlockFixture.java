package com.kelmai.luma.items;

import com.kelmai.luma.blocks.tileEntities.TileEntityFixture;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import static net.minecraftforge.common.ForgeDirection.*;

/**
 * Created with IntelliJ IDEA.
 * User: KelMai
 * Date: 03.09.13
 * Time: 18:35
 */
public class ItemBlockFixture extends ItemBlock {
    private final static String[] subNames = {
            "white", "orange",  "magenta", "lightBlue", "yellow", "lightGreen",
            "pink", "darkGrey", "lightGrey", "cyan", "purple", "blue", "brown",
            "green", "red", "black"
    };
    public int thisID;
    public ItemBlockFixture(int id) {
        super(id);
        setHasSubtypes(true);
        setUnlocalizedName("multiBlock");
        this.thisID = id + 256;
    }

    @Override
    public int getMetadata (int damageValue) {
        return damageValue;
    }

    @Override
    public String getUnlocalizedName(ItemStack itemstack) {
        return getUnlocalizedName() + "." + subNames[itemstack.getItemDamage()];
    }

    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10) {
        boolean r = super.onItemUse(par1ItemStack, par2EntityPlayer, par3World, par4, par5, par6, par7, par8, par9, par10);
        int var11 = par3World.getBlockId(par4, par5, par6);
        if (var11 != Block.vine.blockID && var11 != Block.tallGrass.blockID && var11 != Block.deadBush.blockID)
        {
            if (par7 == 0)
            {
                --par5;
            }

            if (par7 == 1)
            {
                ++par5;
            }

            if (par7 == 2)
            {
                --par6;
            }

            if (par7 == 3)
            {
                ++par6;
            }

            if (par7 == 4)
            {
                --par4;
            }

            if (par7 == 5)
            {
                ++par4;
            }


        }
        byte b0 = -1;
        if (par7 == 0 && par3World.isBlockSolidOnSide(par4, par5 + 1, par6, DOWN)) { b0 = 0; }
        if (par7 == 1 && par3World.isBlockSolidOnSide(par4, par5 - 1, par6, UP)) { b0 = 5; }
        if (par7 == 2 && par3World.isBlockSolidOnSide(par4, par5, par6 + 1, NORTH)) { b0 = 4; }
        if (par7 == 3 && par3World.isBlockSolidOnSide(par4, par5, par6 - 1, SOUTH)) { b0 = 3; }
        if (par7 == 4 && par3World.isBlockSolidOnSide(par4 + 1, par5, par6, WEST)) { b0 = 2; }
        if (par7 == 5 && par3World.isBlockSolidOnSide(par4 - 1, par5, par6, EAST)) { b0 = 1; }
        TileEntityFixture te = (TileEntityFixture)par3World.getBlockTileEntity(par4, par5, par6);
        if (te != null) {
            te.setSide(b0);
        }


        return r;
    }
}
