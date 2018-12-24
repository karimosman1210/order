package com.example.razy_1.order.gui.products;

import android.content.Context;

import com.example.razy_1.order.data.network.DataServices;
import com.example.razy_1.order.data.beans.CategorySetProduct;
import com.example.razy_1.order.utels.StaticMethod;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.razy_1.order.utels.AppConstant.AUTH;

public class ProductPresenter {
    dataProduct dataProduct;
    public ProductPresenter(dataProduct dataProduct) {
        this.dataProduct = dataProduct;
    }
    public void getDataPrdocut(Context context){
        if (StaticMethod.isConnectingToInternet(context)) {
            DataServices setCat = StaticMethod.RetrofitDataInsc().create(DataServices.class);


            setCat.getCatList(AUTH).enqueue(new Callback<CategorySetProduct>() {
                @Override
                public void onResponse(Call<CategorySetProduct> call, Response<CategorySetProduct> response) {
                    if (response.isSuccessful()) {
                        dataProduct.prduct(response.body().getD().getResults());
                    }
                }

                @Override
                public void onFailure(Call<CategorySetProduct> call, Throwable t) {

                }
            });

        }else {
            dataProduct.noConnection();
        }

    }
}
