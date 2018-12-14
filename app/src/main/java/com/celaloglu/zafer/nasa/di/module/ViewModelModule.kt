package com.celaloglu.zafer.nasa.di.module

import com.celaloglu.zafer.nasa.ui.photos.PhotosContract
import com.celaloglu.zafer.nasa.ui.photos.PhotosViewModel
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindPhotosViewModel(photosViewModel: PhotosViewModel):
            PhotosContract.ViewModel
}

