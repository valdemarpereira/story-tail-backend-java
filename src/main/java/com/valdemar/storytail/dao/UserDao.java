package com.valdemar.storytail.dao;

import com.valdemar.storytail.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;


/**
 * Created with IntelliJ IDEA.
 * User: valdemar
 * Date: 05-03-2013
 * Time: 18:48
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class UserDao {


    @Autowired
    MongoTemplate mongoTemplate;
    /**
     * Adds a new person
     */
    public boolean createUser(User user) {

        try {
        mongoTemplate.insert(user, "users");
            return true;

        } catch (Exception e) {
            return false;
        }
    }

}
