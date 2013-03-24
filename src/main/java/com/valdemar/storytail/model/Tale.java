package com.valdemar.storytail.model;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: valdemar
 * Date: 05-03-2013
 * Time: 22:21
 * To change this template use File | Settings | File Templates.
 */
public class Tale {

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
    private Location currentLocation;
    private String currentCity;
    private String currentCountry;

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
}
