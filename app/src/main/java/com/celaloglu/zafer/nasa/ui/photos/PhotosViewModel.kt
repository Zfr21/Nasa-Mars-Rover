package com.celaloglu.zafer.nasa.ui.photos

import android.annotation.SuppressLint
import android.support.annotation.VisibleForTesting
import com.celaloglu.zafer.nasa.api.response.Photo
import com.celaloglu.zafer.nasa.base.viewmodel.BaseViewModel
import com.celaloglu.zafer.nasa.di.scopes.PerActivity
import com.celaloglu.zafer.nasa.repository.PhotosRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@PerActivity
class PhotosViewModel @Inject constructor(private var repository: PhotosRepository) :
        BaseViewModel<PhotosContract.Activity>(), PhotosContract.ViewModel {

    @SuppressLint("CheckResult")
    @VisibleForTesting
    override fun getPhotos() {
        view?.showProgressBar()
        repository.getPhotos()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    view?.hideProgressBar()
                    view?.setAdapter(it)
                }, {
                    view?.hideProgressBar()
                    view?.showErrorMessage()
                })
    }

    override fun onPhotoClick(photo: Photo) {
        view?.openPhotoActivity(photo)
    }
}