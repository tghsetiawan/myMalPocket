package com.example.myanimelistpocket.api.responsemodel.topresult

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class BaseDataTopResult(
    @SerializedName("request_hash") val request_hash : String,
    @SerializedName("request_cached") val request_cached : Boolean,
    @SerializedName("request_cache_expiry") val request_cache_expiry : Int,
    @SerializedName("top") val top : List<TopResult>
): Parcelable
