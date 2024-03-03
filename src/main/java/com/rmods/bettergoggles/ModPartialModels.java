package com.rmods.bettergoggles;

import com.jozufozu.flywheel.core.PartialModel;

import net.minecraft.resources.ResourceLocation;

public class ModPartialModels{
    
    public static final PartialModel DIAMOND_PLATED_GOGGLE =
        new PartialModel(new ResourceLocation(BetterGoggles.MODID, "block/diamond_plated_goggle"));
    public static final PartialModel NETHERITE_PLATED_GOGGLE =
        new PartialModel(new ResourceLocation(BetterGoggles.MODID, "block/netherite_plated_goggle"));

    public static void init(){
        
    }

}
