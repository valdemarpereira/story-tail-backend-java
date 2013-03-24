package com.valdemar.storytail.exceptions;

/**
 * Created with IntelliJ IDEA.
 * User: valdemar
 * Date: 23-03-2013
 * Time: 21:41
 * To change this template use File | Settings | File Templates.
 */
public class YahooWOEIDServiceException extends Exception {

    public YahooWOEIDServiceException(String message) {
        super(message);
    }

    public YahooWOEIDServiceException(Exception e) {
        super(e);
    }
}
