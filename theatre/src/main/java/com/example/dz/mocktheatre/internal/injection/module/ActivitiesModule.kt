package com.example.dz.mocktheatre.internal.injection.module

import com.example.dz.mocktheatre.home.HomeActivity
import com.example.dz.mocktheatre.internal.injection.scope.HomeScope
import com.example.dz.mocktheatre.internal.injection.scope.StartupScope
import com.example.dz.mocktheatre.startup.StartupActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class ActivitiesModule {
    @StartupScope
    @ContributesAndroidInjector(modules = [StartupModule::class])
    internal abstract fun contributeStartupActivity(): StartupActivity

    @HomeScope
    @ContributesAndroidInjector(modules = [HomeModule::class])
    internal abstract fun contributeHomeActivity(): HomeActivity
}