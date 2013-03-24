package com.valdemar.storytail.exceptions;

/**
 * Created with IntelliJ IDEA.
 * User: valdemar
 * Date: 24-03-2013
 * Time: 17:00
 * To change this template use File | Settings | File Templates.
 */
public class WeatherException extends Exception {

    private final String strategyName;

    public WeatherException(Throwable cause, String strategyName) {
        super(cause);
        this.strategyName = strategyName;
    }

    public WeatherException(String message, String strategyName) {
        super(message);
        this.strategyName = strategyName;
    }

    public String getStrategyName() {
        return strategyName;
    }
}
