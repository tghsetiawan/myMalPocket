package com.example.myanimelistpocket.api.responsemodel.detailresult

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class BaseDataDetailResult(
    @SerializedName("request_hash") val request_hash : String,
    @SerializedName("request_cached") val request_cached : Boolean,
    @SerializedName("request_cache_expiry") val request_cache_expiry : Int,
    @SerializedName("mal_id") val mal_id : Int,
    @SerializedName("url") val url : String,
    @SerializedName("image_url") val image_url : String,
    @SerializedName("trailer_url") val trailer_url : String,
    @SerializedName("title") val title : String,
    @SerializedName("title_english") val title_english : String,
    @SerializedName("title_japanese") val title_japanese : String,
    @SerializedName("title_synonyms") val title_synonyms : List<String>,
    @SerializedName("type") val type : String,
    @SerializedName("source") val source : String,
    @SerializedName("episodes") val episodes : Int,
    @SerializedName("status") val status : String,
    @SerializedName("airing") val airing : Boolean,
    @SerializedName("aired") val aired : Aired,
    @SerializedName("duration") val duration : String,
    @SerializedName("rating") val rating : String,
    @SerializedName("score") val score : Double,
    @SerializedName("scored_by") val scored_by : Int,
    @SerializedName("rank") val rank : Int,
    @SerializedName("popularity") val popularity : Int,
    @SerializedName("members") val members : Int,
    @SerializedName("favorites") val favorites : Int,
    @SerializedName("synopsis") val synopsis : String,
    @SerializedName("background") val background : String,
    @SerializedName("premiered") val premiered : String,
    @SerializedName("broadcast") val broadcast : String,
    @SerializedName("producers") val producers : List<Producers>,
    @SerializedName("opening_themes") val opening_themes : List<String>,
    @SerializedName("ending_themes") val ending_themes : List<String>
) : Parcelable
