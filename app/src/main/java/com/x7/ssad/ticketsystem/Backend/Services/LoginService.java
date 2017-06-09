package com.x7.ssad.ticketsystem.Backend.Services;

import com.x7.ssad.ticketsystem.Model.User;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by WangYinghao on 6/8/17.
 */

public interface LoginService {

    @POST("login")
    Call<ResponseBody> login(@Body User user);

    @GET("login/exists/{email}")
    Call<ResponseBody> checkExists(@Path("email") String email);

}
