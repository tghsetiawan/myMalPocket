package com.example.myanimelistpocket.api.responsemodel.seasonslater

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Anime (
        @SerializedName("mal_id") val mal_id : Int,
        @SerializedName("url") val url : String,
        @SerializedName("title") val title : String,
        @SerializedName("image_url") val image_url : String,
        @SerializedName("synopsis") val synopsis : String,
        @SerializedName("type") val type : String,
        @SerializedName("airing_start") val airing_start : String,
        @SerializedName("episodes") val episodes : String,
        @SerializedName("members") val members : Int,
        @SerializedName("source") val source : String,
        @SerializedName("score") val score : String,
        @SerializedName("r18") val r18 : Boolean,
        @SerializedName("kids") val kids : Boolean,
        @SerializedName("continuing") val continuing : Boolean
) : Parcelable
