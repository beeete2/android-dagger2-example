package com.beeete2.android.examples.dagger2.di

import com.beeete2.android.examples.dagger2.App
import com.beeete2.android.examples.dagger2.presentation.MainActivity
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidInjectionModule::class,
    ViewModelModule::class,
    AppModule::class,
    MainActivity.MainActivityBuilder::class
])
interface AppComponent : AndroidInjector<App> {
    @Component.Factory
    abstract class Factory : AndroidInjector.Factory<App>
}
