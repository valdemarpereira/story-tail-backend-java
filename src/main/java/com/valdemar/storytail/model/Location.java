package com.valdemar.storytail.model;

import com.valdemar.storytail.util.Utils;

import java.text.DecimalFormat;

/**
 * Created with IntelliJ IDEA.
 * User: valdemar
 * Date: 05-03-2013
 * Time: 22:42
 * To change this template use File | Settings | File Templates.
 */
public final class Location {

    private final double  lat;
    private final  double  lon;

    public Location(double lat, double lon) {
        this.lat = Utils.roundLocationWith2DecimalPlaces(lat);
        this.lon = Utils.roundLocationWith2DecimalPlaces(lon);
    }

    public double getLat() {
        return lat;
    }
    public double getLon() {
        return lon;
    }
}
