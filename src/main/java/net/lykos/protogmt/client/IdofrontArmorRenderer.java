package net.lykos.protogmt.client;

import net.lykos.protogmt.items.IdofrontArmorItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class IdofrontArmorRenderer extends GeoArmorRenderer<IdofrontArmorItem> {
    public IdofrontArmorRenderer() {
        super(new IdofrontArmorModel());
    }
}
