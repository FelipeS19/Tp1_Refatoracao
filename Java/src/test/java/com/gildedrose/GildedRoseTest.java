package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void shouldNotChangeName() {
        Item[] items = new Item[]{new Item("foo", 0, 0)};
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals("foo", app.getItems()[0].name);
    }

    @Test
    void conjuredShouldDegradeTwiceAsFast() {
        Item[] items = new Item[] { new Item("Conjured Mana Cake", 10, 10) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(8, app.getItems()[0].quality);
    }

}


