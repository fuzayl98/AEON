package com.fuzaylofficial.aeon.di.modules

import com.fuzaylofficial.aeon.ui.dashboard.DashboardFragment
import com.fuzaylofficial.aeon.ui.auth.AuthFragment
import dagger.android.ContributesAndroidInjector
import dagger.Module

@Module
abstract class FragmentBuildersModule {
    @ContributesAndroidInjector(modules = [ViewModelsModule::class])
    abstract fun contributeHomeFragment(): AuthFragment?

    @ContributesAndroidInjector(modules = [ViewModelsModule::class])
    abstract fun contributeAuthFragment(): DashboardFragment?
}