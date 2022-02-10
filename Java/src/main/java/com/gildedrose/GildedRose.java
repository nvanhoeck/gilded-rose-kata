package com.gildedrose;

import com.gildedrose.models.Item;
import com.gildedrose.services.ItemQualityService;
import com.gildedrose.services.factories.ItemQualityStrategyFactory;

import java.util.Arrays;
import java.util.HashSet;

class GildedRose {
    Item[] items;

    private ItemQualityStrategyFactory itemQualityStrategyFactory = new ItemQualityStrategyFactory();
    private ItemQualityService itemQualityService = new ItemQualityService(itemQualityStrategyFactory);

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        //NEW CODE
        this.itemQualityService.evaluateQuality(new HashSet<>(Arrays.asList(this.items)));

        //OLD CODE
//        //Default???
//        for (int i = 0; i < items.length; i++) {
//            if (!items[i].name.equals("Aged Brie")
//                    && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
//                if (items[i].quality > 0) {
//                    if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
//                        items[i].quality = items[i].quality - 1;
//                    }
//                }
//            }
//            //Aged Brie OR Backstage
//            else {
//                //Aged Brie OR Backstage
//                if (items[i].quality < 50) {
//                    items[i].quality = items[i].quality + 1;
//                    //Backstage
//                    if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
//                        if (items[i].sellIn < 11) {
//                            if (items[i].quality < 50) {
//                                items[i].quality = items[i].quality + 1;
//                            }
//                        }
//
//                        if (items[i].sellIn < 6) {
//                            if (items[i].quality < 50) {
//                                items[i].quality = items[i].quality + 1;
//                            }
//                        }
//                    }
//                }
//            }
//
//            //Gets always executed if not Ragnaros
//            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
//                items[i].sellIn = items[i].sellIn - 1;
//            }
//
//            if (items[i].sellIn < 0) {
//                if (!items[i].name.equals("Aged Brie")) {
//                    //DEFAULT, BACKSTAGE & SULFURES
//                    if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
//                        //SULFURAS & DEFAULT
//                        if (items[i].quality > 0) {
//                            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
//                                //DEFAULT
//                                items[i].quality = items[i].quality - 1;
//                            }
//                        }
//                        //SULFURAS
//                    } else {
//                        //Backstage
//                        items[i].quality = items[i].quality - items[i].quality;
//                    }
//                } else {
//                    //Aged brie
//                    if (items[i].quality < 50) {
//                        items[i].quality = items[i].quality + 1;
//                    }
//                }
//            }
//        }
    }
}
