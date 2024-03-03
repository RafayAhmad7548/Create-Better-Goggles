package com.rmods.bettergoggles.renderers.armor;

import com.rmods.bettergoggles.BetterGoggles;
import com.rmods.bettergoggles.items.DiamondGoggleItem;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class DiamondGoggleRenderer extends GeoArmorRenderer<DiamondGoggleItem>{

    public DiamondGoggleRenderer(){
        super(new DefaultedItemGeoModel<>(new ResourceLocation(BetterGoggles.MODID, "armor/diamond_plated_goggle")));
    }
    
}
