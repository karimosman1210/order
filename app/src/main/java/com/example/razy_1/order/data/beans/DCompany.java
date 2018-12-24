package com.example.razy_1.order.data.beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DCompany {
    @SerializedName("results")
    @Expose
    private List<ResultCompany> results = null;

    public List<ResultCompany> getResults() {
        return results;
    }

    public void setResults(List<ResultCompany> results) {
        this.results = results;
    }
}
