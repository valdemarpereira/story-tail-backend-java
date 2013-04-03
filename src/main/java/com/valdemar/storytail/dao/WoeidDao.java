package com.valdemar.storytail.dao;

import com.google.common.base.Optional;
import com.valdemar.storytail.model.Location;
import com.valdemar.storytail.model.Woeid;

/**
 * Created with IntelliJ IDEA.
 * User: valdemar
 * Date: 4/3/13
 * Time: 10:57 PM
 * To change this template use File | Settings | File Templates.
 */
public interface WoeidDao {
    boolean createWoeid(Woeid woeid);

    Optional<Woeid> findWoeid(Location location);
}
