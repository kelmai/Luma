package com.kelmai.luma;

import com.kelmai.luma.items.ItemChromaStone;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * Created with IntelliJ IDEA.
 * User: KelMai
 * Date: 19.08.13
 * Time: 00:58
 */
public class ItemManager {

    public static int itemStartId;

    public static Item itemChromaStone;

    public static void makeItems() {
        itemChromaStone = new ItemChromaStone(ItemManager.itemStartId).setCreativeTab(CreativeTabs.tabMisc).setUnlocalizedName("itemChromaStone");
        LanguageRegistry.addName(itemChromaStone, "Chroma Stone");
    }
}
