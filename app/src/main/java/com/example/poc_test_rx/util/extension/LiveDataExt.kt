package com.example.poc_test_rx.util.extension

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.poc_test_rx.util.Event

fun <T> MutableLiveData<T>.toSingleEvent(content: T) {
    return MutableLiveData<Event<T>>().postValue(Event(content))
}