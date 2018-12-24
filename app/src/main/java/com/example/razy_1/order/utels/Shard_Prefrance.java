package com.example.razy_1.order.utels;

import android.app.Activity;
import android.content.SharedPreferences;

public class Shard_Prefrance {
    public static final String PREFERENCES_FILE_NAME = "MyAppPreferences";
    public static void setLangRefrance(String lang, Activity activity){
        SharedPreferences settingsfile= activity.getSharedPreferences(PREFERENCES_FILE_NAME,0);
        SharedPreferences.Editor myeditor = settingsfile.edit();
        myeditor.putString("Name", lang);
        myeditor.apply();

    }
}
