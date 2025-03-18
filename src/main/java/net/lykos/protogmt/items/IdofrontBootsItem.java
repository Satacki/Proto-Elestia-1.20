package net.lykos.protogmt.items;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

public class IdofrontBootsItem extends ArmorItem {
    public IdofrontBootsItem(ArmorMaterial material, Item.Properties properties) {
        super(material, ArmorItem.Type.BOOTS, properties);
    }

    public void onArmorTick(ItemStack stack, Level world, Player player) {
        if (!world.isClientSide) {
            if (player.isInPowderSnow && !player.getAbilities().flying) {
                player.setOnGround(true); // Simulates walking on powder snow
            }
        }
    }

    @Override
    public boolean isValidRepairItem(ItemStack stack, ItemStack repair) {
        return repair.is(Items.LEATHER); // Ensures proper leather repair item reference
    }
}
