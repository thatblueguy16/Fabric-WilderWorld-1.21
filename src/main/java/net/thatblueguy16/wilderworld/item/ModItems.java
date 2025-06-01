package net.thatblueguy16.wilderworld.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.thatblueguy16.wilderworld.WilderWorld;
import net.thatblueguy16.wilderworld.item.custom.LanternItem;

public class ModItems {
    public static final Item PLANT_FIBER = registerItem( "plant_fiber", new Item( new Item.Settings()));
    public static final Item SAPPHIRE = registerItem( "sapphire", new Item( new Item.Settings()));

    public static final Item MISTCALL_LANTERN = registerItem("mistcall_lantern",new LanternItem(new Item.Settings().maxDamage(32)));
    public static final Item TORMENTIUM_INGOT = registerItem("tormentium_ingot", new Item(new Item.Settings()));

    public static final Item RAW_TORMENTIUM = registerItem("raw_tormentium", new Item(new Item.Settings()));
    public static final Item GLOWROOT_BULB = registerItem("glowroot_bulb", new Item(new Item.Settings().food(ModFoodComponents.GLOWROOT_BULB)));

    public static final Item MASHED_GLOWROOT = registerItem("mashed_glowroot", new Item(new Item.Settings().food(ModFoodComponents.MASHED_GLOWROOT)));
    public static final Item PEAT_CLUMP = registerItem("peat_clump", new Item(new Item.Settings()));
    public static final Item DRIED_PEAT_CLUMP = registerItem("dried_peat_clump", new Item(new Item.Settings().food(ModFoodComponents.DRIED_PEAT_CLUMP)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(WilderWorld.MOD_ID, name), item);
    }

    public static void registerModItems() {
        WilderWorld.LOGGER.info("Registering Mod Items for " + WilderWorld.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(PLANT_FIBER);
            entries.add(SAPPHIRE);
        });

    }
}
