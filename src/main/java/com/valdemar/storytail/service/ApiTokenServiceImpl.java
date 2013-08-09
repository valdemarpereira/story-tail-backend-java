package com.valdemar.storytail.service;

import com.valdemar.storytail.auth.TokenUtils;
import com.valdemar.storytail.dao.TokenRepository;
import com.valdemar.storytail.model.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: valdemar
 * Date: 12/06/13
 * Time: 20:41
 * To change this template use File | Settings | File Templates.
 */
@Component
public class ApiTokenServiceImpl implements ApiTokenService {

    @Autowired
    TokenRepository repo;

    public String generateToken(String userId){

        Token token = new Token(userId, TokenUtils.generateToken());

        repo.save(token);

        return token.getAuthToken();
    }

    @Override
    public String getUserIdFromToken(String token) {

        //TODO check for null
        Token tokenDb = repo.findByAuthToken(token);

        return tokenDb == null? null : tokenDb.getUserId();

    }


    //    String getToken(UserDetails userDetails);
//    String getToken(UserDetails userDetails, Long expiration);
//    boolean validate(String token);
//    UserDetails getUserFromToken(String token);

}
