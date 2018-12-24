package com.example.razy_1.order.data.network;

import com.example.razy_1.order.data.beans.CategorySetProduct;
import com.example.razy_1.order.data.beans.CompanySetProduct;
import com.example.razy_1.order.data.beans.MainResultHistory;
import com.example.razy_1.order.data.beans.ProductList;
import com.example.razy_1.order.data.beans.SuppListProduct;
import com.example.razy_1.order.data.beans.MainUserResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Url;

import static com.example.razy_1.order.utels.AppConstant.AUTHORIZATION;
import static com.example.razy_1.order.utels.AppConstant.CONVET_JSON;

public interface DataServices {
    @GET("ZRAZY_ERP_ODATA_SRV/zzcategorySet")
    @Headers({CONVET_JSON})
    Call<CategorySetProduct> getCatList(@Header(AUTHORIZATION) String authorization);


    @GET("ZRAZY_ERP_ODATA_SRV/ZZSUPPLIERSet")
    @Headers({CONVET_JSON})
    Call<CompanySetProduct> getSuppliers(@Header(AUTHORIZATION) String authorization);

    @GET
    @Headers({CONVET_JSON})
    Call<SuppListProduct> getSuppliers(@Url String url, @Header(AUTHORIZATION) String authorization);

    @GET
    @Headers({CONVET_JSON})
    Call<ProductList> getProduct(@Url String url, @Header(AUTHORIZATION) String authorization);

    @GET
    @Headers({CONVET_JSON})
    Call<MainUserResult> checkLoginApi(@Url String url, @Header(AUTHORIZATION) String authorization);

    @GET
    @Headers({CONVET_JSON})
    Call<MainResultHistory> getMyHistory(@Url String url, @Header(AUTHORIZATION) String authorization);

}
