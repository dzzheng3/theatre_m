package com.example.dz.mocktheatre.startup

import android.content.Context
import com.example.domain.entity.EventType
import com.example.domain.interactor.EventTypeGetAllUseCase
import com.example.dz.mocktheatre.MyApplication
import com.example.dz.mocktheatre.R
import com.example.dz.mocktheatre.internal.util.BaseAnroidViewModel
import com.example.dz.mocktheatre.internal.util.SingleLiveData
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableObserver

class StartupViewModel(context: Context, private val eventTypeGetAllUseCase: EventTypeGetAllUseCase)
    : BaseAnroidViewModel(context.applicationContext as MyApplication) {
    internal val result = SingleLiveData<Boolean>()
    private val error = SingleLiveData<String>()
    fun startup() = addDisposable(getAllEventTypes())

    private fun getAllEventTypes(): Disposable {
        return eventTypeGetAllUseCase.excute().subscribeWith(object : DisposableObserver<List<EventType>>() {
            override fun onComplete() {
            }

            override fun onNext(t: List<EventType>) {
                result.value = true
            }

            override fun onError(e: Throwable) {
                error.value = e.localizedMessage ?: e.message ?: context.getString(R.string.unknown_error)
            }
        })
    }
}