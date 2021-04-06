package com.cash.pastel.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Paging {

    @SerializedName("total")
    @Expose
    private int total;

    @SerializedName("limit")
    @Expose
    private int limit;

    @SerializedName("offset")
    @Expose
    private int offset;

    public Paging() {}
}
