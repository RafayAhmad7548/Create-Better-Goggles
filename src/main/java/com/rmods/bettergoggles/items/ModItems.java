package com.rmods.bettergoggles.items;

import com.rmods.bettergoggles.BetterGoggles;
import com.simibubi.create.AllItems;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.util.entry.ItemEntry;

import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static com.rmods.bettergoggles.BetterGoggles.REGISTRATE;

public class ModItems{

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, BetterGoggles.MODID);

    public static final ItemEntry<BetterGoggleItem> DIAMOND_PLATED_GOGGLE =
        REGISTRATE.item("diamond_plated_goggle", p -> new BetterGoggleItem(PlatingMaterial.DIAMNOD_PlATING, new Item.Properties()
        .stacksTo(1)))
        // .onRegister(CreateRegistrate.itemModel(() -> BetterGoggleModel::new))
        .register();

    public static final ItemEntry<BetterGoggleItem> NETHERITE_PLATED_GOGGLE =
        REGISTRATE.item("netherite_plated_goggle",p -> new BetterGoggleItem(PlatingMaterial.NETHERITE_PLATING, new Item.Properties()
        .stacksTo(1)))
        .register();

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
