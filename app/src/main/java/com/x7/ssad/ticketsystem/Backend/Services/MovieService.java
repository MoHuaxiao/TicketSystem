package com.x7.ssad.ticketsystem.Backend.Services;

import com.x7.ssad.ticketsystem.Model.Movie;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by WangYinghao on 6/8/17.
 */

public interface MovieService {

    //Only Movie IDs are returned.
    @GET("/movie/air")
    Call<List<Movie>> getAirMovies();

    @GET("/movie/id/{id}")
    Call<Movie> getMovieByID(@Path("id") String id);

}
