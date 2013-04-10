package com.valdemar.storytail.dao;

import com.valdemar.storytail.model.Tail;
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
public class TailDaoImpl implements TailDao {

    @Autowired
    MongoTemplate mongoTemplate;
    @Autowired
    TailRepository repo;
    /**
     * Adds a new person
     */
    @Override
    public String insertTail(Tail tail) {
        mongoTemplate.indexOps(Tail.class).ensureIndex( new GeospatialIndex("location") );

        return repo.save(tail).getId();
    }

    @Override
    public Tail findTail(String taleId) {
        return repo.findOne(taleId);
    }
}
