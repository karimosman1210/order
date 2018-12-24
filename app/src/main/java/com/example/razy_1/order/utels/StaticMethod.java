package com.example.razy_1.order.utels;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.util.TypedValue;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AutoCompleteTextView;
import android.widget.LinearLayout;

import com.example.razy_1.order.data.beans.CartItem;
import com.example.razy_1.order.data.beans.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.text.DecimalFormat;
import java.util.List;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.os.ParcelFileDescriptor.MODE_WORLD_READABLE;
import static com.example.razy_1.order.data.shared_pref.ShardPrefKey.App_Name;
import static com.example.razy_1.order.utels.AppConstant.BASE_URL_ORDER;

public class StaticMethod {

    public static Retrofit RetrofitDataInsc() {
        Retrofit retrofit = null;
        final String BASE_URL = BASE_URL_ORDER;
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public static void oriantation(Activity activity){
        activity.requestWindowFeature(Window.FEATURE_NO_TITLE);
        activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        activity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

    }


    public static List<User> getListSharedRef(String key, Context context){

        @SuppressLint("WrongConstant") SharedPreferences prefs = context.getSharedPreferences(App_Name, context.MODE_PRIVATE);

        Gson gson = new Gson();

        String json = prefs.getString(key, null);

        Type type = new TypeToken<List<User>>() {}.getType();

        return gson.fromJson(json, type);

    }

    public static String convertDecemal(String d) {
        DecimalFormat decimalFormat = new DecimalFormat("####.0");
        String formattedValue = decimalFormat.format(Double.valueOf(d));
        return formattedValue;
    }

    public static void addToCart(CartItem cartItem) {

        Integer id = cartItem.items.getProductId();

        if (StaticConfig.items.containsKey(id)) {
            StaticConfig.items.get(id).quantity += cartItem.quantity;

        } else {
            StaticConfig.items.put(id, cartItem);

        }
    }


    public static boolean pemissionCamera(Activity context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ActivityCompat.checkSelfPermission(context,
                    Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED &&
                    ActivityCompat.checkSelfPermission(context,
                            Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(context,
                        new String[]{Manifest.permission.CAMERA,
                                Manifest.permission.CAMERA}, 1);
                return true;
            } else {
                Log.e("DB", "PERMISSION GRANTED");
                return false;
            }
        }
        return false;
    }

    public static boolean isConnectingToInternet(Context _context) {
        ConnectivityManager connectivity = (ConnectivityManager) _context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity != null) {
            NetworkInfo[] info = connectivity.getAllNetworkInfo();
            if (info != null)
                for (int i = 0; i < info.length; i++)
                    if (info[i].getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }
        }
        return false;
    }
    public static void setSearchviewTextSize(SearchView searchView, int fontSize) {
        try {
            AutoCompleteTextView autoCompleteTextViewSearch = (AutoCompleteTextView) searchView.findViewById(searchView.getContext().getResources().getIdentifier("app:id/search_src_text", null, null));
            if (autoCompleteTextViewSearch != null) {
                autoCompleteTextViewSearch.setTextSize(TypedValue.COMPLEX_UNIT_SP, fontSize);
            } else {
                LinearLayout linearLayout1 = (LinearLayout) searchView.getChildAt(0);
                LinearLayout linearLayout2 = (LinearLayout) linearLayout1.getChildAt(2);
                LinearLayout linearLayout3 = (LinearLayout) linearLayout2.getChildAt(1);
                AutoCompleteTextView autoComplete = (AutoCompleteTextView) linearLayout3.getChildAt(0);
                autoComplete.setTextSize(TypedValue.COMPLEX_UNIT_SP, fontSize);
            }
        } catch (Exception e) {
            LinearLayout linearLayout1 = (LinearLayout) searchView.getChildAt(0);
            LinearLayout linearLayout2 = (LinearLayout) linearLayout1.getChildAt(2);
            LinearLayout linearLayout3 = (LinearLayout) linearLayout2.getChildAt(1);
            AutoCompleteTextView autoComplete = (AutoCompleteTextView) linearLayout3.getChildAt(0);
            autoComplete.setTextSize(TypedValue.COMPLEX_UNIT_SP, fontSize);
        }
    }
    public static boolean isOnline(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }
    public static  boolean isNetworkAvailable(Context context) {
        final ConnectivityManager connectivityManager = ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE));
        return connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnected();
    }

}
