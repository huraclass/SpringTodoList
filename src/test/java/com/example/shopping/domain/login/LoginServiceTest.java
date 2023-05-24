package com.example.shopping.domain.login;

import com.example.shopping.domain.Member.Member;
import com.example.shopping.domain.Member.MemberRepository;
import com.example.shopping.domain.util.Util;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@Transactional
@SpringBootTest
class LoginServiceTest {
    private String password;
    @Autowired
    MemberRepository repository;

    @Autowired
    LoginService service;

    @BeforeEach
    void before() {
        Member member = new Member("marin", "marin", "test!");
        repository.save(member);
        Optional<Member> marin = repository.findByLoginId("marin");
        Member findMember = marin.get();
        log.info("findMember.password : {}", findMember.getPassword());
        password = Util.encryption("test!");
    }

    @Test
    void loginTest() {
        Member loginMember = service.login("marin", "test!");
        assertThat(loginMember.getLoginId()).isEqualTo("marin");

    }

}