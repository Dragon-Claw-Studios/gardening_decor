package com.dragonclaw.gardening_decor.common.registry;

import com.dragonclaw.gardening_decor.GardeningDecor;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;

import com.dragonclaw.gardening_decor.common.blocks.*;
import com.google.common.base.Function;

import java.util.HashMap;
import java.util.Map;

public class ModBlocks {

    // Example blocks defined for easy reference
    public static final String[] GRASS_BLOCKS = {"decor_grass_block_1", "decor_grass_block_2", "decor_grass_block_3"};
    public static final String[] IVY_PLANTS = {"decor_ivy_plant_1"};

    // DeferredRegister for blocks and block items
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(GardeningDecor.MOD_ID, Registries.BLOCK);
    public static final DeferredRegister<Item> BLOCK_ITEMS = DeferredRegister.create(GardeningDecor.MOD_ID, Registries.ITEM);

    // Map to hold registered blocks
    public static final Map<String, RegistrySupplier<? extends Block>> BLOCKS_MAP = new HashMap<>();

    public static void registerDecorGrassBlocks() {
        registerBlocks(GRASS_BLOCKS);
    }

    public static void registerDecorIvyPlants() {
        registerBlocks(IVY_PLANTS, DecorIvyPlant::new);
    }

    // Method to register multiple blocks
    public static void registerBlocks(String[] blockNames) {
        for (String name : blockNames) {
            RegistrySupplier<DecorGrassBlock> blockSupplier = BLOCKS.register(name, 
        		() -> new DecorGrassBlock(BlockBehaviour.Properties.copy(Blocks.GRASS_BLOCK)) // Create a new DecorGrassBlock instance
            );

            // Register the corresponding BlockItem
            @SuppressWarnings("unused")
            RegistrySupplier<BlockItem> blockItemSupplier = BLOCK_ITEMS.register(name, () ->
                new BlockItem(blockSupplier.get(), new Item.Properties()
                    .arch$tab(ModItems.GARDENING_DECOR_TAB)
                    .rarity(Rarity.COMMON)
                )
            );

            // Add to map for retrieval
            BLOCKS_MAP.put(name, blockSupplier);
        }
    }

// Overloaded method to register ivy blocks with specific Block class
public static void registerBlocks(String[] blockNames, Function<Properties, DecorIvyPlant> blockSupplier) {
    for (String name : blockNames) {
        // Provide default properties here
        RegistrySupplier<DecorIvyPlant> ivyPlantSupplier = BLOCKS.register(name, 
			() -> new DecorIvyPlant(BlockBehaviour.Properties.copy(Blocks.VINE)
				.noCollission()
				.strength(0.2f)
				.sound(SoundType.VINE)
			) // Create a new DecorGrassBlock instance
		);

        // Register the corresponding BlockItem
        @SuppressWarnings("unused")
        RegistrySupplier<BlockItem> blockItemSupplier = BLOCK_ITEMS.register(name, () ->
            new BlockItem(ivyPlantSupplier.get(), new Item.Properties()
                .arch$tab(ModItems.GARDENING_DECOR_TAB)
                .rarity(Rarity.COMMON)
            )
        );

        // Add to map for retrieval
        BLOCKS_MAP.put(name, ivyPlantSupplier);
    }
}

}
