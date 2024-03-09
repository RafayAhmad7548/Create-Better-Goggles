package com.rmods.bettergoggles.fluids;

import com.tterrag.registrate.util.entry.FluidEntry;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.fluids.ForgeFlowingFluid;

import static com.rmods.bettergoggles.BetterGoggles.REGISTRATE;

public class ModFluids{

    public static final FluidEntry<ForgeFlowingFluid.Flowing> MOLTEN_DIAMOND =
        REGISTRATE.fluid("molten_diamond", new ResourceLocation("bettergoggles:block/molten_diamond_still"), new ResourceLocation("bettergoggles:block/molten_diamond_flow"))
            .lang("Molten Diamond")
            .properties(b -> b.canPushEntity(true).density(1000).viscosity(3000))
            .fluidProperties(b -> b.levelDecreasePerBlock(3).tickRate(4))
            .register();


    public static final FluidEntry<ForgeFlowingFluid.Flowing> MOLTEN_NETHERITE =
        REGISTRATE.fluid("molten_netherite", new ResourceLocation("bettergoggles:block/molten_netherite_still"), new ResourceLocation("bettergoggles:block/molten_netherite_flow"))
            .lang("Molten Netherite")
            .properties(b -> b.canPushEntity(true).density(1000).viscosity(3000))
            .fluidProperties(b -> b.levelDecreasePerBlock(3).tickRate(4))
            .register();

    public static void register(){
        
    }

}
