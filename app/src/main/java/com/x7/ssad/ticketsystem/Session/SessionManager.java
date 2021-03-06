package com.x7.ssad.ticketsystem.Session;

import android.util.Pair;

import com.x7.ssad.ticketsystem.Model.User;

import java.util.ArrayList;

/**
 * Created by WangYinghao on 5/31/17.
 */

public class SessionManager {
    private static final SessionManager ourInstance = new SessionManager();

    public static SessionManager getInstance() {
        return ourInstance;
    }

    private SessionManager() {
        selectSeats = new ArrayList<>();
    }

    private User myUser;
    private int myMovieID = -1;
    private boolean isOnAir;
    private Long myCinemaID;
//    上映时间和结束时间
    public String startTime;
    public String endTime;

//    选中的座位的行列号的ArrayList，比如选了第一排第二个座位和第三排第四个座位，则元素为Pair(1, 2), Pair(3, 4)
    private ArrayList<Pair<Integer, Integer>> selectSeats;

    //Tips: 按Ctrl+N 可自动生成getter&setter.

    public User getMyUser() {
        return myUser;
    }

    public void setMyUser(User myUser) {
        this.myUser = myUser;
    }

    public int getMyMovieID() {
        return myMovieID;
    }

    public void setMyMovieID(int myMovieID) {
        this.myMovieID = myMovieID;
    }

    public boolean isOnAir() {
        return isOnAir;
    }

    public void setOnAir(boolean onAir) {
        isOnAir = onAir;
    }

    public ArrayList<Pair<Integer, Integer>> getSelectSeats() { return selectSeats;}

    public void setSelectSeats(ArrayList<Pair<Integer, Integer>> selectSeats) {
        this.selectSeats = selectSeats;
    }

    public Long getMyCinemaID() {
        return myCinemaID;
    }

    public void setMyCinemaID(Long myCinemaID) {
        this.myCinemaID = myCinemaID;
    }

    public String getStartTime() {
        return this.startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return this.endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
