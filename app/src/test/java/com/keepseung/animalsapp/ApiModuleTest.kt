package com.keepseung.animalsapp

import android.app.Application
import com.keepseung.animalsapp.di.ApiModule
import com.keepseung.animalsapp.di.PrefsModule
import com.keepseung.animalsapp.model.AnimalApiService
import com.keepseung.animalsapp.util.SharedPreferenceHelper

class ApiModuleTest(val mockService: AnimalApiService): ApiModule() {
    override fun provideAnimalApiService(): AnimalApiService {
        return mockService
    }
}