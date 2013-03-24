package com.valdemar.storytail.util.yahoo;

import org.apache.commons.lang.CharEncoding;
import org.scribe.builder.ServiceBuilder;
import org.scribe.builder.api.YahooApi;
import org.scribe.model.*;
import org.scribe.oauth.OAuthService;
import sun.misc.CharacterEncoder;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.net.URLEncoder;


/**
 * Created with IntelliJ IDEA.
 * User: valdemar
 * Date: 23-03-2013
 * Time: 22:44
 * To change this template use File | Settings | File Templates.
 */
public class YQLOAuthExample {

  public void xxx() throws UnsupportedEncodingException {
      OAuthService service = new ServiceBuilder()
              .provider(YahooApi.class)
              .apiKey("dj0yJmk9b1JPN2kxMTNJNG41JmQ9WVdrOU0zVnhkM1J1TXpZbWNHbzlOekkxTlRRMk16WXkmcz1jb25zdW1lcnNlY3JldCZ4PTMw")
              .apiSecret("09654973f4cc05f847161b9ab1288793ab087876")
              .build();
      try {

      Token requestToken = service.getRequestToken();

      String authUrl = service.getAuthorizationUrl(requestToken);

      Verifier v = new Verifier("verifier you got from the user");
      Token accessToken = service.getAccessToken(requestToken, v);


      String query = URLEncoder.encode("select wind from weather.forecast where woeid=26352044 and u='c'", CharEncoding.UTF_8);
      String url = "http://query.yahooapis.com//v1/yql?q="+query+"&format=json";

      OAuthRequest request = new OAuthRequest(Verb.GET, url);
      service.signRequest(accessToken, request); // the access token from step 4
      Response response = request.send();
      System.out.println(response.getBody());

     //http://query.yahooapis.com//v1/yql?q=&format=json
      }
      catch (Throwable tr) {
          tr.printStackTrace();
      }

  }
}
