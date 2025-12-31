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
        List<ItemConvertible> PEAT_SMELTABLES = List.of(ModItems.PEAT_CLUMP);

        offerSmelting(exporter, SAPPHIRE_SMELTABLES, RecipeCategory.MISC, ModItems.SAPPHIRE, .25f, 200, "sapphire");
        offerBlasting(exporter, SAPPHIRE_SMELTABLES, RecipeCategory.MISC, ModItems.SAPPHIRE, .25f, 100, "sapphire");

        offerSmelting(exporter, PEAT_SMELTABLES, RecipeCategory.MISC, ModItems.DRIED_PEAT_CLUMP, .25f, 100, "peat");

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.SAPPHIRE,RecipeCategory.DECORATIONS, ModBlocks.SAPPHIRE_BLOCK);

        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.PEAT_CLUMP,RecipeCategory.MISC, ModBlocks.PEAT_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.DRIED_PEAT_CLUMP,RecipeCategory.MISC, ModBlocks.DRIED_PEAT_BLOCK);


        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Items.STRING, 2)
                .input(ModItems.PLANT_FIBER)
                .criterion("has_plant_fiber", conditionsFromItem(ModItems.PLANT_FIBER))
                .offerTo(exporter, Identifier.of(WilderWorld.MOD_ID, "string_from_plant_fiber"));

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

    ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Blocks.MOSS_CARPET, 3)
                .pattern("   ")
                .pattern("   ")
                .pattern("xx ")
                .input('x', ModItems.PEAT_CLUMP)
                .criterion("has_peat_clump", conditionsFromItem(ModItems.PEAT_CLUMP))
                .offerTo(exporter, Identifier.of(WilderWorld.MOD_ID, "moss_carpet_from_peat_clump"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FERRUSK_DOOR, 3)
                .pattern("xx ")
                .pattern("xx ")
                .pattern("xx ")
                .input('x', ModBlocks.FERRUSK_PLANKS)
                .criterion("has_ferrusk_planks", conditionsFromItem(ModBlocks.FERRUSK_PLANKS))
                .offerTo(exporter, Identifier.of(WilderWorld.MOD_ID, "ferrusk_door_from_ferrusk_planks"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FERRUSK_STAIR, 4)
                .pattern("x  ")
                .pattern("xx ")
                .pattern("xxx")
                .input('x', ModBlocks.FERRUSK_PLANKS)
                .criterion("has_ferrusk_planks", conditionsFromItem(ModBlocks.FERRUSK_PLANKS))
                .offerTo(exporter, Identifier.of(WilderWorld.MOD_ID, "ferrusk_stair_from_ferrusk_planks"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FERRUSK_TRAPDOOR, 2)
                .pattern("   ")
                .pattern("xxx")
                .pattern("xxx")
                .input('x', ModBlocks.FERRUSK_PLANKS)
                .criterion("has_ferrusk_planks", conditionsFromItem(ModBlocks.FERRUSK_PLANKS))
                .offerTo(exporter, Identifier.of(WilderWorld.MOD_ID, "ferrusk_trapdoor_from_ferrusk_planks"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FERRUSK_SLAB, 6)
                .pattern("   ")
                .pattern("   ")
                .pattern("xxx")
                .input('x', ModBlocks.FERRUSK_PLANKS)
                .criterion("has_ferrusk_planks", conditionsFromItem(ModBlocks.FERRUSK_PLANKS))
                .offerTo(exporter, Identifier.of(WilderWorld.MOD_ID, "ferrusk_slab_from_ferrusk_planks"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FERRUSK_FENCE, 3)
                .pattern("   ")
                .pattern("xrx")
                .pattern("xrx")
                .input('x', ModBlocks.FERRUSK_PLANKS)
                .input('r',Items.STICK)
                .criterion("has_ferrusk_planks", conditionsFromItem(ModBlocks.FERRUSK_PLANKS))
                .criterion("has_stick", conditionsFromItem(Items.STICK))
                .offerTo(exporter, Identifier.of(WilderWorld.MOD_ID, "ferrusk_fence_from_ferrusk_planks"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FERRUSK_FENCE_GATE, 1)
                .pattern("   ")
                .pattern("rxr")
                .pattern("rxr")
                .input('x', ModBlocks.FERRUSK_PLANKS)
                .input('r',Items.STICK)
                .criterion("has_ferrusk_planks", conditionsFromItem(ModBlocks.FERRUSK_PLANKS))
                .criterion("has_stick", conditionsFromItem(Items.STICK))
                .offerTo(exporter, Identifier.of(WilderWorld.MOD_ID, "ferrusk_fence_gate_from_ferrusk_planks"));


        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FERRUSK_PRESSURE_PLATE, 2)
                .pattern("   ")
                .pattern("   ")
                .pattern("xx ")
                .input('x', ModBlocks.FERRUSK_PLANKS)
                .criterion("has_ferrusk_planks", conditionsFromItem(ModBlocks.FERRUSK_PLANKS))
                .offerTo(exporter, Identifier.of(WilderWorld.MOD_ID, "ferrusk_pressure_plate_from_ferrusk_planks"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FERRUSK_BUTTON, 1)
                .input(ModBlocks.FERRUSK_PLANKS)
                .criterion("has_ferrusk_planks", conditionsFromItem(ModBlocks.FERRUSK_PLANKS))
                .offerTo(exporter, Identifier.of(WilderWorld.MOD_ID, "ferrusk_button_from_ferrusk_planks"));

ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DEAD_FERRUSK_DOOR, 3)
                .pattern("xx ")
                .pattern("xx ")
                .pattern("xx ")
                .input('x', ModBlocks.DEAD_FERRUSK_PLANKS)
                .criterion("has_dead_ferrusk_planks", conditionsFromItem(ModBlocks.DEAD_FERRUSK_PLANKS))
                .offerTo(exporter, Identifier.of(WilderWorld.MOD_ID, "dead_ferrusk_door_from_dead_ferrusk_planks"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DEAD_FERRUSK_STAIR, 4)
                .pattern("x  ")
                .pattern("xx ")
                .pattern("xxx")
                .input('x', ModBlocks.DEAD_FERRUSK_PLANKS)
                .criterion("has_dead_ferrusk_planks", conditionsFromItem(ModBlocks.DEAD_FERRUSK_PLANKS))
                .offerTo(exporter, Identifier.of(WilderWorld.MOD_ID, "dead_ferrusk_stair_from_dead_ferrusk_planks"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DEAD_FERRUSK_TRAPDOOR, 2)
                .pattern("   ")
                .pattern("xxx")
                .pattern("xxx")
                .input('x', ModBlocks.DEAD_FERRUSK_PLANKS)
                .criterion("has_dead_ferrusk_planks", conditionsFromItem(ModBlocks.DEAD_FERRUSK_PLANKS))
                .offerTo(exporter, Identifier.of(WilderWorld.MOD_ID, "dead_ferrusk_trapdoor_from_dead_ferrusk_planks"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DEAD_FERRUSK_SLAB, 6)
                .pattern("   ")
                .pattern("   ")
                .pattern("xxx")
                .input('x', ModBlocks.DEAD_FERRUSK_PLANKS)
                .criterion("has_dead_ferrusk_planks", conditionsFromItem(ModBlocks.DEAD_FERRUSK_PLANKS))
                .offerTo(exporter, Identifier.of(WilderWorld.MOD_ID, "dead_ferrusk_slab_from_dead_ferrusk_planks"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DEAD_FERRUSK_FENCE, 3)
                .pattern("   ")
                .pattern("xrx")
                .pattern("xrx")
                .input('x', ModBlocks.DEAD_FERRUSK_PLANKS)
                .input('r',Items.STICK)
                .criterion("has_dead_ferrusk_planks", conditionsFromItem(ModBlocks.DEAD_FERRUSK_PLANKS))
                .criterion("has_stick", conditionsFromItem(Items.STICK))
                .offerTo(exporter, Identifier.of(WilderWorld.MOD_ID, "dead_ferrusk_fence_from_dead_ferrusk_planks"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DEAD_FERRUSK_FENCE_GATE, 1)
                .pattern("   ")
                .pattern("rxr")
                .pattern("rxr")
                .input('x', ModBlocks.DEAD_FERRUSK_PLANKS)
                .input('r',Items.STICK)
                .criterion("has_dead_ferrusk_planks", conditionsFromItem(ModBlocks.DEAD_FERRUSK_PLANKS))
                .criterion("has_stick", conditionsFromItem(Items.STICK))
                .offerTo(exporter, Identifier.of(WilderWorld.MOD_ID, "dead_ferrusk_fence_gate_from_dead_ferrusk_planks"));


        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DEAD_FERRUSK_PRESSURE_PLATE, 2)
                .pattern("   ")
                .pattern("   ")
                .pattern("xx ")
                .input('x', ModBlocks.DEAD_FERRUSK_PLANKS)
                .criterion("has_dead_ferrusk_planks", conditionsFromItem(ModBlocks.DEAD_FERRUSK_PLANKS))
                .offerTo(exporter, Identifier.of(WilderWorld.MOD_ID, "dead_ferrusk_pressure_plate_from_dead_ferrusk_planks"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DEAD_FERRUSK_BUTTON, 1)
                .input(ModBlocks.DEAD_FERRUSK_PLANKS)
                .criterion("has_dead_ferrusk_planks", conditionsFromItem(ModBlocks.DEAD_FERRUSK_PLANKS))
                .offerTo(exporter, Identifier.of(WilderWorld.MOD_ID, "dead_ferrusk_button_from_dead_ferrusk_planks"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.LAVENDER_DYE, 2)
                .input(ModBlocks.MILKWEED_LAVENDER)
                .criterion("has_milkweed_lavender", conditionsFromItem(ModBlocks.MILKWEED_LAVENDER))
                .offerTo(exporter, Identifier.of(WilderWorld.MOD_ID, "lavender_dye_from_milkweed_lavender"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Items.LIGHT_BLUE_DYE, 2)
                .input(ModBlocks.MILKWEED_TEAL)
                .criterion("has_milkweed_teal", conditionsFromItem(ModBlocks.MILKWEED_TEAL))
                .offerTo(exporter, Identifier.of(WilderWorld.MOD_ID, "teal_dye_from_milkweed_teal"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Items.YELLOW_DYE, 2)
                .input(ModBlocks.MILKWEED_YELLOW)
                .criterion("has_milkweed_yellow", conditionsFromItem(ModBlocks.MILKWEED_YELLOW))
                .offerTo(exporter, Identifier.of(WilderWorld.MOD_ID, "yellow_dye_from_milkweed_yellow"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Items.PINK_DYE, 2)
                .input(ModBlocks.MILKWEED)
                .criterion("has_milkweed", conditionsFromItem(ModBlocks.MILKWEED))
                .offerTo(exporter, Identifier.of(WilderWorld.MOD_ID, "pink_dye_from_milkweed"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Items.BLUE_DYE, 2)
                .input(ModBlocks.MILKWEED_BLUE)
                .criterion("has_milkweed_blue", conditionsFromItem(ModBlocks.MILKWEED_BLUE))
                .offerTo(exporter, Identifier.of(WilderWorld.MOD_ID, "blue_dye_from_milkweed_blue"));








    }
}
