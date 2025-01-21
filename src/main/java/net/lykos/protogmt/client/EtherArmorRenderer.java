package net.lykos.protogmt.client;

import net.lykos.protogmt.items.EtherArmorItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class EtherArmorRenderer extends GeoArmorRenderer<EtherArmorItem> {
    public EtherArmorRenderer() {
        super(new EtherArmorModel());
    }
}
