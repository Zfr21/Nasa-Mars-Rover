package com.celaloglu.zafer.nasa

import android.app.Activity
import android.app.Application
import com.celaloglu.zafer.nasa.di.component.AppComponent
import com.celaloglu.zafer.nasa.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class NasaApplication : Application(), HasActivityInjector {

    @Inject
    lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun activityInjector(): AndroidInjector<Activity> {
        return activityDispatchingAndroidInjector
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = initDagger(this)
    }

    private fun initDagger(app: NasaApplication): AppComponent {
        return DaggerAppComponent.builder()
                .application(app)
                .build()
    }

    companion object {
        lateinit var appComponent: AppComponent
            private set
    }
}