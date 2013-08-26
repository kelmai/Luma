package com.kelmai.luma;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.Configuration;

import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * User: KelMai
 * Date: 19.08.13
 * Time: 01:02
 */
public class ConfigManager {
    public static void initConfiguration(FMLPreInitializationEvent event) {
        Configuration config = new Configuration(new File("config/luma.cfg"));
        config.load();

        // Blocks
        config.addCustomCategoryComment(        "Blocks",   "This is where you can set the IDs for the Blocks used by the Luma Lamp Mod");
        BlockManager.blockStartId = config.get( "Blocks",   "Block Start ID",   2000,   "The Luma Mod will use 11 consecutive Block IDs, starting with the one you enter here").getInt();
        ItemManager.itemStartId = config.get(   "Items",    "Item Start ID",    20000,  "The Luma Mod will use 1 consecutive Item IDs, starting with the one you enter here").getInt();

        Luma.log("Loading Configuration");

        config.save();
    }
}
