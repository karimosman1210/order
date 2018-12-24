package com.example.razy_1.order.gui.suppliers;

import android.content.Context;

import com.example.razy_1.order.data.network.DataServices;
import com.example.razy_1.order.data.beans.CompanySetProduct;
import com.example.razy_1.order.utels.StaticMethod;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.razy_1.order.utels.AppConstant.AUTH;

public class CompanyPresenter {
    dataCompany dataCompany;

    public CompanyPresenter(dataCompany dataCompany) {
        this.dataCompany = dataCompany;
    }

    public void getCompanyData(Context context) {
        if (StaticMethod.isConnectingToInternet(context)) {

            DataServices setSuppliers = StaticMethod.RetrofitDataInsc().create(DataServices.class);

            setSuppliers.getSuppliers(AUTH).enqueue(new Callback<CompanySetProduct>() {
                @Override
                public void onResponse(Call<CompanySetProduct> call, Response<CompanySetProduct> response) {
                    dataCompany.companyData(response.body().getD().getResults());
                }

                @Override
                public void onFailure(Call<CompanySetProduct> call, Throwable t) {

                }
            });
        } else {
            dataCompany.noConnection();
        }
    }
}
