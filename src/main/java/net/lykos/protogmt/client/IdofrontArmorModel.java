package net.lykos.protogmt.client;

import net.lykos.protogmt.ProtoGMT;
import net.lykos.protogmt.items.IdofrontArmorItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class IdofrontArmorModel extends GeoModel<IdofrontArmorItem> {
    @Override
    public ResourceLocation getModelResource(IdofrontArmorItem animatable) { return ProtoGMT.id("geo/idofrontarmor.geo.json"); }

    @Override
    public ResourceLocation getTextureResource(IdofrontArmorItem animatable) {
        return ProtoGMT.id("textures/armor/atlastexture_idofront_armor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(IdofrontArmorItem animatable) {
        return ProtoGMT.id("animations/idofront.animation.json");
    }
}
