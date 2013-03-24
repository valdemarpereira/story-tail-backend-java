package com.valdemar.storytail.weather;

import com.valdemar.storytail.exceptions.WeatherException;
import com.valdemar.storytail.exceptions.YahooWOEIDServiceException;
import com.valdemar.storytail.model.Location;
import com.valdemar.storytail.model.WindParameters;

import java.io.UnsupportedEncodingException;

/**
 * Created with IntelliJ IDEA.
 * User: valdemar
 * Date: 21-03-2013
 * Time: 23:42
 * To change this template use File | Settings | File Templates.
 */
public interface WeatherStrategy {

    public WindParameters getWindParameter(Location loc) throws WeatherException;
}
