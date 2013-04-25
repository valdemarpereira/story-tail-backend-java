package com.valdemar.storytail.weather;

import com.valdemar.storytail.exceptions.WeatherException;
import com.valdemar.storytail.model.Location;
import com.valdemar.storytail.model.WindParameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: valdemar
 * Date: 21-03-2013
 * Time: 21:44
 * To change this template use File | Settings | File Templates.
 */

@Component
public class WeatherProxy {

    @Autowired
    @Qualifier("yahooWeatherStrategy")
    WeatherStrategy yahooWeatherStrategy;

    @Qualifier("forecastIOWeatherStrategy")
    WeatherStrategy forecastIOWeatherStrategy;

    @Cacheable("defaultCache")
    public WindParameters getWind(Location location) throws WeatherException {

        //just one strategy to get weather
       // return yahooWeatherStrategy.getWindParameter(location);
        return forecastIOWeatherStrategy.getWindParameter(location);

    }


    // @Cacheable("windParameter")
  //  public WindParameters getWindParameters(String key) {

//WeatherStrategy


        //testar este servico com tests de carga


        //durante meia hora, pedir cerca de 100 pedidos por segundo.
        //terei que lancar thread para suportar pedidos ao mesmo tempo??

   // }
}
