package com.example.dz.mocktheatre.startup

import android.content.Context
import com.example.domain.interactor.EventTypeGetAllUseCase
import com.example.dz.mocktheatre.MyApplication
import com.example.dz.mocktheatre.internal.util.BaseAnroidViewModel

class StartupViewModel(context: Context, private val eventTypeGetAllUseCase: EventTypeGetAllUseCase) : BaseAnroidViewModel(context.applicationContext as MyApplication)