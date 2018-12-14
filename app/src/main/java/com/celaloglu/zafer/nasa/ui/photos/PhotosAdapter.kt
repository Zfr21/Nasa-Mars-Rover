package com.celaloglu.zafer.nasa.ui.photos

import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.celaloglu.zafer.nasa.BR
import com.celaloglu.zafer.nasa.api.response.Photo
import com.celaloglu.zafer.nasa.databinding.ItemPhotoBinding

class PhotosAdapter(val photos: List<Photo>, viewModel: PhotosViewModel) :
        RecyclerView.Adapter<PhotosAdapter.PhotosViewHolder>() {

    val vm: PhotosViewModel = viewModel

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotosViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemPhotoBinding.inflate(inflater, parent, false)
        return PhotosViewHolder(binding, vm)
    }

    override fun onBindViewHolder(holder: PhotosViewHolder, position: Int) {
        val photo = photos[position]
        holder.bind(photo)
    }

    override fun getItemCount(): Int {
        return photos.size
    }

    class PhotosViewHolder(private val binding: ViewDataBinding,
                           private val viewModel: PhotosViewModel)
        : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Photo) {
            with(item) {
                binding.setVariable(BR.item, item)
                binding.setVariable(BR.vm, viewModel)
                binding.executePendingBindings()
            }
        }
    }
}