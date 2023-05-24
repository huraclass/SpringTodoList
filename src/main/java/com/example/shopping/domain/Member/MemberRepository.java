package com.example.shopping.domain.Member;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    public Member save(Member member);

    public Member findById(Long id);

    public Optional<Member> findByLoginId(String loginId);

    public List<Member> findAll();

    public void clearStore();
}
