package com.rmods.bettergoggles.fluids;

import static com.rmods.bettergoggles.BetterGoggles.REGISTRATE;

import com.rmods.bettergoggles.BetterGoggles;
import com.tterrag.registrate.util.entry.FluidEntry;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.fluids.ForgeFlowingFluid;


public class ModFluids{

    public static final FluidEntry<ForgeFlowingFluid.Flowing> MOLTEN_DIAMOND = REGISTRATE.fluid("molten_diamond",
        new ResourceLocation(BetterGoggles.MODID, "block/fluid/molten_diamond_still"),
        new ResourceLocation(BetterGoggles.MODID, "block/fluid/molten_diamond_flow"),
        BetterFluidType.create(0x4AEDF9, 0.03f))
            .lang("Molten Diamond")
            .properties(b -> b
                .canPushEntity(true)
                .density(3500)
                .viscosity(4000)
                .canDrown(false)
                .canSwim(false)
                .canHydrate(false)
                .lightLevel(11))
            .fluidProperties(b -> b
                .levelDecreasePerBlock(3)
                .tickRate(40))
            .register();


    public static final FluidEntry<ForgeFlowingFluid.Flowing> MOLTEN_NETHERITE = REGISTRATE.fluid("molten_netherite",
        new ResourceLocation("bettergoggles:block/fluid/molten_netherite_still"),
        new ResourceLocation("bettergoggles:block/fluid/molten_netherite_flow"),
        BetterFluidType.create(0x3C3C3C, 0.03f))
            .lang("Molten Netherite")
            .properties(b -> b
                .canPushEntity(true)
                .density(4000)
                .viscosity(5000)
                .canDrown(false)
                .canSwim(false)
                .canHydrate(false)
                .lightLevel(11))
            .fluidProperties(b -> b
                .levelDecreasePerBlock(3)
                .tickRate(40))
            .register();

    public static void register(){}

}