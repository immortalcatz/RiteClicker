package com.ocdiary.riteclicker.crafting;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

import static com.ocdiary.riteclicker.item.pebs.pebs;

/**
 * Created by OCDiary on 14/08/2016.
 */
public class craftingManager {

    public static void addRecipe(){

        GameRegistry.addShapedRecipe(new ItemStack(Blocks.cobblestone, 1), new Object[]{
                "XX ",
                "XX ",
                "   ",
                'X', pebs});
        GameRegistry.addShapedRecipe(new ItemStack(Blocks.cobblestone, 1), new Object[]{
                "   ",
                " XX",
                " XX",
                'X', pebs});
    }

}
