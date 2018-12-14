package com.celaloglu.zafer.nasa.api.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Camera(val id: Int,
             val name: String,
             @SerializedName("rover_id")
             val roverId: Int,
             @SerializedName("full_name")
             val fullName: String): Parcelable