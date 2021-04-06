package com.cash.pastel.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Attribute implements Serializable {
    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("value_id")
    @Expose
    private String value_id;

    @SerializedName("value_name")
    @Expose
    private String value_name;

    public Attribute() {}
}
