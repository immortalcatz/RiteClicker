package com.ocdiary.riteclicker.config;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.config.Configuration;

import java.io.File;

/**
 * Created by OCDiary on 14/08/2016.
 */
public class ConfigHandler {

    public static int dropSize = 1;
    public static Boolean activateIt = true;

    public static void init(File file) {
        Configuration config = new Configuration(file);

        config.load();

        dropSize = config.getInt("Number of items to drop", "Drop", 1, 0, 64, "Please enter the number of pebbles right clicking dirt or grass should drop.");
        activateIt = config.getBoolean("Activate RiteClicker", "Activate", true, "You can use this to deactivate right clicker, if you are using other mods that conflict. Set to false if you want it off.");

        config.save();
    }
}
