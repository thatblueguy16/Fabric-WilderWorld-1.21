package net.thatblueguy16.wilderworld.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.thatblueguy16.wilderworld.WilderWorld;

public class ModItems {
    public static final Item PLANT_FIBER = registerItem( "plant_fiber", new Item( new Item.Settings()));
    public static final Item SAPPHIRE = registerItem( "sapphire", new Item( new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(WilderWorld.MOD_ID, name), item);
    }

    public static void registerModItems() {
        WilderWorld.LOGGER.info("Regsitering Mod Items for " + WilderWorld.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(PLANT_FIBER);
            entries.add(SAPPHIRE);
        });

    }
}
