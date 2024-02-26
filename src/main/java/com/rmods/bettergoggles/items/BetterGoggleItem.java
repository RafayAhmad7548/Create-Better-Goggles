package com.rmods.bettergoggles.items;

import java.util.List;

import com.rmods.bettergoggles.BetterGoggles;
import com.simibubi.create.content.equipment.goggles.GogglesItem;

import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class BetterGoggleItem extends ArmorItem{

    static{
        GogglesItem.addIsWearingPredicate(BetterGoggleItem::isWearingGoggles);
    }

    public BetterGoggleItem(ArmorMaterial pMaterial, Type pType, Properties pProperties) {
        super(pMaterial, pType, pProperties);
    }

    public static boolean isWearingGoggles(Player player){
        ItemStack headSlot = player.getItemBySlot(EquipmentSlot.HEAD);
        List<TagKey<Item>> tagList = headSlot.getTags().filter(tag -> tag.location().getNamespace().equals(BetterGoggles.MODID)).toList();
        for(TagKey<Item> tag : tagList){
            if(tag.location().getPath().equals("bettergoggles")) return true;
        }
        return false;
    }
    

}
