/*
1. Princípio Aberto-Fechado:
A estrutura permite adicionar novos tipos de itens criando novas classes que implementam ItemUpdater,
sem necessidade de alterar o código existente.

2. Princípio da Responsabilidade Única:
Cada classe ItemUpdater possui apenas uma responsabilidade: atualizar um tipo específico de item,
tornando o código mais organizado e fácil de manter.

3. Princípio de Substituição de Liskov :
Não há violação, pois todas as classes que implementam ItemUpdater podem ser utilizadas de forma
intercambiável sem alterar o comportamento esperado do sistema.
*/





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
