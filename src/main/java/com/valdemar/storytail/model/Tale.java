package com.valdemar.storytail.model;

import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: valdemar
 * Date: 05-03-2013
 * Time: 22:21
 * To change this template use File | Settings | File Templates.
 */
@XmlRootElement
public class Tale {

    private String id;

    private boolean lockedForEdit;
    private Date lockForEditDate;

    private String title;
    private String createdBy;
    private Date createDate;

    private String lastUpdatedBy;
    private Date lastUpdateDate;

    private int maxDays;
    private int maxInteractions;
    private Long travelDistance;
    private int interactions;
    private String language;
    @GeoSpatialIndexed
    private Location currentLocation;
    private String currentCity;
    private String currentCountry;
    private List<String> taildIds = new ArrayList<String>();

    /*
    public Tale(String title, String createdBy, int maxDays, int maxInteractions, Location currentLocation) {
        this.title = title;
        this.createdBy = createdBy;
        this.createDate = DateTime.now();
        this.lastUpdateDate = DateTime.now();
        this.maxDays = maxDays;
        this.maxInteractions = maxInteractions;
        this.currentLocation = currentLocation;
        this.lockedForEdit = false;
        this.interactions = 0;

    }
       */
    public boolean isLockedForEdit() {
        return lockedForEdit;
    }

    public void setLockedForEdit(boolean lockedForEdit) {
        this.lockedForEdit = lockedForEdit;
    }

    public Date getLockForEditDate() {
        return lockForEditDate;
    }

    public void setLockForEditDate(Date lockForEditDate) {
        this.lockForEditDate = lockForEditDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public int getMaxDays() {
        return maxDays;
    }

    public void setMaxDays(int maxDays) {
        this.maxDays = maxDays;
    }

    public int getMaxInteractions() {
        return maxInteractions;
    }

    public void setMaxInteractions(int maxInteractions) {
        this.maxInteractions = maxInteractions;
    }

    public Long getTravelDistance() {
        return travelDistance;
    }

    public void setTravelDistance(Long travelDistance) {
        this.travelDistance = travelDistance;
    }

    public int getInteractions() {
        return interactions;
    }

    public void setInteractions(int interactions) {
        this.interactions = interactions;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }

    public String getCurrentCity() {
        return currentCity;
    }

    public void setCurrentCity(String currentCity) {
        this.currentCity = currentCity;
    }

    public String getCurrentCountry() {
        return currentCountry;
    }

    public void setCurrentCountry(String currentCountry) {
        this.currentCountry = currentCountry;
    }

    public List<String> getTaildIds() {
        return taildIds;
    }

    public void setTaildIds(List<String> taildIds) {
        this.taildIds = taildIds;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void insertTailId(String tailId) {
        taildIds.add(tailId);
    }
}
