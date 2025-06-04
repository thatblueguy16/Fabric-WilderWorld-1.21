package net.thatblueguy16.wilderworld.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.*;
import net.minecraft.item.ArmorItem;
import net.minecraft.util.Identifier;
import net.thatblueguy16.wilderworld.block.ModBlocks;
import net.thatblueguy16.wilderworld.block.custom.LumenPodBlock;
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

        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_CYPRESS_LOG).wood(ModBlocks.STRIPPED_CYPRESS_WOOD);
        blockStateModelGenerator.registerSingleton(ModBlocks.CYPRESS_LEAVES, TexturedModel.LEAVES);
        blockStateModelGenerator.registerTintableCrossBlockState(ModBlocks.CYPRESS_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);

        cypressPlanksPool.stairs(ModBlocks.CYPRESS_STAIR);
        cypressPlanksPool.slab(ModBlocks.CYPRESS_SLAB);

        cypressPlanksPool.button(ModBlocks.CYPRESS_BUTTON);
        cypressPlanksPool.pressurePlate(ModBlocks.CYPRESS_PRESSURE_PLATE);

        cypressPlanksPool.fence(ModBlocks.CYPRESS_FENCE);
        cypressPlanksPool.fenceGate(ModBlocks.CYPRESS_FENCE_GATE);

        blockStateModelGenerator.registerDoor(ModBlocks.CYPRESS_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.CYPRESS_TRAPDOOR);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TORMENTIUM_BLOCK);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_TORMENTIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_TORMENTIUM_ORE);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TORMENTIUM_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MAGIC_BLOCK);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DRIED_PEAT_BLOCK);

        Identifier lampOffIdentifier = TexturedModel.CUBE_ALL.upload(ModBlocks.LUMENPOD_BLOCK, blockStateModelGenerator.modelCollector);
        Identifier lampOnIdentifier = blockStateModelGenerator.createSubModel(ModBlocks.LUMENPOD_BLOCK, "_on", Models.CUBE_ALL, TextureMap::all);
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(ModBlocks.LUMENPOD_BLOCK)
                .coordinate(BlockStateModelGenerator.createBooleanModelMap(LumenPodBlock.CLICKED, lampOnIdentifier, lampOffIdentifier)));


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
        itemModelGenerator.register(ModItems.CHISEL, Models.GENERATED);

        itemModelGenerator.register(ModItems.TORMENTIUM_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TORMENTIUM_PICKAXE, Models.HANDHELD);

        itemModelGenerator.register(ModItems.TORMENTIUM_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TORMENTIUM_SHOVEL, Models.HANDHELD);

        itemModelGenerator.register(ModItems.TORMENTIUM_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TORMENTIUM_HAMMER, Models.HANDHELD);

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.TORMENTIUM_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.TORMENTIUM_CHESTPLATE));

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.TORMENTIUM_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.TORMENTIUM_BOOTS));

        itemModelGenerator.register(ModItems.SAPPHIRE_HORSE_ARMOR, Models.GENERATED);
        itemModelGenerator.register(ModItems.WORLD_SMITHING_TEMPLATE, Models.GENERATED);



    }
}
