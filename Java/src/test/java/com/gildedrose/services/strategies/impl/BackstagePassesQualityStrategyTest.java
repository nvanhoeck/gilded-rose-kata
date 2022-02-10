package com.gildedrose.services.strategies.impl;

import com.gildedrose.enums.ItemName;
import com.gildedrose.exceptions.MaxQualityException;
import com.gildedrose.exceptions.MinQualityException;
import com.gildedrose.models.Item;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BackstagePassesQualityStrategyTest {

    private BackstagePassesQualityStrategy fixture = new BackstagePassesQualityStrategy();

    @Test
    @SneakyThrows
    public void givenSellDateOk_whenEvaluateQuality_thenIncreaseQualityByOne() {
        int originalSellIn = 11;
        int originalQuality = 0;
        Item item = new Item(ItemName.BACKSTAGE_PASSESS.getName(), originalSellIn, originalQuality);
        int returnedQuality = this.fixture.evaluateAndReturnQuality(item);

        assertEquals(1, returnedQuality);
    }

    @Test
    @SneakyThrows
    public void givenSellDateLessThenEleven_whenEvaluateQuality_thenIncreaseQualityByTwo() {
        int originalSellIn = 10;
        int originalQuality = 0;
        Item item = new Item(ItemName.BACKSTAGE_PASSESS.getName(), originalSellIn, originalQuality);
        int returnedQuality = this.fixture.evaluateAndReturnQuality(item);

        assertEquals(2, returnedQuality);
    }

    @Test
    @SneakyThrows
    public void givenSellDateLessThenSix_whenEvaluateQuality_thenIncreaseQualityByThree() {
        int originalSellIn = 5;
        int originalQuality = 0;
        Item item = new Item(ItemName.BACKSTAGE_PASSESS.getName(), originalSellIn, originalQuality);
        int returnedQuality = this.fixture.evaluateAndReturnQuality(item);

        assertEquals(3, returnedQuality);
    }

    @Test
    @SneakyThrows
    public void givenSellDateNok_whenEvaluateQualityNegativeSellIn_thenQualityIsZero() {
        int originalSellIn = -1;
        int originalQuality = 0;
        Item item = new Item(ItemName.BACKSTAGE_PASSESS.getName(), originalSellIn, originalQuality);
        int returnedQuality = this.fixture.evaluateAndReturnQuality(item);

        assertEquals(0, returnedQuality);
    }

    @Test
    public void givenQualityItemExceedsLimit_whenEvaluateQuality_throwMaxQualityException() {
        assertThrows(MaxQualityException.class, () -> {
            int originalSellIn = 10;
            int originalQuality = 51;
            Item item = new Item(ItemName.BACKSTAGE_PASSESS.getName(), originalSellIn, originalQuality);
            this.fixture.evaluateAndReturnQuality(item);
        });
    }

    @Test
    public void givenQualityItemExceedsLimitAfterCalculations_whenEvaluateQuality_throwMaxQualityException() {
        assertThrows(MaxQualityException.class, () -> {
            int originalSellIn = 1;
            int originalQuality = 49;
            Item item = new Item(ItemName.BACKSTAGE_PASSESS.getName(), originalSellIn, originalQuality);
            this.fixture.evaluateAndReturnQuality(item);
        });
    }

    @Test
    public void givenQualityItemIsNegative_whenEvaluateQuality_throwMinQualityException() {
        assertThrows(MinQualityException.class, () -> {
            int originalSellIn = 10;
            int originalQuality = -1;
            Item item = new Item(ItemName.BACKSTAGE_PASSESS.getName(), originalSellIn, originalQuality);
            this.fixture.evaluateAndReturnQuality(item);
        });
    }

}
