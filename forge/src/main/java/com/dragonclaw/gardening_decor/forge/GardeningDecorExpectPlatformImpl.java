package com.dragonclaw.gardening_decor.forge;

import net.minecraftforge.fml.loading.FMLPaths;

import java.nio.file.Path;

import com.dragonclaw.gardening_decor.GardeningDecorExpectPlatform;

public class GardeningDecorExpectPlatformImpl {
    /**
     * This is our actual method to {@link GardeningDecorExpectPlatform#getConfigDirectory()}.
     */
    public static Path getConfigDirectory() {
        return FMLPaths.CONFIGDIR.get();
    }
}
