package com.example.shopping.domain.login;

import com.example.shopping.domain.Member.Member;
import com.example.shopping.domain.Member.MemberRepository;
import com.example.shopping.domain.util.Util;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final MemberRepository memberRepository;

    public Member login(String loginId, String password){
        String encryptionPassword = Util.encryption(password);
        return memberRepository.findByLoginId(loginId)
                .filter(member1 -> member1.getPassword().equals(encryptionPassword))
                .orElse(null);
    }
}
