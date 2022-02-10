package com.gildedrose.services.strategies.impl;

import com.gildedrose.models.Item;
import com.gildedrose.services.strategies.ItemQualityStrategy;

public class SulfurasQualityStrategy implements ItemQualityStrategy {

    @Override
    public int evaluateAndReturnQuality(Item item) {
        return item.getQuality();
    }

    @Override
    public int evaluateAndReturnSellIn(Item item) {
        return item.getSellIn();
    }
}
