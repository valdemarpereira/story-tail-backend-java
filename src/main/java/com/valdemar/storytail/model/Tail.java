package com.valdemar.storytail.model;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: valdemar.pereira
 * Date: 08/04/2013
 * Time: 14:29
 * To change this template use File | Settings | File Templates.
 */
public class Tail {

    private String id;

    private String tail;
    private String createdBy;
    private Date createDate;

    private Location location;
    private String city;
    private String country;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTail() {
        return tail;
    }

    public void setTail(String tail) {
        this.tail = tail;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
