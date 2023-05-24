package com.example.shopping.domain.item;

import java.util.List;

public interface ItemRepository {
    public Item save(Item item);

    public Item findById(Long id);

    public List<Item> findAll();

    public void update(Item updateParam);

    public void clearStore();

}
