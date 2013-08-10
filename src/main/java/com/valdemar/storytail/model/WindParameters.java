package com.valdemar.storytail.model;

import lombok.Data;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Data
@Document
@JsonDeserialize(using = WindParametersDeserializer.class)
public class WindParameters implements Serializable{
    private final float windSpeed;
    private final int windDirection;

}
