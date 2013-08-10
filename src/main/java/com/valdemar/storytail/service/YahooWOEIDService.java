package com.valdemar.storytail.service;

import com.google.common.base.Optional;
import com.valdemar.storytail.dao.WoeidDao;
import com.valdemar.storytail.exceptions.RestClientFatalException;
import com.valdemar.storytail.exceptions.WeatherException;
import com.valdemar.storytail.exceptions.YahooWOEIDServiceException;
import com.valdemar.storytail.model.Location;
import com.valdemar.storytail.model.Woeid;
import com.valdemar.storytail.util.RestClient;
import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.text.MessageFormat;
import java.util.Date;


@Component
public class YahooWOEIDService {

    private final String YAHOO_WOEID_SERVICE = "http://where.yahooapis.com/geocode?location={0},{1}&flags=J&gflags=R";

    @Autowired
    WoeidDao woeidDao;

    private static ObjectMapper objectMapper = new ObjectMapper();

    public Woeid getWOEID(Location loc) throws YahooWOEIDServiceException {

        Optional<Woeid> woeidFromCache = woeidDao.findWoeid(loc);

        if (woeidFromCache.isPresent())
            return woeidFromCache.get();

        String woeidJson = queryYahooForWoeid(loc);
        Woeid woeid;

        try {
            woeid = objectMapper.readValue(woeidJson, Woeid.class);
        } catch (IOException e) {
            throw new YahooWOEIDServiceException(e);
        }


        if (!StringUtils.isNotEmpty(woeid.getWoeid()))
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

}
