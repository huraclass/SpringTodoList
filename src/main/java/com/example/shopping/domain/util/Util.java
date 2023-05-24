package com.example.shopping.domain.util;

import org.springframework.stereotype.Component;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Component
public class Util {
    public static String encryption(String target) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(target.getBytes());
            byte[] digest = md.digest();
            StringBuffer sb = new StringBuffer();
            for (byte b : digest) {
                sb.append(String.format("%02x", b));
            }
            String result = sb.toString();
            return result;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
