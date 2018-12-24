package com.example.razy_1.order.data.beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SuppListProduct {

    @SerializedName("d")
    @Expose
    private DSuppList d;

    public DSuppList getD() {
        return d;
    }

    public void setD(DSuppList d) {
        this.d = d;
    }
}
