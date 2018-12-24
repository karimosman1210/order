package com.example.razy_1.order.data.beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CompanySetProduct {

    @SerializedName("d")
    @Expose
    private DCompany d;

    public DCompany getD() {
        return d;
    }

    public void setD(DCompany d) {
        this.d = d;
    }
}
