package com.dragonclaw.gardening_decor.fabric;

import net.fabricmc.loader.api.FabricLoader;

import java.nio.file.Path;

import com.dragonclaw.gardening_decor.GardeningDecorExpectPlatform;

public class GardeningDecorExpectPlatformImpl {
    /**
     * This is our actual method to {@link GardeningDecorExpectPlatform#getConfigDirectory()}.
     */
    public static Path getConfigDirectory() {
        return FabricLoader.getInstance().getConfigDir();
    }
}
