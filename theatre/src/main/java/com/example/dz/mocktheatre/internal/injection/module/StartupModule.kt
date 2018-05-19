package com.example.dz.mocktheatre.internal.injection.module

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.content.Context
import com.example.domain.Schedulers
import com.example.domain.gateway.SystemGateway
import com.example.domain.interactor.EventTypeGetAllUseCase
import com.example.dz.mocktheatre.internal.injection.scope.StartupScope
import com.example.dz.mocktheatre.startup.StartupViewModel
import dagger.Module
import dagger.Provides

@Module
internal class StartupModule {
    @StartupScope
    @Provides
    internal fun provideEventTypeAllUseCase(schedulers: Schedulers, systemGateway: SystemGateway): EventTypeGetAllUseCase {
        return EventTypeGetAllUseCase(schedulers, systemGateway)
    }

    @Provides
    internal fun provideViewModelFactory(context: Context, eventTypeGetAllUseCase: EventTypeGetAllUseCase): ViewModelProvider.Factory {
        return object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return when {
                    modelClass.isAssignableFrom(StartupViewModel::class.java) ->
                        StartupViewModel(context, eventTypeGetAllUseCase) as T
                    else -> throw IllegalArgumentException("Unknown ViewModel class ${modelClass.name}")
                }
            }
        }
    }
}