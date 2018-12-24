package com.example.razy_1.order.data.beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DProductList {

    @SerializedName("results")
    @Expose
    private List<ResultProductList> results = null;

    public List<ResultProductList> getResults() {
        return results;
    }

    public void setResults(List<ResultProductList> results) {
        this.results = results;
    }

}
