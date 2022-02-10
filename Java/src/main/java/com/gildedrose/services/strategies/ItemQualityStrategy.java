package com.gildedrose.services.strategies;

import com.gildedrose.exceptions.MaxQualityException;
import com.gildedrose.exceptions.ValidationException;
import com.gildedrose.models.Item;

public interface ItemQualityStrategy {
    int evaluateAndReturnQuality(Item item) throws ValidationException;
    int evaluateAndReturnSellIn(Item item) throws ValidationException;
}
