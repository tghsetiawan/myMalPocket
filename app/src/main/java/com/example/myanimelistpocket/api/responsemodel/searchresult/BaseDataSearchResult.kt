package com.example.myanimelistpocket.api.responsemodel.searchresult

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class BaseDataSearchResult(
        @SerializedName("request_hash") val request_hash : String,
        @SerializedName("request_cached") val request_cached : Boolean,
        @SerializedName("request_cache_expiry") val request_cache_expiry : Int,
        @SerializedName("results") val results : List<SearchResult>,
        @SerializedName("last_page") val last_page : Int
) : Parcelable
