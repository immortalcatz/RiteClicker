package com.ocdiary.riteclicker.handlers;

import com.google.common.collect.ImmutableSet;
import com.ocdiary.riteclicker.item.RiteClickerItems;
import com.ocdiary.riteclicker.lib.refs;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

public class EventHandler {

    public static boolean shouldWork = true;
    public static boolean sneaky = ConfigHandler.sneakOn;
    public static String sound = ConfigHandler.soundLoc;
    public static boolean gogWT = ConfigHandler.gogWorld;
    public static boolean vanillaWT = ConfigHandler.defaultWorld;

    @SubscribeEvent
    public void confChange(ConfigChangedEvent.OnConfigChangedEvent e){
        if(e.getModID().equals(refs.MODID)){
            ConfigHandler.config();
        }
    }

    @SubscribeEvent
    public static void onJoin (PlayerEvent.PlayerLoggedInEvent e){
        String world = e.player.world.getWorldType().getName();
        if(!gogWT) {
            if (world.equals("botania-skyblock")) {
                shouldWork = false;
            } else if (!vanillaWT) {
                if((world.equals("default") || world.equals("customized") || world.equals("largeBiomes") || world.equals("amplified") || world.equals("flat"))){
                    shouldWork = false;
                }
            } else {
                shouldWork = true;
            }
        }
    }
    @SubscribeEvent
    public static void onPRiteClick(PlayerInteractEvent.RightClickBlock e) {
        EntityPlayer p = e.getEntityPlayer();
        ResourceLocation loc = new ResourceLocation(ConfigHandler.soundLoc);
        SoundEvent sound = new SoundEvent(loc);
        ItemStack hand = e.getItemStack();

        if (shouldWork) {
            if (sneaky) {
                if (p.getItemStackFromSlot(EntityEquipmentSlot.MAINHAND) == null && p.isSneaking()) {
                    Block block = e.getWorld().getBlockState(e.getPos()).getBlock();
                    if (ImmutableSet.of(Blocks.GRASS, Blocks.GRASS_PATH, Blocks.FARMLAND, Blocks.DIRT).contains(block)) {
                        if (e.getWorld().isRemote) {
                            p.swingArm(EnumHand.MAIN_HAND);
                            p.world.playSound(p, p.posX, p.posY, p.posZ, sound, SoundCategory.BLOCKS, 20.0F, 1.0F);
                        } else {
                            if (!e.getWorld().isRemote && e.getHand() == EnumHand.MAIN_HAND)
                                p.dropItem(new ItemStack(RiteClickerItems.pebbs, 1, 0), false);
                        }
                    }
                }
            }else{
                if (p.getItemStackFromSlot(EntityEquipmentSlot.MAINHAND) == null) {
                    Block block = e.getWorld().getBlockState(e.getPos()).getBlock();
                    if (ImmutableSet.of(Blocks.GRASS, Blocks.GRASS_PATH, Blocks.FARMLAND, Blocks.DIRT).contains(block)) {
                        if (e.getWorld().isRemote) {
                            p.swingArm(EnumHand.MAIN_HAND);
                            p.world.playSound(p, p.posX, p.posY, p.posZ, sound, SoundCategory.BLOCKS, 20.0F, 1.0F);
                        } else {
                            if (!e.getWorld().isRemote && e.getHand() == EnumHand.MAIN_HAND)
                                p.dropItem(new ItemStack(RiteClickerItems.pebbs, 1, 0), false);
                        }
                    }
                }
            }
        }
    }
}