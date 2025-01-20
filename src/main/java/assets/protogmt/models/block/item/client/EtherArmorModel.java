package assets.protogmt.models.block.item.client;

import assets.protogmt.models.block.item.custom.EtherArmorItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class EtherArmorModel extends GeoModel<EtherArmorItem> {
    @Override
    public Identifier getModelResource(EtherArmorItem animatable) {
        return new Identifier(net.lykos.protogmt.ProtoGMT.MOD_ID, "geo/ether.geo.json");
    }

    @Override
    public Identifier getTextureResource(EtherArmorItem animatable) {
        return new Identifier(net.lykos.protogmt.ProtoGMT.MOD_ID, "textures/armor/ether_armor_texture.png");
    }

    @Override
    public Identifier getAnimationResource(EtherArmorItem animatable) {

        return new Identifier(net.lykos.protogmt.ProtoGMT.MOD_ID, "animations/ether.animation.json");
    }
}
