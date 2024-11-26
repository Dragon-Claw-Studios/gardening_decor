package com.dragonclaw.gardening_decor.common.registry;

import dev.architectury.registry.client.rendering.ColorHandlerRegistry;
import net.minecraft.client.color.block.BlockColor;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.world.level.GrassColor;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.world.item.BlockItem;

public class ModColors {

    // Define an array of block names to register colors for
    private static final String[] GRASS_BLOCKS = ModBlocks.GRASS_BLOCKS;

    public static void registerBlockColors() {
        for (String blockName : GRASS_BLOCKS) {
            BlockColor exampleBlockColor = (blockState, blockAndTintGetter, blockPos, tintIndex) -> {
                if (blockAndTintGetter != null && blockPos != null) {
                    return BiomeColors.getAverageGrassColor(blockAndTintGetter, blockPos);
                }
                return GrassColor.getDefaultColor();
            };

            // Register the color for each block by name
            ColorHandlerRegistry.registerBlockColors(exampleBlockColor, ModBlocks.BLOCKS_MAP.get(blockName).get());
        }
    }

    public static void registerItemColors() {
        for (String blockName : GRASS_BLOCKS) {
            ItemColor exampleItemColor = (stack, tintIndex) -> {
                // If the item is a BlockItem, retrieve the block color
                if (stack.getItem() instanceof BlockItem) {
                    // You can also use the same logic as for block colors
                    return GrassColor.getDefaultColor();
                }
                return -1; // Default color (untinted)
            };

            // Register the color for each block item's corresponding item
            ColorHandlerRegistry.registerItemColors(exampleItemColor, ModBlocks.BLOCKS_MAP.get(blockName).get().asItem());
        }
    }
}
