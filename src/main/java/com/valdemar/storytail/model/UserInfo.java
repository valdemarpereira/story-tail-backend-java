package com.valdemar.storytail.model;

import com.valdemar.storytail.service.AuthLoginType;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document
public class UserInfo {

    @Id
    private String id;
    @Indexed
    private final String username;
    @Indexed
    private final AuthLoginType loginType;

    private String name;
    private String first_name;
    private String last_name;
    private String gender;
    private String locale;
    private Date createDate;
    private Date lastLogin;
    private Long loginCount;

    @Transient
    private String apiToken;
}
