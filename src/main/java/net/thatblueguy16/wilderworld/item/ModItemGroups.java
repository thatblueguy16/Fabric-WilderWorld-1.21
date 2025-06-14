package net.thatblueguy16.wilderworld.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.thatblueguy16.wilderworld.WilderWorld;
import net.thatblueguy16.wilderworld.block.ModBlocks;

public class ModItemGroups {
    public static final ItemGroup MISTY_MIRE_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(WilderWorld.MOD_ID, "misty_mire"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.CYPRESS_WOOD))
                    .displayName(Text.translatable("itemgroup.wilderworld.misty_mire"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.PLANT_FIBER);
                        entries.add(ModItems.SAPPHIRE);

                        entries.add(ModBlocks.CYPRESS_PLANKS);
                        entries.add(ModBlocks.CYPRESS_WOOD);

                        entries.add(ModBlocks.SAPPHIRE_ORE);
                        entries.add(ModBlocks.DEEPSLATE_SAPPHIRE_ORE);

                        entries.add(ModBlocks.SAPPHIRE_BLOCK);
                        entries.add(ModItems.MISTCALL_LANTERN);

                        entries.add(ModBlocks.CYPRESS_LOG);
                        entries.add(ModBlocks.CYPRESS_LEAVES);

                        entries.add(ModBlocks.CYPRESS_STAIR);
                        entries.add(ModBlocks.CYPRESS_SLAB);

                        entries.add(ModBlocks.CYPRESS_BUTTON);
                        entries.add(ModBlocks.CYPRESS_PRESSURE_PLATE);

                        entries.add(ModBlocks.CYPRESS_FENCE);
                        entries.add(ModBlocks.CYPRESS_FENCE_GATE);

                        entries.add(ModBlocks.CYPRESS_DOOR);
                        entries.add(ModBlocks.CYPRESS_TRAPDOOR);

                        entries.add(ModBlocks.TORMENTIUM_BLOCK);
                        entries.add(ModBlocks.RAW_TORMENTIUM_BLOCK);

                        entries.add(ModBlocks.TORMENTIUM_ORE);
                        entries.add(ModBlocks.DEEPSLATE_TORMENTIUM_ORE);

                        entries.add(ModItems.RAW_TORMENTIUM);
                        entries.add(ModItems.TORMENTIUM_INGOT);

                        entries.add(ModBlocks.MAGIC_BLOCK);
                        entries.add(ModItems.GLOWROOT_BULB);

                        entries.add(ModItems.MASHED_GLOWROOT);
                        entries.add(ModItems.PEAT_CLUMP);

                        entries.add(ModBlocks.DRIED_PEAT_BLOCK);
                        entries.add(ModItems.DRIED_PEAT_CLUMP);

                        entries.add(ModBlocks.LUMENPOD_BLOCK);
                        entries.add(ModItems.CHISEL);

                        entries.add(ModItems.TORMENTIUM_SWORD);
                        entries.add(ModItems.TORMENTIUM_PICKAXE);

                        entries.add(ModItems.TORMENTIUM_AXE);
                        entries.add(ModItems.TORMENTIUM_SHOVEL);

                        entries.add(ModItems.TORMENTIUM_HOE);
                        entries.add(ModItems.TORMENTIUM_HAMMER);

                        entries.add(ModItems.TORMENTIUM_HELMET);
                        entries.add(ModItems.TORMENTIUM_CHESTPLATE);

                        entries.add(ModItems.TORMENTIUM_LEGGINGS);
                        entries.add(ModItems.TORMENTIUM_BOOTS);

                        entries.add(ModItems.SAPPHIRE_HORSE_ARMOR);
                        entries.add(ModItems.WORLD_SMITHING_TEMPLATE);

                        entries.add(ModBlocks.CYPRESS_SAPLING);

                        entries.add(ModBlocks.STRIPPED_CYPRESS_LOG);
                        entries.add(ModBlocks.STRIPPED_CYPRESS_WOOD);




                    }).build());

    public static final ItemGroup RUSTY_STEPPE_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(WilderWorld.MOD_ID, "rusty_steppe"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.PLANT_FIBER))
                    .displayName(Text.translatable("itemgroup.wilderworld.rusty_steppe"))
                    .entries((displayContext, entries) -> {
                    }).build());

    public static void registerItemGroups() {
        WilderWorld.LOGGER.info("Registering Item Groups for" + WilderWorld.MOD_ID);
    }
}
