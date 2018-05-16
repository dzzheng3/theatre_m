package com.example.dz.mocktheatre.internal.injection.module

import android.content.Context
import com.example.dz.mocktheatre.internal.injection.DaggerApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
internal class AppModule{
    @Singleton
    @Provides
    internal fun provideContext(application: DaggerApplication):Context = application.applicationContext

//    internal fun provideScedulers():Scedulers = AppScedulers()
}