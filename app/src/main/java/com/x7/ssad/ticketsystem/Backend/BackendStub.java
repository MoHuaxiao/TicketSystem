package com.x7.ssad.ticketsystem.Backend;

import android.util.Log;

import com.x7.ssad.ticketsystem.Cache.CinemaCacheStub;
import com.x7.ssad.ticketsystem.Cache.MovieCacheStub;
import com.x7.ssad.ticketsystem.Cache.UserDAOStub;
import com.x7.ssad.ticketsystem.Model.Cinema;
import com.x7.ssad.ticketsystem.Model.Movie;
import com.x7.ssad.ticketsystem.Model.User;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Retrofit;

/**
 * Created by WangYinghao on 5/26/17.
 */

//TODO: Change this to a real backend communication system.
public class BackendStub {


    private static BackendStub ourInstance = new BackendStub();
    List<String> USERS;
    List<String> PASSWORDS;

    UserDAOStub UD;
    CinemaCacheStub CCS;
    MovieCacheStub MCS;

    Retrofit retrofit;

    private BackendStub() {
        USERS = new ArrayList<>();
        PASSWORDS = new ArrayList<>();

        UD = new UserDAOStub();
        CCS = new CinemaCacheStub();
        MCS = new MovieCacheStub();

        retrofit = new Retrofit.Builder().baseUrl("http://localhost:8081").build();

    }

    public static BackendStub getInstance() {
        return ourInstance;
    }

    //Precondition: Check Duplicate Before Using.
    public boolean addUser(String username, String password) {

        USERS.add(username);
        PASSWORDS.add(password);

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

    //Precondition: Check Duplicate Before Using.
    public boolean addUser(User u) {

        UD.getUserList().add(u);

        Log.d("Backend Stub", "User Added");

        return true;

    }

    public boolean userExists(User u) {

        for (int i = 0; i < UD.getUserList().size(); i++) {
            if (u.getEmail().equals(UD.getUserList().get(i).getEmail())) {
                Log.d("Backend Stub", "User exists.");
                return true;
            }
        }
        Log.d("Backend Stub", "User not exist.");
        return false;
    }

    //Precondition: Check Exist before using.
    public boolean verifyUser(User u) {

        for (int i = 0; i < UD.getUserList().size(); i++) {
            if (u.getEmail().equals(UD.getUserList().get(i).getEmail())) {
                if (u.getPassword().equals(UD.getUserList().get(i).getPassword())) {
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

    public Movie getMovieByID(int mid) { return MCS.getMovie(mid); }

    public List<Long> getCinemaIdsListByMovieId(int mid) { return CCS.getShowingCinemas(mid); }

    public Cinema getCinemaByID(Long cid) {
        return CCS.getCinemaByID(cid);
    }
}
