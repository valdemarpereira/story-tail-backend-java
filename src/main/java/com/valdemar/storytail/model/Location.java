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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Location location = (Location) o;

        if (Double.compare(location.lat, lat) != 0) return false;
        if (Double.compare(location.lon, lon) != 0) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = lat != +0.0d ? Double.doubleToLongBits(lat) : 0L;
        result = (int) (temp ^ (temp >>> 32));
        temp = lon != +0.0d ? Double.doubleToLongBits(lon) : 0L;
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
