package com.example.razy_1.order.data.beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MainResultHistory {
    @SerializedName("d")
    @Expose
    private ListResultHistory d;

    public ListResultHistory getD() {
        return d;
    }

    public void setD(ListResultHistory d) {
        this.d = d;
    }
}
