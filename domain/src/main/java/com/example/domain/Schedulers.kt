package com.example.domain

import io.reactivex.Scheduler

interface Schedulers {
    val subScribeOn: Scheduler
    val observeOn: Scheduler
}