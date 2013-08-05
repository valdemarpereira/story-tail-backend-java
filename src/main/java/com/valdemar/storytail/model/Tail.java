package com.valdemar.storytail.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;


@Data
@Document
public class Tail {

    @Id
    private String id;
    private String tail;
    private String createdBy;
    private Date createDate;
    @GeoSpatialIndexed
    private Location location;
    private String city;
    private String country;
}
