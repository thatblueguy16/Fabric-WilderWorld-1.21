package net.thatblueguy16.wilderworld;

import net.fabricmc.api.ModInitializer;

import net.thatblueguy16.wilderworld.block.ModBlocks;
import net.thatblueguy16.wilderworld.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WilderWorld implements ModInitializer {
	public static final String MOD_ID = "wilderworld";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}