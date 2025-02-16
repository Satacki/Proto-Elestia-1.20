package net.lykos.protogmt.registry;

import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Supplier;

public enum ModToolMaterials implements Tier {
    MITHRIL(5, 2369, 12.0f, 5.0f, 30, () -> Ingredient.of(ModItems.MITHRIL_INGOT)),
    ETHER(6, 5000, 15.0f, 10.0f, 40, () -> Ingredient.of(ModItems.ETHER)),
    CHESIUM(7, 50, 20.0f, 0.0f, 50, () -> Ingredient.of(ModItems.HOLY_CHEESE));

    private final int miningLevel;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final LazyLoadedValue<Ingredient> repairIngredient;

    ModToolMaterials(
            int miningLevel,
            int itemDurability,
            float miningSpeed,
            float attackDamage,
            int enchantability,
            Supplier<Ingredient> repairIngredient
    ) {
        this.miningLevel = miningLevel;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairIngredient = new LazyLoadedValue<>(repairIngredient);
    }

    @Override
    public int getUses() {
        return this.itemDurability;
    }

    @Override
    public float getSpeed() {
        return this.miningSpeed;
    }

    @Override
    public float getAttackDamageBonus() {
        return this.attackDamage;
    }

    @Override
    public int getLevel() {
        return this.miningLevel;
    }

    @Override
    public int getEnchantmentValue() {
        return this.enchantability;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
}

