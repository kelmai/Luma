package com.kelmai.luma.items;

import com.kelmai.luma.Luma;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * Created with IntelliJ IDEA.
 * User: KelMai
 * Date: 15.08.13
 * Time: 17:25
 */
public class ItemChromaStone extends Item {
    public ItemChromaStone(int id) {
        super(id);

        setMaxStackSize(64);

    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister) {
        this.itemIcon = par1IconRegister.registerIcon(Luma.modID + ":itemChromaStone");
    }
}
