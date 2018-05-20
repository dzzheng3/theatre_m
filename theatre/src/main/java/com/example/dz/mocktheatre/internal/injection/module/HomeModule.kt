package com.example.dz.mocktheatre.internal.injection.module

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.content.Context
import com.example.domain.Schedulers
import com.example.domain.gateway.InventoryGateway
import com.example.domain.gateway.SystemGateway
import com.example.domain.interactor.EventFindByTypeUseCase
import com.example.domain.interactor.EventTypeGetAllUseCase
import com.example.dz.mocktheatre.event.EventListFragment
import com.example.dz.mocktheatre.event.EventTypeViewModel
import com.example.dz.mocktheatre.internal.injection.scope.HomeScope
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class HomeModule {
    @ContributesAndroidInjector
    internal abstract fun contributeEventListFragment(): EventListFragment

    @Module
    companion object {
        @HomeScope
        @Provides
        @JvmStatic
        internal fun provideEventTypeGetAllUseCase(schedulers: Schedulers, systemGateway: SystemGateway): EventTypeGetAllUseCase {
            return EventTypeGetAllUseCase(schedulers, systemGateway)
        }

        @HomeScope
        @Provides
        @JvmStatic
        internal fun provideEventFindByTypeUseCase(schedulers: Schedulers, inventoryGateway: InventoryGateway): EventFindByTypeUseCase {
            return EventFindByTypeUseCase(schedulers, inventoryGateway)
        }

        @HomeScope
        @Provides
        @JvmStatic
        internal fun provideViewModelFactory(
            context: Context,
            eventTypeGetAllUseCase: EventTypeGetAllUseCase,
            eventFindByTypeUseCase: EventFindByTypeUseCase
        ): ViewModelProvider.Factory {
            return object : ViewModelProvider.Factory {
                override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                    return when {
                        modelClass.isAssignableFrom(EventTypeViewModel::class.java) ->
                            EventTypeViewModel(context, eventTypeGetAllUseCase) as T
                        else -> throw IllegalArgumentException("unknown ViewModel class: ${modelClass.name}")
                    }
                }
            }
        }
    }
}