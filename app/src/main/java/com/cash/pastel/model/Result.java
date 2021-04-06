package com.cash.pastel.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Result implements Serializable {

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("domain_id")
    @Expose
    private String domain_id;

    @SerializedName("settings")
    @Expose
    private Setting settings = null;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("main_features")
    @Expose
    private List<Integer> main_features = null;

    @SerializedName("attributes")
    @Expose
    private List<Attribute> attributes = null;

    @SerializedName("pictures")
    @Expose
    private List<Picture> pictures = null;

    public Result() {}

    //********** SETTERS AND GETTERS**********
    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public String getDomain_id() {
        return domain_id;
    }

    public Setting getSettings() {
        return settings;
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public List<Picture> getPictures() {
        return pictures;
    }
}
