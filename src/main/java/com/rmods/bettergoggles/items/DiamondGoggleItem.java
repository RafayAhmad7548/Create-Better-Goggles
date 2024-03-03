package com.rmods.bettergoggles.items;

import java.util.function.Consumer;

import javax.annotation.Nonnull;

import org.jetbrains.annotations.NotNull;

import com.rmods.bettergoggles.renderers.armor.DiamondGoggleRenderer;
import com.simibubi.create.content.equipment.goggles.GogglesItem;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.renderer.GeoArmorRenderer;
import software.bernie.geckolib.util.GeckoLibUtil;

public class DiamondGoggleItem extends ArmorItem implements GeoItem{

    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    static{
        GogglesItem.addIsWearingPredicate(player -> ModItems.DIAMOND_PLATED_GOGGLE.isIn(player.getItemBySlot(EquipmentSlot.HEAD)));
    }

    public DiamondGoggleItem(ArmorMaterial pMaterial, Type pType, Properties pProperties) {
        super(pMaterial, pType, pProperties);
    }

    @Override
    public void initializeClient(@Nonnull Consumer<IClientItemExtensions> consumer){
        consumer.accept(new IClientItemExtensions(){
            private GeoArmorRenderer<?> renderer;
            @Override
            public @NotNull HumanoidModel<?> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack, EquipmentSlot equipmentSlot, HumanoidModel<?> original){
                if (this.renderer == null) this.renderer = new DiamondGoggleRenderer();
                this.renderer.prepForRender(livingEntity, itemStack, equipmentSlot, original);
                return this.renderer;
            }
        });
    }
    
    @Override
	public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
		controllers.add(new AnimationController<>(this, 20, state -> {
			return PlayState.CONTINUE;
		}));
	}
    
    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache(){
        return this.cache;
    }

}