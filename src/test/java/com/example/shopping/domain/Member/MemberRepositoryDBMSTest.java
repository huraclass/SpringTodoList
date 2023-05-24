package com.example.shopping.domain.Member;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@Transactional
@SpringBootTest
class MemberRepositoryDBMSTest {

    @Autowired
    MemberRepositoryDBMS repository;


    private final String re = "35072c1ae546350e0bfa7ab11d49dc6f129e72ccd57ec7eb671225bbd197c8f1";
    @Test
    void test() {
        Member member = new Member("marin","1234","test");
        Member saveMember = repository.save(member);
        Optional<Member> marin = repository.findByLoginId("marin");
        Member findMember = marin.get();
        assertThat(saveMember).isEqualTo(findMember);
    }

    @Test
    void loginTest() {

    }

    @Test
    void 암호화_알고리즘_테스트() throws NoSuchAlgorithmException {
        assertThat(getA("hello_world")).isEqualTo(re);
        assertThat(getA("hello_worldd")).isNotEqualTo(re);
    }

    private String getA(String target) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(target.getBytes());
        byte[] digest = md.digest();
        StringBuffer sb = new StringBuffer();
        for (byte b : digest) {
            sb.append(String.format("%02x", b));
        }

        String result = sb.toString();
        return result;
    }
}