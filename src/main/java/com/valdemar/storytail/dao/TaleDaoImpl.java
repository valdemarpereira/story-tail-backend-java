package com.valdemar.storytail.dao;

import com.valdemar.storytail.model.Tale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.geo.Distance;
import org.springframework.data.mongodb.core.geo.Metrics;
import org.springframework.data.mongodb.core.geo.Point;
import org.springframework.data.mongodb.core.index.GeospatialIndex;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Created with IntelliJ IDEA.
 * User: valdemar
 * Date: 05-03-2013
 * Time: 18:48
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class TaleDaoImpl implements TaleDao {


    @Autowired
    MongoTemplate mongoTemplate;
    @Autowired
    TalesRepository repo;
    /**
     * Adds a new person
     */
    @Override
    public String createTale(Tale tale) {
        return repo.save(tale).getId();
    }

    @Override
    public List<Tale> findTales(Point p, double distance) {
        List<Tale> tales = repo.findByCurrentLocationNear(p, new Distance(distance, Metrics.KILOMETERS));

        return tales;
    }

    @Override
    public Tale getTale(String taleId) {
        return repo.findOne(taleId);
    }
}
