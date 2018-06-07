package com.example.common.utils;

import java.security.SecureRandom;
import java.util.Random;

public class RandomGenerator
{
    //private static char[] CHARSET_AZ_09 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
    private static char[] CHARSET_AZ_09 = "ABCDEFGHJKLMNPQRTUVWXYZ23456789".toCharArray();

    public static String randomAlphanumeric(int length) {
        Random random = new SecureRandom();

        char[] result = new char[length];
        for (int i = 0; i < result.length; i++) {
            int randomCharIndex = random.nextInt(CHARSET_AZ_09.length);
            result[i] = CHARSET_AZ_09[randomCharIndex];
        }
        return new String(result);
    }
}
