package com.example.razy_1.order.gui.splash;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.razy_1.order.R;
import com.example.razy_1.order.gui.mainpage.HomePage;
import com.example.razy_1.order.utels.KeyStore;
import com.example.razy_1.order.gui.login.Login;


import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.razy_1.order.data.shared_pref.ShardPrefKey.App_Name;
import static com.example.razy_1.order.data.shared_pref.ShardPrefUtils.listUserInfo;
import static com.example.razy_1.order.utels.StaticMethod.isNetworkAvailable;
import static com.example.razy_1.order.utels.StaticMethod.isOnline;
import static com.example.razy_1.order.utels.StaticMethod.oriantation;
import static com.example.razy_1.order.utels.ToastUtel.showToast;

public class SplashScreen extends AppCompatActivity {
    @BindView(R.id.reConnectIntenterBtn)
    Button reConnectIntenterBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        oriantation(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        ButterKnife.bind(this);
        if (getResources().getBoolean(R.bool.portrait_only)) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
        checkInternet();
    }

    @OnClick(R.id.reConnectIntenterBtn)
    public void onViewClicked() {
        reConnectIntenterBtn.setVisibility(View.GONE);
        checkInternet();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    private void checkInternet() {
        if (isNetworkAvailable(this)) {
            if (isOnline(this)) {
                delayLoad();

            } else {
                reConnectIntenterBtn.setVisibility(View.VISIBLE);
                showToast(this, getString(R.string.NointernetConnection));


            }
        } else {
            showToast(this, getString(R.string.NointernetConnection));
            reConnectIntenterBtn.setVisibility(View.VISIBLE);

        }
    }

    void delayLoad() {
        Thread myThread = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(2000);
                    SharedPreferences myPrefs = SplashScreen.this.getSharedPreferences(App_Name, SplashScreen.this.MODE_PRIVATE);
                    String infoUser = myPrefs.getString(listUserInfo, null);
                    if (infoUser != null) {
                        startActivity(new Intent(SplashScreen.this, HomePage.class));
                    } else {
                        startActivity(new Intent(SplashScreen.this, Login.class));
                    }

                    finish();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };
        myThread.start();
    }


}