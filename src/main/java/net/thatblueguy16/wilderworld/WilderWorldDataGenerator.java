package net.thatblueguy16.wilderworld;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.thatblueguy16.wilderworld.datagen.*;

public class WilderWorldDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(ModBlockTagProvider::new);
		pack.addProvider(ModItemTagProvider::new);
		pack.addProvider((ModLootTableProvider::new));
		pack.addProvider(ModModelProvider::new);
		pack.addProvider(ModRecipeProvider::new);
	}
}
