package com.x7.ssad.ticketsystem.Backend;

import android.util.Log;

import com.x7.ssad.ticketsystem.Cache.CinemaCacheStub;
import com.x7.ssad.ticketsystem.Cache.MovieCacheStub;
import com.x7.ssad.ticketsystem.Model.Cinema;
import com.x7.ssad.ticketsystem.Model.Movie;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by WangYinghao on 5/26/17.
 */

//TODO: Change this to a real backend communication system.
public class BackendStub {
    private static BackendStub ourInstance = new BackendStub();
    List<String> USERS;
    List<String> PASSWORDS;
    CinemaCacheStub CCS;
    MovieCacheStub MCS;

    private BackendStub() {
        USERS = new ArrayList<>();
        PASSWORDS = new ArrayList<>();
    }

    public static BackendStub getInstance() {
        return ourInstance;
    }

    //Precondition: Check Duplicate Before Using.
    public boolean addUser(String username, String password) {

        USERS.add(username);
        PASSWORDS.add(password);

        CCS = new CinemaCacheStub();
        MCS = new MovieCacheStub();

        Log.d("Backend Stub", "User Added");

        return true;

    }

    public boolean userExists(String username) {
        for (int i = 0; i < USERS.size(); i++) {
            if (username.equals(USERS.get(i))) {
                Log.d("Backend Stub", "User exists.");
                return true;
            }
        }
        Log.d("Backend Stub", "User not exist.");
        return false;
    }

    //Precondition: Check Exist before using.
    public boolean verifyUser(String username, String password) {

        for (int i = 0; i < USERS.size(); i++) {
            if (username.equals(USERS.get(i))) {
                if (password.equals(PASSWORDS.get(i))) {
                    Log.d("Backend Stub", "Log in Successful.");
                    return true;
                }
                else {
                    Log.d("Backend Stub", "Password Incorrect.");
                    return false;
                }
            }
        }

        Log.d("Backend Stub", "Unknown Error.");
        return false;

    }

    public List<Movie> getHotOnAirMovies() {
        return MCS.getMovieList();
    }

    public List<Cinema> getCinemaList() {
        return CCS.getCinemaList();
    }

}
