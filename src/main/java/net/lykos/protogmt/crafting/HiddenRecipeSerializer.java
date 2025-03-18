package net.lykos.protogmt.crafting;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.core.NonNullList;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.ShapedRecipe;

/**
 * Serializer for Hidden Recipes.
 */
public class HiddenRecipeSerializer implements RecipeSerializer<HiddenRecipe> {
    public static final HiddenRecipeSerializer INSTANCE = new HiddenRecipeSerializer();

    @Override
    public HiddenRecipe fromJson(ResourceLocation id, JsonObject json) {
        NonNullList<Ingredient> ingredients = NonNullList.create();
        JsonArray jsonIngredients = json.getAsJsonArray("ingredients");

        for (int i = 0; i < jsonIngredients.size(); i++) {
            ingredients.add(Ingredient.fromJson(jsonIngredients.get(i)));
        }

        ItemStack result = ItemStack.EMPTY; // Prevents recipe output from appearing

        return new HiddenRecipe(id, ingredients, result);
    }

    @Override
    public HiddenRecipe fromNetwork(ResourceLocation id, FriendlyByteBuf buffer) {
        NonNullList<Ingredient> ingredients = NonNullList.create();
        int size = buffer.readVarInt();

        for (int i = 0; i < size; i++) {
            ingredients.add(Ingredient.fromNetwork(buffer));
        }

        ItemStack result = ItemStack.EMPTY; // Keeps it hidden

        return new HiddenRecipe(id, ingredients, result);
    }

    @Override
    public void toNetwork(FriendlyByteBuf buffer, HiddenRecipe recipe) {
        buffer.writeVarInt(recipe.getIngredients().size());
        for (Ingredient ingredient : recipe.getIngredients()) {
            ingredient.toNetwork(buffer);
        }
    }
}
