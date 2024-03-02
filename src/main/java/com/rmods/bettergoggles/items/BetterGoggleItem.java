package com.rmods.bettergoggles.items;

import com.simibubi.create.content.equipment.goggles.GogglesItem;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;

public class BetterGoggleItem extends ArmorItem{

    static{
        GogglesItem.addIsWearingPredicate(player -> ModItems.DIAMOND_PLATED_GOGGLE.isIn(player.getItemBySlot(EquipmentSlot.HEAD)));
        GogglesItem.addIsWearingPredicate(player -> ModItems.NETHERITE_PLATED_GOGGLE.isIn(player.getItemBySlot(EquipmentSlot.HEAD)));
    }

    public BetterGoggleItem(ArmorMaterial pMaterial, Type pType, Properties pProperties) {
        super(pMaterial, pType, pProperties);
    }


}
