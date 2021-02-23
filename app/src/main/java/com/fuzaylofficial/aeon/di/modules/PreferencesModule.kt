package com.fuzaylofficial.aeon.di.modules

import android.content.Context
import android.content.SharedPreferences
import androidx.preference.PreferenceManager
import dagger.Module
import dagger.Provides

@Module
class PreferencesModule {


    @Provides
    fun bindPrefs(ctx:Context) : SharedPreferences{
        return PreferenceManager.getDefaultSharedPreferences(ctx)
    }

}