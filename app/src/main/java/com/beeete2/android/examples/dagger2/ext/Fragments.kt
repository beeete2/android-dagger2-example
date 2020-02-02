package com.beeete2.android.examples.dagger2.ext

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * Taken from https://github.com/DroidKaigi/conference-app-2020/blob/master/corecomponent/androidcomponent/src/main/java/io/github/droidkaigi/confsched2020/ext/Fragments.kt
 */

inline fun <reified T : ViewModel> Fragment.assistedViewModels(
    crossinline body: () -> T
): Lazy<T> {
    return viewModels {
        object : ViewModelProvider.NewInstanceFactory() {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                @Suppress("UNCHECKED_CAST")
                return body() as T
            }
        }
    }
}
