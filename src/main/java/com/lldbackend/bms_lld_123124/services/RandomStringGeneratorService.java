package com.lldbackend.bms_lld_123124.services;

import org.springframework.stereotype.Service;

@Service
public class RandomStringGeneratorService {
    public String generateRandomString(int length) {
        String allowedChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder randomString = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int randomNum = (int) (Math.random() * allowedChars.length());
            randomString.append(allowedChars.charAt(randomNum));
        }
        return randomString.toString();
    }
}
