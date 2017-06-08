package com.x7.ssad.ticketsystem.Cache;

import com.x7.ssad.ticketsystem.Model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by WangYinghao on 6/8/17.
 */

public class UserDAOStub {

    List<User> userList = new ArrayList<>();

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
