package com.example.network_activities.login.view;

import static com.example.network_activities.login.constants.MYSHARED_PREF;
import static com.example.network_activities.login.constants.USER_PROFILE;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.network_activities.login.model.UserProfileModel;
import com.google.gson.Gson;


public class SharedPreferencesManager {

    private static SharedPreferencesManager instance;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;


    private SharedPreferencesManager(Context context) {
        sharedPreferences = context.getSharedPreferences(MYSHARED_PREF, Context.MODE_PRIVATE);
    }

    public static synchronized SharedPreferencesManager getInstance(Context context) {
        if (instance == null) {
            instance = new SharedPreferencesManager(context.getApplicationContext());
        }
        return instance;
    }

    public String getString(String key) {
        return sharedPreferences.getString(key, null);
    }

    public void saveUserProfile(UserProfileModel userProfile) {
        Gson gson = new Gson();
        editor = sharedPreferences.edit();
        String userProfileJson = gson.toJson(userProfile);
        editor.putString(USER_PROFILE, userProfileJson);
        editor.apply();
    }

}
