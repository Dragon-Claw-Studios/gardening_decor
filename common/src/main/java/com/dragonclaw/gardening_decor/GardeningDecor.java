package com.dragonclaw.gardening_decor;

import dev.architectury.platform.Platform;
import dev.architectury.utils.Env;
import com.dragonclaw.gardening_decor.common.registry.*;

public class GardeningDecor {
    public static final String MOD_ID = "gardening_decor";

    public static void init() {
        // First, register blocks and items
        ModItems.TABS.register();
        ModBlocks.registerDecorGrassBlocks(); // Register your grass blocks here
		ModBlocks.registerDecorIvyPlants();
        ModBlocks.BLOCKS.register(); // Register blocks
		ModBlocks.BLOCK_ITEMS.register(); // Register blocks
        ModItems.ITEMS.register(); // Register items
        
        // After blocks and items are registered, register the client setup event
        if (Platform.getEnvironment() == Env.CLIENT) {
            // Register the client setup event to ensure the proper lifecycle stage
            GardeningDecorClient.registerClientEvents();
        }
    }
}
