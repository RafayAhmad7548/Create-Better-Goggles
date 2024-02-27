package com.rmods.bettergoggles.items;


import javax.annotation.Nonnull;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem.Type;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

public enum PlatingMaterial implements ArmorMaterial{

    DIAMNOD_PlATING("diamond_plated_goggle", 343, 3, 10, Items.DIAMOND, SoundEvents.ARMOR_EQUIP_DIAMOND, 2.0F, 0.0F);

    private final String name;
    private final int durability;
    private final int damageReductionAmount;
    private final int enchantmentValue;
    private final Item repairItem;
    private final SoundEvent sound;
    private final float toughness;
    private final float knockbackResistance;

    private PlatingMaterial(String name, int durability, int damageReductionAmount, int enchantmentValue, Item repairItem, SoundEvent sound, float toughness, float knockbackResistance){
        this.name = name;
        this.durability = durability;
        this.damageReductionAmount = damageReductionAmount;
        this.enchantmentValue = enchantmentValue;
        this.repairItem = repairItem;
        this.sound = sound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
    }

    @Override
    public int getDurabilityForType(@Nonnull Type pType) {
        return durability;
    }

    @Override
    public int getDefenseForType(@Nonnull Type pType) {
        return damageReductionAmount;
    }

    @Override
    public int getEnchantmentValue() {
        return enchantmentValue;
    }

    @Override
    public SoundEvent getEquipSound() {
        return sound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.of(repairItem);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public float getToughness() {
        return toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return knockbackResistance;
    }
    
}
