package com.x7.ssad.ticketsystem.Utils;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.x7.ssad.ticketsystem.Cache.PreferenceDAO;

import java.io.IOException;
import java.util.HashSet;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by WangYinghao on 6/8/17.
 */

public class AddCookiesInterceptor implements Interceptor {

    PreferenceDAO Preferences;

    public AddCookiesInterceptor(Application a) {
        Preferences = PreferenceDAO.get();
        Preferences.init(a);
    }

    @Override
    public Response intercept(Chain chain) throws IOException {

        Request.Builder builder = chain.request().newBuilder();
        //TODO: retrieve cookies from local preferences
        HashSet<String> preferences = (HashSet<String>) Preferences.getCookieSets(new HashSet<String>());

        for (String cookie : preferences) {

            builder.addHeader("Cookie", cookie);
            Log.v("OkHttp", "Adding Header: " + cookie);

        }

        return chain.proceed(builder.build());

    }

}
