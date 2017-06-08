package com.x7.ssad.ticketsystem.Backend;

import android.app.Application;
import android.content.Context;
import android.util.DebugUtils;
import android.util.Log;

import com.google.gson.Gson;
import com.x7.ssad.ticketsystem.Backend.Services.LoginService;
import com.x7.ssad.ticketsystem.Backend.Services.MovieService;
import com.x7.ssad.ticketsystem.Cache.CinemaCacheStub;
import com.x7.ssad.ticketsystem.Cache.MovieCacheStub;
import com.x7.ssad.ticketsystem.Cache.UserDAOStub;
import com.x7.ssad.ticketsystem.Model.Cinema;
import com.x7.ssad.ticketsystem.Model.Movie;
import com.x7.ssad.ticketsystem.Model.User;
import com.x7.ssad.ticketsystem.Utils.AddCookiesInterceptor;
import com.x7.ssad.ticketsystem.Utils.ReceivedCookiesInterceptor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.prefs.Preferences;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by WangYinghao on 5/26/17.
 */

//TODO: Change this to a real backend communication system.
public class BackendStub {

    public static final String BACKEND_SERVER_URI = "http://192.168.1.236:8081";

    private static BackendStub ourInstance = new BackendStub();

    CinemaCacheStub CCS;
    MovieCacheStub MCS;

    LoginService loginService;
    MovieService movieService;

    private BackendStub() {

        CCS = new CinemaCacheStub();
        MCS = new MovieCacheStub();

    }

    public static BackendStub getInstance() {
        return ourInstance;
    }

    public void init(Application c) {

        HttpLoggingInterceptor hli = new HttpLoggingInterceptor();
        hli.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new AddCookiesInterceptor(c))
                .addInterceptor(new ReceivedCookiesInterceptor(c))
                .addInterceptor(hli)
                .build();
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BACKEND_SERVER_URI).callFactory(okHttpClient).addConverterFactory(GsonConverterFactory.create()).build();
        loginService = retrofit.create(LoginService.class);
        movieService = retrofit.create(MovieService.class);

    }

    public int login(User u) {

        Call<ResponseBody> loginCall = loginService.login(u);

        try {
            switch (loginCall.execute().code()) {
                //User not exists
                case 200:
                    Log.d("Backend::Login", "Login Success");
                    return 200;
                //User exists
                case 201:
                    Log.d("Backend::Login", "User Created");
                    return 201;
                case 202:
                    Log.d("Backend::Login", "User already logged in");
                    return 202;
                case 400:
                    Log.d("Backend::Login", "Wrong Password");
                    return 400;
                default:
                    Log.d("Backend::Login", "Unknown return code");
                    return 404;
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }

        Log.d("Backend::Login", "Unknown error");
        return 500;

    }

    public List<Movie> getHotOnAirMovies() {
        return MCS.getMovieList(movieService);
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
