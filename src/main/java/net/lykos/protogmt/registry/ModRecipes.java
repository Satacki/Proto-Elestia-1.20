package net.lykos.protogmt.registry;

import net.lykos.protogmt.ProtoGMT;
import net.lykos.protogmt.recipe.DragonEggRecipe;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.core.Registry;

public class ModRecipes {
    public static final RecipeType<DragonEggRecipe> DRAGON_EGG_RECIPE = new RecipeType<>() {};
    public static final RecipeSerializer<DragonEggRecipe> DRAGON_EGG_SERIALIZER = new DragonEggRecipe.Serializer();

    public static void register() {
        System.out.println("[DEBUG] Registering custom recipes...");

        // ✅ Register Dragon Egg Recipe
        Registry.register(BuiltInRegistries.RECIPE_TYPE, new ResourceLocation(ProtoGMT.MOD_ID, "dragon_egg_crafting"), DRAGON_EGG_RECIPE);
        Registry.register(BuiltInRegistries.RECIPE_SERIALIZER, new ResourceLocation(ProtoGMT.MOD_ID, "dragon_egg_crafting"), DRAGON_EGG_SERIALIZER);

        System.out.println("[DEBUG] ✅ Custom Dragon Egg Recipe Registered!");
    }
}
