package com.dragonclaw.gardening_decor.forge;

import com.dragonclaw.gardening_decor.GardeningDecor;

import dev.architectury.platform.forge.EventBuses;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(GardeningDecor.MOD_ID)
public final class GardeningDecorForge {
    public GardeningDecorForge() {
        // Submit our event bus to let Architectury API register our content on the right time.
        EventBuses.registerModEventBus(GardeningDecor.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());

        // Run our common setup.
        GardeningDecor.init();
    }
}
