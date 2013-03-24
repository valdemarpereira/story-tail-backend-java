package com.valdemar.storytail.service;

import com.valdemar.storytail.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: valdemar
 * Date: 05-03-2013
 * Time: 19:14
 * To change this template use File | Settings | File Templates.
 */
@Service
public class UserService {

    @Autowired
    UserDao userDao;

    public void createUser() {


    }
}
