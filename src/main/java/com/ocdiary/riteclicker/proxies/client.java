package com.ocdiary.riteclicker.proxies;

import com.ocdiary.riteclicker.item.RiteClickerItems;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Created by OCDiary on 05/01/2017.
 */
public class client extends common {

    @Override
    public void preInit(FMLPreInitializationEvent e) {

    }

    @Override
    public void init(FMLInitializationEvent e) {
        RiteClickerItems.regRenders();
    }

    @Override
    public void postInit(FMLPostInitializationEvent e) {

    }
}
