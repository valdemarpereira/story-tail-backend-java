package com.valdemar.storytail.model;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: valdemar
 * Date: 4/3/13
 * Time: 11:08 PM
 * To change this template use File | Settings | File Templates.
 */
public final class NearTales {

    private List<Tale> tales;
    private int distanceInMeters;


    public NearTales(List<Tale> tales, int distanceInMeters) {
        this.tales = tales;
        this.distanceInMeters = distanceInMeters;
    }

    public List<Tale> getTales() {
        return tales;
    }

    public long getDistanceInMeters() {
        return distanceInMeters;
    }
}
