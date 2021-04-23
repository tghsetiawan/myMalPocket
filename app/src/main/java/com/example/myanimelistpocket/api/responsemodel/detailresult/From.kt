package com.example.myanimelistpocket.api.responsemodel.detailresult

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class From (
    @SerializedName("day") val day : Int,
    @SerializedName("month") val month : Int,
    @SerializedName("year") val year : Int
) : Parcelable
