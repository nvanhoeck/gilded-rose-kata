package com.gildedrose.services.strategies.impl;

import com.gildedrose.enums.ItemName;
import com.gildedrose.exceptions.MaxQualityException;
import com.gildedrose.exceptions.MinQualityException;
import com.gildedrose.models.Item;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DefaultQualityStrategyTest {
    private DefaultQualityStrategy fixture = new DefaultQualityStrategy();

    private final String RANDOM_NAME = "RANDOM";


    @Test
    @SneakyThrows
    public void givenSellDateOk_whenEvaluateQuality_thenDecreaseQualityByOne() {
        int originalSellIn = 50;
        int originalQuality = 10;
        Item item = new Item(this.RANDOM_NAME, originalSellIn, originalQuality);
        int returnedQuality = this.fixture.evaluateAndReturnQuality(item);

        assertEquals(9, returnedQuality);
    }

    @Test
    @SneakyThrows
    public void givenSellDateNok_whenEvaluateQualityNegativeSellIn_thenQualityIsDecreasedByTwo() {
        int originalSellIn = -1;
        int originalQuality = 20;
        Item item = new Item(this.RANDOM_NAME, originalSellIn, originalQuality);
        int returnedQuality = this.fixture.evaluateAndReturnQuality(item);

        assertEquals(18, returnedQuality);
    }

    @Test
    public void givenQualityItemExceedsLimit_whenEvaluateQuality_throwMaxQualityException() {
        assertThrows(MaxQualityException.class, () -> {
            int originalSellIn = 10;
            int originalQuality = 51;
            Item item = new Item(this.RANDOM_NAME, originalSellIn, originalQuality);
            this.fixture.evaluateAndReturnQuality(item);
        });
    }

    @Test
    public void givenQualityItemIsNegative_whenEvaluateQuality_throwMinQualityException() {
        assertThrows(MinQualityException.class, () -> {
            int originalSellIn = -1;
            int originalQuality = 1;
            Item item = new Item(this.RANDOM_NAME, originalSellIn, originalQuality);
            this.fixture.evaluateAndReturnQuality(item);
        });
    }

}
