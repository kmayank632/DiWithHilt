package com.dabodiya.dihilt.view.activity

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.dabodiya.dihilt.listener.EventListener
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainActivityVM @Inject constructor(
    val eventListener: EventListener
) : ViewModel() {

    /* ToolBar Title */
    val toolBarTitle = ObservableField("")

}