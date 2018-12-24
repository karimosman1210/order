package com.example.razy_1.order.data.beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MainUserResult {
    @SerializedName("d")
    @Expose
    private ListInfoUser d;

    public ListInfoUser getD() {
        return d;
    }

    public void setD(ListInfoUser d) {
        this.d = d;
    }
}
