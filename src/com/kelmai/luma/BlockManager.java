package com.kelmai.luma;

import com.kelmai.luma.blocks.BlockFixture;
import com.kelmai.luma.blocks.BlockLumaLamp;
import com.kelmai.luma.blocks.BlockLumaTube;
import com.kelmai.luma.blocks.BlockMultiLamp;
import com.kelmai.luma.blocks.tileEntities.TileEntityFixture;
import com.kelmai.luma.items.ItemBlockFixture;
import com.kelmai.luma.items.ItemBlockLumaLamp;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: KelMai
 * Date: 19.08.13
 * Time: 00:28
 */
public class BlockManager {
    public static int blockStartId;

    public static List<Integer> NEIHiddenBlocks = new ArrayList<Integer>();

    private static final String[] lumaLampNames = makeColorNameList("Luma Lamp", "", "");
    private static final String[] lumaLampNamesInv = makeColorNameList("Luma Lamp", "Inverted", "");
    private static final String[] lumaLampBarNames = makeColorNameList("Luma Lamp", "", "Caged");
    private static final String[] lumaLampBarNamesInv = makeColorNameList("Luma Lamp", "Inverted", "Caged");

    private static final String[] fixtureNames = makeColorNameList("Fixture", "", "");
    private static final String[] fixtureNamesInv = makeColorNameList("Fixture", "Inverted", "");
    private static final String[] fixtureBarNames = makeColorNameList("Fixture", "", "Caged");
    private static final String[] fixtureBarNamesInv = makeColorNameList("Fixture", "Inverted", "Caged");

    private static final String[] lumaTubeNames = makeColorNameList("Luma Tube", "", "");

    public static Block blockLumaLampOff;
    public static Block blockLumaLampOn;
    public static Block blockLumaLampOnInv;
    public static Block blockLumaLampOffInv;
    public static Block blockLumaLampBarOff;
    public static Block blockLumaLampBarOn;
    public static Block blockLumaLampBarOffInv;
    public static Block blockLumaLampBarOnInv;
    public static Block blockMultiLampOn;
    public static Block blockMultiLampOff;
    public static Block blockMultiLampBarOn;
    public static Block blockMultiLampBarOff;

    public static Block blockLumaTubeOff;
    public static Block blockLumaTubeOn;

    public static Block blockFixtureOff;
    public static Block blockFixtureOffBars;
    public static Block blockFixtureOn;
    public static Block blockFixtureOnBars;


    public static Block blockFixtureOffInv;
    public static Block blockFixtureOffBarsInv;
    public static Block blockFixtureOnInv;
    public static Block blockFixtureOnBarsInv;

    public static void makeBlocks() {
        int id;

        // Luma Lamp
        id = ConfigManager.blockLumaLampId;
        blockLumaLampOff = newColoredBlock(new BlockLumaLamp(id, false, false, false), "blockLumaLampOff", lumaLampNames, Luma.tab);
        blockLumaLampOn  = newColoredBlock(new BlockLumaLamp(id+1, true, false, false), "blockLumaLampOn", lumaLampNames, null);
        blockLumaLampOnInv  = newColoredBlock(new BlockLumaLamp(id+2, false, false, true), "blockLumaLampOnInv", lumaLampNamesInv, Luma.tab);
        blockLumaLampOffInv = newColoredBlock(new BlockLumaLamp(id+3, true, false, true), "blockLumaLampOffInv", lumaLampNamesInv, null);

        // Caged Luma Lamp
        id = ConfigManager.blockLumaLampBarsId;
        blockLumaLampBarOff = newColoredBlock(new BlockLumaLamp(id, false, true, false), "blockLumaLampBarOff", lumaLampBarNames, Luma.tab);
        blockLumaLampBarOn  = newColoredBlock(new BlockLumaLamp(id+1, true, true, false), "blockLumaLampBarOn", lumaLampBarNames, null);
        blockLumaLampBarOnInv  = newColoredBlock(new BlockLumaLamp(id+2, false, true, true), "blockLumaLampBarOnInv", lumaLampBarNamesInv, Luma.tab);
        blockLumaLampBarOffInv = newColoredBlock(new BlockLumaLamp(id+3, true, true, true), "blockLumaLampBarOffInv", lumaLampBarNamesInv, null);


        // Fixture
        id = ConfigManager.blockFixtureId;
        blockFixtureOff = newCustomColoredBlock(new BlockFixture(id, Material.glass, false, false, false), TileEntityFixture.class, "lumaFixtureOff", fixtureNames, Luma.tab);
        blockFixtureOn = newCustomColoredBlock(new BlockFixture(id+1, Material.glass, true, false, false), TileEntityFixture.class, "lumaFixtureOn", fixtureNames, null);
        blockFixtureOffInv = newCustomColoredBlock(new BlockFixture(id+2, Material.glass, false, true, false), TileEntityFixture.class, "lumaFixtureOffInv", fixtureNamesInv, Luma.tab);
        blockFixtureOnInv = newCustomColoredBlock(new BlockFixture(id+3, Material.glass, true, true, false), TileEntityFixture.class, "lumaFixtureOnInv", fixtureNamesInv, null);


        // Caged Fixture
        id = ConfigManager.blockFixtureBarsId;
        blockFixtureOffBars = newCustomColoredBlock(new BlockFixture(id, Material.glass, false, false, true), TileEntityFixture.class, "lumaFixtureOffBars", fixtureBarNames, Luma.tab);
        blockFixtureOnBars = newCustomColoredBlock(new BlockFixture(id+1, Material.glass, true, false, true), TileEntityFixture.class, "lumaFixtureOnBars", fixtureBarNames, null);
        blockFixtureOffBarsInv = newCustomColoredBlock(new BlockFixture(id+2, Material.glass, false, true, true), TileEntityFixture.class, "lumaFixtureOffBarsInv", fixtureBarNamesInv, Luma.tab);
        blockFixtureOnBarsInv = newCustomColoredBlock(new BlockFixture(id+3, Material.glass, true, true, true), TileEntityFixture.class, "lumaFixtureOnBarsInv", fixtureBarNamesInv, null);


        // Multilamp
        id = ConfigManager.blockMultilampId;
        blockMultiLampOff = newBlock(new BlockMultiLamp(id, false, false), "blockMultiLampOff", "Multilamp", Luma.tab);
        blockMultiLampOn = newBlock(new BlockMultiLamp(id+1, true, false), "blockMultiLampOn", "Multilamp", null);

        // Caged Multilamp
        id = ConfigManager.blockMultilampBarsId;
        blockMultiLampBarOff = newBlock(new BlockMultiLamp(id, false, true), "blockMultiLampBarOff", "Caged Multilamp", Luma.tab);
        blockMultiLampBarOn = newBlock(new BlockMultiLamp(id+1, true, true), "blockMultiLampBarOn", "Caged Multilamp", null);

        // Luma Tube
        id = ConfigManager.blockLumaTubeId;
        blockLumaTubeOff = newColoredBlock(new BlockLumaTube(id, false), "blockLumaTubeOff", lumaTubeNames, Luma.tab);
        blockLumaTubeOn  = newColoredBlock(new BlockLumaTube(id+1, true), "blockLumaTubeOn", lumaTubeNames, null);
    }

