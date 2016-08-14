package com.ocdiary.riteclicker;

import com.ocdiary.riteclicker.config.ConfigHandler;
import com.ocdiary.riteclicker.crafting.craftingManager;
import com.ocdiary.riteclicker.event.riteClick;
import com.ocdiary.riteclicker.item.pebs;
import com.ocdiary.riteclicker.lib.refs;
import com.ocdiary.riteclicker.proxy.serverProxy;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.MinecraftForge;

/**
 * Created by OCDiary on 13/08/2016.
 */

@Mod(modid = refs.MODID, name = refs.NAME, version = refs.VERSION)
public class RiteClicker {

    @SidedProxy(clientSide = refs.CPROX, serverSide = refs.SPROX)
    public static serverProxy proxy;

    @Mod.Instance("RiteClicker")
    public static RiteClicker instance;

    @Mod.EventHandler
    public void preLoad(FMLPreInitializationEvent e){

       //Init the config
        ConfigHandler.init(e.getSuggestedConfigurationFile());

        //RiteClicker
        MinecraftForge.EVENT_BUS.register(new riteClick());

        //Initiliaze the pebbles
        pebs.register();

        //add the recipe
        craftingManager.addRecipe();
    }

    @Mod.EventHandler
    public void load(FMLInitializationEvent e){    }

    @Mod.EventHandler
    public void postLoad(FMLPostInitializationEvent e){  }
}
