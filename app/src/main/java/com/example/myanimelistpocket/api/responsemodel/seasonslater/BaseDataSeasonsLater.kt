package com.example.myanimelistpocket.api.responsemodel.seasonslater

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class BaseDataSeasonsLater(
        @SerializedName("request_hash") val request_hash : String,
        @SerializedName("request_cached") val request_cached : Boolean,
        @SerializedName("request_cache_expiry") val request_cache_expiry : Int,
        @SerializedName("season_name") val season_name : String,
        @SerializedName("season_year") val season_year : String,
        @SerializedName("anime") val anime : List<Anime>
) : Parcelable
