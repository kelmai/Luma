package com.kelmai.luma.items;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

/**
 * Created with IntelliJ IDEA.
 * User: KelMai
 * Date: 11.08.13
 * Time: 22:32
 */
public class ItemBlockLumaLamp extends ItemBlock {

    private final static String[] subNames = {
            "white", "orange",  "magenta", "lightBlue", "yellow", "lightGreen",
            "pink", "darkGrey", "lightGrey", "cyan", "purple", "blue", "brown",
            "green", "red", "black"
    };

    public ItemBlockLumaLamp(int id) {
        super(id);
        setHasSubtypes(true);
        setUnlocalizedName("multiBlock");
    }

    @Override
    public int getMetadata (int damageValue) {
        return damageValue;
    }

    @Override
    public String getUnlocalizedName(ItemStack itemstack) {
        return getUnlocalizedName() + "." + subNames[itemstack.getItemDamage()];
    }
}
