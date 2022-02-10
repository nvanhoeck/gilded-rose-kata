package com.gildedrose.services.strategies.impl;

import com.gildedrose.enums.ItemName;
import com.gildedrose.models.Item;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SulfurasQualityStrategyTest {
    private SulfurasQualityStrategy fixture = new SulfurasQualityStrategy();

    @Test
    @SneakyThrows
    public void givenSellDateOk_whenEvaluateQuality_thenQualityIsTheSame() {
        int originalSellIn = 10;
        int originalQuality = 10;
        Item item = new Item(ItemName.SULFURAS.getName(), originalSellIn, originalQuality);
        int returnedQuality = this.fixture.evaluateAndReturnQuality(item);

        assertEquals(10, returnedQuality);
    }

    @Test
    @SneakyThrows
    public void givenSellDateNok_whenEvaluateQualityNegativeSellIn_thenQualityIsTheSame() {
        int originalSellIn = -1;
        int originalQuality = 10;
        Item item = new Item(ItemName.SULFURAS.getName(), originalSellIn, originalQuality);
        int returnedQuality = this.fixture.evaluateAndReturnQuality(item);

        assertEquals(10, returnedQuality);
    }

    @Test
    public void givenQualityItemExceedsLimit_whenEvaluateQuality_thenThrowNoException() {
        assertDoesNotThrow(() -> {
            int originalSellIn = 10;
            int originalQuality = 80;
            Item item = new Item(ItemName.SULFURAS.getName(), originalSellIn, originalQuality);
            this.fixture.evaluateAndReturnQuality(item);
        });
    }


    @Test
    public void givenQualityItemIsNegative_whenEvaluateQuality_thenThrowNoException() {
        assertDoesNotThrow(() -> {
            int originalSellIn = 10;
            int originalQuality = -1;
            Item item = new Item(ItemName.SULFURAS.getName(), originalSellIn, originalQuality);
            this.fixture.evaluateAndReturnQuality(item);
        });
    }
}
