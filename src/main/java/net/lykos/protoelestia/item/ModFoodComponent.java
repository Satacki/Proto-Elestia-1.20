package net.lykos.protoelestia.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class ModFoodComponent {
    public static final FoodComponent HOLY_CHEESE = new FoodComponent.Builder().hunger(10).saturationModifier(10f)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 1000, 3), 1.0f).statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 6000, 3), 1.0f).statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 6000, 0), 1.0f).statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 2400, 4), 1.0f).statusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 2400, 4), 1.0f).alwaysEdible().build();
}
