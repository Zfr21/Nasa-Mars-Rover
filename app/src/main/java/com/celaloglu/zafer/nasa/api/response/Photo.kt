package com.celaloglu.zafer.nasa.api.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Photo(val id: Int,
                 val sol: Int,
                 val camera: Camera,
                 @SerializedName("img_src")
                 val imgSrc: String,
                 @SerializedName("earth_date")
                 val earthDate: String,
                 val rover: Rover) : Parcelable
