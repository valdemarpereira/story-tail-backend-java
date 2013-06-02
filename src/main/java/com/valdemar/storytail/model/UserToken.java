package com.valdemar.storytail.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: valdemar
 * Date: 5/27/13
 * Time: 6:31 PM
 * To change this template use File | Settings | File Templates.
 */
@Data
@Document
public class UserToken {

    private String userId;
    private String token;
    private long valid;

}
