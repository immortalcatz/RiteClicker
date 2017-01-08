package com.ocdiary.riteclicker.handlers;

import com.ocdiary.riteclicker.RiteClicker;
import net.minecraftforge.common.MinecraftForge;

public class ConfigHandler {

    public static boolean sneakOn;
    public static boolean defaultWorld;
    public static boolean gogWorld;
    public static String soundLoc;

    public static void config() {
        MinecraftForge.EVENT_BUS.register(RiteClicker.instance);

        final String CLICKERCONF = RiteClicker.config.CATEGORY_GENERAL + RiteClicker.config.CATEGORY_SPLITTER + "Rite Clicker";
        RiteClicker.config.addCustomCategoryComment(CLICKERCONF, "Here you can make changes to the mod features.");
        sneakOn = RiteClicker.config.get(CLICKERCONF, "Do you want the right click function to only work when sneaking?", true).getBoolean();
        soundLoc = RiteClicker.config.get(CLICKERCONF, "Sound that should be played when block is right clicked:", "block.grass.hit").getString();

        final String CLICKERWORLDS = RiteClicker.config.CATEGORY_GENERAL + RiteClicker.config.CATEGORY_SPLITTER + "World Type Options";
        defaultWorld = RiteClicker.config.get(CLICKERWORLDS, "Should right clicker work in vanilla world types?", false).getBoolean();
        gogWorld = RiteClicker.config.get(CLICKERWORLDS, "Should right clicker work in Botania Garden of Glass world type", false).getBoolean();


        if (RiteClicker.config.hasChanged()) {
            RiteClicker.config.save();
        }
    }
}
