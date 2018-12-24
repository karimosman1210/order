package com.example.razy_1.order.gui.login;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.example.razy_1.order.data.beans.MainUserResult;
import com.example.razy_1.order.data.network.DataServices;
import com.example.razy_1.order.data.shared_pref.ShardPrefUtils;
import com.example.razy_1.order.utels.StaticMethod;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.razy_1.order.utels.AppConstant.AUTH;

public class LoginPresenter {
    LoginInterface loginInterface;

    public LoginPresenter(LoginInterface loginInterface) {
        this.loginInterface = loginInterface;

    }

    public void checkLogin(String email, String password, final Context context) {
        if (StaticMethod.isConnectingToInternet(context)) {
            if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {

                loginInterface.emptyDialog();
            } else {
                DataServices dataServices = StaticMethod.RetrofitDataInsc().create(DataServices.class);
                dataServices.checkLoginApi("ZRAZY_ERP_ODATA_SRV/ZZCUSTOMER_loginSet?$filter=CustomerId%20eq%20" + email + "%20and%20Password%20eq%20%27" + password + "%27", AUTH).enqueue(new Callback<MainUserResult>() {
                    @Override
                    public void onResponse(Call<MainUserResult> call, Response<MainUserResult> response) {
                        if (response.isSuccessful()) {
                            loginInterface.sucessLogin();
                            Log.v("dasdas", response.body().getD().getResults().get(0).getEmail());
                            ShardPrefUtils.saveSharedPreferencesLogList(context, response.body().getD().getResults());


                        } else {
                            loginInterface.error();
                        }
                    }

                    @Override
                    public void onFailure(Call<MainUserResult> call, Throwable t) {

                    }
                });
            }

        } else {
            loginInterface.noConnection();
        }
    }
}
