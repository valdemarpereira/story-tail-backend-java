package com.valdemar.storytail.service;

import com.valdemar.storytail.model.FacebookUserInfo;
import com.valdemar.storytail.model.UserInfo;


public interface UserLoginService {

    public UserInfo createOrUpdateUser(FacebookUserInfo fb);
    public UserInfo getUserInfoByUserId(String userId);
}
