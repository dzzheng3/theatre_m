package com.example.dz.mocktheatre.internal.util

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.content.Context
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.plusAssign

abstract class BaseAnroidViewModel : AndroidViewModel {
    protected val context:Context
    constructor(application: Application) : super(application) {
        context = application
    }
    private val disposables = CompositeDisposable()
    fun addDisposable(disposable: Disposable){
        disposables+=disposable
    }

    override fun onCleared() {
        disposables.dispose()
    }
}