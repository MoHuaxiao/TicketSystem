package com.x7.ssad.ticketsystem.Model;

/**
 * Created by WangYinghao on 6/8/17.
 */

public class User  {

    String email;
    String password;

    public User(String e, String p) {
        email = e;
        password = p;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
