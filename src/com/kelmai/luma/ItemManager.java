package com.kelmai.luma;

import com.kelmai.luma.items.ItemChromaStone;
import com.kelmai.luma.items.ItemKelmaiDebug;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.item.Item;

/**
 * Created with IntelliJ IDEA.
 * User: KelMai
 * Date: 19.08.13
 * Time: 00:58
 */
public class ItemManager {

    public static int itemStartId;
    public static Item itemKelmaiDebug;
    public static Item itemChromaStone;

    public static void makeItems() {

        // Chroma Stone
        itemChromaStone = new ItemChromaStone(ConfigManager.itemChromaStoneId).setCreativeTab(Luma.tab).setUnlocalizedName("itemChromaStone");
        LanguageRegistry.addName(itemChromaStone, "Chroma Stone");


        // Debug Item
        if (ConfigManager.itemDebug) {
            itemKelmaiDebug = new ItemKelmaiDebug(ConfigManager.itemDebugId).setCreativeTab(Luma.tab).setUnlocalizedName("itemKelmaiDebug");
            LanguageRegistry.addName(itemKelmaiDebug, "KelMai Debug Item");
        }
    }
}
