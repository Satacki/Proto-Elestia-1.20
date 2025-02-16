package net.lykos.protogmt.gui;

import net.lykos.protogmt.items.CartridgeItem;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.lykos.protogmt.items.IdofrontArmorItem;
import net.lykos.protogmt.registry.ModScreenHandlers;

public class BondrewdArmorScreenHandler extends AbstractContainerMenu {
    private final ItemStack chestplate;
    private final SimpleContainer inventory;


    public BondrewdArmorScreenHandler(int syncId, Inventory playerInventory) {
        this(syncId, playerInventory, playerInventory.getSelected());
    }


    public BondrewdArmorScreenHandler(int syncId, Inventory playerInventory, ItemStack chestplate) {
        super(ModScreenHandlers.BONDED_ARMOR_SCREEN_HANDLER, syncId);
        this.chestplate = chestplate;
        this.inventory = new SimpleContainer(3);

        if (chestplate.getItem() instanceof IdofrontArmorItem armor) {
            for (int i = 0; i < 3; i++) {
                this.inventory.setItem(i, armor.getCartridge(chestplate, i)); //
            }
        }

        for (int i = 0; i < 3; i++) {
            this.addSlot(new Slot(this.inventory, i, 43 + i * 36, 42) {
                @Override
                public boolean mayPickup(Player player) {
                    return false;
                }

                @Override
                public boolean mayPlace(ItemStack stack) {
                    return stack.getItem() instanceof CartridgeItem;
                }
            });
        }



        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 9; col++) {
                this.addSlot(new Slot(playerInventory, col + row * 9 + 9, 8 + col * 18, 84 + row * 18));
            }
        }

        for (int col = 0; col < 9; col++) {
            this.addSlot(new Slot(playerInventory, col, 8 + col * 18, 142));
        }
    }


    @Override
    public void removed(Player player) {
        super.removed(player);
       // if (chestplate.getItem() instanceof IdofrontArmorItem armor) {
           // for (int i = 0; i < 3; i++) {
         //       armor.setCartridge(chestplate, i, this.inventory.getItem(i));
            //}
        //}
    }
    @Override
    public boolean canTakeItemForPickAll(ItemStack stack, Slot slot) {

        if (slot.getItem().getItem() instanceof ArmorItem) {
            System.out.println("[DEBUG] Prevented armor removal via normal click!");
            return false;
        }
        return super.canTakeItemForPickAll(stack, slot);
    }

    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        Slot slot = this.slots.get(index);

        if (slot != null && slot.hasItem()) {
            ItemStack stack = slot.getItem();

            System.out.println("[DEBUG] Clicked slot: " + index + " | Item: " + stack.getItem());


            if (stack.getItem() instanceof ArmorItem) {
                return ItemStack.EMPTY;
            }
        }

        return ItemStack.EMPTY;
    }



    @Override
    public boolean stillValid(Player player) {
        return player.getItemBySlot(EquipmentSlot.CHEST).getItem() instanceof IdofrontArmorItem;
    }

}
