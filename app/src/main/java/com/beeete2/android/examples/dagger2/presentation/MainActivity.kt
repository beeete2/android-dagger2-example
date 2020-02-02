package com.beeete2.android.examples.dagger2.presentation

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.beeete2.android.examples.dagger2.R
import com.beeete2.android.examples.dagger2.presentation.view.detail.DetailFragment
import com.beeete2.android.examples.dagger2.presentation.view.list.ListFragment
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.android.support.DaggerAppCompatActivity

class MainActivity : DaggerAppCompatActivity() {

    private val navController by lazy { findNavController(R.id.nav_host_fragment) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        setupActionBarWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()
    }

    @Module
    abstract class MainActivityBuilder {
        @ContributesAndroidInjector(modules = [ActivityModule::class])
        abstract fun contributeActivity(): MainActivity
    }

    @Module
    abstract class ActivityModule {
        @Binds
        abstract fun providesActivity(mainActivity: MainActivity): FragmentActivity

        @ContributesAndroidInjector(modules = [ListFragment.FragmentModule::class])
        abstract fun contributeListFragment(): ListFragment

        @ContributesAndroidInjector(modules = [DetailFragment.FragmentModule::class])
        abstract fun contributeDetailFragment(): DetailFragment
    }

}
