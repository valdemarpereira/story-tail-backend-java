package com.valdemar.storytail.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created with IntelliJ IDEA.
 * User: valdemar
 * Date: 24-03-2013
 * Time: 15:47
 * To change this template use File | Settings | File Templates.
 */
@XmlRootElement
public class ServerResponse<T> {
    private boolean error;
    private String errorMessage;
    private T response;

    public ServerResponse() {}

    public ServerResponse(String errorMessage) {
        this.error = true;
        this.errorMessage = errorMessage;
    }

    public ServerResponse(T entity) {
        this.response = entity;
    }

    public boolean isError() {
        return error;
    }

    public T getResponse() {
        return response;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
