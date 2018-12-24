package com.example.razy_1.order.gui.history;

import android.content.Context;
import android.util.Log;

import com.example.razy_1.order.data.beans.MainResultHistory;
import com.example.razy_1.order.data.beans.MainUserResult;
import com.example.razy_1.order.data.beans.ResultHistory;
import com.example.razy_1.order.data.network.DataServices;
import com.example.razy_1.order.utels.StaticMethod;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.razy_1.order.data.shared_pref.ShardPrefUtils.listUserInfo;
import static com.example.razy_1.order.utels.AppConstant.AUTH;

public class MyOrderPresenter {
    GetMyOrder getMyOrderResultList;

    public MyOrderPresenter(GetMyOrder getMyOrderResultList) {
        this.getMyOrderResultList = getMyOrderResultList;
    }

    public void myOrder(Context context) {
        if (StaticMethod.isConnectingToInternet(context)){
            DataServices dataServices = StaticMethod.RetrofitDataInsc().create(DataServices.class);
            dataServices.getMyHistory("ZRAZY_ERP_ODATA_SRV/CustomerHistorySet?$filter=CustomerId%20eq%201", AUTH).enqueue(new Callback<MainResultHistory>() {
                @Override
                public void onResponse(Call<MainResultHistory> call, Response<MainResultHistory> response) {
                    if (response.isSuccessful()){
                        if (response.body().getD().getResults()!=null){
                            getMyOrderResultList.myOrder(response.body().getD().getResults());
                        }else {
                            getMyOrderResultList.noOrder();
                        }

                    }
                }

                @Override
                public void onFailure(Call<MainResultHistory> call, Throwable t) {

                }
            });
        }else {
            getMyOrderResultList.noConnection();
        }

    }
}
