package com.fuzaylofficial.aeon.di.components

import android.app.Application
import com.fuzaylofficial.aeon.di.App
import com.fuzaylofficial.aeon.di.modules.*
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    (AndroidSupportInjectionModule::class)
    ,(AppModule::class)
    ,(FragmentBuildersModule::class)
    ,(NetworkModule::class)
    ,(ViewModelsModule::class)
    ,(PreferencesModule::class)])

interface AppComponent : AndroidInjector<App> {

    override fun inject(instance: App)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}