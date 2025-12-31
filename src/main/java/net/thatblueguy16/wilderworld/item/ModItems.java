package net.thatblueguy16.wilderworld.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.thatblueguy16.wilderworld.WilderWorld;
import net.thatblueguy16.wilderworld.block.ModBlocks;
import net.thatblueguy16.wilderworld.entity.ModEntities;
import net.thatblueguy16.wilderworld.item.custom.ChiselItem;
import net.thatblueguy16.wilderworld.item.custom.LanternItem;

import java.util.List;

public class ModItems {
    public static final Item PLANT_FIBER = registerItem( "plant_fiber", new Item( new Item.Settings()));
    public static final Item SAPPHIRE = registerItem( "sapphire", new Item( new Item.Settings()));

    public static final Item MISTCALL_LANTERN = registerItem("mistcall_lantern",new LanternItem(new Item.Settings().maxDamage(32)));
    public static final Item GLOWROOT = registerItem("glowroot",
            new AliasedBlockItem(ModBlocks.GLOWROOT_CROP, new Item.Settings().food(ModFoodComponents.GLOWROOT)) {
            });

    public static final Item PEAT_CLUMP = registerItem("peat_clump", new Item(new Item.Settings()));
    public static final Item DRIED_PEAT_CLUMP = registerItem("dried_peat_clump", new Item(new Item.Settings().food(ModFoodComponents.DRIED_PEAT_CLUMP)){
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip.wilderworld.dried_peat_clump.tooltip"));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });

    public static final Item LAVENDER_DYE = registerItem( "lavender_dye", new Item(new Item.Settings()));

    public static final Item SCUTTLE_TAIL_SPAWN_EGG = registerItem("scuttle_tail_spawn_egg",
            new SpawnEggItem(ModEntities.ScuttleTail, 0x263b24, 0xb9eeb4, new Item.Settings()));

 public static final Item BOG_MAW_SPAWN_EGG = registerItem("bog_maw_spawn_egg",
            new SpawnEggItem(ModEntities.BogMaw, 0x4f3a2e, 0x382e27, new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(WilderWorld.MOD_ID, name), item);
    }

    public static void registerModItems() {
        WilderWorld.LOGGER.info("Registering Mod Items for " + WilderWorld.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {

        });

    }
}
