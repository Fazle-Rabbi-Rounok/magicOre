package com.magicore.manager;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.Set;

public final class OreManager {

    private OreManager() {
    }

    private static final Set<Block> ORES = Set.of(
            Blocks.COAL_ORE,
            Blocks.DEEPSLATE_COAL_ORE,

            Blocks.COPPER_ORE,
            Blocks.DEEPSLATE_COPPER_ORE,

            Blocks.IRON_ORE,
            Blocks.DEEPSLATE_IRON_ORE,

            Blocks.GOLD_ORE,
            Blocks.DEEPSLATE_GOLD_ORE,

            Blocks.REDSTONE_ORE,
            Blocks.DEEPSLATE_REDSTONE_ORE,

            Blocks.LAPIS_ORE,
            Blocks.DEEPSLATE_LAPIS_ORE,

            Blocks.EMERALD_ORE,
            Blocks.DEEPSLATE_EMERALD_ORE,

            Blocks.DIAMOND_ORE,
            Blocks.DEEPSLATE_DIAMOND_ORE,

            Blocks.NETHER_GOLD_ORE,

            Blocks.ANCIENT_DEBRIS
    );

    public static boolean isMagicOre(Block block) {
        return ORES.contains(block);
    }
}
