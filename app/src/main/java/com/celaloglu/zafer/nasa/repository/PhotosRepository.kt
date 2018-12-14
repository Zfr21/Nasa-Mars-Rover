package com.celaloglu.zafer.nasa.repository

import com.celaloglu.zafer.nasa.api.response.Photos
import com.celaloglu.zafer.nasa.api.service.NasaService
import com.celaloglu.zafer.nasa.util.getDate
import io.reactivex.Single
import javax.inject.Inject

class PhotosRepository @Inject constructor(private val service: NasaService) {

    fun getPhotos(): Single<Photos> {
        return service.getPhotos(getDate())
    }
}