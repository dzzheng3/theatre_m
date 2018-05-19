package com.example.domain

import io.reactivex.Observable

abstract class UseCase<in Params, Result> internal constructor(private val schedulers: Schedulers) {
    internal abstract fun buildObservalble(params: Params?): Observable<Result>
    fun excute(params: Params? = null): Observable<Result> {
        return buildObservalble(params)
            .subscribeOn(schedulers.subScribeOn)
            .observeOn(schedulers.observeOn, true)
    }
}