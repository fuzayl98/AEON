package com.fuzaylofficial.aeon.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.fuzaylofficial.aeon.di.ViewModelFactory
import com.fuzaylofficial.aeon.di.keys.ViewModelKey
import com.fuzaylofficial.aeon.ui.dashboard.DashboardViewModel
import com.fuzaylofficial.aeon.ui.auth.AuthViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelsModule {
    @Binds
    abstract fun bindViewModelFactory(modelProvider: ViewModelFactory?): ViewModelProvider.Factory?

    @Binds
    @IntoMap
    @ViewModelKey(DashboardViewModel::class)
    protected abstract fun authViewModel(authViewModel: DashboardViewModel?): ViewModel?

    @Binds
    @IntoMap
    @ViewModelKey(AuthViewModel::class)
    protected abstract fun homeViewModel(authViewModel: AuthViewModel?): ViewModel?

}
