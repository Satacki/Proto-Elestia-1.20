package assets.protogmt.models.block.item.client;

import assets.protogmt.models.block.item.custom.EtherArmorItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class EtherArmorRenderer extends GeoArmorRenderer<EtherArmorItem> {
    public EtherArmorRenderer()
    {
        super(new EtherArmorModel());
    }
}
