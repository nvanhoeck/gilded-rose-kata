package com.gildedrose.services.factories;

import com.gildedrose.services.strategies.ItemQualityStrategy;
import com.gildedrose.services.strategies.impl.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class ItemQualityStrategyFactoryTest {


    private ItemQualityStrategyFactory fixture;


    @BeforeEach
    void setUp() {
        this.fixture = new ItemQualityStrategyFactory();
    }

    @ParameterizedTest
    @MethodSource("provideItemNameEnumsAndTheirStrategies")
    public void whenFetchingQualityStrategyByName_ReturnQualityStrategy(String itemName,
        Class itemQualityStrategy) {
        ItemQualityStrategy itemStrategyResult = this.fixture.getItemStrategy(itemName);
        assertEquals(itemQualityStrategy, itemStrategyResult.getClass());
    }

    private static Stream<Arguments> provideItemNameEnumsAndTheirStrategies() {
        return Stream.of(Arguments.of("Aged Brie", AgedBrieItemQualityStrategy.class),
            Arguments.of("Backstage passes to a TAFKAL80ETC concert",
                BackstagePassesQualityStrategy.class),
            Arguments.of("Sulfuras, Hand of Ragnaros", SulfurasQualityStrategy.class),
            Arguments.of("UNKNOWN", DefaultQualityStrategy.class),
            Arguments.of("Conjured Mana Cake", ConjuredQualityStrategy.class)
            );
    }
}
