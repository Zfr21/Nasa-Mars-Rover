package com.celaloglu.zafer.nasa.di.component

import android.app.Application
import com.celaloglu.zafer.nasa.api.service.NasaService
import com.celaloglu.zafer.nasa.di.module.NetworkModule
import com.celaloglu.zafer.nasa.di.scopes.PerApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule

@PerApplication
@Component(modules = [AndroidInjectionModule::class, NetworkModule::class])
interface AppComponent : AppComponentProvides {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}

interface AppComponentProvides {
    fun nasaService(): NasaService
}
