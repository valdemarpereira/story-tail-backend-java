package com.valdemar.storytail.service;

import com.valdemar.storytail.exceptions.InvalidUserTokenException;
import com.valdemar.storytail.model.AuthApiKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: valdemar
 * Date: 5/27/13
 * Time: 6:08 PM
 * To change this template use File | Settings | File Templates.
 */
@Service
public class AuthenticatorServiceImpl implements AuthenticatorService {

    @Autowired
    FacebookAuthenticatorService fbService;

    @Override
    public AuthApiKey authenticate(String token, AuthLoginType authType) throws InvalidUserTokenException {

        String username = false;

        switch (authType) {
            case FACEBOOK:
                username = fbService.authenticate(token);

                break;
            default:
                throw new AssertionError("Not implemented");
        }


        if(username == null)
            throw new InvalidUserTokenException();


        return generateApiKey(username);
    }

    private AuthApiKey generateApiKey(String username) {




    }
}
