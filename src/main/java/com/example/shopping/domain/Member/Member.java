package com.example.shopping.domain.Member;

import com.example.shopping.domain.util.Util;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class Member {


    private Long id;

    @NotEmpty
    private String loginId;

    @NotEmpty
    private String name;

    @NotEmpty
    private String password;

    public Member(String loginId, String name, String password) {
        this.loginId = loginId;
        this.name = name;
        this.password = password;
    }

    public static Member encryptionPassword(Member member) {
        String encryptionPassword = Util.encryption(member.getPassword());
        member.setPassword(encryptionPassword);
        return member;
    }
}
