package com.valdemar.storytail.service;

import com.google.common.base.Optional;
import com.valdemar.storytail.dao.WoeidDao;
import com.valdemar.storytail.exceptions.YahooWOEIDServiceException;
import com.valdemar.storytail.model.WindParameters;
import com.valdemar.storytail.util.RestClient;
import com.valdemar.storytail.weather.YahooConstants;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URL;

/**
 * Created with IntelliJ IDEA.
 * User: valdemar
 * Date: 22-03-2013
 * Time: 14:38
 * To change this template use File | Settings | File Templates.
 */

@Component
public class YahooWindService {

    private final String YAHOO_WOEID_SERVICE = "http://where.yahooapis.com/geocode?location={0},{1}&flags=J&gflags=R&appid=" + YahooConstants.API_KEY;

    @Autowired
    WoeidDao woeidDao;

    public Optional<WindParameters> getWind(String woied) throws YahooWOEIDServiceException, UnsupportedEncodingException {

        String query = "select wind from weather.forecast where woeid=" + woied + " and u='c'";
//        String query = URLEncoder.encode("select wind from weather.forecast where woeid=" + woied + " and u='c'", CharEncoding.UTF_8);
        String url = "http://query.yahooapis.com/v1/public/yql?q=" + query + "&format=json";

        String windJson = queryYahooForWind(url);

        Optional<WindParameters> wind = convertYahooResponseUsingJacksonStream(windJson);

        return wind;
    }

    private String queryYahooForWind(String myURL) throws YahooWOEIDServiceException {
        try {
            URL url = new URL(myURL);
            String nullFragment = null;
            URI uri = new URI(url.getProtocol(), url.getHost(), url.getPath(), url.getQuery(), nullFragment);

            return RestClient.getJson(uri);

        } catch (Exception e) {
            throw new YahooWOEIDServiceException(e);
        }
    }


    private Optional<WindParameters> convertYahooResponseUsingJacksonStream(String woeidJson) throws YahooWOEIDServiceException {

        Optional<WindParameters> windParameters;
        JsonFactory jfactory = new JsonFactory();
        JsonParser jParser = null;

        try {

            jParser = jfactory.createJsonParser(woeidJson);

            // loop until token equal to "}"
            while (jParser.nextToken() != JsonToken.END_OBJECT) {

                String fieldname = jParser.getCurrentName();

                if ("wind".equals(fieldname)) {

                    String windSpeed = "0.0";
                    String windDirection = "0";

                    while (jParser.nextToken() != JsonToken.END_OBJECT) {

                        fieldname = jParser.getCurrentName();

                        if ("direction".equals(fieldname)) {
                           // jParser.nextToken();
                            windDirection = jParser.getText();
                        } else if ("speed".equals(fieldname)) {
                           // jParser.nextToken();
                            windSpeed = jParser.getText();
                        } else
                            jParser.nextToken();
                    }
                    return  Optional.of(new WindParameters(Float.parseFloat(windSpeed), Integer.parseInt(windDirection)));
                }
            }
        } catch (Exception e) {
            throw new YahooWOEIDServiceException(e);
        } finally {
            if (jParser != null)
                try {
                    jParser.close();
                } catch (IOException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }

        }

        return Optional.absent();
    }
}
