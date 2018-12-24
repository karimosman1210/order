package com.example.razy_1.order.data.beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CategorySetProduct {

    @SerializedName("d")
    @Expose
    private DProduct d;

    public DProduct getD() {
        return d;
    }

    public void setD(DProduct d) {
        this.d = d;
    }
}
