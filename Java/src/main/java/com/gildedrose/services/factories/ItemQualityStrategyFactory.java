package com.gildedrose.services.factories;

import com.gildedrose.enums.ItemName;
import com.gildedrose.services.strategies.ItemQualityStrategy;
import com.gildedrose.services.strategies.impl.*;

import java.util.HashMap;
import java.util.Map;

public class ItemQualityStrategyFactory {

    private Map<String, ItemQualityStrategy> itemQualityStrategies = new HashMap<>();

    public ItemQualityStrategyFactory() {
        this.itemQualityStrategies.put(ItemName.AGED_BRIE.getName(), new AgedBrieItemQualityStrategy());
        this.itemQualityStrategies.put(ItemName.BACKSTAGE_PASSESS.getName(), new BackstagePassesQualityStrategy());
        this.itemQualityStrategies.put(ItemName.SULFURAS.getName(), new SulfurasQualityStrategy());
        this.itemQualityStrategies.put(ItemName.CONJURED.getName(), new ConjuredQualityStrategy());
    }

    public ItemQualityStrategy getItemStrategy(String itemName) {
        return this.itemQualityStrategies.getOrDefault(itemName, new DefaultQualityStrategy());
    }

}
