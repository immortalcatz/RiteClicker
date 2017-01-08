package com.ocdiary.riteclicker.handlers;


import com.ocdiary.riteclicker.item.RiteClickerItems;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;


public class CraftingHandler {

    public static void init(){
        //Adds recipe for pebbles into cobble
        GameRegistry.addShapedRecipe(new ItemStack(Blocks.COBBLESTONE), "AA ", "AA ", "   ", 'A', RiteClickerItems.pebbs);
        GameRegistry.addShapedRecipe(new ItemStack(Blocks.COBBLESTONE), "   ", " AA", " AA", 'A', RiteClickerItems.pebbs);
    }
}
