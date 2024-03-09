package com.rmods.bettergoggles.fluids;

import java.util.function.Consumer;

import org.jetbrains.annotations.NotNull;
import org.joml.Vector3f;

import com.mojang.blaze3d.shaders.FogShape;
import com.mojang.blaze3d.systems.RenderSystem;
import com.simibubi.create.foundation.utility.Color;
import com.tterrag.registrate.builders.FluidBuilder.FluidTypeFactory;

import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.FogRenderer.FogMode;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.material.FluidState;
import net.minecraftforge.client.extensions.common.IClientFluidTypeExtensions;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidType;

public class BetterFluidType extends FluidType{
    
    private Vector3f fogColor;
    private float fogDistance;
    private ResourceLocation stillTexture;
    private ResourceLocation flowingTexture;

    public static FluidTypeFactory create(int fogColor, float fogDistance){
        return (p, s, f) -> {
            BetterFluidType fluidType = new BetterFluidType(p, s, f);
            fluidType.fogColor = new Color(fogColor, false).asVectorF();
            fluidType.fogDistance = fogDistance;
            return fluidType;
        };
    }

    public BetterFluidType(Properties properties, ResourceLocation stillTexture, ResourceLocation flowingTexture){
        super(properties);
        this.stillTexture = stillTexture;
        this.flowingTexture = flowingTexture;
    }

    @Override
    public void initializeClient(Consumer<IClientFluidTypeExtensions> consumer){
        consumer.accept(new IClientFluidTypeExtensions(){
            @Override
            public ResourceLocation getStillTexture(){
                return stillTexture;
            }

            @Override
            public ResourceLocation getFlowingTexture(){
                return flowingTexture;
            }

            @Override
            public int getTintColor(FluidStack stack){
                return 0xffffffff;
            }

            @Override
            public int getTintColor(FluidState state, BlockAndTintGetter getter, BlockPos pos){
                return 0x00ffffff;
            }
            
            @Override
            public @NotNull Vector3f modifyFogColor(Camera camera, float partialTick, ClientLevel level, int renderDistance, float darkenWorldAmount, Vector3f fluidFogColor){
                return fogColor == null ? fluidFogColor : fogColor;
            }

            @Override
            public void modifyFogRender(Camera camera, FogMode mode, float renderDistance, float partialTick, float nearDistance, float farDistance, FogShape shape){
                float baseWaterFog = 96.0f;
                if (fogDistance != 1f) {
                    RenderSystem.setShaderFogShape(FogShape.CYLINDER);
                    RenderSystem.setShaderFogStart(-8);
                    RenderSystem.setShaderFogEnd(baseWaterFog * fogDistance);
                }
            }
        });
    }
}
