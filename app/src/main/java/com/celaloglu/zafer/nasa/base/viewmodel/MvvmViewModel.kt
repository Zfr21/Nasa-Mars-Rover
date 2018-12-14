package com.celaloglu.zafer.nasa.base.viewmodel

import android.databinding.Observable
import com.celaloglu.zafer.nasa.base.view.MvvmView

interface MvvmViewModel<V : MvvmView> : Observable {

    fun attachView(view: V)

    fun detachView()
}