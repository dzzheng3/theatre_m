package com.example.dz.mocktheatre.internal.injection.component

import com.example.dz.mocktheatre.internal.injection.DaggerApplication
import com.example.dz.mocktheatre.internal.injection.module.AppModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@Component(modules = [AndroidSupportInjectionModule::class, AppModule::class])
internal interface AppComponent : AndroidInjector<DaggerApplication> {
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<DaggerApplication>()
}