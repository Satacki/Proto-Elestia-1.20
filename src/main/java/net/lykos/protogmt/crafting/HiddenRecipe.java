package net.lykos.protogmt.crafting;

import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;

/**
 * Custom Hidden Recipe that prevents normal crafting.
 */
public class HiddenRecipe implements Recipe<Container> {
    private final ResourceLocation id;
    private final NonNullList<Ingredient> ingredients;
    private final ItemStack output;

    public HiddenRecipe(ResourceLocation id, NonNullList<Ingredient> ingredients, ItemStack output) {
        this.id = id;
        this.ingredients = ingredients;
        this.output = output;
    }

    @Override
    public boolean matches(Container inventory, Level world) {
        return false; // Makes the recipe "invalid" for normal crafting
    }

    @Override
    public ItemStack assemble(Container container, RegistryAccess registryAccess) {
        return ItemStack.EMPTY; // Ensures the recipe is ignored
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return false; // Prevents it from appearing in crafting tables
    }

    @Override
    public ItemStack getResultItem(RegistryAccess registryAccess) {
        return ItemStack.EMPTY; // JEI will not detect a valid output
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        return ingredients;
    }

    @Override
    public ResourceLocation getId() {
        return id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return HiddenRecipeSerializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return HiddenRecipeType.INSTANCE;
    }
}