    public static Block newBlock(Block block, String unlocalizedName, String name) {
        return newBlock(block, unlocalizedName, name, Luma.tab);
    }



    public static Block newBlock(Block block, String unlocalizedName, String name, CreativeTabs creativeTab) {
        block.setUnlocalizedName(unlocalizedName);
        block.setCreativeTab(creativeTab);

        GameRegistry.registerBlock(block, Luma.modID + "_" + unlocalizedName);
        LanguageRegistry.addName(block, name);
        Luma.log("Block ID " + block.blockID + ": " + unlocalizedName);
        if (creativeTab == null) {
            NEIHiddenBlocks.add(block.blockID);
        }
        return block;
    }

    public static Block newCustomBlock(Block block, Class<? extends TileEntity> tileEntityClass, String ulNamePart, String name, CreativeTabs creativeTab) {
        block.setUnlocalizedName("block"+ulNamePart);
        block.setCreativeTab(creativeTab);
        GameRegistry.registerBlock(block, Luma.modID + "_block"+ulNamePart);
        GameRegistry.registerTileEntity(tileEntityClass, Luma.modID + "_tileEntity"+ulNamePart);
        LanguageRegistry.addName(block, name);
        if (creativeTab == null) {
            NEIHiddenBlocks.add(block.blockID);
        }
        return block;
    }

    public static Block newCustomColoredBlock(Block block, Class<? extends TileEntity> tileEntityClass, String ulNamePart, String[] names, CreativeTabs creativeTab) {
        block.setUnlocalizedName("block"+ulNamePart);
        block.setCreativeTab(creativeTab);
        LanguageRegistry.addName(block, names[0]);
        GameRegistry.registerBlock(block, ItemBlockFixture.class, Luma.modID + "_block"+ulNamePart);
        GameRegistry.registerTileEntity(tileEntityClass, Luma.modID + "_tileEntity"+ulNamePart);

        if (creativeTab == null) {
            NEIHiddenBlocks.add(block.blockID);
        }
        for (int ix = 0; ix < 16; ix++) {
            ItemStack blockStack = new ItemStack(block, 1, ix);
            LanguageRegistry.addName(blockStack, names[ix]);
        }
        Luma.log("colored special Block ID " + block.blockID + " (colored): " + ulNamePart);
        return block;
    }

    public static Block newColoredBlock(Block block, String unlocalizedName, String[] names, CreativeTabs creativeTab) {
        block.setUnlocalizedName(unlocalizedName);
        block.setCreativeTab(creativeTab);
        LanguageRegistry.addName(block, names[0]);
        GameRegistry.registerBlock(block, ItemBlockLumaLamp.class, Luma.modID + "_" + unlocalizedName);
        if (creativeTab == null) {
            NEIHiddenBlocks.add(block.blockID);
        }
        for (int ix = 0; ix < 16; ix++) {
            ItemStack blockStack = new ItemStack(block, 1, ix);
            LanguageRegistry.addName(blockStack, names[ix]);
        }
        Luma.log("Block ID " + block.blockID + " (colored): " + unlocalizedName);
        return block;
    }

    public static String[] makeColorNameList(String blockName, String beforeColor, String afterColor) {
        String[] colors = { "", "Orange ", "Magenta ", "Light Blue ", "Yellow ", "Light Green ",
                "Pink ", "Dark Grey ", "Light Grey ", "Cyan ", "Purple ",
                "Blue ", "Brown ", "Green ", "Red ", "Black " };

        String[] r = new String[16];

        if (beforeColor != "") {
            beforeColor = beforeColor + " ";
        }

        if (afterColor != "") {
            afterColor = afterColor + " ";
        }

        for (int i = 0; i < 16; i++) {
            r[i] = beforeColor + colors[i] + afterColor + blockName;
        }

        return r;
    }
}
