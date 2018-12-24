package com.example.razy_1.order.utels;

import android.app.Activity;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import static android.content.Context.CONNECTIVITY_SERVICE;

public class CheckInternet extends AsyncTask<Void,Void,Boolean>{
    private Activity activity;
    InternetCheckLitener internetCheckLitener;

    public CheckInternet(Activity activity, InternetCheckLitener internetCheckLitener) {
        this.activity = activity;
        this.internetCheckLitener = internetCheckLitener;
    }

    @Override
    protected Boolean doInBackground(Void... voids) {
        return hasInternetAccess();
    }
    private boolean hasInternetAccess() {
        if (isNetworkAvailable()) {
            try {
                HttpURLConnection urlc = (HttpURLConnection) (new URL("http://clients3.google.com/generate_204").openConnection());
                urlc.setRequestProperty("User-Agent", "Android");
                urlc.setRequestProperty("Connection", "close");
                urlc.setConnectTimeout(2000);
                urlc.connect();
                return (urlc.getResponseCode() == 204 &&
                        urlc.getContentLength() == 0);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            Log.d("TAG", "No network available!");
        }
        return false;
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager = (ConnectivityManager) activity.getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting() && activeNetworkInfo.isAvailable();

    }

    public interface InternetCheckLitener{
        void onComplete(boolean connected);
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        internetCheckLitener.onComplete(aBoolean);
    }

}
