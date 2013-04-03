package com.valdemar.storytail.service;

import com.valdemar.storytail.dao.TaleDao;
import com.valdemar.storytail.model.Location;
import com.valdemar.storytail.model.NearTales;
import com.valdemar.storytail.model.Tale;
import com.valdemar.storytail.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.geo.Point;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: valdemar
 * Date: 05-03-2013
 * Time: 19:14
 * To change this template use File | Settings | File Templates.
 */
@Service
public class TaleServiceImpl implements TaleService {

    @Autowired
    TaleDao taleDao;

    private static final int NEAR = 300; //300 meters
    private static final int NEAR_INC = 200;
    private static final int NEAR_INC_MAX = 1100;



    @Override
    public void createTale(User user, String title, Location currentLocation, int maxDays, int maxInteractions) {

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

    @Override
    public NearTales findNearTales(Location location){

        Point point = new Point(location.getLat(), location.getLon());

        List<Tale> tales = null;
        int computedNear = 0;

        while(computedNear < NEAR_INC_MAX) {

            tales = taleDao.findTales(point, (NEAR + computedNear) / 1000.00);
            if(tales.size() > 0)
                break;
            else
                computedNear += NEAR_INC;
        }

        return new NearTales(tales, NEAR + computedNear);
    }

    @Override
    public Tale findTale(String taleId) {
        return taleDao.getTale(taleId);
    }
}
