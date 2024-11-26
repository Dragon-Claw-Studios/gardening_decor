package com.dragonclaw.gardening_decor.common.registry;

import com.dragonclaw.gardening_decor.GardeningDecor;
import com.google.common.base.Suppliers;
import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrarManager;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;


import java.util.function.Supplier;

public class ModItems {
	// We can use this if we don't want to use DeferredRegister
	public static final Supplier<RegistrarManager> REGISTRIES = Suppliers.memoize(() -> RegistrarManager.get(GardeningDecor.MOD_ID));

	// Registering a new creative tab
	public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(GardeningDecor.MOD_ID, Registries.CREATIVE_MODE_TAB);
	public static final RegistrySupplier<CreativeModeTab> GARDENING_DECOR_TAB = TABS.register("gardening_decor_tab", () ->
		CreativeTabRegistry.create(Component.translatable("Gardening Decor"),
			() -> new ItemStack(ModItems.EXAMPLE_ITEM.get())));
    
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(GardeningDecor.MOD_ID, Registries.ITEM);

	// Register Items

	public static final RegistrySupplier<Item> EXAMPLE_ITEM = ITEMS.register("example_item", () ->
		new Item(new Item.Properties().arch$tab(ModItems.GARDENING_DECOR_TAB)));
            
	public static final RegistrySupplier<Item> EXAMPLE_ITEM_TWO = ITEMS.register("example_item_two", () ->
		new Item(new Item.Properties().arch$tab(ModItems.GARDENING_DECOR_TAB)));
}
