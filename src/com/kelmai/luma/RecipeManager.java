package com.kelmai.luma;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * Created with IntelliJ IDEA.
 * User: KelMai
 * Date: 19.08.13
 * Time: 00:02
 */
public class RecipeManager {
    public static void makeRecipes() {
        ItemStack glowStoneDust = new ItemStack(Item.glowstone);
        ItemStack paper         = new ItemStack(Item.paper);
        ItemStack redstoneDust  = new ItemStack(Item.redstone);
        ItemStack glass         = new ItemStack(Block.glass);
        ItemStack redstoneTorch = new ItemStack(Block.torchRedstoneActive);
        ItemStack bars          = new ItemStack(Block.fenceIron);

        // Luma Lamp
        GameRegistry.addRecipe(new ItemStack(BlockManager.blockLumaLampOff),    "aba",
                                                                                "cdc",
                                                                                "aba",

                                                                                'a', glowStoneDust,
                                                                                'b', redstoneDust,
                                                                                'c', paper,
                                                                                'd', glass);

        // Chroma Stone
        GameRegistry.addRecipe(new ItemStack(ItemManager.itemChromaStone),      "bcd",
                                                                                "eaf",
                                                                                "ghi",

                                                                                'a', new ItemStack(Item.diamond),
                                                                                'b', new ItemStack(Item.dyePowder, 1, 11),
                                                                                'c', new ItemStack(Item.dyePowder, 1, 1),
                                                                                'd', new ItemStack(Item.dyePowder, 1, 13),
                                                                                'e', new ItemStack(Item.dyePowder, 1, 10),
                                                                                'f', new ItemStack(Item.dyePowder, 1, 5),
                                                                                'g', new ItemStack(Item.dyePowder, 1, 2),
                                                                                'h', new ItemStack(Item.dyePowder, 1, 6),
                                                                                'i', new ItemStack(Item.dyePowder, 1, 4));

        // Inverted Luma Lamp
        GameRegistry.addShapelessRecipe(new ItemStack(BlockManager.blockLumaLampOnInv),     new ItemStack(BlockManager.blockLumaLampOff),
                                                                                            redstoneTorch);

        // Caged Luma Lamp
        GameRegistry.addShapelessRecipe(new ItemStack(BlockManager.blockLumaLampBarOff),    new ItemStack(BlockManager.blockLumaLampOff),
                                                                                            bars);

        // Inverted Caged Luma Lamp
        GameRegistry.addShapelessRecipe(new ItemStack(BlockManager.blockLumaLampBarOnInv),  new ItemStack(BlockManager.blockLumaLampOnInv),
                                                                                            bars);

        // Multilamp
        GameRegistry.addShapelessRecipe(new ItemStack(BlockManager.blockMultiLampOff),      new ItemStack(BlockManager.blockLumaLampOff),
                                                                                            new ItemStack(ItemManager.itemChromaStone));

        // Caged Multilamp
        GameRegistry.addShapelessRecipe(new ItemStack(BlockManager.blockMultiLampBarOff),   new ItemStack(BlockManager.blockMultiLampOff),
                                                                                            bars);

        // Luma Fixture
        GameRegistry.addRecipe(new ItemStack(BlockManager.blockFixtureOff, 4, 0),  "   ",
                                                                                " b ",
                                                                                "aaa",

                                                                                'a', new ItemStack(Block.stone),
                                                                                'b', new ItemStack(BlockManager.blockLumaLampOff));

        // Caged Luma Fixture
        GameRegistry.addRecipe(new ItemStack(BlockManager.blockFixtureOffBars, 4, 0),  " c ",
                                                                                    "cbc",
                                                                                    "aaa",

                                                                                    'a', new ItemStack(Block.stone),
                                                                                    'b', new ItemStack(BlockManager.blockLumaLampOff),
                                                                                    'c', bars);

        // Inverted Luma Fixture
        GameRegistry.addRecipe(new ItemStack(BlockManager.blockFixtureOffInv, 4, 0),   "   ",
                                                                                    " b ",
                                                                                    "aca",

                                                                                    'a', new ItemStack(Block.stone),
                                                                                    'b', new ItemStack(BlockManager.blockLumaLampOff),
                                                                                    'c', redstoneTorch);

        // Caged Inverted Luma Fixture
        GameRegistry.addRecipe(new ItemStack(BlockManager.blockFixtureOffBarsInv, 4, 0),   " c ",
                                                                                        "cbc",
                                                                                        "ada",

                                                                                        'a', new ItemStack(Block.stone),
                                                                                        'b', new ItemStack(BlockManager.blockLumaLampOff),
                                                                                        'c', bars,
                                                                                        'd', redstoneTorch);

        // Colored Luma Lamps
        makeDyedRecipes(BlockManager.blockLumaLampOff);

        // Colored Inverted Luma Lamps
        makeDyedRecipes(BlockManager.blockLumaLampOnInv);

        // Colored Caged Luma Lamps
        makeDyedRecipes(BlockManager.blockLumaLampBarOff);

        // Colored Inverted Caged Luma Lamps
        makeDyedRecipes(BlockManager.blockLumaLampBarOnInv);



        // Colored Fixtures
        makeDyedRecipes(BlockManager.blockFixtureOff);

        // Colored Inverted Fixtures
        makeDyedRecipes(BlockManager.blockFixtureOnInv);

        // Colored Caged Fixtures
        makeDyedRecipes(BlockManager.blockFixtureOffBars);

        // Colored Inverted Caged Fixtures
        makeDyedRecipes(BlockManager.blockFixtureOnBarsInv);
    }

    public static void makeDyedRecipes(Block block) {
        ItemStack blockStack = new ItemStack(block, 1, 0);
        for (int i = 1; i < 16; i++) {
            GameRegistry.addShapelessRecipe(new ItemStack(block, 1, i), 	blockStack,
                                                                            new ItemStack(Item.dyePowder, 1, 15-i));
        }
    }


}
