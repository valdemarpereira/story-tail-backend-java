package com.valdemar.storytail.service;

import com.google.common.base.Optional;
import com.valdemar.storytail.dao.WoeidDao;
import com.valdemar.storytail.exceptions.YahooWOEIDServiceException;
import com.valdemar.storytail.model.Location;
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
import java.text.MessageFormat;

/**
 * Created with IntelliJ IDEA.
 * User: valdemar
 * Date: 22-03-2013
 * Time: 14:38
 * To change this template use File | Settings | File Templates.
 */

@Component
public class ForecastIOWindService {

    private static final String KEY = "4891e75f23694d2d70d43f0ace1204a9";

    @Autowired
    WoeidDao woeidDao;

    public Optional<WindParameters> getWind(Location location) throws YahooWOEIDServiceException, UnsupportedEncodingException {

        String url = "https://api.forecast.io/forecast/{0}/{1},{2]";

        String windJson = queryForWind(MessageFormat.format(url, KEY, location.getLat(), location.getLon()));

        Optional<WindParameters> wind = convertResponseUsingJacksonStream(windJson);

        return wind;
    }

    private String queryForWind(String myURL) throws YahooWOEIDServiceException {
        try {
            URL url = new URL(myURL);
            String nullFragment = null;
            URI uri = new URI(url.getProtocol(), url.getHost(), url.getPath(), url.getQuery(), nullFragment);

            return RestClient.getJson(uri);

        } catch (Exception e) {
            throw new YahooWOEIDServiceException(e);
        }
    }


    private Optional<WindParameters> convertResponseUsingJacksonStream(String woeidJson) throws YahooWOEIDServiceException {

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
