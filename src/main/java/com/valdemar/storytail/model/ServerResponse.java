package com.valdemar.storytail.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@Document
public class ServerResponse<T> {
    private boolean error;
    private String errorMessage;
    private T response;

    public ServerResponse(String errorMessage) {
        this.error = true;
        this.errorMessage = errorMessage;
    }

    public ServerResponse(T entity) {
        this.response = entity;
    }


}
