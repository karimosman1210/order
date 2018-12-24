package com.example.razy_1.order.data.beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ListResultHistory {

    @SerializedName("results")
    @Expose
    private List<ResultHistory> results = null;

    public List<ResultHistory> getResults() {
        return results;
    }

    public void setResults(List<ResultHistory> results) {
        this.results = results;
    }
}
