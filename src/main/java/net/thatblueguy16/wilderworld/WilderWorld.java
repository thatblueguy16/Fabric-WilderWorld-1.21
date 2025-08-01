package net.thatblueguy16.wilderworld;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.thatblueguy16.wilderworld.block.ModBlocks;
import net.thatblueguy16.wilderworld.component.ModDataComponentTypes;
import net.thatblueguy16.wilderworld.item.ModItemGroups;
import net.thatblueguy16.wilderworld.item.ModItems;
import net.thatblueguy16.wilderworld.util.HammerUsageEvent;
import net.thatblueguy16.wilderworld.world.gen.ModWorldGeneration;
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

		ModDataComponentTypes.registerDataComponentTypes();
		ModWorldGeneration.generateModWorldGen();

		PlayerBlockBreakEvents.BEFORE.register(new HammerUsageEvent());

		FuelRegistry.INSTANCE.add(ModBlocks.CYPRESS_BUTTON, 100);
		FuelRegistry.INSTANCE.add(ModBlocks.CYPRESS_LOG, 300);

		FuelRegistry.INSTANCE.add(ModBlocks.CYPRESS_LEAVES, 150);
		FuelRegistry.INSTANCE.add(ModBlocks.CYPRESS_WOOD, 300);

		FuelRegistry.INSTANCE.add(ModBlocks.CYPRESS_PLANKS, 300);
		FuelRegistry.INSTANCE.add(ModBlocks.CYPRESS_PRESSURE_PLATE, 300);

		FuelRegistry.INSTANCE.add(ModBlocks.CYPRESS_SLAB, 150);
		FuelRegistry.INSTANCE.add(ModBlocks.CYPRESS_TRAPDOOR, 300);

		FuelRegistry.INSTANCE.add(ModBlocks.CYPRESS_DOOR, 300);
		FuelRegistry.INSTANCE.add(ModBlocks.CYPRESS_FENCE, 300);

		FuelRegistry.INSTANCE.add(ModBlocks.CYPRESS_FENCE_GATE, 300);
		FuelRegistry.INSTANCE.add(ModItems.PEAT_CLUMP, 800);

		FuelRegistry.INSTANCE.add(ModBlocks.DRIED_PEAT_BLOCK, 16000);
		FuelRegistry.INSTANCE.add(ModItems.DRIED_PEAT_CLUMP, 1600);

		FuelRegistry.INSTANCE.add(ModBlocks.FERRUSK_LOG, 300);
		FuelRegistry.INSTANCE.add(ModBlocks.DEAD_FERRUSK_WOOD, 300);
		FuelRegistry.INSTANCE.add(ModBlocks.DEAD_FERRUSK_LOG, 300);
		FuelRegistry.INSTANCE.add(ModBlocks.FERRUSK_WOOD, 300);


		StrippableBlockRegistry.register(ModBlocks.CYPRESS_LOG, ModBlocks.STRIPPED_CYPRESS_LOG);
		StrippableBlockRegistry.register(ModBlocks.CYPRESS_WOOD, ModBlocks.STRIPPED_CYPRESS_WOOD);

		StrippableBlockRegistry.register(ModBlocks.FERRUSK_LOG, ModBlocks.DEAD_FERRUSK_LOG);
		StrippableBlockRegistry.register(ModBlocks.FERRUSK_WOOD, ModBlocks.DEAD_FERRUSK_WOOD);

		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.CYPRESS_LOG, 5,5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_CYPRESS_LOG, 5,5);

		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.CYPRESS_WOOD, 5,5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_CYPRESS_WOOD, 5,5);

		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.CYPRESS_PLANKS, 5,20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.CYPRESS_STAIR, 5,20);

		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.CYPRESS_SLAB, 5,20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.CYPRESS_FENCE_GATE, 5,20);

		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.CYPRESS_FENCE, 5,20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.CYPRESS_DOOR, 5,20);

		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.CYPRESS_TRAPDOOR, 5,20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.CYPRESS_LEAVES, 30,60);

		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.FERRUSK_LOG, 5,5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.FERRUSK_WOOD, 5,5);

		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.DEAD_FERRUSK_WOOD, 5,5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.DEAD_FERRUSK_LOG, 5,5);


		CompostingChanceRegistry.INSTANCE.add(ModItems.GLOWROOT_BULB, 0.25f);
		CompostingChanceRegistry.INSTANCE.add(ModBlocks.CYPRESS_LEAVES, 0.25f);

		CompostingChanceRegistry.INSTANCE.add(ModBlocks.BROMELIAD, 0.25f);
		CompostingChanceRegistry.INSTANCE.add(ModBlocks.SPORECAP, 0.25f);

		ModWorldGeneration.generateModWorldGen();



	}
}