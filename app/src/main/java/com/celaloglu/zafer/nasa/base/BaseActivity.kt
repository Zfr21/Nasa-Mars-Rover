package com.celaloglu.zafer.nasa.base

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.annotation.CallSuper
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.celaloglu.zafer.nasa.NasaApplication
import com.celaloglu.zafer.nasa.base.view.MvvmView
import com.celaloglu.zafer.nasa.di.component.ActivityComponent
import com.celaloglu.zafer.nasa.di.component.DaggerActivityComponent
import kotlinx.android.synthetic.main.activity_photos.view.*

abstract class BaseActivity<B : ViewDataBinding> : AppCompatActivity(), MvvmView {

    protected lateinit var binding: B

    protected lateinit var activityComponent: ActivityComponent

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, getLayoutId())
        activityComponent = DaggerActivityComponent
                .builder()
                .appComponent(NasaApplication.appComponent)
                .build()
    }

    override fun showProgressBar() {
        binding.root.progressBar.visibility = View.VISIBLE
    }

    override fun hideProgressBar() {
        binding.root.progressBar.visibility = View.GONE
    }

    @LayoutRes
    protected abstract fun getLayoutId(): Int
}