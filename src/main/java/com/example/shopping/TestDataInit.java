package com.example.shopping;

import com.example.shopping.domain.Member.Member;
import com.example.shopping.domain.Member.MemberRepository;
import com.example.shopping.domain.item.Item;
import com.example.shopping.domain.item.ItemRepositoryMemory;
import lombok.RequiredArgsConstructor;


//@Component
@RequiredArgsConstructor
public class TestDataInit {

    private final ItemRepositoryMemory itemRepositoryMemory;
    private final MemberRepository memberRepository;
    /**
     * 테스트용 데이터 추가
     */
    //@PostConstruct
    public void init() {
        itemRepositoryMemory.save(new Item("itemA", 10000, 10));
        itemRepositoryMemory.save(new Item("itemB", 20000, 20));

        Member member = new Member();
        member.setLoginId("test");
        member.setPassword("test!");
        member.setName("tester");
        memberRepository.save(member);
    }

}