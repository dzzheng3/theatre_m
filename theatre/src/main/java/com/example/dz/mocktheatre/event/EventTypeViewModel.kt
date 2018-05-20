package com.example.dz.mocktheatre.event

import android.app.Application
import android.content.Context
import com.example.domain.interactor.EventTypeGetAllUseCase
import com.example.dz.mocktheatre.internal.util.BaseAnroidViewModel

class EventTypeViewModel(
    context: Context,
    private val eventTypeGetAllUseCase: EventTypeGetAllUseCase
) : BaseAnroidViewModel(context.applicationContext as Application)