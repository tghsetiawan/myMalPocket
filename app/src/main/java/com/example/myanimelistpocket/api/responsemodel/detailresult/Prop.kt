package com.example.myanimelistpocket.api.responsemodel.detailresult

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Prop(
    @SerializedName("from") val from : From,
    @SerializedName("to") val to : To
) : Parcelable
