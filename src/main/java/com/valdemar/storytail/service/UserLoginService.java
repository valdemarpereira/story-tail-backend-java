package com.valdemar.storytail.service;

import com.valdemar.storytail.dao.UserRepository;
import com.valdemar.storytail.model.FacebookUserInfo;
import com.valdemar.storytail.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: valdemar
 * Date: 12/06/13
 * Time: 19:46
 * To change this template use File | Settings | File Templates.
 */
@Component
public class UserLoginService {

    @Autowired
    UserRepository userRepository;


    public UserInfo createOrUpdateUser(FacebookUserInfo fb) {

        UserInfo userInfo = userRepository.findByUsernameAndLoginType(fb.getUsername(), AuthLoginType.FACEBOOK);

        if(userInfo != null){
            updateUserInfo(userInfo);
        }
        else {

            userInfo = new UserInfo(fb.getUsername(), AuthLoginType.FACEBOOK);
            userInfo.setCreateDate(new Date());
            userInfo.setFirst_name(fb.getFirst_name());
            //TODO: Use a Enum
            userInfo.setGender(fb.getGender());
            userInfo.setLast_name(fb.getLast_name());
            userInfo.setLastLogin(new Date());
            userInfo.setLoginCount(1L);
            userInfo.setName(fb.getName());

           return userRepository.save(userInfo);
        }

        return userInfo;
    }

    private UserInfo updateUserInfo(UserInfo userInfo) {

        userInfo.setLastLogin(new Date());
        userInfo.setLoginCount(userInfo.getLoginCount() + 1);

        return userRepository.save(userInfo);
    }
}
