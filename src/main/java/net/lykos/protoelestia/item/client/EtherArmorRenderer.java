package net.lykos.protoelestia.item.client;

import net.lykos.protoelestia.item.custom.EtherArmorItem;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class EtherArmorRenderer extends GeoArmorRenderer<EtherArmorItem> {
    public EtherArmorRenderer()
    {
        super(new EtherArmorModel());
    }
}
