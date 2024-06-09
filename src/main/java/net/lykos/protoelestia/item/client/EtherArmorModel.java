package net.lykos.protoelestia.item.client;

import net.lykos.protoelestia.ProtoElestia;
import net.lykos.protoelestia.item.custom.EtherArmorItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class EtherArmorModel extends GeoModel<EtherArmorItem> {
    @Override
    public Identifier getModelResource(EtherArmorItem animatable) {
        return new Identifier(ProtoElestia.MOD_ID, "geo/ether.geo.json");
    }

    @Override
    public Identifier getTextureResource(EtherArmorItem animatable) {
        return new Identifier(ProtoElestia.MOD_ID, "textures/armor/ether_armor_texture.png");
    }

    @Override
    public Identifier getAnimationResource(EtherArmorItem animatable) {

        return new Identifier(ProtoElestia.MOD_ID, "animations/ether.animation.json");
    }
}
