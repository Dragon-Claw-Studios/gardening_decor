package com.dragonclaw.gardening_decor;

import com.dragonclaw.gardening_decor.common.registry.ModColors;
import com.dragonclaw.gardening_decor.common.registry.ModRenderTypes;

import dev.architectury.event.events.client.ClientLifecycleEvent;
import dev.architectury.platform.Platform;

public class GardeningDecorClient {

    // This method will be invoked during client setup
    public static void onClientSetup() {
        // Ensure the block is available before registering the render type
		ModRenderTypes.registerRenderTypes();
        ModColors.registerBlockColors();
		ModColors.registerItemColors();

        // If running on Fabric, you can add Fabric-specific logic here
        if (Platform.isFabric()) {
            // Fabric-specific initialization logic (if needed)
        }

        // If running on Forge, you can add Forge-specific logic here
        if (Platform.isForge()) {
            // Forge-specific initialization logic (if needed)
        }
    }

    // Register the event listener
    public static void registerClientEvents() {
        // Add a listener for the client setup event to register block colors
        ClientLifecycleEvent.CLIENT_SETUP.register(instance -> onClientSetup());
    }
}
