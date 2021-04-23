package com.example.myanimelistpocket.api.responsemodel.detailresult

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Aired(
    @SerializedName("from") val from : String,
    @SerializedName("to") val to : String,
    @SerializedName("prop") val prop : Prop,
    @SerializedName("string") val string : String
) : Parcelable
