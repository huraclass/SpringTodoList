package com.example.shopping.domain.item;

import com.example.shopping.mapper.ItemMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ItemRepositoryDBMS implements ItemRepository {

    private final ItemMapper itemMapper;

    @Override
    public Item save(Item item) {
        itemMapper.save(item);
        return item;
    }

    @Override
    public Item findById(Long id) {
        Item findItem = itemMapper.findById(id);
        return findItem;
    }

    @Override
    public List<Item> findAll() {
        return itemMapper.findAll();
    }

    @Override
    public void update(Item updateParam) {
        itemMapper.update(updateParam);
    }

    @Override
    public void clearStore() {

    }
}
