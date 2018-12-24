package com.example.razy_1.order.utels;

import android.util.Base64;

public class AppConstant {
    public static final String BASE_URL_ORDER = "http://tds.razytech.com:8000/sap/opu/odata/sap/";
    public static final String AUTH = "Basic " + Base64.encodeToString(("hamdy" + ":" + "123456789").getBytes(), Base64.NO_WRAP);
    public static final String CONVET_JSON = "Accept: application/json";
    public static final String AUTHORIZATION="Authorization";

}
