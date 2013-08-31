package com.kelmai.luma.items;

import com.kelmai.luma.Luma;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * Created with IntelliJ IDEA.
 * User: KelMai
 * Date: 30.08.13
 * Time: 13:33
 */
public class ItemKelmaiDebug extends Item {
    public ItemKelmaiDebug(int id) {
        super(id);

        setMaxStackSize(1);

    }


    /**
     * Callback for item usage. If the item does something special on right clicking, he will have one of those. Return
     * True if something happen and false if it don't. This is for ITEMS, not BLOCKS
     */
    public boolean onItemUse(ItemStack itemStack, EntityPlayer entityPlayer, World world, int x, int y, int z, int side, float par8, float par9, float par10) {
        if (!world.isRemote) {

            int metadata = world.getBlockMetadata(x, y, z);
            int id = world.getBlockId(x, y, z);

            String sideOutput;
            switch (side) {
                case 4:
                     sideOutput = "west";
                    break;
                case 5:
                    sideOutput = "east";
                    break;
                case 3:
                    sideOutput = "south";
                    break;
                case 2:
                    sideOutput = "north";
                    break;
                case 1:
                    sideOutput = "top";
                    break;
                case 0:
                    sideOutput = "bottom";
                    break;
                default:
                    sideOutput = "none";
                    break;
            }

            Block block = Block.blocksList[id];

            int powerInd = world.getStrongestIndirectPower(x, y, z);
            int power = world.getBlockPowerInput(x, y, z);


            entityPlayer.addChatMessage("§l=======[[ LUMA DEBUG OUTPUT ]]=======");
            entityPlayer.addChatMessage("§7x §f" + x + "  §7y §f" + y + "  §7z §f" + z);
            entityPlayer.addChatMessage(block.getLocalizedName() + " / " + block.getUnlocalizedName() + " " + id + ":" + metadata);
            entityPlayer.addChatMessage("§7side: §f" + sideOutput + " (" + side + ")");
            if (world.isBlockIndirectlyGettingPowered(x, y, z)) {
                entityPlayer.addChatMessage("§7power: direct§f " + power + "§7  indirect§f " + powerInd);
            }


            Luma.log("side: "+side);
            Luma.log("par8: "+par8);
            Luma.log("par9: "+par9);
            Luma.log("par10: "+par10);

            return true;
        } else {
            return false;
        }
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister) {
        this.itemIcon = par1IconRegister.registerIcon(Luma.modID + ":itemKelmaiDebug");
    }
}
