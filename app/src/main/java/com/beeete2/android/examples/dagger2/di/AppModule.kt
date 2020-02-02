package com.beeete2.android.examples.dagger2.di

import com.squareup.inject.assisted.dagger2.AssistedModule
import dagger.Module

@AssistedModule
@Module(includes = [AssistedInject_AppModule::class])
abstract class AppModule
