package com.gildedrose.services.strategies.impl;

import com.gildedrose.exceptions.MaxQualityException;
import com.gildedrose.exceptions.MinQualityException;
import com.gildedrose.exceptions.ValidationException;
import com.gildedrose.models.Item;
import com.gildedrose.services.strategies.ItemQualityStrategy;

public class AgedBrieItemQualityStrategy implements ItemQualityStrategy {

    @Override
    public int evaluateAndReturnQuality(Item item) throws ValidationException {
        if (item.getQuality() < 0) {
            throw new MinQualityException("Quality cannot be less then 0");
        }
        int qualityModifier = item.getSellIn() < 0 ? 2 : 1;
        int returnQuality = item.getQuality() + qualityModifier;
        if (returnQuality <= 50) {
            return returnQuality;
        }
        throw new MaxQualityException("Quality is bigger then 50");
    }

    @Override
    public int evaluateAndReturnSellIn(Item item) {
        return item.getSellIn() - 1;
    }
}
