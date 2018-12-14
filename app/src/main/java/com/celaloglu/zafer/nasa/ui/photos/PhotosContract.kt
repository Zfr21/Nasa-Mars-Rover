package com.celaloglu.zafer.nasa.ui.photos

import com.celaloglu.zafer.nasa.api.response.Photo
import com.celaloglu.zafer.nasa.api.response.Photos
import com.celaloglu.zafer.nasa.base.view.MvvmView
import com.celaloglu.zafer.nasa.base.viewmodel.MvvmViewModel

interface PhotosContract {

    interface Activity : MvvmView {

        fun setAdapter(photos: Photos)

        fun openPhotoActivity(photo: Photo)

        fun showErrorMessage()
    }

    interface ViewModel : MvvmViewModel<Activity> {

        fun getPhotos()

        fun onPhotoClick(photo: Photo)
    }
}