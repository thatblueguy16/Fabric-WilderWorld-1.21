package net.thatblueguy16.wilderworld;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.thatblueguy16.wilderworld.block.ModBlocks;
import net.thatblueguy16.wilderworld.item.ModItemGroups;
import net.thatblueguy16.wilderworld.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WilderWorld implements ModInitializer {
	public static final String MOD_ID = "wilderworld";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		FuelRegistry.INSTANCE.add(ModBlocks.CYPRESS_BUTTON,100);
		FuelRegistry.INSTANCE.add(ModBlocks.CYPRESS_LOG,300);

		FuelRegistry.INSTANCE.add(ModBlocks.CYPRESS_LEAVES,150);
		FuelRegistry.INSTANCE.add(ModBlocks.CYPRESS_WOOD,300);

		FuelRegistry.INSTANCE.add(ModBlocks.CYPRESS_PLANKS,300);
		FuelRegistry.INSTANCE.add(ModBlocks.CYPRESS_PRESSURE_PLATE,300);

		FuelRegistry.INSTANCE.add(ModBlocks.CYPRESS_SLAB,150);
		FuelRegistry.INSTANCE.add(ModBlocks.CYPRESS_TRAPDOOR,300);

		FuelRegistry.INSTANCE.add(ModBlocks.CYPRESS_DOOR,300);
		FuelRegistry.INSTANCE.add(ModBlocks.CYPRESS_FENCE,300);

		FuelRegistry.INSTANCE.add(ModBlocks.CYPRESS_FENCE_GATE,300);
		FuelRegistry.INSTANCE.add(ModItems.PEAT_CLUMP, 800);

		FuelRegistry.INSTANCE.add(ModBlocks.DRIED_PEAT_BLOCK, 1650);


	}
}