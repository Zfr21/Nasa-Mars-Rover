package com.celaloglu.zafer.nasa.api.service

import com.celaloglu.zafer.nasa.api.response.Photos
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface NasaService {

    @GET("rovers/curiosity/photos")
    fun getPhotos(@Query("earth_date") earthDate: String): Single<Photos>
}
