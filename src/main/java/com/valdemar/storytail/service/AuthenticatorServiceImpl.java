package com.valdemar.storytail.service;

import com.valdemar.storytail.exceptions.InvalidUserTokenException;
import com.valdemar.storytail.exceptions.UserAuthenticationException;
import com.valdemar.storytail.model.AuthApiKey;
import com.valdemar.storytail.model.FacebookUserInfo;
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
    public AuthApiKey authenticate(String token, AuthLoginType authType) throws UserAuthenticationException {

        FacebookUserInfo facebookUserInfo;

        switch (authType) {
            case FACEBOOK:
                facebookUserInfo = fbService.authenticate(token);

                break;
            default:
                throw new AssertionError("Not implemented");
        }


        if(facebookUserInfo == null)
            throw new InvalidUserTokenException("Invalid Token");


        checkAndCreateNewUser(facebookUserInfo);

        return generateApiKey(facebookUserInfo);
    }

    private void checkAndCreateNewUser(FacebookUserInfo facebookUserInfo) {
        //TODO: Implement

    }

    private AuthApiKey generateApiKey(FacebookUserInfo fb) {

        //TODO: Implement
          return null;
    }
}
