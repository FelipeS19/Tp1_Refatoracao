package com.gildedrose;
import java.util.HashMap;
import java.util.Map;

class GildedRose {

    private Map<String, ItemUpdater> updaters = new HashMap<>();
    private Item[] items;

    public Item[] getItems() {
        return items;
    }
    public GildedRose(Item[] items) {
        this.items = items;

        updaters.put("Aged Brie", new AgedBrieUpdater());
        updaters.put("Backstage passes to a TAFKAL80ETC concert", new BackstagePassUpdater());
        updaters.put("Sulfuras, Hand of Ragnaros", new SulfurasUpdater());

    }

    public void updateQuality() {
        for (Item item : items) {
            ItemUpdater updater;

            if (item.name.contains("Conjured")) {
                updater = new ConjuredItemUpdater();
            } else {
                updater = updaters.getOrDefault(item.name, new DefaultUpdater());
            }

            updater.update(item);
        }
    }
}
