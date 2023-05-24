package com.example.shopping.mapper;

import com.example.shopping.domain.Member.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {

    void save(Member member);

    Member findById(Long id);

    Member findByLoginId(String loginId);

    List<Member> findAll();

    void clearStore();
}
