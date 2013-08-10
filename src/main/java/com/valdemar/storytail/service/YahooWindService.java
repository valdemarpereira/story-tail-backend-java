package com.valdemar.storytail.service;

import com.valdemar.storytail.dao.WoeidDao;
import com.valdemar.storytail.exceptions.WeatherException;
import com.valdemar.storytail.model.WindParameters;
import com.valdemar.storytail.util.RestClient;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URL;


@Component
public class YahooWindService {

    @Autowired
    WoeidDao woeidDao;

    private static ObjectMapper objectMapper = new ObjectMapper();

    public WindParameters getWind(String woied) throws WeatherException, UnsupportedEncodingException {

        String query = "select wind from weather.forecast where woeid=" + woied + " and u='c'";
        String url = "http://query.yahooapis.com/v1/public/yql?q=" + query + "&format=json";

        String windJson = queryYahooForWind(url);

        WindParameters windParameters;

        try {
            windParameters = objectMapper.readValue(windJson, WindParameters.class);

        } catch (IOException e) {
            throw new WeatherException(e, "Error parsing wind details");
        }

        return windParameters;
    }

    private String queryYahooForWind(String myURL) throws WeatherException {
        try {
            URL url = new URL(myURL);
            String nullFragment = null;
            URI uri = new URI(url.getProtocol(), url.getHost(), url.getPath(), url.getQuery(), nullFragment);

            return RestClient.getJson(uri);

        } catch (Exception e) {
            throw new WeatherException(e, "Error Querying for wind");
        }
    }

}
