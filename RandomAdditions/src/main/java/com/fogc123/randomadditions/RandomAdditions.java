package com.fogc123.randomadditions;


import com.fogc123.randomadditions.blocks.ModBlocks;
import com.fogc123.randomadditions.items.ModItems;
import com.fogc123.randomadditions.tilentities.ModTileEntities;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;

import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(RandomAdditions.MODID)
public class RandomAdditions
{
    public static final String MODID = "randomadditions";
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public RandomAdditions()
    {
        final IEventBus modeventbus = FMLJavaModLoadingContext.get().getModEventBus();
        ModItems.ITEMS.register(modeventbus);
        ModBlocks.BLOCKS.register(modeventbus);
        ModTileEntities.TILE_ENTITIES.register(modeventbus);
    }

}
