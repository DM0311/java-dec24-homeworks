package ru.otus.java.basic.homeworks.homework32.application;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ItemRepository {
    private List<Item> items;

    public ItemRepository() {
        this.items = new ArrayList<>(Arrays.asList(
                new Item(1L, "Milk", BigDecimal.valueOf(92)),
                new Item(2L, "Bread", BigDecimal.valueOf(93)),
                new Item(3L, "Cheese", BigDecimal.valueOf(94))
        ));
    }

    public List<Item> getAllItems() {
        return Collections.unmodifiableList(items);
    }

    public void addNewItem(Item item) {
        items.add(item);
    }

    public Item findById(Long id) {
        for (Item o : items) {
            if (o.getId().equals(id)) {
                return o;
            }
        }
        return null;
    }
}
