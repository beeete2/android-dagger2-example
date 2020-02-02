package com.beeete2.android.examples.dagger2.presentation.view.list

import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.beeete2.android.examples.dagger2.App
import com.beeete2.android.examples.dagger2.ext.toSingleEvent
import javax.inject.Inject

class ListViewModel @Inject constructor(app: App) : AndroidViewModel(app) {

    private val _navigate = MutableLiveData<String>()
    val navigate: LiveData<String> = _navigate.toSingleEvent()

    fun navigateToDetail(name: String) {
        _navigate.value = name
    }

}
