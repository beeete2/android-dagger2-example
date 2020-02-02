package com.beeete2.android.examples.dagger2

import android.app.Application
import android.util.Log
import com.beeete2.android.examples.dagger2.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class App : Application(), HasAndroidInjector {

    private val tag by lazy { this.javaClass.simpleName }

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    override fun onCreate() {
        super.onCreate()
        Log.i(tag, "onCreate")
    }

    override fun androidInjector(): AndroidInjector<Any> {
        DaggerAppComponent.factory().create(this).inject(this)
        return androidInjector
    }
}
