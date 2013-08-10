package com.valdemar.storytail.model;

import com.valdemar.storytail.util.Utils;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.xml.bind.annotation.XmlRootElement;
import java.text.DecimalFormat;

@Document
public final class Location {

    private  double  lat;
    private  double  lon;

    public Location() {

    }

    public Location(double lat, double lon) {
        this.lat = lat;
        this.lon = lon;
    }

    public double getLat() {
        return lat;
    }
    public double getLon() {
        return lon;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public void setLon(double lon) {
        this.lon = lon;
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
