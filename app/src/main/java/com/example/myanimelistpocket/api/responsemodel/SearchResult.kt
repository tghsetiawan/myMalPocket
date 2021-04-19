package com.example.myanimelistpocket.api.responsemodel

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SearchResult(
    @SerializedName("mal_id") val mal_id : Int,
    @SerializedName("url") val url : String,
    @SerializedName("image_url") val image_url : String,
    @SerializedName("title") val title : String,
    @SerializedName("airing") val airing : Boolean,
    @SerializedName("synopsis") val synopsis : String,
    @SerializedName("type") val type : String,
    @SerializedName("episodes") val episodes : Int,
    @SerializedName("score") val score : Double,
    @SerializedName("start_date") val start_date : String,
    @SerializedName("end_date") val end_date : String,
    @SerializedName("members") val members : Int,
    @SerializedName("rated") val rated : String
) : Parcelable
