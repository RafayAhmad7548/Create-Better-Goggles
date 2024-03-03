package com.rmods.bettergoggles.items;

import com.mojang.blaze3d.vertex.PoseStack;
import com.rmods.bettergoggles.ModPartialModels;

import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraftforge.client.model.BakedModelWrapper;

public class BetterGoggleModel extends BakedModelWrapper<BakedModel>{

	private PlatingMaterial material;

    public BetterGoggleModel(BakedModel originalModel, PlatingMaterial material){
        super(originalModel);
		this.material = material;
    }
    
	@Override
	public BakedModel applyTransform(ItemDisplayContext cameraItemDisplayContext, PoseStack mat, boolean leftHanded) {
		if (cameraItemDisplayContext == ItemDisplayContext.HEAD)
			if(material == PlatingMaterial.DIAMNOD_PlATING) return ModPartialModels.DIAMOND_PLATED_GOGGLE.get().applyTransform(cameraItemDisplayContext, mat, leftHanded);
			else return ModPartialModels.NETHERITE_PLATED_GOGGLE.get().applyTransform(cameraItemDisplayContext, mat, leftHanded);
		return super.applyTransform(cameraItemDisplayContext, mat, leftHanded);
	}
}
