package com.dabodiya.dihilt.view.fragment.home

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.dabodiya.dihilt.R
import com.dabodiya.dihilt.app.MyApplication
import com.dabodiya.dihilt.listener.EventListener
import com.dabodiya.dihilt.listener.ResourceProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeVM @Inject constructor(
    val app: MyApplication,
    val resourceProvider: ResourceProvider,
    val eventListener: EventListener
) : ViewModel() {

    /* UI Fields */
    val no1 = ObservableField("")
    val no2 = ObservableField("")
    val message = ObservableField("")

    fun result() {
        if (!no1.get().isNullOrEmpty() && !no2.get().isNullOrEmpty()) {

            /* Type Conversion */
            val a = Integer.parseInt(no1.get().toString())
            val b = Integer.parseInt(no2.get().toString())

            /* Addition a and b */
            val c = a.plus(b)

            /* Set Sum */
            app.setSum(c)

            /* SnackBar message*/
            message.set(resourceProvider.getString(R.string.add_successfully))

        } else {

            /* Set Sum */
            app.setSum(0)

            /* SnackBar message*/
            message.set(resourceProvider.getString(R.string.add_failed))
        }

    }

}