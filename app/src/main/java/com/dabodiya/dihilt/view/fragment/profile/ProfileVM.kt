package com.dabodiya.dihilt.view.fragment.profile

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.dabodiya.dihilt.app.MyApplication
import com.dabodiya.dihilt.listener.EventListener
import com.dabodiya.dihilt.listener.ResourceProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.*
import javax.inject.Inject

@HiltViewModel
class ProfileVM @Inject constructor(
    val app: MyApplication,
    val resourceProvider: ResourceProvider,
    val eventListener: EventListener
) : ViewModel() {

    /* UI Field */
    val sum = ObservableField("")

    fun getSumForProfile() {

        /* Get Sum */
        val finalSum = app.getSum()
        sum.set(finalSum.toString())
    }
}