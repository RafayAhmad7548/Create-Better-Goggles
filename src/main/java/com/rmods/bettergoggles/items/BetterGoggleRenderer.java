package com.rmods.bettergoggles.items;

import com.rmods.bettergoggles.BetterGoggles;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class BetterGoggleRenderer extends GeoArmorRenderer<BetterGoggleItem>{

    public BetterGoggleRenderer(){
        super(new DefaultedItemGeoModel<>(new ResourceLocation(BetterGoggles.MODID, "armor/diamond_plated_goggle")));
    }
    
}
