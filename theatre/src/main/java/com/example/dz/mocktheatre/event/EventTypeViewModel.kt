package com.example.dz.mocktheatre.event

import android.app.Application
import android.content.Context
import android.databinding.ObservableArrayList
import android.databinding.ObservableBoolean
import android.databinding.ObservableField
import com.example.domain.entity.EventType
import com.example.domain.interactor.EventTypeGetAllUseCase
import com.example.dz.mocktheatre.R
import com.example.dz.mocktheatre.internal.util.BaseAnroidViewModel
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableObserver

class EventTypeViewModel(
    context: Context,
    private val eventTypeGetAllUseCase: EventTypeGetAllUseCase
) : BaseAnroidViewModel(context.applicationContext as Application) {
    val loading = ObservableBoolean()
    val result = ObservableArrayList<EventType>()
    val empty = ObservableBoolean()
    val error = ObservableField<String>()

    private fun getAllEventTypes(): Disposable {
        return eventTypeGetAllUseCase.excute().subscribeWith(object : DisposableObserver<List<EventType>>() {
            override fun onComplete() {
                //to do
            }

            override fun onNext(t: List<EventType>) {
                loading.set(false)
                result.clear()
                result.addAll(t)
                empty.set(t.isEmpty())
            }

            override fun onError(e: Throwable) {
                loading.set(false)
                error.set(e.localizedMessage ?: e.message
                ?: context.getString(R.string.unknown_error))
            }
        })
    }
}