package com.ocdiary.riteclicker.item;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * Created by OCDiary on 14/08/2016.
 */
public class pebs extends Item{

    public static Item pebs;

    public static void register(){
        initiliazeItem();
        registerItem();
    }

    public static void initiliazeItem() {

        pebs = (new Item()).setUnlocalizedName("pebs").setTextureName("riteclicker:pebs").setCreativeTab(CreativeTabs.tabMisc);
    }



    public static void registerItem() {

        GameRegistry.registerItem(pebs, pebs.getUnlocalizedName());
    }
}
