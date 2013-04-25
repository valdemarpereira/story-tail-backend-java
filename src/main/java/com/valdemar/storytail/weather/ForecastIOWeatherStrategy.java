package com.valdemar.storytail.weather;

import com.google.common.base.Optional;
import com.valdemar.storytail.exceptions.WeatherException;
import com.valdemar.storytail.model.Location;
import com.valdemar.storytail.model.WindParameters;
import com.valdemar.storytail.model.Woeid;
import com.valdemar.storytail.service.ForecastIOWindService;
import com.valdemar.storytail.service.YahooWOEIDService;
import com.valdemar.storytail.service.YahooWindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: valdemar
 * Date: 22-03-2013
 * Time: 0:05
 * To change this template use File | Settings | File Templates.
 */
@Component
public class ForecastIOWeatherStrategy implements WeatherStrategy {

    @Autowired
    ForecastIOWindService forecastIOWindService;

    @Override
    public WindParameters getWindParameter(Location location) throws WeatherException {

        try{

            Optional<WindParameters> wind = forecastIOWindService.getWind(location);

            if(wind.isPresent())
                return wind.get();
            else
                throw new WeatherException("Could not retrive windParameters.", this.getClass().getName());
        }
        catch (WeatherException tr) {
            throw tr;
        }
        catch (Throwable tr) {
            throw new WeatherException(tr, this.getClass().getName());
        }
    }
}
