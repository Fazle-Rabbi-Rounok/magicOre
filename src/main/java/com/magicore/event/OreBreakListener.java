package com.magicore.event;

import com.magicore.MagicOre;
import com.magicore.manager.OreManager;
import com.magicore.loot.LootManager;

import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;

import net.minecraft.core.BlockPos;

import net.minecraft.server.level.ServerLevel;

import net.minecraft.world.entity.player.Player;

import net.minecraft.world.level.Level;

import net.minecraft.world.level.block.Block;

import net.minecraft.world.level.block.entity.BlockEntity;

import net.minecraft.world.level.block.state.BlockState;

public final class OreBreakListener {

    private OreBreakListener() {
    }

    public static void register() {

        PlayerBlockBreakEvents.AFTER.register(
                OreBreakListener::onBlockBroken
        );

    }

    private static void onBlockBroken(Level level,
                                      Player player,
                                      BlockPos pos,
                                      BlockState state,
                                      BlockEntity blockEntity) {

        Block block = state.getBlock();

        if (!OreManager.isMagicOre(block)) {
            return;
        }

        MagicOre.LOGGER.info(
                "{} mined {}",
                player.getName().getString(),
                block.getName().getString()
        );

        if (level instanceof ServerLevel serverLevel) {
            LootManager.dropLoot(serverLevel, pos, block);
        }
    }
}
