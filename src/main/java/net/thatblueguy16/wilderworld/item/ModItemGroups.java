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
