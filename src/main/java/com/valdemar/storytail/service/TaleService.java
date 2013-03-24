package com.valdemar.storytail.service;

import com.valdemar.storytail.dao.TaleDao;
import com.valdemar.storytail.model.Location;
import com.valdemar.storytail.model.Tale;
import com.valdemar.storytail.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: valdemar
 * Date: 05-03-2013
 * Time: 19:14
 * To change this template use File | Settings | File Templates.
 */
@Service
public class TaleService {

    @Autowired
    TaleDao taleDao;


    public void createTale( User user,String title, Location currentLocation, int maxDays, int maxInteractions) {

        Tale tale = new Tale();
        tale.setTitle(title);
        tale.setCreatedBy(user.getPassword());
        tale.setCreateDate(new Date());
        tale.setLastUpdateDate(new Date());
        tale.setMaxDays(maxDays);
        tale.setMaxInteractions(maxInteractions);
        tale.setLockedForEdit(false);
        tale.setInteractions(0);
        tale.setCurrentLocation(currentLocation);
        // tale.location = location;

        taleDao.createTale(tale);


    }
}
