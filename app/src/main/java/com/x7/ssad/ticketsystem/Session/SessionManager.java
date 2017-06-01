package com.x7.ssad.ticketsystem.Session;

/**
 * Created by WangYinghao on 5/31/17.
 */

public class SessionManager {
    private static final SessionManager ourInstance = new SessionManager();

    public static SessionManager getInstance() {
        return ourInstance;
    }

    private SessionManager() {
    }

    private String myEmail;
    private int myMovieID;
    private boolean isOnAir;

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
}
