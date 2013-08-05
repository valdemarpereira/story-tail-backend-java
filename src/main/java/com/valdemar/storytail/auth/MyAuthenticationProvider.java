package com.valdemar.storytail.auth;

import com.valdemar.storytail.model.UserInfo;
import com.valdemar.storytail.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;


@Controller
public class MyAuthenticationProvider implements UserDetailsService {


        @Autowired
    UserLoginService userLoginService;


    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {

        UserInfo userInfo = userLoginService.getUserInfoByUserId(userId);

        if(userInfo == null)
            throw new UsernameNotFoundException(userId);

        List<GrantedAuthority> grantedAuths = new ArrayList<GrantedAuthority>();
        grantedAuths.add(new SimpleGrantedAuthority("ROLE_USER"));

        UserDetails loadedUser = new User(userInfo.getUsername(),"null", grantedAuths);

        return loadedUser;

    }
}
