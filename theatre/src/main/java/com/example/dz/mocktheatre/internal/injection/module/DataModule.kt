package com.example.dz.mocktheatre.internal.injection.module

import android.content.Context
import com.example.data.BuildConfig
import com.example.data.gateway.SystemGatewayImpl
import com.example.data.local.EventTypeLocalDataSource
import com.example.data.local.dao.EventTypeDao
import com.example.data.local.system.SystemDatabase
import com.example.data.remote.EventTypeRemoteDataSource
import com.example.data.remote.api.TheatreApi
import com.example.data.remote.api.TheatreService
import com.example.data.repository.EventTypeRepository
import com.example.data.repository.mapper.EventTypeMapper
import com.example.domain.gateway.SystemGateway
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
internal class DataModule {
    @Singleton
    @Provides
    internal fun provideTheatreApi(): TheatreService = TheatreApi(BuildConfig.API_URL)

    @Singleton
    @Provides
    internal fun provideSystemDatabase(context: Context): SystemDatabase = SystemDatabase.newInstance(context)

    @Singleton
    @Provides
    internal fun provideEventTypeDao(systemDatabase: SystemDatabase): EventTypeDao = systemDatabase.eventTypeDao()

    @Singleton
    @Provides
    internal fun provideEventTypeLocalDataSource(eventTypeDao: EventTypeDao) = EventTypeLocalDataSource(eventTypeDao)

    @Singleton
    @Provides
    internal fun provideEventTypeRemoteDataSource(theatreService: TheatreService) = EventTypeRemoteDataSource(theatreService)

    @Singleton
    @Provides
    internal fun provideEventTypeRepository(
        eventTypeLocalDataSource: EventTypeLocalDataSource,
        eventTypeRemoteDataSource: EventTypeRemoteDataSource
    ): EventTypeRepository {
        return EventTypeRepository(eventTypeLocalDataSource, eventTypeRemoteDataSource, EventTypeMapper())
    }

    @Singleton
    @Provides
    internal fun provideSystemGateway(eventTypeRepository: EventTypeRepository): SystemGateway {
        return SystemGatewayImpl(eventTypeRepository)
    }
}