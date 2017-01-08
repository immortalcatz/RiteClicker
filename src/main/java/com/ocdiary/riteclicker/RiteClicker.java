package com.ocdiary.riteclicker;


import com.ocdiary.riteclicker.handlers.ConfigHandler;
import com.ocdiary.riteclicker.handlers.EventsHandler;
import com.ocdiary.riteclicker.handlers.RecipeHandler;
import com.ocdiary.riteclicker.item.RiteClickerItems;
import com.ocdiary.riteclicker.lib.refs;
import com.ocdiary.riteclicker.proxies.common;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.*;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = refs.MODID, name = refs.NAME, version = refs.VERSION, acceptedMinecraftVersions = refs.AVERSION)
public class RiteClicker {

    @Instance
    public static RiteClicker instance;

    @SidedProxy(clientSide = refs.CPROX, serverSide = refs.SPROX)
    public static common proxy;

    public static Logger log = FMLLog.getLogger();

    public static Configuration config;


    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent e) {
        log.info("Rite Clicker Pre-Init");

        config = new Configuration(e.getSuggestedConfigurationFile());
        ConfigHandler.config();

        proxy.preInit(e);

        RiteClickerItems.init();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent e){
        log.info("Rite Clicker Init");
        proxy.init(e);

        MinecraftForge.EVENT_BUS.register(instance);

        RecipeHandler.init();
    }


    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e){
        log.info("Rite Clicker Post-Init");
        proxy.postInit(e);

        MinecraftForge.EVENT_BUS.register(EventsHandler.class);
    }

}
