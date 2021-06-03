package com.example.myanimelistpocket.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Club(
        var logo:Int,
        var name:String,
        var desc:String,
        var color:Int): Parcelable
