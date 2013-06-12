package com.valdemar.storytail.dao;

import com.valdemar.storytail.model.Tale;
import com.valdemar.storytail.model.UserInfo;
import com.valdemar.storytail.service.AuthLoginType;
import org.springframework.data.mongodb.core.geo.Box;
import org.springframework.data.mongodb.core.geo.Circle;
import org.springframework.data.mongodb.core.geo.Distance;
import org.springframework.data.mongodb.core.geo.Point;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: valdemar
 * Date: 13-03-2013
 * Time: 21:04
 * To change this template use File | Settings | File Templates.
 */
public interface UserRepository extends MongoRepository<UserInfo, String> {

    UserInfo findByUsernameAndLoginType(String userName, AuthLoginType loginType);

    UserInfo findById(String id);

}
