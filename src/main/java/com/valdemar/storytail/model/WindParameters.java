package com.valdemar.storytail.model;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: valdemar
 * Date: 21-03-2013
 * Time: 21:48
 * To change this template use File | Settings | File Templates.
 */
public class WindParameters implements Serializable{
    private final float windSpeed;
    private final int windDirection;

    public WindParameters(float windSpeed, int windDirection) {
        this.windSpeed = windSpeed;
        this.windDirection = windDirection;
    }

    public float getWindSpeed() {
        return windSpeed;
    }

    public float getWindDirection() {
        return windDirection;
    }
}
