package net.lykos.protogmt.items;

import net.lykos.protogmt.client.IdofrontArmorRenderer;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.network.chat.Component;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleMenuProvider;
import net.lykos.protogmt.gui.BondrewdArmorScreenHandler;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.client.RenderProvider;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class IdofrontArmorItem extends ArmorItem implements GeoItem {
    private final AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);
    private final Supplier<Object> renderProvider = GeoItem.makeRenderer(this);

    public IdofrontArmorItem(ArmorMaterial material, Type type, Properties settings) {
        super(material, type, settings);
    }

    /**
     * ✅ Stores a Cartridge in a specific slot (0, 1, 2).
     */
    public void setCartridge(ItemStack chestplate, int slot, ItemStack cartridge) {
        if (slot < 0 || slot >= 3) return; // Ensure valid slot number
        CompoundTag tag = chestplate.getOrCreateTag();
        if (!cartridge.isEmpty()) {
            tag.put("Cartridge" + slot, cartridge.save(new CompoundTag())); // Save cartridge item in slot
        } else {
            tag.remove("Cartridge" + slot); // Remove if empty
        }
    }

    /**
     * ✅ Retrieves the Cartridge from a specific slot (0, 1, 2).
     */
    public ItemStack getCartridge(ItemStack chestplate, int slot) {
        if (slot < 0 || slot >= 3) return ItemStack.EMPTY; // Ensure valid slot number
        CompoundTag tag = chestplate.getTag();
        if (tag != null && tag.contains("Cartridge" + slot)) {
            return ItemStack.of(tag.getCompound("Cartridge" + slot));
        }
        return ItemStack.EMPTY;
    }

    /**
     * ✅ Checks if any Cartridge is inserted in the armor.
     */
    public boolean hasCartridge(ItemStack chestplate) {
        for (int i = 0; i < 3; i++) {
            if (!getCartridge(chestplate, i).isEmpty()) {
                return true;
            }
        }
        return false;
    }

    /**
     * ✅ Opens the Cartridge GUI when the Keybind is pressed.
     */
    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        ItemStack heldItem = player.getItemInHand(hand);

        if (!world.isClientSide && heldItem.getItem() == this) {
            // Open Cartridge GUI
            player.openMenu(new SimpleMenuProvider(
                    (syncId, inv, p) -> new BondrewdArmorScreenHandler(syncId, inv, heldItem),
                    Component.literal("Cartridge Slots")
            ));
            return InteractionResultHolder.success(heldItem);
        }
        return super.use(world, player, hand);
    }

    /**
     * ✅ Keeps Geckolib rendering intact.
     */
    @Override
    public void createRenderer(Consumer<Object> consumer) {
        consumer.accept(new RenderProvider() {
            private IdofrontArmorRenderer renderer;

            @Override
            public HumanoidModel<LivingEntity> getHumanoidArmorModel(
                    LivingEntity livingEntity,
                    ItemStack itemStack,
                    EquipmentSlot equipmentSlot,
                    HumanoidModel<LivingEntity> original
            ) {
                if (this.renderer == null) this.renderer = new IdofrontArmorRenderer();

                this.renderer.prepForRender(livingEntity, itemStack, equipmentSlot, original);

                return this.renderer;
            }
        });
    }

    @Override
    public Supplier<Object> getRenderProvider() {
        return this.renderProvider;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController(this, "controller", 0, this::predicate));
    }

    private PlayState predicate(AnimationState animationState) {
        animationState.getController().setAnimation(RawAnimation.begin().then("idle", Animation.LoopType.LOOP));
        return PlayState.CONTINUE;
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }
}
