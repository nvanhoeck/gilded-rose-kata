package com.gildedrose.services.strategies.impl;

import com.gildedrose.exceptions.MaxQualityException;
import com.gildedrose.exceptions.MinQualityException;
import com.gildedrose.exceptions.ValidationException;
import com.gildedrose.models.Item;
import com.gildedrose.services.strategies.ItemQualityStrategy;

public class BackstagePassesQualityStrategy implements ItemQualityStrategy {

    @Override
    public int evaluateAndReturnQuality(Item item) throws ValidationException {
        if (item.getQuality() < 0) {
            throw new MinQualityException("Quality cannot be less then 0");
        }
        int returnQuality = determineQualityBySellIn(item);
        if (returnQuality <= 50) {
            return returnQuality;
        }
        throw new MaxQualityException("Quality is bigger then 50");
    }

    private int determineQualityBySellIn(Item item) {
        int sellInQualityChangeIfLowerThenSix = item.getSellIn() < 6 ? 1 : 0;
        int sellInQualityChangeIfLowerThenEleven = item.getSellIn() < 11 ? 1 : 0;
        if(item.getSellIn() < 0) {
            return 0;
        }
        return item.getQuality() + sellInQualityChangeIfLowerThenEleven + sellInQualityChangeIfLowerThenSix + 1;
    }

    @Override
    public int evaluateAndReturnSellIn(Item item) {
        return item.getSellIn() - 1;
    }
}
