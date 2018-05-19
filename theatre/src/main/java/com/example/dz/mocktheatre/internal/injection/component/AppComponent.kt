package com.example.dz.mocktheatre.internal.injection.component

import com.example.dz.mocktheatre.internal.injection.DaggerApplication
import com.example.dz.mocktheatre.internal.injection.module.ActivitiesModule
import com.example.dz.mocktheatre.internal.injection.module.AppModule
import com.example.dz.mocktheatre.internal.injection.module.DataModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class, ActivitiesModule::class, AppModule::class, DataModule::class])
internal interface AppComponent : AndroidInjector<DaggerApplication> {
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<DaggerApplication>()
}