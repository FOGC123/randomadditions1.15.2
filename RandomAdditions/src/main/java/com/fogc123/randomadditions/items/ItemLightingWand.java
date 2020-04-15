package com.fogc123.randomadditions.items;

import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class ItemLightingWand extends Item {
    public ItemLightingWand()
    {
        super(new Item.Properties().maxDamage(150));
    }
    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn)
    {
        ItemStack stack = playerIn.getHeldItem(handIn);
        Vec3d ray = playerIn.getLookVec();
        LightningBoltEntity bolt = new LightningBoltEntity(worldIn, playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ(), true);
        worldIn.addEntity(bolt);
        return ActionResult.resultSuccess(stack);

    }
}
