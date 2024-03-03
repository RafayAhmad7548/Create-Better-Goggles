package com.rmods.bettergoggles.items;

import com.mojang.blaze3d.vertex.PoseStack;
import com.rmods.bettergoggles.ModPartialModels;

import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraftforge.client.model.BakedModelWrapper;

public class BetterGoggleModel extends BakedModelWrapper<BakedModel>{

    public BetterGoggleModel(BakedModel originalModel){
        super(originalModel);
    }
    
	@Override
	public BakedModel applyTransform(ItemDisplayContext cameraItemDisplayContext, PoseStack mat, boolean leftHanded) {
		if (cameraItemDisplayContext == ItemDisplayContext.HEAD)
			return ModPartialModels.DIAMOND_PLATED_GOGGLE.get()
				.applyTransform(cameraItemDisplayContext, mat, leftHanded);
		return super.applyTransform(cameraItemDisplayContext, mat, leftHanded);
	}
}
