package com.valdemar.storytail.service;

import com.valdemar.storytail.dao.TailDao;
import com.valdemar.storytail.dao.TaleDao;
import com.valdemar.storytail.exceptions.NewTaleCreationException;
import com.valdemar.storytail.model.*;
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
    @Autowired
    TailDao tailDao;

    private static final int NEAR = 300; //300 meters
    private static final int NEAR_INC = 200;
    private static final int NEAR_INC_MAX = 1100;



    @Override
    public void createNewTale(NewTale tale) throws NewTaleCreationException {

        Tail tail = new Tail();
        tail.setTail(tale.getTail());
        tail.setCity(tale.getCurrentCity());
        tail.setCountry(tale.getCurrentCountry());
        tail.setCreateDate(new Date());
        tail.setLocation(tale.getCurrentLocation());
        tail.setCreatedBy(tale.getCreatedBy());

        String tailId = tailDao.insertTail(tail);

        if("".equals(tailId))
            throw new NewTaleCreationException("Could not create a new tale... ");

        tale.setCreateDate(new Date());
        tale.setLastUpdateDate(new Date());
        tale.setLockedForEdit(false);
        tale.setInteractions(0);
        tale.insertTailId(tailId);

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
