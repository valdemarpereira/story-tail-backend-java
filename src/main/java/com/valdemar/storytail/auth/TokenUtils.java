package com.valdemar.storytail.auth;

import java.util.UUID;

public class TokenUtils {

    public static String generateToken() {

        //TODO; use a nonce
        return  UUID.randomUUID().toString();


    }

    public static boolean validateToken(String token) {

        //TODO: Validate Token
        return true;
    }
}