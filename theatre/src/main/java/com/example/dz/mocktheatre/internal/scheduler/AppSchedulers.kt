package com.example.dz.mocktheatre.internal.scheduler

import com.example.domain.Schedulers
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers

class AppSchedulers : Schedulers {
    override val subScribeOn: Scheduler
        get() = io.reactivex.schedulers.Schedulers.io()
    override val observeOn: Scheduler
        get() = AndroidSchedulers.mainThread()
}