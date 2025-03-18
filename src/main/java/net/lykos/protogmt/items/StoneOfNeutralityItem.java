package net.lykos.protogmt.items;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class StoneOfNeutralityItem extends Item {
    public StoneOfNeutralityItem(Properties properties) {
        super(new Properties().stacksTo(1));
    }

    public static boolean isPvpDisabled(ServerPlayer player) {
        for (ItemStack stack : player.getInventory().items) {
            if (stack.getItem() instanceof StoneOfNeutralityItem) {
                return true;
            }
        }
        return false;
    }
}
