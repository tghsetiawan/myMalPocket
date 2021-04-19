package com.example.myanimelistpocket.api.responsemodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BaseData <T> {
    @SerializedName("request_hash")
    @Expose
    private String request_hash;
    @SerializedName("request_cached")
    @Expose
    private Boolean request_cached;
    @SerializedName("request_cache_expiry")
    @Expose
    private Integer request_cache_expiry;
    @SerializedName("results")
    @Expose
    private T results;
    @SerializedName("last_page")
    @Expose
    private Integer last_page;

    public String getRequest_hash() {
        return request_hash;
    }

    public void setRequest_hash(String request_hash) {
        this.request_hash = request_hash;
    }

    public Boolean getRequest_cached() {
        return request_cached;
    }

    public void setRequest_cached(Boolean request_cached) {
        this.request_cached = request_cached;
    }

    public Integer getRequest_cache_expiry() {
        return request_cache_expiry;
    }

    public void setRequest_cache_expiry(Integer request_cache_expiry) {
        this.request_cache_expiry = request_cache_expiry;
    }

    public T getResults() {
        return results;
    }

    public void setResults(T results) {
        this.results = results;
    }

    public Integer getLast_page() {
        return last_page;
    }

    public void setLast_page(Integer last_page) {
        this.last_page = last_page;
    }
}
