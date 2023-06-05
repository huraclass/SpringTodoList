package com.example.shopping.domain.Member;

import com.example.shopping.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;

@Slf4j
@Repository
@Transactional
@RequiredArgsConstructor
public class MemberRepositoryDBMS implements MemberRepository{

    private final MemberMapper mapper;

    @Override
    public Member save(Member member) {
        Member encryptionMember = Member.encryptionPassword(member);
        mapper.save(encryptionMember);
        log.info("pass : {}", encryptionMember.getPassword());
        return encryptionMember;
    }

    @Override
    public Member findById(Long id) {
        return mapper.findById(id);
    }

    @Override
    public Optional<Member> findByLoginId(String loginId) {
        return Optional.ofNullable(mapper.findByLoginId(loginId));
    }

    @Override
    public List<Member> findAll() {
        return mapper.findAll();
    }

    @Override
    public void clearStore() {

    }
}
