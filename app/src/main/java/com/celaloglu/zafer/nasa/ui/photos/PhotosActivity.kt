package com.celaloglu.zafer.nasa.ui.photos

import android.os.Bundle
import android.widget.Toast
import com.android.databinding.library.baseAdapters.BR
import com.celaloglu.zafer.nasa.R
import com.celaloglu.zafer.nasa.api.response.Photo
import com.celaloglu.zafer.nasa.api.response.Photos
import com.celaloglu.zafer.nasa.base.BaseActivity
import com.celaloglu.zafer.nasa.databinding.ActivityPhotosBinding
import com.celaloglu.zafer.nasa.ui.photo.PhotoActivity
import javax.inject.Inject

class PhotosActivity : BaseActivity<ActivityPhotosBinding>(), PhotosContract.Activity {

    private lateinit var adapter: PhotosAdapter

    @Inject
    lateinit var viewModel: PhotosViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityComponent.inject(this)
        binding.setVariable(BR.vm, viewModel)
        viewModel.getPhotos()
    }

    override fun onResume() {
        super.onResume()
        viewModel.attachView(this)
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_photos
    }

    override fun onStop() {
        super.onStop()
        viewModel.detachView()
    }

    override fun setAdapter(photos: Photos) {
        adapter = PhotosAdapter(photos = photos.photos, viewModel = viewModel)
        binding.recyclerView.adapter = adapter
    }

    override fun openPhotoActivity(photo: Photo) {
        PhotoActivity.start(this, photo)
    }

    override fun showErrorMessage() {
        Toast.makeText(this, "Oops! An error has been occurred, looks like your internet " +
                "connection is disabled", Toast.LENGTH_LONG)
                .show()
    }
}
