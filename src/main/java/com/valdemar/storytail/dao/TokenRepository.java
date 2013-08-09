package com.valdemar.storytail.dao;

import com.valdemar.storytail.model.Token;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface TokenRepository extends MongoRepository<Token, String> {

    Token findByAuthToken(String authToken);

}
