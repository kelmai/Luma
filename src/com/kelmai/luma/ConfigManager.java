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

//    public static boolean blockLumaLamp;
//    public static boolean blockLumaLampBars;
//    public static boolean blockFixture;
//    public static boolean blockFixtureBars;
//    public static boolean blockMultilamp;
//    public static boolean blockMultilampBars;

    public static int blockLumaLampId;
    public static int blockLumaLampBarsId;
    public static int blockFixtureId;
    public static int blockFixtureBarsId;
    public static int blockMultilampId;
    public static int blockMultilampBarsId;

    public static int blockLumaTubeId;

    public static boolean itemDebug;

    public static int itemChromaStoneId;
    public static int itemDebugId;







    public static void initConfiguration(FMLPreInitializationEvent event) {
        Configuration config = new Configuration(new File("config/luma.cfg"));
        config.load();

        // Blocks
        config.addCustomCategoryComment(    "Blocks",   "Set the IDs for the Blocks used by the Luma Lamp Mod");

//        blockLumaLamp =         config.get( "Blocks",   "01 Enable Luma Lamps",        true, "Enable/Disable Blocks").getBoolean(true);
//        blockLumaLampBars =     config.get( "Blocks",   "02 Enable Caged Luma Lamps",  true).getBoolean(true);
//        blockFixture =          config.get( "Blocks",   "03 Enable Fixtures",          true).getBoolean(true);
//        blockFixtureBars =      config.get( "Blocks",   "04 Enable Caged Fixtures",    true).getBoolean(true);
//        blockMultilamp =        config.get( "Blocks",   "05 Enable Multilamp",         true).getBoolean(true);
//        blockMultilampBars =    config.get( "Blocks",   "06 Enable Caged Multilamp",   true).getBoolean(true);



        blockLumaLampId =       config.get( "Blocks",   "01 Luma Lamp Start ID",        3750,   "4 consecutive Block IDs, starting with the one entered here. Standard: 3750").getInt();
        blockLumaLampBarsId =   config.get( "Blocks",   "02 Caged Luma Lamp Start ID",  3754,   "4 consecutive Block IDs, starting with the one entered here. Standard: 3754").getInt();
        blockFixtureId =        config.get( "Blocks",   "03 Fixture Start ID",          3758,   "4 consecutive Block IDs, starting with the one entered here. Standard: 3758").getInt();
        blockFixtureBarsId =    config.get( "Blocks",   "04 Caged Fixture Start ID",    3762,   "4 consecutive Block IDs, starting with the one entered here. Standard: 3762").getInt();
        blockMultilampId =      config.get( "Blocks",   "05 Multilamp Start ID",        3766,   "2 consecutive Block IDs, starting with the one entered here. Standard: 3766").getInt();
        blockMultilampBarsId =  config.get( "Blocks",   "06 Caged Multilamp Start ID",  3768,   "2 consecutive Block IDs, starting with the one entered here. Standard: 3768").getInt();
        blockLumaTubeId =       config.get( "Blocks",   "07 Luma Tube ID",              3770,   "2 consecutive Block IDs, starting with the one entered here. Standard: 3768").getInt();

        // Items
        config.addCustomCategoryComment(    "Items",    "Set the IDs for the Items used by the Luma Lamp Mod");

        itemChromaStoneId =     config.get( "Items",    "01 Chroma Stone ID",      12050,  "The ID for the Chroma stone Item. Standard: 12050").getInt();
        itemDebug =             config.get( "Items",    "02 Enable Debug Item",    true, "Enable/Disable Debug Item").getBoolean(false);
        itemDebugId =           config.get( "Items",    "03 Debug Item ID",        12051,  "The ID for the Debug Item. Standard: 12051").getInt();


        Luma.log("Loading Configuration");

        config.save();
    }
}
