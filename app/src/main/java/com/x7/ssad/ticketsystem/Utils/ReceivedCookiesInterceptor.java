package com.x7.ssad.ticketsystem.Utils;

import android.app.Application;
import android.content.Context;

import com.x7.ssad.ticketsystem.Cache.PreferenceDAO;

import java.io.IOException;
import java.util.HashSet;

import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * Created by WangYinghao on 6/8/17.
 */

public class ReceivedCookiesInterceptor implements Interceptor {

    PreferenceDAO Preferences;

    public ReceivedCookiesInterceptor(Application a) {
        Preferences = PreferenceDAO.get();
        Preferences.init(a);
    }

    @Override
    public Response intercept(Chain chain) throws IOException {

        Response originalResponse = chain.proceed(chain.request());

        if (!originalResponse.headers("Set-Cookie").isEmpty()) {

            HashSet<String> cookies = new HashSet<>();

            for (String header : originalResponse.headers("Set-Cookie")) {
                cookies.add(header);
            }

            //TODO: persist all cookies into local preferences
            Preferences.putCookieSets(cookies);

        }

        return originalResponse;

    }

}
