package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

public void updateQuality() {
    for (Item item : items) {

        if (item.name.equals("Aged Brie")) {
            updateAgedBrie(item);

        } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            updateBackstage(item);

        } else if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
            updateSulfuras(item);

        } else {
            updateDefault(item);
        }

        if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
            item.sellIn--;
        }
    }
}

private void updateAgedBrie(Item item) {
    if (item.quality < 50) {
        item.quality++;
    }

    if (item.sellIn < 0 && item.quality < 50) {
        item.quality++;
    }
}

private void updateSulfuras(Item item) {

}
private void updateBackstage(Item item) {
    if (item.quality < 50) {
        item.quality++;

        if (item.sellIn < 11 && item.quality < 50) {
            item.quality++;
        }

        if (item.sellIn < 6 && item.quality < 50) {
            item.quality++;
        }
    }
    if (item.sellIn <
0) {
        item.quality = 0;
    }
}

private void updateDefault(Item item) {
    if (item.quality > 0) {
        item.quality--;
    }

    if (item.sellIn < 0 && item.quality > 0) {
        item.quality--;
    }
}
}
