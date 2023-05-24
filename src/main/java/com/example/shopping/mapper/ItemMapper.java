package com.example.shopping.mapper;

import com.example.shopping.domain.item.Item;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ItemMapper {
    void save(Item item);

    Item findById(Long id);

    List<Item> findAll();

    void update(Item item);
}
