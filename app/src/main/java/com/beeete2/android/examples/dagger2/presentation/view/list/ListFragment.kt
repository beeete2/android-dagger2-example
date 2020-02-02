package com.beeete2.android.examples.dagger2.presentation.view.list

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import com.beeete2.android.examples.dagger2.di.ViewModelKey
import com.beeete2.android.examples.dagger2.R
import dagger.Binds
import dagger.Module
import dagger.android.support.DaggerFragment
import dagger.multibindings.IntoMap
import kotlinx.android.synthetic.main.fragment_list.*
import javax.inject.Inject

class ListFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: ListViewModel by viewModels { viewModelFactory }

    private val navController by lazy { findNavController() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.navigate.observe(viewLifecycleOwner) { name ->
            val action = ListFragmentDirections.toDetail(name = name)
            navController.navigate(action)
        }

        bobby_button.setOnClickListener {
            viewModel.navigateToDetail("Bobby")
        }
        john_button.setOnClickListener {
            viewModel.navigateToDetail("John")
        }
    }

    @Module
    abstract class FragmentModule {
        @Binds
        @IntoMap
        @ViewModelKey(ListViewModel::class)
        abstract fun bindViewModel(viewModel: ListViewModel): ViewModel
    }
}
