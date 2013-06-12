package com.valdemar.storytail.service;

import com.valdemar.storytail.exceptions.InvalidUserTokenException;
import com.valdemar.storytail.exceptions.UserAuthenticationException;
import com.valdemar.storytail.model.AuthApiKey;
import com.valdemar.storytail.model.UserInfo;

/**
 * Created with IntelliJ IDEA.
 * User: valdemar
 * Date: 5/27/13
 * Time: 6:11 PM
 * To change this template use File | Settings | File Templates.
 */
public interface AuthenticatorService {
    UserInfo authenticate(String token, AuthLoginType facebook) throws UserAuthenticationException;
}
