package com.beeete2.android.examples.dagger2.presentation.view.detail

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.beeete2.android.examples.dagger2.App
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject

class DetailViewModel @AssistedInject constructor(
    @Assisted name: String,
    app: App
) : AndroidViewModel(app) {

    private val _name = MutableLiveData<String>()
    val name: LiveData<String> = _name

    init {
        _name.value = "Your name is $name."
    }

    @AssistedInject.Factory
    interface Factory {
        fun create(
            name: String
        ): DetailViewModel
    }

}
