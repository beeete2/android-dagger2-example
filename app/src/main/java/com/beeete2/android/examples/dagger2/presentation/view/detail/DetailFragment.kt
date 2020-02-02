package com.beeete2.android.examples.dagger2.presentation.view.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.lifecycle.observe
import androidx.navigation.fragment.navArgs
import com.beeete2.android.examples.dagger2.R
import com.beeete2.android.examples.dagger2.di.ViewModelKey
import com.beeete2.android.examples.dagger2.ext.assistedViewModels
import dagger.Binds
import dagger.Module
import dagger.android.support.DaggerFragment
import dagger.multibindings.IntoMap
import kotlinx.android.synthetic.main.fragment_detail.*
import javax.inject.Inject

class DetailFragment : DaggerFragment() {

    @Inject
    lateinit var factory: DetailViewModel.Factory

    private val args: DetailFragmentArgs by navArgs()

    private val viewModel: DetailViewModel by assistedViewModels { factory.create(args.name) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.name.observe(viewLifecycleOwner) {
            textView.text = it
        }
    }

    @Module
    abstract class FragmentModule {
        @Binds
        @IntoMap
        @ViewModelKey(DetailViewModel::class)
        abstract fun bindViewModel(viewModel: DetailViewModel): ViewModel
    }
}
