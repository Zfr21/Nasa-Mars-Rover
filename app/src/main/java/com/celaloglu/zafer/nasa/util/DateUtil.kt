package com.celaloglu.zafer.nasa.util

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*

@SuppressLint("SimpleDateFormat")
fun getDate(): String {
    val cal = Calendar.getInstance()
    val dateFormat = SimpleDateFormat("yyyy-MM-dd")
    cal.add(Calendar.DAY_OF_YEAR, -7)
    return dateFormat.format(Date(cal.timeInMillis))
}