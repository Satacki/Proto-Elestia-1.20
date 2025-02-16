package net.lykos.protogmt.client;

import net.lykos.protogmt.ProtoGMT;
import net.lykos.protogmt.items.EtherArmorItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class EtherArmorModel extends GeoModel<EtherArmorItem> {
    @Override
    public ResourceLocation getModelResource(EtherArmorItem animatable) {
        return ProtoGMT.id("geo/ether.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EtherArmorItem animatable) {
        return ProtoGMT.id("textures/armor/ether_armor_texture.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EtherArmorItem animatable) {
        return ProtoGMT.id("animations/ether.animation.json");
    }
}
