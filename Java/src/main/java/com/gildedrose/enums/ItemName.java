package com.gildedrose.enums;

public enum ItemName {

    AGED_BRIE("Aged Brie"),
    BACKSTAGE_PASSESS("Backstage passes to a TAFKAL80ETC concert"),
    SULFURAS("Sulfuras, Hand of Ragnaros"),
    CONJURED("Conjured Mana Cake");

    private String name;

    ItemName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
