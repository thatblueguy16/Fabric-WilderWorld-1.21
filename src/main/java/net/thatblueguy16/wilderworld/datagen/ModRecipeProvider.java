package net.thatblueguy16.wilderworld.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.ShapedRecipe;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;
import net.thatblueguy16.wilderworld.WilderWorld;
import net.thatblueguy16.wilderworld.block.ModBlocks;
import net.thatblueguy16.wilderworld.item.ModItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        List<ItemConvertible> SAPPHIRE_SMELTABLES = List.of(ModBlocks.SAPPHIRE_ORE, ModBlocks.DEEPSLATE_SAPPHIRE_ORE);
        List<ItemConvertible> TORMENTIUM_SMELTABLES = List.of(ModBlocks.TORMENTIUM_ORE, ModBlocks.DEEPSLATE_TORMENTIUM_ORE, ModItems.RAW_TORMENTIUM);
        List<ItemConvertible> PEAT_SMELTABLES = List.of(ModItems.PEAT_CLUMP);

        offerSmelting(exporter, SAPPHIRE_SMELTABLES, RecipeCategory.MISC, ModItems.SAPPHIRE, .25f, 200, "sapphire");
        offerBlasting(exporter, SAPPHIRE_SMELTABLES, RecipeCategory.MISC, ModItems.SAPPHIRE, .25f, 100, "sapphire");

        offerSmelting(exporter, TORMENTIUM_SMELTABLES, RecipeCategory.MISC, ModItems.TORMENTIUM_INGOT, .5f, 200, "tormentium");
        offerBlasting(exporter, TORMENTIUM_SMELTABLES, RecipeCategory.MISC, ModItems.TORMENTIUM_INGOT, .5f, 200, "tormentium");

        offerSmelting(exporter, PEAT_SMELTABLES, RecipeCategory.MISC, ModItems.DRIED_PEAT_CLUMP, .25f, 100, "peat");


        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.SAPPHIRE,RecipeCategory.DECORATIONS, ModBlocks.SAPPHIRE_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.TORMENTIUM_INGOT,RecipeCategory.DECORATIONS, ModBlocks.TORMENTIUM_BLOCK);

        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.PEAT_CLUMP,RecipeCategory.MISC, Blocks.MOSS_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.RAW_TORMENTIUM,RecipeCategory.DECORATIONS, ModBlocks.RAW_TORMENTIUM_BLOCK);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Items.STRING, 2)
                .input(ModItems.PLANT_FIBER)
                .criterion("has_plant_fiber", conditionsFromItem(ModItems.PLANT_FIBER))
                .offerTo(exporter, Identifier.of(WilderWorld.MOD_ID, "string_from_plant_fiber"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CYPRESS_PLANKS, 4)
                .input(ModBlocks.CYPRESS_LOG)
                .criterion("has_cypress_log", conditionsFromItem(ModBlocks.CYPRESS_LOG))
                .offerTo(exporter, Identifier.of(WilderWorld.MOD_ID, "cypress_planks_from_cypress_log"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CYPRESS_PLANKS, 4)
                .input(ModBlocks.CYPRESS_WOOD)
                .criterion("has_cypress_wood", conditionsFromItem(ModBlocks.CYPRESS_WOOD))
                .offerTo(exporter, Identifier.of(WilderWorld.MOD_ID, "cypress_planks_from_cypress_wood"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Blocks.CRAFTING_TABLE, 1)
                .pattern("   ")
                .pattern("xx ")
                .pattern("xx ")
                .input('x', ModBlocks.CYPRESS_PLANKS)
                .criterion("has_cypress_planks", conditionsFromItem(ModBlocks.CYPRESS_PLANKS))
                .offerTo(exporter, Identifier.of(WilderWorld.MOD_ID, "crafting_table_from_cypress_planks"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CYPRESS_DOOR, 3)
                .pattern("xx ")
                .pattern("xx ")
                .pattern("xx ")
                .input('x', ModBlocks.CYPRESS_PLANKS)
                .criterion("has_cypress_planks", conditionsFromItem(ModBlocks.CYPRESS_PLANKS))
                .offerTo(exporter, Identifier.of(WilderWorld.MOD_ID, "cypress_door_from_cypress_planks"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CYPRESS_STAIR, 4)
                .pattern("x  ")
                .pattern("xx ")
                .pattern("xxx")
                .input('x', ModBlocks.CYPRESS_PLANKS)
                .criterion("has_cypress_planks", conditionsFromItem(ModBlocks.CYPRESS_PLANKS))
                .offerTo(exporter, Identifier.of(WilderWorld.MOD_ID, "cypress_stair_from_cypress_planks"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CYPRESS_TRAPDOOR, 2)
                .pattern("   ")
                .pattern("xxx")
                .pattern("xxx")
                .input('x', ModBlocks.CYPRESS_PLANKS)
                .criterion("has_cypress_planks", conditionsFromItem(ModBlocks.CYPRESS_PLANKS))
                .offerTo(exporter, Identifier.of(WilderWorld.MOD_ID, "cypress_trapdoor_from_cypress_planks"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CYPRESS_SLAB, 6)
                .pattern("   ")
                .pattern("   ")
                .pattern("xxx")
                .input('x', ModBlocks.CYPRESS_PLANKS)
                .criterion("has_cypress_planks", conditionsFromItem(ModBlocks.CYPRESS_PLANKS))
                .offerTo(exporter, Identifier.of(WilderWorld.MOD_ID, "cypress_slab_from_cypress_planks"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CYPRESS_FENCE, 3)
                .pattern("   ")
                .pattern("xrx")
                .pattern("xrx")
                .input('x', ModBlocks.CYPRESS_PLANKS)
                .input('r',Items.STICK)
                .criterion("has_cypress_planks", conditionsFromItem(ModBlocks.CYPRESS_PLANKS))
                    .criterion("has_stick", conditionsFromItem(Items.STICK))
                .offerTo(exporter, Identifier.of(WilderWorld.MOD_ID, "cypress_fence_from_cypress_planks"));

                ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CYPRESS_FENCE_GATE, 1)
                .pattern("   ")
                .pattern("rxr")
                .pattern("rxr")
                .input('x', ModBlocks.CYPRESS_PLANKS)
                .input('r',Items.STICK)
                .criterion("has_cypress_planks", conditionsFromItem(ModBlocks.CYPRESS_PLANKS))
                        .criterion("has_stick", conditionsFromItem(Items.STICK))
                .offerTo(exporter, Identifier.of(WilderWorld.MOD_ID, "cypress_fence_gate_from_cypress_planks"));


        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CYPRESS_PRESSURE_PLATE, 2)
                .pattern("   ")
                .pattern("   ")
                .pattern("xx ")
                .input('x', ModBlocks.CYPRESS_PLANKS)
                .criterion("has_cypress_planks", conditionsFromItem(ModBlocks.CYPRESS_PLANKS))
                .offerTo(exporter, Identifier.of(WilderWorld.MOD_ID, "cypress_pressure_plate_from_cypress_planks"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CYPRESS_BUTTON, 1)
                .input(ModBlocks.CYPRESS_PLANKS)
                .criterion("has_cypress_planks", conditionsFromItem(ModBlocks.CYPRESS_PLANKS))
                .offerTo(exporter, Identifier.of(WilderWorld.MOD_ID, "cypress_button_from_cypress_planks"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.STICK, 4)
                .pattern("   ")
                .pattern("x  ")
                .pattern("x  ")
                .input('x', ModBlocks.CYPRESS_PLANKS)
                .criterion("has_cypress_planks", conditionsFromItem(ModBlocks.CYPRESS_PLANKS))
                .offerTo(exporter, Identifier.of(WilderWorld.MOD_ID, "stick_from_cypress_planks"));

    ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CYPRESS_WOOD, 3)
                .pattern("   ")
                .pattern("xx ")
                .pattern("xx ")
                .input('x', ModBlocks.CYPRESS_LOG)
                .criterion("has_cypress_log", conditionsFromItem(ModBlocks.CYPRESS_LOG))
                .offerTo(exporter, Identifier.of(WilderWorld.MOD_ID, "cypress_wood_from_cypress_log"));

    ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Blocks.MOSS_CARPET, 3)
                .pattern("   ")
                .pattern("   ")
                .pattern("xx ")
                .input('x', ModItems.PEAT_CLUMP)
                .criterion("has_peat_clump", conditionsFromItem(ModItems.PEAT_CLUMP))
                .offerTo(exporter, Identifier.of(WilderWorld.MOD_ID, "moss_carpet_from_peat_clump"));

    ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.DRIED_PEAT_BLOCK, 1)
                .pattern("xxx")
                .pattern("rrr")
                .pattern("xxx")
                .input('x', ModItems.DRIED_PEAT_CLUMP)
                .input('r', ModItems.PLANT_FIBER)
                .criterion("has_dried_peat_clump", conditionsFromItem(ModItems.DRIED_PEAT_CLUMP))
                .criterion("has_plant_fiber", conditionsFromItem(ModItems.PLANT_FIBER))
                .offerTo(exporter, Identifier.of(WilderWorld.MOD_ID, "dried_peat_block_recipe"));

ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.TORMENTIUM_SWORD, 1)
                .pattern(" x ")
                .pattern(" x ")
                .pattern(" r ")
                .input('x', ModItems.TORMENTIUM_INGOT)
                .input('r', Items.STICK)
                .criterion("has+tormentium_ingot", conditionsFromItem(ModItems.TORMENTIUM_INGOT))
                .criterion("has_stick", conditionsFromItem(Items.STICK))
                .offerTo(exporter, Identifier.of(WilderWorld.MOD_ID, "tormentium_sword_recipe"));

ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.TORMENTIUM_PICKAXE, 1)
                .pattern("xxx")
                .pattern(" r ")
                .pattern(" r ")
                .input('x', ModItems.TORMENTIUM_INGOT)
                .input('r', Items.STICK)
                .criterion("has+tormentium_ingot", conditionsFromItem(ModItems.TORMENTIUM_INGOT))
                .criterion("has_stick", conditionsFromItem(Items.STICK))
                .offerTo(exporter, Identifier.of(WilderWorld.MOD_ID, "tormentium_pickaxe_recipe"));

ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.TORMENTIUM_AXE, 1)
                .pattern("xx ")
                .pattern("xr ")
                .pattern(" r ")
                .input('x', ModItems.TORMENTIUM_INGOT)
                .input('r', Items.STICK)
                .criterion("has+tormentium_ingot", conditionsFromItem(ModItems.TORMENTIUM_INGOT))
                .criterion("has_stick", conditionsFromItem(Items.STICK))
                .offerTo(exporter, Identifier.of(WilderWorld.MOD_ID, "tormentium_axe_recipe"));

ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.TORMENTIUM_SHOVEL, 1)
                .pattern(" x ")
                .pattern(" r ")
                .pattern(" r ")
                .input('x', ModItems.TORMENTIUM_INGOT)
                .input('r', Items.STICK)
                .criterion("has+tormentium_ingot", conditionsFromItem(ModItems.TORMENTIUM_INGOT))
                .criterion("has_stick", conditionsFromItem(Items.STICK))
                .offerTo(exporter, Identifier.of(WilderWorld.MOD_ID, "tormentium_shovel_recipe"));

ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.TORMENTIUM_HOE, 1)
                .pattern("xx ")
                .pattern(" r ")
                .pattern(" r ")
                .input('x', ModItems.TORMENTIUM_INGOT)
                .input('r', Items.STICK)
                .criterion("has+tormentium_ingot", conditionsFromItem(ModItems.TORMENTIUM_INGOT))
                .criterion("has_stick", conditionsFromItem(Items.STICK))
                .offerTo(exporter, Identifier.of(WilderWorld.MOD_ID, "tormentium_hoe_recipe"));

ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.MISTCALL_LANTERN, 1)
                .pattern("cxc")
                .pattern("crc")
                .pattern("cxc")
                .input('x', ModItems.TORMENTIUM_INGOT)
                .input('r', ModBlocks.LUMENPOD_BLOCK)
                .input('c', Items.COPPER_INGOT)
                .criterion("has_tormentium_ingot", conditionsFromItem(ModItems.TORMENTIUM_INGOT))
                .criterion("has_lumenpod_block", conditionsFromItem(ModBlocks.LUMENPOD_BLOCK))
                .criterion("has_copper_ingot", conditionsFromItem(Items.COPPER_INGOT))
                .offerTo(exporter, Identifier.of(WilderWorld.MOD_ID, "mistcall_lantern_recipe"));

ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.TORMENTIUM_HAMMER, 1)
                .pattern("xxx")
                .pattern("xrx")
                .pattern(" c ")
                .input('x', ModItems.TORMENTIUM_INGOT)
                .input('r', Items.NETHERITE_INGOT)
                .input('c', Items.STICK)
                .criterion("has_tormentium_ingot", conditionsFromItem(ModItems.TORMENTIUM_INGOT))
                .criterion("has_netherite_ingot", conditionsFromItem(Items.NETHERITE_INGOT))
                .criterion("has_stich", conditionsFromItem(Items.STICK))
                .offerTo(exporter, Identifier.of(WilderWorld.MOD_ID, "tormentium_hammer_recipe"));




    }
}
