package net.thatblueguy16.wilderworld.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.thatblueguy16.wilderworld.block.ModBlocks;
import net.thatblueguy16.wilderworld.item.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SAPPHIRE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SAPPHIRE_ORE);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_SAPPHIRE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CYPRESS_WOOD);

        BlockStateModelGenerator.BlockTexturePool cypressPlanksPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.CYPRESS_PLANKS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CYPRESS_LOG);

        cypressPlanksPool.stairs(ModBlocks.CYPRESS_STAIR);
        cypressPlanksPool.slab(ModBlocks.CYPRESS_SLAB);

        cypressPlanksPool.button(ModBlocks.CYPRESS_BUTTON);
        cypressPlanksPool.pressurePlate(ModBlocks.CYPRESS_PRESSURE_PLATE);

        cypressPlanksPool.fence(ModBlocks.CYPRESS_FENCE);
        cypressPlanksPool.fenceGate(ModBlocks.CYPRESS_FENCE_GATE);

        blockStateModelGenerator.registerDoor(ModBlocks.CYPRESS_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.CYPRESS_TRAPDOOR);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CYPRESS_LEAVES);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TORMENTIUM_BLOCK);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_TORMENTIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_TORMENTIUM_ORE);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TORMENTIUM_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MAGIC_BLOCK);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DRIED_PEAT_BLOCK);


    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.PLANT_FIBER, Models.GENERATED);
        itemModelGenerator.register(ModItems.SAPPHIRE, Models.GENERATED);

        itemModelGenerator.register(ModItems.MISTCALL_LANTERN, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_TORMENTIUM, Models.GENERATED);

        itemModelGenerator.register(ModItems.TORMENTIUM_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.GLOWROOT_BULB, Models.GENERATED);

        itemModelGenerator.register(ModItems.MASHED_GLOWROOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.PEAT_CLUMP, Models.GENERATED);
        itemModelGenerator.register(ModItems.DRIED_PEAT_CLUMP, Models.GENERATED);



    }
}
