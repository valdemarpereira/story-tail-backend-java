package com.valdemar.storytail.service;

import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: valdemar
 * Date: 12/06/13
 * Time: 20:41
 * To change this template use File | Settings | File Templates.
 */
public interface ApiTokenService {

    public String generateToken(String userId);

    String getUserIdFromToken(String token);
}
