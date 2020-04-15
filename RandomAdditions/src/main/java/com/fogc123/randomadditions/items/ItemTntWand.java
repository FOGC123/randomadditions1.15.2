package com.fogc123.randomadditions.items;

import net.minecraft.entity.item.TNTEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class ItemTntWand extends Item {

    public ItemTntWand()
    {
        super(new Item.Properties().maxDamage(150));
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn)
    {
        ItemStack stack = playerIn.getHeldItem(handIn);
        TNTEntity tnt = new TNTEntity(worldIn, playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ(), playerIn);

        worldIn.addEntity(tnt);
        stack.damageItem(5, playerIn, new Consumer<PlayerEntity>() {
            @Override
            public void accept(PlayerEntity playerEntity) {

            }
        });
        return ActionResult.resultSuccess(stack);
    }
}
