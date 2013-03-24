package com.valdemar.storytail.exceptions;

/**
 * Created with IntelliJ IDEA.
 * User: valdemar
 * Date: 22-03-2013
 * Time: 15:00
 * To change this template use File | Settings | File Templates.
 */
public class RestClientFatalException extends Exception {

    public RestClientFatalException(String message) {
        super(message);
    }

    public RestClientFatalException(Exception e) {
        super(e);
    }
}
