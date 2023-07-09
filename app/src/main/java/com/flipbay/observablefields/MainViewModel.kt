package com.flipbay.observablefields

import androidx.databinding.ObservableField
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel(), DefaultLifecycleObserver {

    val liveText = ObservableField("Dummy Live Text")
}