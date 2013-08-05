package com.valdemar.storytail.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document
public class Token {

    @Id
    private String id;
    @Indexed
    private final String userId;
    @Indexed
    private final String authToken;

    private Date date;

    private int counter;

}