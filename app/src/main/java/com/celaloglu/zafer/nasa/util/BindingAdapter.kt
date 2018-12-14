package com.celaloglu.zafer.nasa.util

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions

object BindingAdapter {

    @JvmStatic
    @BindingAdapter("imgSrc")
    fun setImageUrl(view: ImageView, imgSrc: String?) {
        Glide.with(view.context).load(imgSrc)
                .apply(RequestOptions()
                        .diskCacheStrategy(DiskCacheStrategy.DATA)
                        .priority(com.bumptech.glide.Priority.HIGH))
                .into(view)
    }
}