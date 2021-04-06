package com.cash.pastel.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Setting implements Serializable {

    @SerializedName("listing_strategy")
    @Expose
    private String listing_strategy;

    public Setting() {}
}
