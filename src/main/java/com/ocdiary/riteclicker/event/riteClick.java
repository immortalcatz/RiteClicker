package com.ocdiary.riteclicker.event;

import com.ocdiary.riteclicker.config.ConfigHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

import static com.ocdiary.riteclicker.item.pebs.pebs;

/**
 * Created by OCDiary on 14/08/2016.
 */
public class riteClick {

    public static Boolean activated = ConfigHandler.activateIt;

    @SubscribeEvent
    public void rightClickEvent(PlayerInteractEvent e)
    {
        ItemStack equipped = e.entityPlayer.getCurrentEquippedItem();
        if ((e.action == PlayerInteractEvent.Action.RIGHT_CLICK_BLOCK) && (equipped == null) && (activated == true))
        {
            Block block = e.world.getBlock(e.x, e.y, e.z);
            if ((block == Blocks.grass) || (block == Blocks.dirt)) {
                if (e.world.isRemote) {
                    e.entityPlayer.swingItem();
                } else {
                    e.world.playSoundEffect(e.x + 0.5D, e.y + 0.5D, e.z + 0.5D, block.stepSound.getBreakSound(), block.stepSound.getVolume() * 0.2F, block.stepSound.getPitch() + (float) (Math.random() * 0.2D - 0.1D));
                    if (Math.random() < 0.8D) {
                        e.entityPlayer.dropPlayerItemWithRandomChoice(new ItemStack(pebs, ConfigHandler.dropSize), false);
                    }
                }
            }
        }
    }
}
