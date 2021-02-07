package com.keepseung.animalsapp.di

import com.keepseung.animalsapp.model.AnimalApiService
import dagger.Component

@Component(modules = [ApiModule::class])
interface ApiComponent {
    fun inject(service:AnimalApiService)
}