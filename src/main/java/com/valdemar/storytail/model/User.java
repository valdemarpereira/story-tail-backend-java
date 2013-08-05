package com.valdemar.storytail.model;


import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@Data
@Document
public class User {

    final String username;
    final String password;
    final String email;
    Date birthday;
    Date createDate;
    Date lastLogin;
    Long nrLogins;

}
