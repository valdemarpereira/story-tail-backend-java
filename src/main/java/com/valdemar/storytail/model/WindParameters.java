package com.valdemar.storytail.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Data
@Document
public class WindParameters implements Serializable{
    private final float windSpeed;
    private final int windDirection;

}
