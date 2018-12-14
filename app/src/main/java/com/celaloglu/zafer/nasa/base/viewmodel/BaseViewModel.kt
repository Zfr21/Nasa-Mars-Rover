package com.celaloglu.zafer.nasa.base.viewmodel

import android.databinding.BaseObservable
import android.support.annotation.CallSuper
import com.celaloglu.zafer.nasa.base.view.MvvmView

abstract class BaseViewModel<V : MvvmView> : BaseObservable(), MvvmViewModel<V>{

    var view: V? = null
        private set

    @CallSuper
    override fun attachView(view: V) {
        this.view = view
    }

    @CallSuper
    override fun detachView() {
        view = null
    }
}