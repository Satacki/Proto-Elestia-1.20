package net.lykos.protogmt.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.resources.ResourceLocation;
import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    // Define the custom tag key for banners
    public static final TagKey<Item> BANNERS = TagKey.create(
            net.minecraft.core.registries.Registries.ITEM,
            new ResourceLocation("yourmodid", "banners") // Replace "yourmodid" with your actual mod ID
    );

    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        getOrCreateTagBuilder(BANNERS)
                .add(
                        Items.WHITE_BANNER, Items.ORANGE_BANNER, Items.MAGENTA_BANNER,
                        Items.LIGHT_BLUE_BANNER, Items.YELLOW_BANNER, Items.LIME_BANNER,
                        Items.PINK_BANNER, Items.GRAY_BANNER, Items.LIGHT_GRAY_BANNER,
                        Items.CYAN_BANNER, Items.PURPLE_BANNER, Items.BLUE_BANNER,
                        Items.BROWN_BANNER, Items.GREEN_BANNER, Items.RED_BANNER,
                        Items.BLACK_BANNER
                );
    }
}
