package com.valdemar.storytail.service;

import com.google.common.base.Optional;
import com.valdemar.storytail.dao.WoeidDao;
import com.valdemar.storytail.exceptions.RestClientFatalException;
import com.valdemar.storytail.exceptions.YahooWOEIDServiceException;
import com.valdemar.storytail.model.Location;
import com.valdemar.storytail.model.Woeid;
import com.valdemar.storytail.util.RestClient;
import com.valdemar.storytail.weather.YahooConstants;
import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.text.MessageFormat;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: valdemar
 * Date: 22-03-2013
 * Time: 14:38
 * To change this template use File | Settings | File Templates.
 */

@Component
public class YahooWOEIDService {

    private final String YAHOO_WOEID_SERVICE = "http://where.yahooapis.com/geocode?location={0},{1}&flags=J&gflags=R";

    @Autowired
    WoeidDao woeidDao;

    public Woeid getWOEID(Location loc) throws YahooWOEIDServiceException {

        Optional<Woeid> woeidFromCache = woeidDao.findWoeid(loc);

        if (woeidFromCache.isPresent())
            return woeidFromCache.get();

        String woeidJson = queryYahooForWoeid(loc);

        Woeid woeid = convertYahooResponseUsingJacksonStream(woeidJson);

        if(!StringUtils.isNotEmpty(woeid.getWoeid()))
            throw new YahooWOEIDServiceException("Error Getting WOEID from location");

        woeid.setLocation(loc);
        woeid.setRecordDate(new Date());

        woeidDao.createWoeid(woeid);

        return woeid;
    }

    private String queryYahooForWoeid(Location loc) throws YahooWOEIDServiceException {
        try {
            URI uri = new URI(MessageFormat.format(YAHOO_WOEID_SERVICE, Double.toString(loc.getLat()), Double.toString(loc.getLon())));

            return RestClient.getJson(uri);

        } catch (Exception e) {
            throw new YahooWOEIDServiceException(e);
        }
    }


    private Woeid convertYahooResponseUsingJacksonStream(String woeidJson) throws YahooWOEIDServiceException {

        Woeid woeid = new Woeid();
        JsonFactory jfactory = new JsonFactory();
        JsonParser jParser = null;

        try {

            jParser = jfactory.createJsonParser(woeidJson);

            // loop until token equal to "}"
            while (jParser.nextToken() != JsonToken.END_OBJECT) {

                String fieldname = jParser.getCurrentName();

                if ("ResultSet".equals(fieldname)) {

                    // messages is array, loop until token equal to "]"
                    while (jParser.nextToken() != JsonToken.END_OBJECT) {

                        fieldname = jParser.getCurrentName();

                        if ("Error".equals(fieldname)) {
                            jParser.nextToken();
                            if (!jParser.getText().equals("0"))
                                throw new RestClientFatalException("Error calling Yahoo webservice");
                        }
                        if ("Results".equals(fieldname)) {

                            JsonToken token = jParser.nextToken(); // current token is "[", move next
                            token = jParser.nextToken(); // current token is "[", move next

                            while (jParser.nextToken() != JsonToken.END_OBJECT) {

                                fieldname = jParser.getCurrentName();

                                if ("woeid".equals(fieldname)) {
                                    jParser.nextToken();
                                    woeid.setWoeid(jParser.getText());
                                } else if ("country".equals(fieldname)) {
                                    jParser.nextToken();
                                    woeid.setCountry(jParser.getText());
                                } else if ("city".equals(fieldname)) {
                                    jParser.nextToken();
                                    woeid.setCity(jParser.getText());
                                } else if ("state".equals(fieldname)) {
                                    jParser.nextToken();
                                    woeid.setState(jParser.getText());
                                } else if ("county".equals(fieldname)) {
                                    jParser.nextToken();
                                    woeid.setCounty(jParser.getText());
                                } else
                                    token = jParser.nextToken();
                            }

                            return woeid;
                        }
                    }
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
        return woeid;
    }
}
