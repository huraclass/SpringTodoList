package com.example.shopping.domain.Member;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.*;

@Slf4j
public class MemberRepositoryMemory implements MemberRepository{
    MemberRepositoryMemory() {
        init();
    }

    private void init() {
        Member member = new Member();
        member.setLoginId("test");
        member.setPassword("test!");
        member.setName("tester");
        this.save(member);
    }
    private static Map<Long, Member> store = new HashMap<>();

    private static long sequence = 0l;

    public Member save(Member member) {
        Member encryptionMember = Member.encryptionPassword(member);
        member.setId(++sequence);
        log.info("save : member = {}", member);
        store.put(member.getId(), member);
        return member;
    }

    public Member findById(Long id) {
        return store.get(id);
    }

    public Optional<Member> findByLoginId(String loginId) {
        List<Member> members = findAll();
        members.forEach(member -> log.info("member : {}", member));
        return findAll().stream()
                .filter(member -> member.getLoginId().equals(loginId))
                .findFirst();
    }

    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
