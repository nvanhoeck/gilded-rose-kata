package com.gildedrose.services.strategies.impl;

import com.gildedrose.exceptions.MaxQualityException;
import com.gildedrose.exceptions.MinQualityException;
import com.gildedrose.exceptions.ValidationException;
import com.gildedrose.models.Item;
import com.gildedrose.services.strategies.ItemQualityStrategy;

public class ConjuredQualityStrategy implements ItemQualityStrategy {

    @Override
    public int evaluateAndReturnQuality(Item item) throws ValidationException {

        int qualityChangeAfterSellInCheck =
            item.getSellIn() < 0 && item.getQuality() > 0 ? -2 : 0;
        int qualityChange = item.getQuality() > 0 ? -2 : 0;
        int returnQuality = item.getQuality() + qualityChange + qualityChangeAfterSellInCheck;
        if (returnQuality < 0) {
            throw new MinQualityException("Quality cannot be less then 0");
        }
        if (item.getQuality() > 50) {
            throw new MaxQualityException("Quality is bigger then 50");
        }
        return returnQuality;

    }

    @Override
    public int evaluateAndReturnSellIn(Item item) {
        return item.getSellIn() - 1;
    }
}
