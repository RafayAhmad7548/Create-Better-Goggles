package com.rmods.bettergoggles.items;

import com.rmods.bettergoggles.BetterGoggles;
import com.tterrag.registrate.util.entry.ItemEntry;

import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static com.rmods.bettergoggles.BetterGoggles.REGISTRATE;

public class ModItems{

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, BetterGoggles.MODID);

    public static final ItemEntry<DiamondGoggleItem> DIAMOND_PLATED_GOGGLE =
        REGISTRATE.item("diamond_plated_goggle", p -> new DiamondGoggleItem(PlatingMaterial.DIAMNOD_PlATING, ArmorItem.Type.HELMET, new Item.Properties()))
        .register();
    public static final ItemEntry<NetheriteGoggleItem> NETHERITE_PLATED_GOGGLE =
        REGISTRATE.item("netherite_plated_goggle", p -> new NetheriteGoggleItem(PlatingMaterial.NETHERITE_PLATING, ArmorItem.Type.HELMET, new Item.Properties())).register();

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
