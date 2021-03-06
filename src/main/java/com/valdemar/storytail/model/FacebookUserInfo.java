package com.valdemar.storytail.model;

import lombok.Data;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class FacebookUserInfo {

    private String id;
    private String name;
    private String first_name;
    private String last_name;
    private String username;
    private String gender;
    private String locale;
}
