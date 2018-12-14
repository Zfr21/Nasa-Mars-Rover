package com.celaloglu.zafer.nasa.ui.photo

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.celaloglu.zafer.nasa.R
import com.celaloglu.zafer.nasa.api.response.Photo
import com.celaloglu.zafer.nasa.base.BaseActivity
import com.celaloglu.zafer.nasa.databinding.ActivityPhotoBinding

class PhotoActivity : BaseActivity<ActivityPhotoBinding>() {

    private lateinit var photo: Photo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        photo = intent.getParcelableExtra(PHOTO)
        binding.item = photo

        val title = photo.rover.name
        supportActionBar?.title = title
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_photo
    }

    companion object {

        const val PHOTO: String = "PHOTO"

        fun start(context: Context, photo: Photo) {
            val intent = Intent(context, PhotoActivity::class.java)
            intent.putExtra(PHOTO, photo)
            context.startActivity(intent)
        }
    }
}
