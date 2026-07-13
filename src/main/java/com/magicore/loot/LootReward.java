package com.magicore.loot;

import net.minecraft.world.item.ItemStack;

public class LootReward {

    private final ItemStack item;
    private final int weight;

    public LootReward(ItemStack item, int weight) {
        this.item = item;
        this.weight = weight;
    }

    public ItemStack getItem() {
        return item.copy();
    }

    public int getWeight() {
        return weight;
    }
}
