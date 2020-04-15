package com.fogc123.randomadditions.blocks;

import com.fogc123.randomadditions.RandomAdditions;
import net.minecraft.block.Block;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, RandomAdditions.MODID);

    public static final RegistryObject WAND_INFUSER = BLOCKS.register("wand_infuser", () -> new BlockWandInfuser());

}
