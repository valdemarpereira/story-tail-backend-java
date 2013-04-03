package com.valdemar.storytail.dao;

import com.valdemar.storytail.model.User;

/**
 * Created with IntelliJ IDEA.
 * User: valdemar
 * Date: 4/3/13
 * Time: 10:56 PM
 * To change this template use File | Settings | File Templates.
 */
public interface UserDao {
    boolean createUser(User user);
}
