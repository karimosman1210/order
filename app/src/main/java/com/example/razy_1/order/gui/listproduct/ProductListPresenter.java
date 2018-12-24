package com.example.razy_1.order.gui.listproduct;
import com.example.razy_1.order.data.network.DataServices;
import com.example.razy_1.order.data.beans.ProductList;
import com.example.razy_1.order.utels.StaticMethod;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.razy_1.order.utels.AppConstant.AUTH;

public class ProductListPresenter {
    getListProduct listPrduct;

    public ProductListPresenter(getListProduct listPrduct) {
        this.listPrduct = listPrduct;
    }

    public void getMyProduct(int myId) {
        DataServices getProductLis =StaticMethod.RetrofitDataInsc().create(DataServices.class);

        getProductLis.getProduct("ZRAZY_ERP_ODATA_SRV/zPRODUCTByCATEGOSet?$filter=CategoryId%20eq%20" + myId, AUTH).enqueue(new Callback<ProductList>() {
            public void onResponse(Call<ProductList> call, Response<ProductList> response) {
                if (response.isSuccessful()) {
                    listPrduct.myProduct(response.body().getD().getResults());
                }
            }

            @Override
            public void onFailure(Call<ProductList> call, Throwable t) {

            }
        });



    }

}
