package com.valdemar.storytail.service;

import com.valdemar.storytail.exceptions.YahooWOEIDServiceException;
import com.valdemar.storytail.util.RestClient;
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


    public String authenticate(String token) {

        String url =  GRAPH_URL + token;




    }

    private String get(String myURL) throws YahooWOEIDServiceException {
        try {
            URL url = new URL(myURL);
            String nullFragment = null;
            URI uri = new URI(url.getProtocol(), url.getHost(), url.getPath(), url.getQuery(), nullFragment);

            return RestClient.getJson(uri);

        } catch (Exception e) {
            throw new YahooWOEIDServiceException(e);
        }
    }
}
