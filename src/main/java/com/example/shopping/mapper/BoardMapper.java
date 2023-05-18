package com.example.shopping.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardMapper {
    int selectAge(Person person);

    void insertPerson(Person person);
}
