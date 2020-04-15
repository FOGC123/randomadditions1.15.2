package com.fogc123.randomadditions.tilentities;

import com.fogc123.randomadditions.RandomAdditions;
import com.fogc123.randomadditions.blocks.ModBlocks;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModTileEntities {
    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITIES = new DeferredRegister<>(ForgeRegistries.TILE_ENTITIES, RandomAdditions.MODID);

    public static final RegistryObject<TileEntityType<TileEntityWandInfuser>> WAND_INFUSER = TILE_ENTITIES.register("firstblock", () -> TileEntityType.Builder.create(TileEntityWandInfuser::new, ModBlocks.WAND_INFUSER).build(null));
}
