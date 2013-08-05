package com.valdemar.storytail.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Document
public class Tale {

    @Id
    private String id;
    private boolean lockedForEdit;
    private Date lockForEditDate;
    private String title;
    @Indexed
    private String createdBy;
    private Date createDate;
    private String lastUpdatedBy;
    private Date lastUpdateDate;
    private int maxDays;
    private int maxInteractions;
    private Long travelDistance;
    private int interactions;
    private String language;
    @GeoSpatialIndexed
    private Location currentLocation;
    private String currentCity;
    private String currentCountry;
    private List<String> taildIds = new ArrayList<String>();

    public void insertTailId(String tailId) {
        taildIds.add(tailId);
    }
}
