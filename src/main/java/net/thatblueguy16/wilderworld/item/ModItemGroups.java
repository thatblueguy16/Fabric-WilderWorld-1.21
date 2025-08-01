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
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.PEAT_CLUMP))
                    .displayName(Text.translatable("itemgroup.wilderworld.misty_mire"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.CYPRESS_PLANKS);
                        entries.add(ModBlocks.CYPRESS_WOOD);

                        entries.add(ModBlocks.CYPRESS_LOG);
                        entries.add(ModBlocks.CYPRESS_LEAVES);

                        entries.add(ModBlocks.CYPRESS_SAPLING);
                        entries.add(ModBlocks.CYPRESS_STAIR);

                        entries.add(ModBlocks.CYPRESS_SLAB);
                        entries.add(ModBlocks.CYPRESS_BUTTON);

                        entries.add(ModBlocks.CYPRESS_PRESSURE_PLATE);
                        entries.add(ModBlocks.CYPRESS_FENCE);

                        entries.add(ModBlocks.CYPRESS_FENCE_GATE);
                        entries.add(ModBlocks.CYPRESS_DOOR);

                        entries.add(ModBlocks.CYPRESS_TRAPDOOR);
                        entries.add(ModItems.PEAT_CLUMP);

                        entries.add(ModBlocks.PEAT_BLOCK);
                        entries.add(ModBlocks.DRIED_PEAT_BLOCK);

                        entries.add(ModItems.DRIED_PEAT_CLUMP);
                        entries.add(ModBlocks.STRIPPED_CYPRESS_LOG);

                        entries.add(ModBlocks.STRIPPED_CYPRESS_WOOD);
                        entries.add(ModBlocks.BROMELIAD);

                        entries.add(ModBlocks.SPORECAP);
                        entries.add(ModBlocks.SPORECAP_BLOCK);

                        entries.add(ModItems.GLOWROOT_BULB);
                        entries.add(ModItems.MASHED_GLOWROOT);

                        entries.add(ModItems.PLANT_FIBER);




                    }).build());

    public static final ItemGroup RUSTY_STEPPE_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(WilderWorld.MOD_ID, "rusty_steppe"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.DEAD_FERRUSK_LOG))
                    .displayName(Text.translatable("itemgroup.wilderworld.rusty_steppe"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.DEAD_FERRUSK_LOG);
                        entries.add(ModBlocks.FERRUSK_LOG);

                        entries.add(ModBlocks.DEAD_FERRUSK_WOOD);
                        entries.add(ModBlocks.FERRUSK_WOOD);

                        entries.add(ModBlocks.FERRUSK_SAPLING);
                        entries.add(ModBlocks.DEAD_FERRUSK_SAPLING);

                        entries.add(ModBlocks.DEAD_FERRUSK_LEAVES);
                        entries.add(ModBlocks.FERRUSK_LEAVES);


                    }).build());

    public static void registerItemGroups() {
        WilderWorld.LOGGER.info("Registering Item Groups for" + WilderWorld.MOD_ID);
    }
}
