package com.valdemar.storytail.model;

import lombok.Data;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@Data
@Document

public class Woeid {

    private Date recordDate;
    private String woeid;
    private Location location;
    private String country;
    private String city;
    private String county;
    private String state;
}
