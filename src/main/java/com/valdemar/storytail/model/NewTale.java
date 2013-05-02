package com.valdemar.storytail.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created with IntelliJ IDEA.
 * User: valdemar.pereira
 * Date: 08/04/2013
 * Time: 14:55
 * To change this template use File | Settings | File Templates.
 */
@XmlRootElement
public class NewTale extends Tale{

    private String tail;

    public String getTail() {
        return tail;
    }

    public void setTail(String tail) {
        this.tail = tail;
    }
}
