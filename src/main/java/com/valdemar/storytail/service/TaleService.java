package com.valdemar.storytail.service;

import com.valdemar.storytail.model.Location;
import com.valdemar.storytail.model.NearTales;
import com.valdemar.storytail.model.Tale;
import com.valdemar.storytail.model.User;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: valdemar
 * Date: 4/3/13
 * Time: 10:50 PM
 * To change this template use File | Settings | File Templates.
 */
public interface TaleService {
    void createTale(User user, String title, Location currentLocation, int maxDays, int maxInteractions);

    NearTales findNearTales(Location location);

    Tale findTale(String taleId);

}
