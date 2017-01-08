package com.ocdiary.riteclicker.item;

import com.ocdiary.riteclicker.lib.refs;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class RiteClickerItems {

    public static Item pebbs;

    public static void init(){
       pebbs = new pebs();
       registerItems();
    }

    public static void registerItems(){
        GameRegistry.register(pebbs, new ResourceLocation(refs.MODID, "pebs"));
    }

    public static void regRenders(){
        regRender(pebbs);
    }

    public static void regRender(Item item){
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(refs.MODID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
    }
}
