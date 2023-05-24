package com.example.shopping.domain.item;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Transactional
@SpringBootTest
class ItemRepositoryDBMSTest {
    @Autowired
    ItemRepository repository;

    @Test
    void saveTest() {
        Item item = new Item("marin", 1000, 10);
        Item save = repository.save(item);
        Item findItem = repository.findById(save.getId());
        assertThat(save).isEqualTo(findItem);
    }

    @Test
    void findALlTest() {
        Item marin = new Item("marin", 1000, 10);
        Item pokora = new Item("pokora", 1000, 10);

        repository.save(marin);
        repository.save(pokora);
        List<Item> AllItem = repository.findAll();
        assertThat(AllItem.size()).isEqualTo(3);
    }

    @Test
    void updateTest() {
        Item item = new Item("marin", 1000, 10);
        Item saveItem = repository.save(item);
        Item updateItem = new Item(saveItem.getId(), "korone", 20000, 20);
        repository.update(updateItem);
        Item findItem = repository.findById(saveItem.getId());
        assertThat(findItem).isEqualTo(updateItem);
    }
}