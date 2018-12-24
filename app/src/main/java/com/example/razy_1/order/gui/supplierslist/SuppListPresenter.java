package com.example.razy_1.order.gui.supplierslist;

import com.example.razy_1.order.data.network.DataServices;
import com.example.razy_1.order.data.beans.SuppListProduct;
import com.example.razy_1.order.utels.StaticMethod;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.razy_1.order.utels.AppConstant.AUTH;

public class SuppListPresenter {
getListSupp getSuppList;

    public SuppListPresenter(getListSupp getSuppList) {
        this.getSuppList = getSuppList;
    }

    public void getListSupp(int id){
        DataServices getSuppList1= StaticMethod.RetrofitDataInsc().create(DataServices.class);
        getSuppList1.getSuppliers("ZRAZY_ERP_ODATA_SRV/ZPRODUCTBySUPPLISet?$filter=SupplierId%20eq%20"+id,AUTH).enqueue(new Callback<SuppListProduct>() {
            @Override
            public void onResponse(Call<SuppListProduct> call, Response<SuppListProduct> response) {
                if (response.body().getD().getResults()!=null) {
                    getSuppList.getSupp(response.body().getD().getResults());
                }
            }
            @Override
            public void onFailure(Call<SuppListProduct> call, Throwable t) {
            }
        });
    }
}
