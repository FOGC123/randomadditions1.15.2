package com.fogc123.randomadditions.items;

import com.fogc123.randomadditions.RandomAdditions;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, RandomAdditions.MODID);

    public static final RegistryObject ITEM_FIREBALL_WAND = ITEMS.register("fireball_wand", () -> new ItemFireballWand());
    public static final RegistryObject ITEM_TNT_WAND = ITEMS.register("tnt_wand", () -> new ItemTntWand());
    public static final RegistryObject ITEM_LIGHTNING_WAND = ITEMS.register("lighting_wand", () -> new ItemLightingWand());
}
