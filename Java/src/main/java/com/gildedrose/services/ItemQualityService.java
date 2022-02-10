package com.gildedrose.services;

import com.gildedrose.exceptions.ValidationException;
import com.gildedrose.models.Item;
import com.gildedrose.services.factories.ItemQualityStrategyFactory;
import lombok.extern.slf4j.Slf4j;

import java.util.Set;

@Slf4j
public class ItemQualityService {

    private ItemQualityStrategyFactory itemQualityStrategyFactory;

    public ItemQualityService(ItemQualityStrategyFactory itemQualityStrategyFactory) {
        this.itemQualityStrategyFactory = itemQualityStrategyFactory;
    }

    public void evaluateQuality(Set<Item> itemsToEvaluate) {
        itemsToEvaluate.forEach(itemToEvaluate -> {
            try {
                this.updateItemQuality(itemToEvaluate);
                this.updateItemSellIn(itemToEvaluate);
            } catch (ValidationException e) {
                log.warn(e.getMessage());
            }
        });
    }

    private void updateItemSellIn(Item itemToEvaluate) throws ValidationException {
        int updatedSellIn =
            this.itemQualityStrategyFactory.getItemStrategy(itemToEvaluate.getName())
                .evaluateAndReturnSellIn(itemToEvaluate);
        itemToEvaluate.setSellIn(updatedSellIn);
    }

    private void updateItemQuality(Item itemToEvaluate) throws ValidationException {
        int updatedQuality =
            this.itemQualityStrategyFactory.getItemStrategy(itemToEvaluate.getName())
                .evaluateAndReturnQuality(itemToEvaluate);
        itemToEvaluate.setQuality(updatedQuality);
    }

}
