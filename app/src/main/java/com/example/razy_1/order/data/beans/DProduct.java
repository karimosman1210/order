package com.example.razy_1.order.data.beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DProduct {

    @SerializedName("results")
    @Expose
    private List<ResultProduct> results = null;

    public List<ResultProduct> getResults() {
        return results;
    }

    public void setResults(List<ResultProduct> results) {
        this.results = results;
    }
}
