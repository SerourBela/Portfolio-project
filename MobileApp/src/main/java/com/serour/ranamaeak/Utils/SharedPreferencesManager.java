package com.serour.ranamaeak.Utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;


public class SharedPreferencesManager {

    public static String getSharedPreference(Context mContext, String key)
    {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(mContext);
        return preferences.getString(key, "");
    }

    public static void setSharedPreference(Context mContext, String key ,String value)
    {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(mContext);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, value);
        editor.apply();
    }
    public static void Clear (Context mContext)
    {
    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(mContext);
    SharedPreferences.Editor editor = preferences.edit();
        editor.clear();
        editor.apply();
}
}