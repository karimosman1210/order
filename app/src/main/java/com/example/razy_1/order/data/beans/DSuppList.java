package com.example.razy_1.order.data.beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DSuppList {

    @SerializedName("results")
    @Expose
    private List<ResultListSuppList> results = null;

    public List<ResultListSuppList> getResults() {
        return results;
    }

    public void setResults(List<ResultListSuppList> results) {
        this.results = results;
    }

}
