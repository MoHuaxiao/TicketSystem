package com.x7.ssad.ticketsystem.Session;

import android.util.Pair;

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

    private String myEmail;
    private int myMovieID;
    private boolean isOnAir;
    private Long myCinemaID;

//    选中的座位的行列号的ArrayList，比如选了第一排第二个座位和第三排第四个座位，则元素为Pair(1, 2), Pair(3, 4)
    private ArrayList<Pair<Integer, Integer>> selectSeats;

    //Tips: 按Ctrl+N 可自动生成getter&setter.
    public String getMyEmail() {
        return myEmail;
    }

    public void setMyEmail(String myEmail) {
        this.myEmail = myEmail;
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
}
