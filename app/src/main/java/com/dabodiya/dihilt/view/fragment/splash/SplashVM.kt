package com.dabodiya.dihilt.view.fragment.splash

import androidx.lifecycle.ViewModel
import com.dabodiya.dihilt.listener.EventListener
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashVM @Inject constructor(
    val eventListener: EventListener
) : ViewModel() {

}