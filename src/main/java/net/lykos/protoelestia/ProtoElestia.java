package net.lykos.protoelestia;

import net.fabricmc.api.ModInitializer;

import net.lykos.protoelestia.block.ModBlocks;
import net.lykos.protoelestia.item.ModItemGroup;
import net.lykos.protoelestia.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProtoElestia implements ModInitializer {

	public static final	String MOD_ID = "protoelestia";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroup.registerItemGroup();


		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}