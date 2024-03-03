package com.rmods.bettergoggles.items;

import java.util.UUID;

import javax.annotation.Nonnull;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.simibubi.create.content.equipment.goggles.GogglesItem;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Equipable;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

@SuppressWarnings("null")
public class BetterGoggleItem extends Item implements Equipable{

    private final int defense;
    private final float toughness;
    private final float knockbackResistance;
    private final PlatingMaterial material;
    private final int durability;

    private final Multimap<Attribute, AttributeModifier> defaultModifiers;
    private final UUID uuid = UUID.fromString("2AD3F246-FEE1-4E67-B886-69FD380BB150");

    static{
        GogglesItem.addIsWearingPredicate(player -> ModItems.DIAMOND_PLATED_GOGGLE.isIn(player.getItemBySlot(EquipmentSlot.HEAD)));
        GogglesItem.addIsWearingPredicate(player -> ModItems.NETHERITE_PLATED_GOGGLE.isIn(player.getItemBySlot(EquipmentSlot.HEAD)));
    }
    
    public BetterGoggleItem(PlatingMaterial material, Properties pProperties){
        super(pProperties);
        this.material = material;
        this.defense = material.getDefenseForType(ArmorItem.Type.HELMET);
        this.toughness = material.getToughness();
        this.knockbackResistance = material.getKnockbackResistance();
        this.durability = material.getDurabilityForType(ArmorItem.Type.HELMET);

        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(Attributes.ARMOR, new AttributeModifier(uuid, "Armor modifier", (double)defense, AttributeModifier.Operation.ADDITION));
        builder.put(Attributes.ARMOR_TOUGHNESS, new AttributeModifier(uuid, "Armor toughness", (double)toughness, AttributeModifier.Operation.ADDITION));
        if(this.knockbackResistance>0) builder.put(Attributes.KNOCKBACK_RESISTANCE, new AttributeModifier(uuid, "Armor knockback resistance", (double)knockbackResistance, AttributeModifier.Operation.ADDITION));

        this.defaultModifiers = builder.build();
    }

    @Override
    public InteractionResultHolder<ItemStack> use(@Nonnull Level pLevel, @Nonnull Player pPlayer, @Nonnull InteractionHand pUsedHand){
        return swapWithEquipmentSlot(this, pLevel, pPlayer, pUsedHand);
    }

    @Override
    public SoundEvent getEquipSound(){
        return material.getEquipSound();
    }
    
    @Override
    public EquipmentSlot getEquipmentSlot(){
        return EquipmentSlot.HEAD;
    }

    public int getEnchantmentValue(){
        return material.getEnchantmentValue();
    }

    public boolean isValidRepairItem(@Nonnull ItemStack pToRepair, @Nonnull ItemStack pRepair) {
        return material.getRepairIngredient().test(pRepair) || super.isValidRepairItem(pToRepair, pRepair);
    }

    public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(@Nonnull EquipmentSlot pEquipmentSlot) {
        if(pEquipmentSlot == getEquipmentSlot()) return defaultModifiers;
        return ImmutableMultimap.of();
    }

    public int getDefense(){
        return defense;
    }

    public float getToughness(){
        return toughness;
    }

    public float getKnockbackResistance(){
        return knockbackResistance;
    }

    public PlatingMaterial getMaterial(){
        return material;
    }

    public int getDurability(){
        return durability;
    }

}
