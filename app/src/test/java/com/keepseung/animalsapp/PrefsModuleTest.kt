package com.keepseung.animalsapp

import android.app.Application
import com.keepseung.animalsapp.di.PrefsModule
import com.keepseung.animalsapp.util.SharedPreferenceHelper

class PrefsModuleTest(val mockPrefs:SharedPreferenceHelper):PrefsModule() {
    override fun provideSharedPreferences(app: Application): SharedPreferenceHelper {
        return mockPrefs
    }
}