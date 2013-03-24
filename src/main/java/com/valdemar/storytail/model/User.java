package com.valdemar.storytail.model;


import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: valdemar
 * Date: 02-03-2013
 * Time: 23:32
 * To change this template use File | Settings | File Templates.
 */
public class User {
    String username;
    String password;
    String email;
    Date birthday;
    Date createDate;
    Date lastLogin;
    Long nrLogins;

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Long getNrLogins() {
        return nrLogins;
    }

    public void setNrLogins(Long nrLogins) {
        this.nrLogins = nrLogins;
    }
}
