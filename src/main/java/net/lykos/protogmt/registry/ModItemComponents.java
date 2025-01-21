package net.lykos.protogmt.registry;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModItemComponents {
    public static final FoodProperties HOLY_CHEESE = new FoodProperties.Builder().nutrition(10)
            .saturationMod(10f)
            .effect(new MobEffectInstance(MobEffects.REGENERATION, 1000, 3), 1.0f)
            .effect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 6000, 3), 1.0f)
            .effect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 6000, 0), 1.0f)
            .effect(new MobEffectInstance(MobEffects.ABSORPTION, 2400, 4), 1.0f)
            .effect(new MobEffectInstance(MobEffects.GLOWING, 2400, 0), 1.0f)
            .alwaysEat()
            .build();

    public static final FoodProperties CHESIUM_PICKAXE = new FoodProperties.Builder().nutrition(10)
            .saturationMod(10f)
            .effect(new MobEffectInstance(MobEffects.REGENERATION, 1000, 3), 1.0f)
            .effect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 6000, 3), 1.0f)
            .effect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 6000, 0), 1.0f)
            .effect(new MobEffectInstance(MobEffects.ABSORPTION, 2400, 4), 1.0f)
            .effect(new MobEffectInstance(MobEffects.GLOWING, 2400, 4), 1.0f)
            .alwaysEat()
            .build();
}
