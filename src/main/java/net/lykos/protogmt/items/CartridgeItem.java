package net.lykos.protogmt.items;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.world.item.Item;

public class CartridgeItem extends Item {
    public CartridgeItem(FabricItemSettings rarity) {
        super(new Properties().stacksTo(1));
    }

}