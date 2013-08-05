package com.valdemar.storytail.service;

import com.valdemar.storytail.exceptions.UserAuthenticationException;
import com.valdemar.storytail.model.FacebookUserInfo;
import com.valdemar.storytail.model.UserInfo;
import com.valdemar.storytail.util.RestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.URL;

/**
 * Created with IntelliJ IDEA.
 * User: valdemar
 * Date: 5/27/13
 * Time: 6:13 PM
 * To change this template use File | Settings | File Templates.
 */
@Component
public class FacebookAuthenticatorService {

    private static final String GRAPH_URL = "https://graph.facebook.com/me?access_token=";

    @Autowired
    UserLoginService userLoginService;

    @Autowired
    ApiTokenService apiTokenService;


    public UserInfo authenticate(String fbToken) throws UserAuthenticationException {

        //todo: validar caso o fbToken seja invalido...

        String url =  GRAPH_URL + fbToken;

        FacebookUserInfo fb = get(url);

        UserInfo userInfo = userLoginService.createOrUpdateUser(fb); // incr num of login, last login, etc etc

        userInfo.setApiToken(apiTokenService.generateToken(userInfo.getId()));

       return userInfo;


    }

    private FacebookUserInfo get(String myURL) throws UserAuthenticationException {
        try {
            URL url = new URL(myURL);
            String nullFragment = null;
            URI uri = new URI(url.getProtocol(), url.getHost(), url.getPath(), url.getQuery(), nullFragment);

            return RestClient.getJson(uri, FacebookUserInfo.class);

        } catch (Exception e) {
            throw new UserAuthenticationException(e);
        }
    }
}
