package com.valdemar.storytail.dao;

import com.google.common.base.Optional;
import com.valdemar.storytail.model.Location;
import com.valdemar.storytail.model.Woeid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.index.GeospatialIndex;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: valdemar
 * Date: 05-03-2013
 * Time: 18:48
 * To change this template use File | Settings | File Templates.
 */
@Component
public class WoeidDao {

    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    WoeidRepository repo;
    /**
     * Adds a new person
     */
    public boolean createWoeid(Woeid woeid) {
        //TODO: Put this on a centraliza code
        mongoTemplate.indexOps(Woeid.class).ensureIndex( new GeospatialIndex("location") );
        repo.save(woeid);

        return true;
    }

    public Optional<Woeid> findWoeid(Location location) {
        Woeid woeid = repo.findBylocation(location);

        if(woeid == null)
            return Optional.absent();
        else
            return Optional.of(woeid);
    }
}
