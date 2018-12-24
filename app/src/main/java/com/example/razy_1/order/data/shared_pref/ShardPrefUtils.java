package com.example.razy_1.order.data.shared_pref;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.razy_1.order.data.beans.ListInfoUser;
import com.example.razy_1.order.data.beans.User;
import com.google.gson.Gson;

import java.util.List;

import static com.example.razy_1.order.data.shared_pref.ShardPrefKey.App_Name;
public class ShardPrefUtils {
    public static final String listUserInfo = "UserInfo";

    public static void saveSharedPreferencesLogList(Context context, List<User> infoUsers) {
        SharedPreferences mPrefs = context.getSharedPreferences(App_Name, context.MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = mPrefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(infoUsers);
        prefsEditor.putString(listUserInfo, json);
        prefsEditor.commit();

    }
}
