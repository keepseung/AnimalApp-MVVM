package com.keepseung.animalsapp.di

import com.keepseung.animalsapp.viewmodel.ListViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApiModule::class, PrefsModule::class, AppModule::class])
interface ViewModelComponet {
    fun inject(viewModel:ListViewModel)
}