package com.valdemar.storytail.exceptions;

/**
 * Created with IntelliJ IDEA.
 * User: valdemar
 * Date: 5/27/13
 * Time: 6:17 PM
 * To change this template use File | Settings | File Templates.
 */
public class UserAuthenticationException extends Exception{

    public UserAuthenticationException(String message) {
        super(message);
    }

    public UserAuthenticationException(Exception e) {
        super(e);
    }

}
