package com.rmods.bettergoggles.renderers.armor;

import com.rmods.bettergoggles.BetterGoggles;
import com.rmods.bettergoggles.items.DiamondGoggleItem;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class NetheriteGoggleRenderer extends GeoArmorRenderer<DiamondGoggleItem>{

    public NetheriteGoggleRenderer(){
        super(new DefaultedItemGeoModel<>(new ResourceLocation(BetterGoggles.MODID, "armor/netherite_plated_goggle")));
    }
    
}
