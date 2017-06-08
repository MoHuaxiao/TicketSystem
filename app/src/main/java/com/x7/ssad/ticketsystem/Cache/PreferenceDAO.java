package com.x7.ssad.ticketsystem.Cache;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by WangYinghao on 6/8/17.
 */

public class PreferenceDAO {

    private static PreferenceDAO instance;

    public static PreferenceDAO get() {
        if (instance == null) instance = getSync();
        return instance;
    }

    private static synchronized PreferenceDAO getSync() {
        if (instance == null) instance = new PreferenceDAO();
        return instance;
    }

    private PreferenceDAO() {
    }

    public void init(Application a) {
        preferences = a.getSharedPreferences("TicketSystem", Context.MODE_PRIVATE);
        editor = preferences.edit();

    }

    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    public Set<String> getCookieSets(HashSet<String> cookies) {

        return preferences.getStringSet("COOKIES", cookies);

    }

    public void putCookieSets(HashSet<String> cookies) {

        editor.putStringSet("COOKIES", cookies);
        editor.commit();

    }
}
