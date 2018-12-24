package com.example.razy_1.order.data.beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProductList {

    @SerializedName("d")
    @Expose
    private DProductList d;

    public DProductList getD() {
        return d;
    }

    public void setD(DProductList d) {
        this.d = d;
    }
}
