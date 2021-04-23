package com.example.myanimelistpocket.api.responsemodel.detailresult

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Producers(
    @SerializedName("mal_id") val mal_id : Int,
    @SerializedName("type") val type : String,
    @SerializedName("name") val name : String,
    @SerializedName("url") val url : String
) : Parcelable
