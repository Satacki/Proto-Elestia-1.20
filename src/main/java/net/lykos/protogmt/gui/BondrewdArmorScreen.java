package net.lykos.protogmt.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class BondrewdArmorScreen extends AbstractContainerScreen<BondrewdArmorScreenHandler> {
    private static final ResourceLocation TEXTURE = new ResourceLocation("protogmt", "textures/gui/bondrewd_armor_gui.png");

    public BondrewdArmorScreen(BondrewdArmorScreenHandler handler, Inventory playerInventory, Component title) {
        super(handler, playerInventory, title);
        this.imageWidth = 173;
        this.imageHeight = 163;
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float delta, int mouseX, int mouseY) {
        RenderSystem.setShaderTexture(0, TEXTURE);

        int x = (this.width - this.imageWidth) / 2;
        int y = (this.height - this.imageHeight) / 2;

        guiGraphics.blit(TEXTURE, x, y, 0, 0, this.imageWidth, this.imageHeight);

    }






    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float delta) {
        this.renderBackground(guiGraphics);
        super.render(guiGraphics, mouseX, mouseY, delta);
        this.renderTooltip(guiGraphics, mouseX, mouseY);
    }
}
