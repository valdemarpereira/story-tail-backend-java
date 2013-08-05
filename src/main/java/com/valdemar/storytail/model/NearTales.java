package com.valdemar.storytail.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Data
@Document
public final class NearTales {

    private final List<Tale> tales;
    private final int distanceInMeters;
}
