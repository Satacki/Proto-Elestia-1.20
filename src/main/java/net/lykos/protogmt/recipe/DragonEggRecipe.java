package net.lykos.protogmt.recipe;

import com.google.gson.JsonObject;
import net.minecraft.core.NonNullList;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;

public class DragonEggRecipe extends ShapedRecipe {
    public DragonEggRecipe(ResourceLocation id, String group, CraftingBookCategory category, int width, int height, NonNullList<Ingredient> ingredients, ItemStack result) {
        super(id, group, category, width, height, ingredients, result);
    }

    @Override
    public NonNullList<ItemStack> getRemainingItems(CraftingContainer container) {
        System.out.println("[DEBUG] getRemainingItems() called for DragonEggRecipe!");

        NonNullList<ItemStack> remainingItems = NonNullList.withSize(container.getContainerSize(), ItemStack.EMPTY);

        for (int i = 0; i < container.getContainerSize(); i++) {
            ItemStack stack = container.getItem(i);

            // ✅ If this slot contains a Dragon Egg, return it instead of consuming it
            if (stack.getItem() == Items.DRAGON_EGG) {
                System.out.println("[DEBUG] Keeping Dragon Egg in crafting grid.");
                remainingItems.set(i, stack.copy()); // ✅ Keeps the Dragon Egg
            } else {
                remainingItems.set(i, stack.getRecipeRemainder()); // ✅ Handles other items normally
            }
        }

        return remainingItems;
    }


    public static class Serializer implements RecipeSerializer<DragonEggRecipe> {
        @Override
        public DragonEggRecipe fromJson(ResourceLocation id, JsonObject json) {
            ShapedRecipe recipe = RecipeSerializer.SHAPED_RECIPE.fromJson(id, json);
            return new DragonEggRecipe(id, recipe.getGroup(), recipe.category(), recipe.getWidth(), recipe.getHeight(), recipe.getIngredients(), recipe.getResultItem(null) // ✅ Use `null` for RegistryAccess
            );
        }

        @Override
        public DragonEggRecipe fromNetwork(ResourceLocation id, FriendlyByteBuf buffer) {
            ShapedRecipe recipe = RecipeSerializer.SHAPED_RECIPE.fromNetwork(id, buffer);
            return new DragonEggRecipe(id, recipe.getGroup(), recipe.category(), recipe.getWidth(), recipe.getHeight(), recipe.getIngredients(), recipe.getResultItem(null) // ✅ Use `null` for RegistryAccess
            );
        }

        @Override
        public void toNetwork(FriendlyByteBuf buffer, DragonEggRecipe recipe) {
            RecipeSerializer.SHAPED_RECIPE.toNetwork(buffer, recipe);
        }

    }
}
