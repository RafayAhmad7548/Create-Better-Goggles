package com.rmods.bettergoggles.fluids;

import com.tterrag.registrate.util.entry.FluidEntry;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.fluids.ForgeFlowingFluid;

import static com.rmods.bettergoggles.BetterGoggles.REGISTRATE;

public class ModFluids{

    public static final FluidEntry<ForgeFlowingFluid.Flowing> MOLTEN_DIAMOND =
        REGISTRATE.fluid("molten_diamond", new ResourceLocation("bettergoggles:fluid/molten_diamond_still"), new ResourceLocation("bettergoggles:fluid/molten_diamond_flow"))
            .lang("Molten Diamond")
            .properties(b -> b.canPushEntity(true).density(500).viscosity(1500))
            .fluidProperties(b -> b.levelDecreasePerBlock(2))
            .register();

    public static void register(){
        
    }
        


}
