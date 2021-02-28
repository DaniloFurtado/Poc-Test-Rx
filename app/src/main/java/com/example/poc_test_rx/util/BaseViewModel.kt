package com.example.poc_test_rx.util

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable

open class BaseViewModel: ViewModel(), LifecycleObserver{

    private val disposables = CompositeDisposable()

    protected fun Disposable.addToDisposable(){
        disposables.add(this)
    }

    override fun onCleared() {
        super.onCleared()
        this.disposables.dispose()
    }
}