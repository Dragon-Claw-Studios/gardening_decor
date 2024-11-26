package com.dragonclaw.gardening_decor.common.registry;

import dev.architectury.registry.client.rendering.RenderTypeRegistry;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.Block;

public class ModRenderTypes {

    // Method to register render types for example blocks
    public static void registerRenderTypes() {
        // Registering cutoutMipped for grass blocks
        for (String blockName : ModBlocks.GRASS_BLOCKS) { // Use GRASS_BLOCKS from ModBlocks
            Block block = ModBlocks.BLOCKS_MAP.get(blockName).get(); // Retrieve the block from BLOCKS_MAP
            if (block != null) {
                RenderTypeRegistry.register(RenderType.cutoutMipped(), block); // Register render type
            }
        }

        // Registering cutoutMipped for ivy plants
        for (String blockName : ModBlocks.IVY_PLANTS) { // Use IVY_PLANTS from ModBlocks
            Block block = ModBlocks.BLOCKS_MAP.get(blockName).get(); // Retrieve the block from BLOCKS_MAP
            if (block != null) {
                RenderTypeRegistry.register(RenderType.cutoutMipped(), block); // Register render type
            }
        }
    }
}
