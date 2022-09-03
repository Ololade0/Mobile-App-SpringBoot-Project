package com.example.demo.utils;

import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.Random;



@Component
public class utils {
    private final String ALPHABET = "0123456789abcdefhjdhdd" ;

    private final Random RANDOM = new SecureRandom();


    public String generateUserId(int length){
        return generateRandonString(length);
    }

    private String generateRandonString(int length) {
        StringBuilder stringBuilder = new StringBuilder(length);
        for (int i = 0; i < length ; i++) {
            stringBuilder.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));

        }
        return new String(stringBuilder);
    }
}


