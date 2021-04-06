package com.cash.pastel.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Response {
    @SerializedName("keywords")
    @Expose
    private String keywords;

    @SerializedName("paging")
    @Expose
    private Paging paging;

    @SerializedName("results")
    @Expose
    private List<Result> results = null;

    public Response() {}

    //*******************GETTERS AND SETTERS*******************

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public Paging getPaging() {
        return paging;
    }

    public void setPaging(Paging paging) {
        this.paging = paging;
    }
}
