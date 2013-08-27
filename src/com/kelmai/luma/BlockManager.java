package com.kelmai.luma;

import com.kelmai.luma.blocks.BlockFixture;
import com.kelmai.luma.blocks.BlockLumaLamp;
import com.kelmai.luma.blocks.BlockMultiLamp;
import com.kelmai.luma.blocks.tileEntities.TileEntityFixture;
import com.kelmai.luma.items.ItemBlockLumaLamp;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

/**
 * Created with IntelliJ IDEA.
 * User: KelMai
 * Date: 19.08.13
 * Time: 00:28
 */
public class BlockManager {
    public static int blockStartId;

    private static final String[] lumaLampNames = makeColorNameList("Luma Lamp", "", "");
    private static final String[] lumaLampNamesInv = makeColorNameList("Luma Lamp", "Inverted", "");
    private static final String[] lumaLampBarNames = makeColorNameList("Luma Lamp", "", "Caged");
    private static final String[] lumaLampBarNamesInv = makeColorNameList("Luma Lamp", "Inverted", "Caged");

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

    public static Block blockFixtureOff;
    public static Block blockFixtureOn;

    public static void makeBlocks() {
        blockLumaLampOff = newColoredBlock(new BlockLumaLamp(blockStartId, false, false, false), "blockLumaLampOff", lumaLampNames, CreativeTabs.tabBlock);
        blockLumaLampOn  = newColoredBlock(new BlockLumaLamp(blockStartId+1, true, false, false), "blockLumaLampOn", lumaLampNames, null);

        blockLumaLampOnInv  = newColoredBlock(new BlockLumaLamp(blockStartId+2, false, false, true), "blockLumaLampOnInv", lumaLampNamesInv, CreativeTabs.tabBlock);
        blockLumaLampOffInv = newColoredBlock(new BlockLumaLamp(blockStartId+3, true, false, true), "blockLumaLampOffInv", lumaLampNamesInv, null);

        blockLumaLampBarOff = newColoredBlock(new BlockLumaLamp(blockStartId+4, false, true, false), "blockLumaLampBarOff", lumaLampBarNames, CreativeTabs.tabBlock);
        blockLumaLampBarOn  = newColoredBlock(new BlockLumaLamp(blockStartId+5, true, true, false), "blockLumaLampBarOn", lumaLampBarNames, null);

        blockLumaLampBarOnInv  = newColoredBlock(new BlockLumaLamp(blockStartId+6, false, true, true), "blockLumaLampBarOnInv", lumaLampBarNamesInv, CreativeTabs.tabBlock);
        blockLumaLampBarOffInv = newColoredBlock(new BlockLumaLamp(blockStartId+7, true, true, true), "blockLumaLampBarOffInv", lumaLampBarNamesInv, null);

        blockMultiLampOff = newBlock(new BlockMultiLamp(blockStartId+8, false, false), "blockMultiLampOff", "Multilamp", CreativeTabs.tabBlock);
        blockMultiLampOn = newBlock(new BlockMultiLamp(blockStartId+9, true, false), "blockMultiLampOn", "Multilamp", null);

        blockMultiLampBarOff = newBlock(new BlockMultiLamp(blockStartId+10, false, true), "blockMultiLampBarOff", "Caged Multilamp", CreativeTabs.tabBlock);
        blockMultiLampBarOn = newBlock(new BlockMultiLamp(blockStartId+11, true, true), "blockMultiLampBarOn", "Caged Multilamp", null);

        blockFixtureOff = newCustomBlock(new BlockFixture(blockStartId+12, Material.glass, CreativeTabs.tabBlock, false, false, false), TileEntityFixture.class, "lumaFixtureOff", "Luma Fixture");
        blockFixtureOn = newCustomBlock(new BlockFixture(blockStartId+13, Material.glass, null, true, false, false), TileEntityFixture.class, "lumaFixtureOn", "Luma Fixture");

//        GameRegistry.registerBlock(blockFixture, "blockLumaFixture");
//        GameRegistry.registerTileEntity(TileEntityFixture.class, "tileEntityFixture");
//
//        LanguageRegistry.addName(blockFixture, "Luma Fixture");

    }

    public static Block newBlock(Block block, String unlocalizedName, String name) {
        return newBlock(block, unlocalizedName, name, CreativeTabs.tabBlock);
    }



    public static Block newBlock(Block block, String unlocalizedName, String name, CreativeTabs creativeTab) {
        block.setUnlocalizedName(unlocalizedName);
        block.setCreativeTab(creativeTab);

        GameRegistry.registerBlock(block, Luma.modID + "_" + unlocalizedName);
        LanguageRegistry.addName(block, name);
        Luma.log("Block ID " + block.blockID + ": " + unlocalizedName);
        return block;
    }

    public static Block newCustomBlock(Block block, Class<? extends TileEntity> tileEntityClass, String ulNamePart, String name) {
        block.setUnlocalizedName("block"+ulNamePart);
        GameRegistry.registerBlock(block, Luma.modID + "_block"+ulNamePart);
        GameRegistry.registerTileEntity(tileEntityClass, Luma.modID + "_tileEntity"+ulNamePart);

        LanguageRegistry.addName(block, name);

        return block;
    }

    public static Block newColoredBlock(Block block, String unlocalizedName, String[] names, CreativeTabs creativeTab) {
        block.setUnlocalizedName(unlocalizedName);
        block.setCreativeTab(creativeTab);
        GameRegistry.registerBlock(block, ItemBlockLumaLamp.class, Luma.modID + "_" + unlocalizedName);
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
