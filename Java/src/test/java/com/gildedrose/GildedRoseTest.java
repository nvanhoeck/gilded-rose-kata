package com.gildedrose;

import com.gildedrose.models.Item;

import static org.junit.jupiter.api.Assertions.assertEquals;

//Begreep niet goed wat hier gefixed moest worden, of dat de opdracht eerder was van uw eigen testen te schrijven
class GildedRoseTest {

    //@Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("fixme", app.items[0].getName());
    }

}
