package com.valdemar.storytail.exceptions;

import org.springframework.http.HttpStatus;

/**
 * Created with IntelliJ IDEA.
 * User: valdemar
 * Date: 22-03-2013
 * Time: 15:00
 * To change this template use File | Settings | File Templates.
 */
public class RestClientFailedException extends Exception {

    private HttpStatus httpStatus;

    public RestClientFailedException(Exception e, HttpStatus httpStatus) {
        super(e);
        this.httpStatus = httpStatus;
    }

    public RestClientFailedException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
