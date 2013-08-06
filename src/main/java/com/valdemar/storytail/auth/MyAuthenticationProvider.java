package com.valdemar.storytail.auth;

import com.valdemar.storytail.model.UserInfo;
import com.valdemar.storytail.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;



@Component
public class MyAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    UserLoginService userLoginService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String userId = authentication.getName();
        String token = authentication.getCredentials().toString();

        if(userId == null)
            throw new CredentialsExpiredException("xpto");


        UserInfo userInfo = userLoginService.getUserInfoByUserId(userId);

        if(userInfo == null)
            throw new UsernameNotFoundException(userId);

        List<GrantedAuthority> grantedAuths = new ArrayList<GrantedAuthority>();
        grantedAuths.add(new SimpleGrantedAuthority("ROLE_USER"));

        Authentication auth = new UsernamePasswordAuthenticationToken(userId, token, grantedAuths);
//            return auth;

        return auth;


//        if (name.equals("admin") && password.equals("system")) {
//            List<GrantedAuthority> grantedAuths = new ArrayList<GrantedAuthority>();
//            grantedAuths.add(new SimpleGrantedAuthority("ROLE_USER"));
//            Authentication auth = new UsernamePasswordAuthenticationToken(name, password, grantedAuths);
//            return auth;
//        } else {
//            return null;
//        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}

/*
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
*/