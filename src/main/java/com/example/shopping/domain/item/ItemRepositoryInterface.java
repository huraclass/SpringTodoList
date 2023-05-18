package com.example.shopping.domain.item;

import java.util.List;

public interface ItemRepositoryInterface {
    public Item save(Item item);

    public Item findById(Long id);

    public List<Item> findAll();

    public void update(Long itemId, Item updateParam);

    public void clearStore();

}
