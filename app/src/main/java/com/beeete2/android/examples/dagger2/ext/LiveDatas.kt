package com.beeete2.android.examples.dagger2.ext

import androidx.lifecycle.LiveData
import com.hadilq.liveevent.LiveEvent

/**
 * Taken from https://proandroiddev.com/livedata-with-single-events-2395dea972a8
 */
fun <T> LiveData<T>.toSingleEvent(): LiveData<T> {
    val result = LiveEvent<T>()
    result.addSource(this) {
        result.value = it
    }
    return result
}
