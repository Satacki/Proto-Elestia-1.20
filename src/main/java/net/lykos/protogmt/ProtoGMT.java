package net.lykos.protogmt;

import net.fabricmc.api.ModInitializer;

import net.lykos.protogmt.block.ModBlocks;
import assets.protogmt.models.block.item.ModItemGroup;
import assets.protogmt.models.block.item.ModItems;
import net.lykos.protogmt.util.ModRegistries;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProtoGMT implements ModInitializer {

	public static final	String MOD_ID = "protogmt";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroup.registerItemGroup();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModRegistries.registerModStuffs();
	}
}