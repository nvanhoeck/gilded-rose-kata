package com.gildedrose.services.strategies.impl;

import com.gildedrose.enums.ItemName;
import com.gildedrose.exceptions.MaxQualityException;
import com.gildedrose.exceptions.MinQualityException;
import com.gildedrose.models.Item;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AgedBrieItemQualityStrategyTest {

    private AgedBrieItemQualityStrategy fixture = new AgedBrieItemQualityStrategy();

    @Test
    @SneakyThrows
    public void givenSellDateOk_whenEvaluateQuality_thenIncreaseQualityByOne() {
        int originalSellIn = 1;
        int originalQuality = 0;
        Item item = new Item(ItemName.AGED_BRIE.getName(), originalSellIn, originalQuality);
        int returnedQuality = this.fixture.evaluateAndReturnQuality(item);

        assertEquals(1, returnedQuality);
    }

    @Test
    @SneakyThrows
    public void givenSellDateNok_whenEvaluateQualityNegativeSellIn_thenIncreaseQualityByTwo() {
        int originalSellIn = -1;
        int originalQuality = 0;
        Item item = new Item(ItemName.AGED_BRIE.getName(), originalSellIn, originalQuality);
        int returnedQuality = this.fixture.evaluateAndReturnQuality(item);

        assertEquals(2, returnedQuality);
    }

    @Test
    public void givenQualityItemExceedsLimit_whenEvaluateQuality_throwMaxQualityException() {
        assertThrows(MaxQualityException.class, () -> {
            int originalSellIn = 10;
            int originalQuality = 51;
            Item item = new Item(ItemName.AGED_BRIE.getName(), originalSellIn, originalQuality);
            this.fixture.evaluateAndReturnQuality(item);
        });
    }

    @Test
    public void givenQualityItemExceedsLimitAfterCalculations_whenEvaluateQuality_throwMaxQualityException() {
        assertThrows(MaxQualityException.class, () -> {
            int originalSellIn = -1;
            int originalQuality = 49;
            Item item = new Item(ItemName.AGED_BRIE.getName(), originalSellIn, originalQuality);
            this.fixture.evaluateAndReturnQuality(item);
        });
    }

    @Test
    public void givenQualityItemIsNegative_whenEvaluateQuality_throwMinQualityException() {
        assertThrows(MinQualityException.class, () -> {
            int originalSellIn = 10;
            int originalQuality = -1;
            Item item = new Item(ItemName.AGED_BRIE.getName(), originalSellIn, originalQuality);
            this.fixture.evaluateAndReturnQuality(item);
        });
    }
}
