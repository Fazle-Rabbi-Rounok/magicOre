package com.magicore.loot;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.ArrayList;
import java.util.List;

public final class LootManager {

    private LootManager() {
    }

    public static void dropLoot(ServerLevel level, BlockPos pos, Block block) {

        ItemStack reward = rollLoot(level.getRandom(), block);

        ItemEntity item = new ItemEntity(
                level,
                pos.getX() + 0.5,
                pos.getY() + 0.5,
                pos.getZ() + 0.5,
                reward
        );

        level.addFreshEntity(item);
    }

    private static ItemStack rollLoot(RandomSource random, Block block) {

        List<LootReward> pool = getPool(block);

        int totalWeight = 0;

        for (LootReward reward : pool) {
            totalWeight += reward.getWeight();
        }

        int roll = random.nextInt(totalWeight);

        int current = 0;

        for (LootReward reward : pool) {

            current += reward.getWeight();

            if (roll < current) {
                return reward.getItem();
            }
        }

        return new ItemStack(Items.BREAD);
    }

    private static List<LootReward> getPool(Block block) {

    List<LootReward> pool = new ArrayList<>();

    /*
     * ==========================
     * COAL ORE
     * ==========================
     */
    if (block == Blocks.COAL_ORE || block == Blocks.DEEPSLATE_COAL_ORE) {

        pool.add(new LootReward(new ItemStack(Items.BREAD, 3), 16));
        pool.add(new LootReward(new ItemStack(Items.COOKED_BEEF, 6), 14));
        pool.add(new LootReward(new ItemStack(Items.TORCH, 32), 12));
        pool.add(new LootReward(new ItemStack(Items.IRON_INGOT, 6), 12));
        pool.add(new LootReward(new ItemStack(Items.COAL, 32), 10));
        pool.add(new LootReward(new ItemStack(Items.IRON_PICKAXE), 10));
        pool.add(new LootReward(new ItemStack(Items.EMERALD, 4), 8));
        pool.add(new LootReward(new ItemStack(Items.IRON_CHESTPLATE), 8));
        pool.add(new LootReward(new ItemStack(Items.GOLDEN_APPLE), 6));
        pool.add(new LootReward(new ItemStack(Items.DIAMOND, 2), 4));

        return pool;
    }

    /*
     * ==========================
     * IRON ORE
     * ==========================
     */
    if (block == Blocks.IRON_ORE || block == Blocks.DEEPSLATE_IRON_ORE) {

        pool.add(new LootReward(new ItemStack(Items.IRON_INGOT, 18), 15));
        pool.add(new LootReward(new ItemStack(Items.GOLD_INGOT, 8), 13));
        pool.add(new LootReward(new ItemStack(Items.DIAMOND, 3), 12));
        pool.add(new LootReward(new ItemStack(Items.EMERALD, 9), 10));
        pool.add(new LootReward(new ItemStack(Items.DIAMOND_PICKAXE), 10));
        pool.add(new LootReward(new ItemStack(Items.IRON_CHESTPLATE), 9));
        pool.add(new LootReward(new ItemStack(Items.GOLDEN_APPLE, 2), 9));
        pool.add(new LootReward(new ItemStack(Items.TOTEM_OF_UNDYING), 8));
        pool.add(new LootReward(new ItemStack(Items.ENCHANTED_BOOK), 8));
        pool.add(new LootReward(new ItemStack(Items.DIAMOND_CHESTPLATE), 6));

        return pool;
    }

    /*
     * ==========================
     * GOLD / REDSTONE / LAPIS
     * ==========================
     */
    if (block == Blocks.GOLD_ORE
            || block == Blocks.DEEPSLATE_GOLD_ORE
            || block == Blocks.REDSTONE_ORE
            || block == Blocks.DEEPSLATE_REDSTONE_ORE
            || block == Blocks.LAPIS_ORE
            || block == Blocks.DEEPSLATE_LAPIS_ORE) {

        pool.add(new LootReward(new ItemStack(Items.GOLD_INGOT, 18), 15));
        pool.add(new LootReward(new ItemStack(Items.DIAMOND, 5), 13));
        pool.add(new LootReward(new ItemStack(Items.ENDER_PEARL, 8), 12));
        pool.add(new LootReward(new ItemStack(Items.BLAZE_ROD, 8), 10));
        pool.add(new LootReward(new ItemStack(Items.EXPERIENCE_BOTTLE, 16), 10));
        pool.add(new LootReward(new ItemStack(Items.DIAMOND_SWORD), 10));
        pool.add(new LootReward(new ItemStack(Items.ENCHANTED_BOOK), 10));
        pool.add(new LootReward(new ItemStack(Items.TOTEM_OF_UNDYING), 8));
        pool.add(new LootReward(new ItemStack(Items.SHULKER_BOX), 7));
        pool.add(new LootReward(new ItemStack(Items.NETHERITE_SCRAP, 2), 5));

        return pool;
    }

    /*
     * ==========================
     * EMERALD ORE
     * ==========================
     */
    if (block == Blocks.EMERALD_ORE || block == Blocks.DEEPSLATE_EMERALD_ORE) {

        pool.add(new LootReward(new ItemStack(Items.EMERALD, 36), 18));
        pool.add(new LootReward(new ItemStack(Items.DIAMOND, 9), 12));
        pool.add(new LootReward(new ItemStack(Items.TOTEM_OF_UNDYING), 12));
        pool.add(new LootReward(new ItemStack(Items.SHULKER_BOX), 10));
        pool.add(new LootReward(new ItemStack(Items.DIAMOND_CHESTPLATE), 10));
        pool.add(new LootReward(new ItemStack(Items.ENCHANTED_BOOK), 10));
        pool.add(new LootReward(new ItemStack(Items.GOLDEN_CARROT, 32), 8));
        pool.add(new LootReward(new ItemStack(Items.BEACON), 5));
        pool.add(new LootReward(new ItemStack(Items.NETHERITE_INGOT), 4));
        pool.add(new LootReward(new ItemStack(Items.ELYTRA), 1));

        return pool;
    }

    /*
     * ==========================
     * DIAMOND ORE
     * ==========================
     */
    if (block == Blocks.DIAMOND_ORE || block == Blocks.DEEPSLATE_DIAMOND_ORE) {

        pool.add(new LootReward(new ItemStack(Items.DIAMOND, 18), 18));
        pool.add(new LootReward(new ItemStack(Items.NETHERITE_SCRAP, 4), 15));
        pool.add(new LootReward(new ItemStack(Items.TOTEM_OF_UNDYING, 2), 12));
        pool.add(new LootReward(new ItemStack(Items.DIAMOND_PICKAXE), 10));
        pool.add(new LootReward(new ItemStack(Items.DIAMOND_SWORD), 10));
        pool.add(new LootReward(new ItemStack(Items.ENCHANTED_GOLDEN_APPLE), 8));
        pool.add(new LootReward(new ItemStack(Items.SHULKER_BOX), 8));
        pool.add(new LootReward(new ItemStack(Items.BEACON), 5));
        pool.add(new LootReward(new ItemStack(Items.NETHERITE_INGOT), 3));
        pool.add(new LootReward(new ItemStack(Items.ELYTRA), 1));

        return pool;
    }

    /*
     * ==========================
     * ANCIENT DEBRIS
     * ==========================
     */
    if (block == Blocks.ANCIENT_DEBRIS) {

        pool.add(new LootReward(new ItemStack(Items.NETHERITE_INGOT, 2), 20));
        pool.add(new LootReward(new ItemStack(Items.ANCIENT_DEBRIS, 4), 15));
        pool.add(new LootReward(new ItemStack(Items.NETHERITE_SCRAP, 8), 10));
        pool.add(new LootReward(new ItemStack(Items.NETHERITE_SWORD), 10));
        pool.add(new LootReward(new ItemStack(Items.NETHERITE_CHESTPLATE), 10));
        pool.add(new LootReward(new ItemStack(Items.BEACON), 8));
        pool.add(new LootReward(new ItemStack(Items.TOTEM_OF_UNDYING, 3), 8));
        pool.add(new LootReward(new ItemStack(Items.SHULKER_BOX, 2), 8));
        pool.add(new LootReward(new ItemStack(Items.ENCHANTED_GOLDEN_APPLE, 2), 6));
        pool.add(new LootReward(new ItemStack(Items.ELYTRA), 1));

        return pool;
    }

    /*
     * Default
     */
    pool.add(new LootReward(new ItemStack(Items.BREAD), 100));

    return pool;
}

}
