package com.fogc123.randomadditions.items;

import net.minecraft.block.SoundType;
import net.minecraft.client.audio.Sound;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.*;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.client.event.sound.PlaySoundEvent;

import java.util.function.Consumer;

public class ItemFireballWand extends Item {
    public ItemFireballWand()
    {
        super(new Item.Properties().maxDamage(150));
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        Vec3d aim = playerIn.getLookVec();
        ItemStack stack = playerIn.getHeldItem(handIn);
        FireballEntity fireball = new FireballEntity(worldIn, playerIn, 1, 1, 1);
        fireball.setPosition(playerIn.getPosX() + aim.x * 1.50, playerIn.getPosY() + aim.y * 2, playerIn.getPosZ() + aim.z * 1.50);

        fireball.accelerationX = aim.x * 0.1;

        fireball.accelerationY = aim.y * 0.1;

        fireball.accelerationZ = aim.z * 0.1;

        worldIn.addEntity(fireball);
        stack.damageItem(5, playerIn, new Consumer<PlayerEntity>() {
            @Override
            public void accept(PlayerEntity playerEntity) {

            }
        });
        return ActionResult.resultSuccess(playerIn.getHeldItem(handIn));

    }

}
