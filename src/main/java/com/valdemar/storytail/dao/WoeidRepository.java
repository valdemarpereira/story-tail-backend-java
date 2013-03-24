package com.valdemar.storytail.dao;

import com.valdemar.storytail.model.Location;
import com.valdemar.storytail.model.Woeid;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created with IntelliJ IDEA.
 * User: valdemar
 * Date: 13-03-2013
 * Time: 21:04
 * To change this template use File | Settings | File Templates.
 */
public interface WoeidRepository extends MongoRepository<Woeid, String> {

    Woeid findBylocation(Location location);
}
