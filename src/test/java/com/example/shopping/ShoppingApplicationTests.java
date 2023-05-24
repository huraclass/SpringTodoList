package com.example.shopping;

import com.example.shopping.mapper.BoardMapper;
import com.example.shopping.mapper.Person;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@SpringBootTest
class ShoppingApplicationTests {

    @Autowired
    BoardMapper mapper;

    @Test
    void te() {
        Person person = new Person();
        person.setAge(18);
        person.setName("marin");

        mapper.insertPerson(person);
        int age = mapper.selectAge(person);
        Assertions.assertThat(person.getAge()).isEqualTo(age);
    }

}
