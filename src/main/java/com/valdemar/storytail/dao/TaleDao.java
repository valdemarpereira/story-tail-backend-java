package com.valdemar.storytail.dao;

import com.valdemar.storytail.model.Tale;
import org.springframework.data.mongodb.core.geo.Point;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: valdemar
 * Date: 4/3/13
 * Time: 10:55 PM
 * To change this template use File | Settings | File Templates.
 */
public interface TaleDao {
    boolean createTale(Tale tale);

    List<Tale> findTales(Point p, double distance);

    Tale getTale(String taleId);
}
