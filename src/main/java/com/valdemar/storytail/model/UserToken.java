package com.valdemar.storytail.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;


@Data
@Document
public class UserToken {

    private String userId;
    private String token;
    private long valid;

}
