package com.celaloglu.zafer.nasa.di.component

import com.celaloglu.zafer.nasa.di.module.ViewModelModule
import com.celaloglu.zafer.nasa.di.scopes.PerActivity
import com.celaloglu.zafer.nasa.ui.photos.PhotosActivity
import dagger.Component

@PerActivity
@Component(dependencies = [(AppComponent::class)],
        modules = [(ViewModelModule::class)])
interface ActivityComponent {
    fun inject(activity: PhotosActivity)
}