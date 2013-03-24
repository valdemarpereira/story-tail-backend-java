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
public class TaleDao {


    @Autowired
    MongoTemplate mongoTemplate;
    @Autowired
    TalesRepository repo;
    /**
     * Adds a new person
     */
    public boolean createTale(Tale tale) {
        mongoTemplate.indexOps(Tale.class).ensureIndex( new GeospatialIndex("currentLocation") );

        repo.save(tale);

        return true;
        /*
        try {
        mongoTemplate.insert(tale, "tales");
            return true;

        } catch (Exception e) {
            logger.error("An error has occurred while trying to add new tale", e);
            return false;
        } */
    }

    public List<Tale> findTales(Point p, double distance) {
        // when
     //   List<Tale> locations = repo.findByCurrentLocationWithin(circle);
        List<Tale> locations = repo.findByCurrentLocationNear(p, new Distance(distance, Metrics.KILOMETERS));

        return locations;
    }
}
